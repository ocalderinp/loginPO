package pageObjects.appointments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.BasePage;

public class LoginPage extends BasePage {

    //Ubicacion de elementos con pageFactory
    @FindBy(id = "txt-username")
    WebElement usernameField;

    @FindBy(id = "txt-password")
    WebElement passwordField;

    @FindBy(id = "btn-login")
    WebElement loginButton;

    @FindBy(xpath = "//h2[contains(text(), 'Login')]")
    WebElement loginTitle;

    //Constructor que hereda de basePage
    public LoginPage (WebDriver driver) {
        super(driver);
    }

    //Operaciones del pageObject
    public AppointmentPage loginSuccess (String username, String password){
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h2")));
        return new AppointmentPage(driver);
    }

    public boolean verifyIsLoginPage() {
        return loginTitle.isDisplayed();
    }

}
