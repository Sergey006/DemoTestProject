package data;

public enum Errors {
    WRONG_CREDENTIALS("Epic sadface: Username and password do not match any user in this service"),
    PASSWORD_REQUIRED("Epic sadface: Password is required"),
    USERNAME_REQUIRED("Epic sadface: Username is required");

    Errors(String description) {
        this.description = description;
    }

    private final String description;

    @Override
    public String toString() {
        return description;
    }
}
