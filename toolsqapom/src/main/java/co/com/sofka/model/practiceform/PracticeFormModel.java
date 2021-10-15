package co.com.sofka.model.practiceform;

import co.com.sofka.util.Gender;
import co.com.sofka.util.Hobbies;
import co.com.sofka.util.Status;
import co.com.sofka.util.UserRole;
import org.openqa.selenium.By;

import java.util.List;

public class PracticeFormModel {
    private UserRole userRole;
    private String employeeName;
    private String userName;
    private Status status;
    private String password;
    private String confirmPassword;
    private String Save;


    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getSave() {
        return Save;
    }

    public void setSave(String save) {
        Save = save;
    }
}
