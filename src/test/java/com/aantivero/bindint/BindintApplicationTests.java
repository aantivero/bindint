package com.aantivero.bindint;

import com.aantivero.bindint.cuenta.CuentaClient;
import com.aantivero.bindint.cuenta.model.Cuenta;
import com.aantivero.bindint.cuenta.model.Movimiento;
import com.aantivero.bindint.debin.DebinClient;
import com.aantivero.bindint.debin.model.Adhesion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BindintApplicationTests {

	private BindintApplication.LoginClient loginClient;
	private CuentaClient cuentaClient;
	private DebinClient debinClient;

	private String bank_id = "322";
	private String token = "JWT eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJYTnhaa0swK1I3aldLMGtUM0d4UnRDajBOaURBQzVGUVRuaUVNZ0lFcUVNPSIsImNyZWF0ZWQiOjE1Mjc2MDEzNDg3MzEsIm5hbWUiOiJBbGVqYW5kcm8gQWxiZXJ0byBBbnRpdmVybyIsImV4cCI6MTUyNzYzMDE0OH0.QNgZTOLPZl8twOdxzjNS7Mzt3Hkzgth7h3fg8SfW0RMRQwx5HkLTKCYfYE4u6zRNZuVEoIfveDuLxgL6w2Txiw";

	@Before
	public void setUp() {
		FeignClientBuilder builder = new FeignClientBuilder();
		loginClient = builder.getLoginClient();
		cuentaClient = builder.getCuentaClient();
		debinClient = builder.getDebinClient();
	}

	@Test
	public void contextLoads() {
	}

	@Test
	public void loginTest() {
		loginClient.login("pepe", "pompin");
	}

	@Test
	public void consultaDeVistasTest() {
		List<Cuenta> cuentas = cuentaClient.consultaDeVistas(bank_id, token);
		for (Cuenta cuenta: cuentas) {
			System.out.println(cuenta);
		}
	}

	@Test
	public void consultaDeCuentaTest() {
		List<Cuenta> consultaDeCuentas = cuentaClient.consultaDeCuentas("322", "owner", token);
		for (Cuenta cuenta : consultaDeCuentas) {
			System.out.println(cuenta);
			System.out.println("-----------CONSULTA DE CUENTA------------------------");
			Cuenta consultaDeCuenta = cuentaClient.consultaDeCuenta(cuenta.getBank_id(), cuenta.getId(), "owner", token);
			System.out.println(consultaDeCuenta);
			System.out.println("-----------END CONSULTA DE CUENTA--------------------");
			System.out.println("-----------CONSULTA DE MOVIMIENTOS------------------------");
			List<Movimiento> movimientos = cuentaClient.consultaDeMovimientos(cuenta.getBank_id(), cuenta.getId(), "owner", token);
			for (Movimiento movimiento: movimientos) {
				System.out.println(movimiento);
			}
			System.out.println("-----------END CONSULTA DE MOVIMIENTOS------------------------");
		}
	}

	@Test
	public void debinAltaDeCuentaVendedor() {
		Adhesion adhesion = debinClient.altaBajaDeCuentaVendedor("322", "21-1-99999-4-6", "owner", token, true);
		System.out.println(adhesion);
	}

	@Test
	public void debinBajaDeCuentaVendedor() {
		Adhesion adhesion = debinClient.altaBajaDeCuentaVendedor("322", "21-1-99999-4-6", "owner", token, false);
		System.out.println(adhesion);
	}

}
