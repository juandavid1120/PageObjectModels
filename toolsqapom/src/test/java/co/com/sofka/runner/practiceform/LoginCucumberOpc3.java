
package co.com.sofka.runner.practiceform;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        publish = true,
        plugin = {"pretty", "html:target/cucumber-report/cucumber.html"},
        features = {"src/test/resources/features/webui/practiceform/Login.feature"},
        glue = {"co.com.sofka.stepdefinition.practiceform.opt3"},
        tags = "not @ignore"
)
public class LoginCucumberOpc3 {
}
/*Scenario: Ingreso de un usuario final con login fallido.
        When el usuario final ingresa user y password invalido.
        Then el sistema deberá mostrar un mensaje de user o password incorrectos

        Scenario: Ingreso de un usuario final con login con campos vacios
        When el usuario final de la click al boton login
        Then el sistema deberá mostrar por pantalla un mensaje debes ingresar los datos*/
