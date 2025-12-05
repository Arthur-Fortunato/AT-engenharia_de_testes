package br.com.infnet.ex04.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SignupPage {

    private WebDriver driver;

    private By radioMr   = By.id("id_gender1");
    private By radioMrs  = By.id("id_gender2"); // deixei aqui mas n vou usar

    private By inputPassword = By.cssSelector("input[data-qa='password']");

    private By selectDays   = By.cssSelector("select[data-qa='days']");
    private By selectMonths = By.cssSelector("select[data-qa='months']");
    private By selectYears  = By.cssSelector("select[data-qa='years']");

    private By inputFirstName = By.cssSelector("input[data-qa='first_name']");
    private By inputLastName  = By.cssSelector("input[data-qa='last_name']");
    private By inputCompany   = By.cssSelector("input[data-qa='company']");
    private By inputAddress   = By.cssSelector("input[data-qa='address']");
    private By inputAddress2   = By.cssSelector("input[data-qa='address2']");
    private By selectCountry  = By.cssSelector("select[data-qa='country']");
    private By inputState     = By.cssSelector("input[data-qa='state']");
    private By inputCity      = By.cssSelector("input[data-qa='city']");
    private By inputZipcode   = By.cssSelector("input[data-qa='zipcode']");
    private By inputMobile    = By.cssSelector("input[data-qa='mobile_number']");
    private By buttonCreateAccount = By.cssSelector("button[data-qa='create-account']");

    public SignupPage(WebDriver driver) {
        this.driver = driver;
    }

    public AccountCreatedPage preencherFormularioCompleto() {
        driver.findElement(radioMr).click();
        driver.findElement(inputPassword).sendKeys("Senha123");

        new Select(driver.findElement(selectDays)).selectByValue("2");
        new Select(driver.findElement(selectMonths)).selectByValue("2");
        new Select(driver.findElement(selectYears)).selectByValue("2004");

        driver.findElement(inputFirstName).sendKeys("Arthur");
        driver.findElement(inputLastName).sendKeys("Fortunato");
        driver.findElement(inputCompany).sendKeys("Fortunato's");
        driver.findElement(inputAddress).sendKeys("Rua aleatoria");
        driver.findElement(inputAddress2).sendKeys("Rua aleatoria2");

        new Select(driver.findElement(selectCountry)).selectByVisibleText("United States");

        driver.findElement(inputState).sendKeys("RJ");
        driver.findElement(inputCity).sendKeys("Rio de Janeiro");
        driver.findElement(inputZipcode).sendKeys("12345678");
        driver.findElement(inputMobile).sendKeys("21123456789");

        driver.findElement(buttonCreateAccount).click();

        return new AccountCreatedPage(driver);
    }
}
