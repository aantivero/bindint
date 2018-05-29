package com.aantivero.bindint;

import feign.*;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import lombok.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetSocketAddress;
import java.net.Proxy;

@SpringBootApplication
@RestController
@EnableFeignClients
public class BindintApplication {

	public static void main(String[] args) {
		SpringApplication.run(BindintApplication.class, args);
	}

	@RequestMapping("/")
	public String home() {
		FeignClientBuilder builder = new FeignClientBuilder();
		LoginClient loginClient = builder.getLoginClient();
		Token token = loginClient.login("alejandro.antivero@gmail.com", "M13YTa225t1UpxA");
		return token.getToken();

	}

	@Data
	@ToString
	@NoArgsConstructor
	@AllArgsConstructor
	class Token {
		private String token;
	}

	interface LoginClient {
		@RequestLine("POST /login/jwt")
		@Headers("Content-Type: application/json")
		Token login(@Param("username")String username, @Param("password") String password);
	}
}
