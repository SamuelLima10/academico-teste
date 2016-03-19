package br.com.academico.test;

import org.junit.Test;

import br.com.academico.page.PageLancamentoNotas;
import static org.junit.Assert.assertEquals;

public class LancamentoNotasTest extends BaseTest{

	
	PageLancamentoNotas pageLancamentoNotas = new PageLancamentoNotas(driver);
	
	@Test
	public void lancarNotasQuandoAlunoAprovadoPorNotaMaiorQueSete(){
		lancarNotasAluno("7.0","8.0", "9.0");
		pageLancamentoNotas.clicarEmCalcular();
		
		assertEquals("Aprovado", pageLancamentoNotas.verificarSituacaoDoAluno());
	}
	
	@Test
	public void lancarNotasQuandoAlunoReprovadoPorNotaMenorQueQuatro(){
		lancarNotasAluno("3.0","4.0", "2.0");
		pageLancamentoNotas.clicarEmCalcular();
		
		assertEquals("Reprovado", pageLancamentoNotas.verificarSituacaoDoAluno());
	}

	@Test
	public void lancarNotasQuandoAlunoEmProvaFinalComNotaMenorQueSeteEMaiorQueQuatroQuandoAlunoAprovado(){
		lancarNotasAluno("5.0","3.0", "7.0");
		pageLancamentoNotas.clicarEmCalcular();
		pageLancamentoNotas.clicarEmCalcular();
		pageLancamentoNotas.lancarProvaFinal("5.0");
		pageLancamentoNotas.clicarEmCalcular();

		assertEquals("Aprovado Prova Final", pageLancamentoNotas.verificarSituacaoDoAluno());
	}
	
	@Test
	public void lancarNotasQuandoAlunoEmProvaFinalComNotaMenorQueSeteEMaiorQueQuatroQuandoAlunoReprovado(){
		lancarNotasAluno("5.0","3.0", "7.0");
		pageLancamentoNotas.clicarEmCalcular();
		pageLancamentoNotas.lancarProvaFinal("2.0");
		pageLancamentoNotas.clicarEmCalcular();

		assertEquals("Reprovado Prova Final", pageLancamentoNotas.verificarSituacaoDoAluno());
	}
	

	private void lancarNotasAluno(String nota1, String nota2, String nota3) {
		pageLancamentoNotas.lancarPrimeiraNota(nota1);
		pageLancamentoNotas.lancarSegundaNota(nota2);
		pageLancamentoNotas.lancarTerceiraNota(nota3);
	}
}
