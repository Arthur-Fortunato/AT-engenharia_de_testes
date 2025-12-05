package br.com.infnet.ex04.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AutenticationPage {
    protected WebDriver driver;
    // SIGNUP
    private By inputSignupName  = By.cssSelector("input[data-qa='signup-name']");
    private By inputSignupEmail = By.cssSelector("input[data-qa='signup-email']");
    private By buttonSignup     = By.cssSelector("button[data-qa='signup-button']");
    // LOGIN
    private By inputLoginEmail    = By.cssSelector("input[data-qa='login-email']");
    private By inputLoginPassword = By.cssSelector("input[data-qa='login-password']");
    private By buttonLogin        = By.cssSelector("button[data-qa='login-button']");

    private By mensagemErro = By.xpath("//p[contains(text(),'Your email or password is incorrect!')]");

    public AutenticationPage(WebDriver driver) {
        this.driver = driver;
    }

    public SignupPage preencherSignup(String nome, String email) {
        driver.findElement(inputSignupName).sendKeys(nome);
        driver.findElement(inputSignupEmail).sendKeys(email);
        driver.findElement(buttonSignup).click();
        return new SignupPage(driver);
    }

    public HomePageLogada preencherLogin(String email, String senha) {
        driver.findElement(inputLoginEmail).sendKeys(email);
        driver.findElement(inputLoginPassword).sendKeys(senha);
        driver.findElement(buttonLogin).click();
        return new HomePageLogada(driver);
    }

    public boolean erroVisivel() {
        return !driver.findElements(mensagemErro).isEmpty();
    }
}