package co.com.sofka.stepdefinition.practiceform.opt1;

import co.com.sofka.model.practiceform.PageLoginModel;
import co.com.sofka.model.practiceform.PracticeFormModel;
import co.com.sofka.page.practiceform.PageLogin;
import co.com.sofka.page.practiceform.PracticeForm;
import co.com.sofka.stepdefinition.setup.WebUI;
import co.com.sofka.util.Seconds;
import co.com.sofka.util.Status;
import co.com.sofka.util.UserRole;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static co.com.sofka.util.Seconds.TEN_SECONDS;

public class PracticeFormCucumberOpt1StepDefinition extends WebUI {

    private static final Logger LOGGER = Logger.getLogger(PracticeFormCucumberOpt1StepDefinition.class);
    private PracticeFormModel practiceFormModel;
    private List<WebElement> allRows;
    private PracticeForm practiceForm;
    private By btnAdmin;
    private By btnAdd;
    private PageLoginModel pageLoginModel;
    private PageLogin pageLogin;
    private static final String MENSAJE_BIENVENIDA = "Welcome Paul";
    private static final String ASSERTION_EXCEPTION_MESSAGE = "Los valores suministrados no son los esperados.";

    @Given("que el Administrador se encuentra en la formulario de ingreso de usuario")
    public void que_el_administrador_se_encuentra_en_la_formulario_de_ingreso_de_usuario() {
        try {
            generalSetUp();
            dataConfigurationLogin();
            pageLogin = new PageLogin(driver, pageLoginModel);
            pageLogin.fillLogin();

            dataConfigurationAddUser();
            practiceForm = new PracticeForm(driver, practiceFormModel,TEN_SECONDS.getValue());
            btnAdmin = By.id("menu_admin_viewAdminModule");
            practiceForm.clickOn(btnAdmin);
            practiceForm.asertionsTest();
            btnAdd = By.id("btnAdd");

            practiceForm.clickOn(btnAdd);
        } catch (Exception exception) {
            quitDriver();
            LOGGER.error(exception.getMessage(), exception);
            Assertions.fail(exception.getMessage());
        }
    }

    @When("el Administrador ingresa todos los campos y confirma la acción")
    public void el_administrador_ingresa_todos_los_campos_y_confirma_la_acción() {
        try {

            practiceForm.fillStudentForm();
        } catch (Exception exception) {
            quitDriver();
            LOGGER.error(exception.getMessage(), exception);
            Assertions.fail(exception.getMessage());
        }
    }

    @Then("el sistema deberá mostrar por pantalla el registro del usuario ingresado.")
    public void el_sistema_deberá_mostrar_por_pantalla_el_registro_del_usuario_ingresado() {
        try {
            practiceForm.searchUserAdd();

            allRows=practiceForm.getResultTable();



            Assertions.assertTrue(
                   practiceForm.validateUsersFilteredByRoles(allRows,practiceFormModel.getUserName()),ASSERTION_EXCEPTION_MESSAGE
            );
            quitDriver();
        } catch (Exception exception) {
            quitDriver();
            LOGGER.error(exception.getMessage(), exception);
            Assertions.fail(exception.getMessage());
        }
    }

    //Funciones comunes:
    private void dataConfigurationAddUser() {
        practiceFormModel = new PracticeFormModel();
        practiceFormModel.setUserRole(UserRole.ADMIN);
        practiceFormModel.setEmployeeName("David Morris");
        practiceFormModel.setUserName("juancho190659");
        practiceFormModel.setStatus(Status.ENABLED);
        practiceFormModel.setPassword("Juancho190540!");
        practiceFormModel.setConfirmPassword("Juancho190540!");

    }

    private void dataConfigurationLogin() {
        pageLoginModel = new PageLoginModel();
        pageLoginModel.setUsername("Admin");
        pageLoginModel.setPassword("admin123");

    }
  /*  private List<String> expected(){
        List<String> submitedFormResult = new ArrayList<String>();
        submitedFormResult.add(practiceFormModel.getName() + " " + practiceFormModel.getLastName());
        submitedFormResult.add(Gender.MALE.getValue());
        submitedFormResult.add(practiceFormModel.getMobile());
        return submitedFormResult;
    }*/


}
