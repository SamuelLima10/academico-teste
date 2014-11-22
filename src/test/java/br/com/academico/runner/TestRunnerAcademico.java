package br.com.academico.runner;
import java.io.IOException;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.model.InitializationError;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.runtime.junit.FeatureRunner;
@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "html:target/cucumber", "json:target/cucumber.json"},
features = {"src//test//resources"},
//tags = {"@Teste"},
glue="br.com.academico.steps")
public class TestRunnerAcademico {
	static Cucumber cucumber;
	
	@BeforeClass
	public static void iniciarTestes() throws InitializationError, IOException{
		cucumber = new Cucumber(TestRunnerAcademico.class);
	}
	
	
	public static void retornarStepComErro(){
		List<FeatureRunner> listaCenarios = cucumber.getChildren();
		for (int i=0; i< listaCenarios.size(); i++){
			System.out.println(listaCenarios.get(i).getDescription().getChildren().get(i));
		}
	}
	
}
