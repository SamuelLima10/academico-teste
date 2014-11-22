package br.com.academico.steps;

import java.util.Map;

import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepsDefsAcademico extends Steps{
	@Given("^Estou acessando o sistema academico$")
	public void estou_acessando_o_sistema_academico() throws Throwable {
		assertEquals("Sistema Acadêmico", driver.getTitle());
	}

	@When("^Preencho as seguintes nota do aluno:$")
	public void preencho_as_seguintes_nota_do_aluno(DataTable notasPrenchidas) throws Throwable {
		
		for (Map<String,String> notas: notasPrenchidas.asMaps(String.class, String.class)){
			driver.findElement(By.id("cadastroAluno:nota1")).clear();
			driver.findElement(By.id("cadastroAluno:nota1")).sendKeys(notas.get("Nota1"));
			driver.findElement(By.id("cadastroAluno:nota2")).clear();
			driver.findElement(By.id("cadastroAluno:nota2")).sendKeys(notas.get("Nota2"));
			driver.findElement(By.id("cadastroAluno:nota3")).clear();
			driver.findElement(By.id("cadastroAluno:nota3")).sendKeys(notas.get("Nota3"));
		}
	}

	@When("^Clico no botão \"(.*?)\"$")
	public void clico_no_botão(String txBotao) throws Throwable {
		driver.findElement(By.xpath("//input[@value='"+txBotao+"']")).click();
	}

	@Then("^Deve ser exibido a mensagem \"(.*?)\"$")
	public void deve_ser_exibido_a_mensagem(String txMensagemValidacaoNota) throws Throwable {
		assertEquals(txMensagemValidacaoNota, driver.findElement(By.cssSelector("li")).getText());
	}
	
	@When("^Preencho a nota da prova final com \"(.*?)\"$")
	public void preencho_a_nota_da_prova_final_com(String notaProvaFinal) throws Throwable {
		driver.findElement(By.id("cadastroAluno:provaFinal")).clear();
		driver.findElement(By.id("cadastroAluno:provaFinal")).sendKeys(notaProvaFinal);
	}
}
