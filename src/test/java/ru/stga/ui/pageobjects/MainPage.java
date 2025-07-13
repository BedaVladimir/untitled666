package ru.stga.ui.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MainPage {

    WebDriver driver;

    private final WebDriverWait wait;

    @FindBy(css = "test")
    private WebElement modalWindowCrossIcon;

    @FindBy(css = "test")
    private List<WebElement> productCardRoot;


}
