package pageObjects.appointments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pageObjects.BasePage;

public class FinalPage extends BasePage {

    @FindBy(how = How.TAG_NAME, using = "h2")
    WebElement title;

    @FindBy(id = "facility")
    WebElement txtFacility;

    @FindBy(id = "program")
    WebElement txtProgram;

    @FindBy(id = "hospital_readmission")
    WebElement txtHospital;

    @FindBy(id = "visit_date")
    WebElement txtVisitDate;

    @FindBy(id = "comment")
    WebElement txtComment;

    public FinalPage(WebDriver driver){
        super(driver);
    }

    public boolean titleIsDisplayed(){
        return title.isDisplayed();
    }

    public boolean titleContain(){
        return title.getText().contains("Appointment Confirmation");
    }

    public boolean facilityContain(String texto){
        return txtFacility.getText().contains(texto);
    }

    public boolean hospitalContain(boolean valor){
        if(valor)
            return txtHospital.getText().contains("Yes");
        else return txtHospital.getText().contains("No");
    }

    public boolean commentContain(String comment){
        return txtComment.getText().contains(comment);
    }

    public boolean healthcareProgram(String medicaid) {
        return txtProgram.getText().contains(medicaid);
    }

    public boolean verifyDate(String fecha) {
        return txtVisitDate.getText().contains(fecha);

    }
}
