package br.com.infnet.ex04.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    protected WebDriver driver;
    private By linkSignup = By.cssSelector("a[href='/login']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public AutenticationPage clicarNoLinkSignup() {
        driver.findElement(linkSignup).click();
        return new AutenticationPage(driver);
    }
}
