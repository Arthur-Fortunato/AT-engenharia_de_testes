package br.com.infnet.ex04.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageLogada {
    private WebDriver driver;

    private By loggedInText = By.xpath("//a[contains(text(),'Logged in as')]");

    public HomePageLogada(WebDriver driver) {
        this.driver = driver;
    }

    public boolean usuarioLogado() {
        return !driver.findElements(loggedInText).isEmpty();
    }
}
