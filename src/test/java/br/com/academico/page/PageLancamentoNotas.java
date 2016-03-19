package br.com.academico.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageLancamentoNotas {
	
	private WebDriver driver;
	
	public PageLancamentoNotas(WebDriver driver) {
		this.driver=driver;
	}
	
	public void lancarPrimeiraNota(String txPrimeiraNota){
		driver.findElement(By.id("cadastroAluno:nota1")).clear();
		driver.findElement(By.id("cadastroAluno:nota1")).sendKeys(txPrimeiraNota);
	}
	
	public void lancarSegundaNota(String txSegundaNota){
		driver.findElement(By.id("cadastroAluno:nota2")).clear();
		driver.findElement(By.id("cadastroAluno:nota2")).sendKeys(txSegundaNota);
	}
	
	public void lancarTerceiraNota(String txTerceiraNota){
		driver.findElement(By.id("cadastroAluno:nota3")).clear();
		driver.findElement(By.id("cadastroAluno:nota3")).sendKeys(txTerceiraNota);
	}
	
	public void lancarProvaFinal(String txNotaFinal){
		driver.findElement(By.id("cadastroAluno:provaFinal")).clear();
		driver.findElement(By.id("cadastroAluno:provaFinal")).sendKeys(txNotaFinal);
	}
	
	public String verificarMediaFinal(){
		return driver.findElement(By.id("cadastroAluno:mediafinal")).getText();
	}
	
	public void clicarEmCalcular(){
		driver.findElement(By.id("cadastroAluno:buttonCalcular")).click();
	}
	
	public String verificarSituacaoDoAluno(){
		return driver.findElement(By.cssSelector("li")).getText();
	}

}


