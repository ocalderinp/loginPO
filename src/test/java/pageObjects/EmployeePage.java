package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class EmployeePage {
    private WebDriver driver;

    @FindBy(how = How.TAG_NAME, using = "h4")
    WebElement textoPagina;

    public EmployeePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean textoPaginaIsDisplayed(){
        return textoPagina.isDisplayed();
    }

    public boolean textoPaginaContainsText(String text){
        return textoPagina.getText().contains(text);
    }
}
