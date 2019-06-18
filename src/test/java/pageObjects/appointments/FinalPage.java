package pageObjects.appointments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pageObjects.BasePage;

public class FinalPage extends BasePage {

    @FindBy(how = How.TAG_NAME, using = "h2")
    WebElement title;

    public FinalPage(WebDriver driver){
        super(driver);
    }

    public boolean titleIsDisplayed(){
        return title.isDisplayed();
    }

    public boolean titleText(){
        return title.getText().contains("Appointment Confirmation");
    }
}
