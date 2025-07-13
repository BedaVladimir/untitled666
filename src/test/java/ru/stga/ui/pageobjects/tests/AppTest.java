package ru.stga.ui.pageobjects.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import ru.stga.ui.pageobjects.LoginPage;

public class AppTest {

    private WebDriver driver;

    public static final String BASE_URL = "чото там из пропертей";

    public static final String username = "чото там из пропертей";

    public static final String password = "чото там из пропертей";

    private LoginPage loginPage;

    @BeforeEach
    void setupDriver() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Selenide.open(BASE_URL);
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testPricesOnProductCardsOnMainPage() {
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        loginPage.clickLoginButton();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
