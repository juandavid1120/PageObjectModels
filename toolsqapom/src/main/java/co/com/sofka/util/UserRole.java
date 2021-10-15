package co.com.sofka.util;

public enum UserRole {
    ADMIN("Admin"),
    ESS("ESS");


    private final String value;


    public String getValue() {
        return value;
    }

    UserRole(String value) {
        this.value = value;
    }
}
