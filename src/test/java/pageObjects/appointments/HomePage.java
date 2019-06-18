package pageObjects.appointments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.BasePage;

public class HomePage extends BasePage {

    @FindBy(id = "btn-make-appointment")
    WebElement makeAppointmentButton;


    public HomePage (WebDriver driver) {
        super(driver);
    }

    public LoginPage clickAppointmentButton(){
        makeAppointmentButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h2")));
        return new LoginPage(driver);
    }
}
