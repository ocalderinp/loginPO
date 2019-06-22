package pageObjects.appointments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import pageObjects.BasePage;

public class AppointmentPage extends BasePage {

    @FindBy(id = "combo_facility")
    WebElement inputFacility;

    @FindBy(id = "chk_hospotal_readmission")
    WebElement inputHospital;

    @FindBy(id = "radio_program_medicare")
    WebElement inputMedicare;

    @FindBy(id = "radio_program_medicaid")
    WebElement inputMedicaid;

    @FindBy(id = "radio_program_none")
    WebElement inputNone;

    @FindBy(id = "txt_visit_date")
    WebElement inputDate;

    @FindBy(id = "txt_comment")
    WebElement inputComment;

    @FindBy(id = "btn-book-appointment")
    WebElement btnAppointment;

    public AppointmentPage (WebDriver driver){
        super(driver);
    }

    public boolean textDisplayedAfterLogin() {
        return driver.findElement(By.tagName("h2")).getText().contains("Make Appointment");
    }

    public FinalPage addAppointment(String calendar, String comment,
                                    String comboFacility, String program, boolean applyHospital){
        Select combo = new Select(inputFacility);
        combo.selectByValue(comboFacility);

        if(applyHospital)
            inputHospital.click();

        if(program.equals("Medicaid")){
            inputMedicaid.click();
        }else if (program.equals("Medicare")){
            inputMedicare.click();
        }else{
            inputNone.click();
        }

        inputDate.sendKeys(calendar);
        inputComment.sendKeys(comment);
        btnAppointment.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h2")));

        return new FinalPage(driver);
    }
}
