package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class EmployeePage extends BasePage{
    @FindBy(how = How.TAG_NAME, using = "h4")
    private WebElement textoPagina;

    @FindBy(how = How.ID, using = "name")
    private WebElement name;

    @FindBy(how = How.ID, using = "address")
    private WebElement address;

    @FindBy(how = How.CSS, using = "[placeholder=\"City\"]")
    private WebElement city;

    @FindBy(how = How.ID, using = "state")
    private WebElement state;

    @FindBy(how = How.ID, using = "postcode")
    private WebElement postcode;

    @FindBy(how = How.ID, using = "email")
    private WebElement email;

    @FindBy(how = How.ID, using = "phoneNumber")
    private WebElement phone;

    WebElement addButton;

    @FindBy(how = How.ID, using = "success-alert")
    private WebElement success;

    public EmployeePage(WebDriver driver){
        super(driver);
    }

    public boolean textoPaginaIsDisplayed(){
        return textoPagina.isDisplayed();
    }

    public boolean textoPaginaContainsText(String text){
        return textoPagina.getText().contains(text);
    }

    public void addEmployee(String name, String address, String city, String state, String postal, String email,
                            String  phone){
        this.name.sendKeys(name);
        this.address.sendKeys(address);
        this.city.sendKeys(city);
        this.state.sendKeys(state);
        this.postcode.sendKeys(postal);
        this.email.sendKeys(email);
        this.phone.sendKeys(phone);
        addButton.click();
    }

    public boolean messageSuccessIsDisplayed(){
        return success.isDisplayed();
    }

    public boolean messageSuccessTextRight() {
        return success.getText().contains("Employee added successfully.");
    }
}
