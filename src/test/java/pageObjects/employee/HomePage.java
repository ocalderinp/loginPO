package pageObjects.employee;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.BasePage;

public class HomePage extends BasePage {
    @FindBy(how = How.ID, using = "user")
    private WebElement inputUser;

    @FindBy(how = How.ID, using = "pass")
    private WebElement inputPassword;

    @FindBy(how = How.ID, using = "loginButton")
    private WebElement loginButton;

//    @FindBy(how = How.NAME, using = "errorMessage")
    @FindBy(name = "errorMessage")
    private WebElement messageError;

    public HomePage(WebDriver driver){
        super(driver);
    }

    public EmployeePage login(String usuario, String password){
        inputUser.sendKeys(usuario);
        inputPassword.sendKeys(password);
        loginButton.click();
        wait.until(ExpectedConditions.titleIs("Add Employee v2 – Verstand QA"));
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
