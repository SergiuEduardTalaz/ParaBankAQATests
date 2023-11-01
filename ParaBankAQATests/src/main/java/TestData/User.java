package TestData;

public class User {
    private String username;
    private String password;
    private String expectedErrorMessage;
    private String expectedUrl;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, String expectedUrl) {
        this.username = username;
        this.password = password;
        this.expectedUrl = expectedUrl;
    }

    public User(String username, String password, String expectedUrl, String expectedErrorMessage) {
        this.username = username;
        this.password = password;
        this.expectedUrl = expectedUrl;
        this.expectedErrorMessage = expectedErrorMessage;
    }


    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getExpectedErrorMessage() {
        return expectedErrorMessage;
    }

    public String getExpectedUrl() {
        return expectedUrl;
    }
}
