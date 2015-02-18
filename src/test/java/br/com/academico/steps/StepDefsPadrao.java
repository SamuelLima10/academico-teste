package br.com.academico.steps;

import java.io.IOException;

import org.junit.runners.model.InitializationError;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;

public class StepDefsPadrao extends Steps {

	@Given("^Estou acessando o sistema pelo navegador Firefox$")
	public void estou_acessando_o_sistema_pelo_navegador_Firefox()
			throws Throwable {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();

	}

	@Given("^Acesso o sistema pela url \"(.*?)\"$")
	public void acesso_o_sistema_pela_url(String txURLSistema) throws Throwable {
		driver.get(txURLSistema);
	}

	@After
	public void finalizarTestes(Scenario scenario) throws InitializationError,
			IOException {
		if (scenario.isFailed()) {
			System.out.println("Deu erro no cenario: " + scenario.getName());
		}
		driver.quit();

	}
}
