package co.com.sofka.stepdefinition.practiceform.opt3;

import co.com.sofka.model.practiceform.PageLoginModel;

import co.com.sofka.page.practiceform.PageLogin;
import co.com.sofka.stepdefinition.setup.LoginWebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

public class LoginCucumber extends LoginWebUI {
    private static final Logger LOGGER = Logger.getLogger(LoginCucumber.class);
    private PageLoginModel pageLoginModel;
    private PageLogin pageLogin;
    private static final String ASSERTION_EXCEPTION_MESSAGE = "Los valores suministrados no son los esperados.";
    private static final String MENSAJE_BIENVENIDA = "Welcome Paul";
    private static final String MENSAJE_LOGIN_INVALIDO = "Invalid credentials";
    private static final String MENSAJE_CAMPOS_VACIOS = "Username cannot be empty";

    //background
    @Given("que el usuario final se encuentra en la página del login")
    public void que_el_usuario_final_se_encuentra_en_la_pagina_del_login() {
        try {
            generalSetUp();
            dataConfigurationLogin();
        } catch (Exception exception) {
            quitDriver();
            LOGGER.error(exception.getMessage(), exception);
            Assertions.fail(exception.getMessage());
        }
    }

    @When("el usuario final ingresa user y password validos")
    public void el_usuario_final_ingresa_user_y_password_validos() {
        try {
            pageLogin = new PageLogin(driver, pageLoginModel);
            pageLogin.fillLogin();
        } catch (Exception exception) {
            quitDriver();
            LOGGER.error(exception.getMessage(), exception);
            Assertions.fail(exception.getMessage());
        }

    }

    @Then("el sistema deberá mostrar por pantalla el mensaje de bienvenida")
    public void el_sistema_debera_mostrar_por_pantalla_el_mensaje_de_bienvenida() {
        try {
            Assertions.assertEquals(
                    MENSAJE_BIENVENIDA,
                    pageLogin.obtenerMensajeBienvenida(),
                    ASSERTION_EXCEPTION_MESSAGE
            );
            quitDriver();
        } catch (Exception exception) {
            quitDriver();
            LOGGER.error(exception.getMessage(), exception);
            Assertions.fail(exception.getMessage());
        }
    }


    @When("el usuario final ingresa user y password invalido.")
    public void el_usuario_final_ingresa_user_y_password_invalido() {
        try {
            pageLoginModel.setUsername("Admin");
            pageLoginModel.setPassword("admin1234");
            pageLogin = new PageLogin(driver, pageLoginModel);
            pageLogin.fillLogin();
        } catch (Exception exception){
            quitDriver();
            LOGGER.error(exception.getMessage(), exception);
            Assertions.fail(exception.getMessage());
        }
    }

    @Then("el sistema deberá mostrar un mensaje de user o password incorrectos")
    public void el_sistema_debera_mostrar_un_mensaje_de_user_o_password_incorrectos() {
        try {
            Assertions.assertEquals(
                    MENSAJE_LOGIN_INVALIDO,
                    pageLogin.obtenerMensajeLoginFallido(),
                    ASSERTION_EXCEPTION_MESSAGE
            );
            quitDriver();
        } catch (Exception exception) {
            quitDriver();
            LOGGER.error(exception.getMessage(), exception);
            Assertions.fail(exception.getMessage());
        }
    }

    //LOGIN SIN DATOS
    @When("el usuario final de la click al boton login")
    public void el_usuario_final_de_la_click_al_boton_login() {
        try {
            pageLoginModel.setUsername("");
            pageLoginModel.setPassword("");
            pageLogin = new PageLogin(driver, pageLoginModel);
            pageLogin.fillLogin();
        } catch (Exception exception){
            quitDriver();
            LOGGER.error(exception.getMessage(), exception);
            Assertions.fail(exception.getMessage());
        }
    }

    @Then("el sistema deberá mostrar por pantalla un mensaje debes ingresar los datos")
    public void el_sistema_debera_mostrar_por_pantalla_un_mensaje_debes_ingresar_los_datos() {
        try {
            Assertions.assertEquals(
                    MENSAJE_CAMPOS_VACIOS,
                    pageLogin.obtenerMensajeLoginFallido(),
                    ASSERTION_EXCEPTION_MESSAGE
            );
            quitDriver();
        } catch (Exception exception){
            quitDriver();
            LOGGER.error(exception.getMessage(), exception);
            Assertions.fail(exception.getMessage());
        }
    }

    //Funciones comunes:
    private void dataConfigurationLogin() {
        pageLoginModel = new PageLoginModel();
        pageLoginModel.setUsername("Admin");
        pageLoginModel.setPassword("admin123");

    }

}
