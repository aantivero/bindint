package com.aantivero.bindint;

import com.aantivero.bindint.cuenta.CuentaClient;
import com.aantivero.bindint.cuenta.model.Cuenta;
import com.aantivero.bindint.debin.DebinClient;
import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import lombok.Getter;

import java.net.InetSocketAddress;
import java.net.Proxy;

@Getter
public class FeignClientBuilder {

    private BindintApplication.LoginClient loginClient = createClient(BindintApplication.LoginClient.class, "https://sandbox.bind.com.ar/v1");
    private CuentaClient cuentaClient = createClient(CuentaClient.class, "https://sandbox.bind.com.ar/v1");
    private DebinClient debinClient = createClient(DebinClient.class, "https://sandbox.bind.com.ar/v1");

    private static <T> T createClient(Class<T> type, String uri) {
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("pfcajavip.cajval.sba.com.ar", 3128));
        okhttp3.OkHttpClient okHttpClient = new okhttp3.OkHttpClient.Builder().proxy(proxy).build();
        return Feign.builder()
                .client(new OkHttpClient(okHttpClient))
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .logger(new Slf4jLogger(type))
                .logLevel(Logger.Level.FULL)
                .target(type, uri);
    }
}
