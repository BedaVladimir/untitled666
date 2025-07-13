package ru.stga.ui.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    WebDriver driver;

    private final WebDriverWait wait;

    @FindBy(xpath = "//test_xpath")
    private WebElement usernameField;

    @FindBy(xpath = "//test_xpath")
    private WebElement passwordField;

    @FindBy(xpath = "//test_xpath")
    private WebElement loginButton;

    @FindBy(xpath = "//test_xpath")
    private WebElement resetButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void setUsername(String username) {
        usernameField.sendKeys(username);
    }

    public String getUsernameFieldValue() {
        return usernameField.getText();
    }

    public void setPassword(String password) {
        passwordField.sendKeys(password);
    }

    public String getPasswordFieldValue() {
        return passwordField.getText();
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void clickResetButton() {
        resetButton.click();
    }
}
