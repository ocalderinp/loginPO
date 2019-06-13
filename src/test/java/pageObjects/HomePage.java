package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;

    @FindBy(how = How.ID, using = "user")
    WebElement inputUser;

    @FindBy(how = How.ID, using = "pass")
    WebElement inputPassword;

//    @FindBy(how = How.ID, using = "loginButton")
    WebElement loginButton;

    @FindBy(how = How.NAME, using = "errorMessage")
    WebElement messageError;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public EmployeePage login(String usuario, String password){
        inputUser.sendKeys(usuario);
        inputPassword.sendKeys(password);
        loginButton.click();
        return new EmployeePage(driver);
    }

    public void incorrectLogin(String usuario, String password){
        inputUser.sendKeys(usuario);
        inputPassword.sendKeys(password);
        loginButton.click();
    }

    public boolean messageErrorIsDisplayed(){
        return messageError.isDisplayed();
    }


}
