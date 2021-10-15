package co.com.sofka.page.practiceform;

import co.com.sofka.model.practiceform.PracticeFormModel;
import co.com.sofka.page.common.CommonActionsOnPages;
import co.com.sofka.util.Seconds;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static io.cucumber.messages.internal.com.google.common.base.StandardSystemProperty.USER_DIR;

public class PracticeForm extends CommonActionsOnPages {

    private static final Logger LOGGER = Logger.getLogger(PracticeForm.class);
    private PracticeFormModel practiceFormModel;
    private static final String MODEL_NULL_MESSAGE = "El modelo del formulario es nulo.";

    //For input test cases.
    private final By userRole = By.id("systemUser_userType");
    private final By employeeName = By.id("systemUser_employeeName_empName");
    private final By userName = By.id("systemUser_userName");
    private final By status = By.xpath("//*[@id=\"systemUser_status\"]");
    private final By password = By.id("systemUser_password");
    private final By confirmPassword = By.id("systemUser_confirmPassword");
    private final By save = By.id("btnSave");


    private static By assertionUserName;
    private By assertionUserRole;
    private By assertionEmployeeName;
    private By assertionStatus;
    private By assertiontabla;
    private By search;


    //For Assertions test case.
    public void asertionsTest() {//para traer datos


          assertionUserName = By.id("searchSystemUser_userName");
          assertionUserRole = By.id("searchSystemUser_userType");
          assertionEmployeeName = By.id("searchSystemUser_employeeName_empName");
          assertionStatus = By.id("searchSystemUser_status");
          search = By.id("searchBtn");
    }
     public void searchUserAdd() throws IOException {
         System.out.println("searchadd"+assertionUserName);
        // scrollTo(assertionUserName);
         withExplicitWaitClear(assertionUserName);
         System.out.println("searchadespuesWithExpli");
         withExplicitWaitTypeInto(assertionUserName, practiceFormModel.getUserName());

         System.out.println("searchaddSali");
     }

    public List<WebElement> getResultTable(){
         WebElement table = findElement(By.id("resultTable"));
        List<WebElement> allRows = table.findElements(By.tagName("tr"));
        return allRows;
    }

    public boolean validateUsersFilteredByRoles(List<WebElement> allRows, String usuario){
        for (WebElement row : allRows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            int i = 0;
            for (WebElement cell : cells) {
                if(i==1 && cell.getText().equalsIgnoreCase(usuario)){
                    return true;
                }
                i++;
            }
        }
        return false;
    }


    /*//Sikulix elements.
    private static final String ATTACHMENT_FILE_PATCH = USER_DIR.value() + "\\src\\test\\resources\\images\\practiceform\\happy.jpg";

    private static final String PAGE_BASE_PATCH = USER_DIR.value() + "\\src\\main\\resources\\page\\practiceform\\";
    private static final String SELECT_PICTURE_PATCH = PAGE_BASE_PATCH + "selectPicture.PNG";
    private static final String SELECT_OPEN_PATCH = PAGE_BASE_PATCH + "openWindows.PNG";
    private static final String FILE_NAME_TEXT_BOX_PATCH = PAGE_BASE_PATCH + "fileNameWindows.PNG";*/


    public PracticeForm(WebDriver driver, PracticeFormModel practiceFormModel) {
        super(driver);
        this.practiceFormModel = practiceFormModel;
    }

    public PracticeForm(WebDriver driver, PracticeFormModel practiceFormModel, int secondsForExplicitWait) {

        super(driver, secondsForExplicitWait);

        if(practiceFormModel == null)
            LOGGER.warn(MODEL_NULL_MESSAGE);

        this.practiceFormModel = practiceFormModel;

    }

    //Page functions.
    public void fillStudentForm() throws IOException {

        select(userRole,practiceFormModel.getUserRole().getValue());//

        clear(employeeName);
        typeInto(employeeName, practiceFormModel.getEmployeeName());

        clear(userName);
        typeInto(userName, practiceFormModel.getUserName());

        select(userRole,practiceFormModel.getUserRole().getValue());//


        clear(password);
        typeInto(password, practiceFormModel.getPassword());

        clear(confirmPassword);
        typeInto(confirmPassword, practiceFormModel.getConfirmPassword());

        clickOn(save);


    }


    /*public List<String> isRegistrationDone() {
        List<String> submitedFormResult = new ArrayList<>();
        submitedFormResult.add(getText(assertionStudentName).trim());
        submitedFormResult.add(getText(assertionGender).trim());
        submitedFormResult.add(getText(assertionMobile).trim());
        return submitedFormResult;
    }*/


}
