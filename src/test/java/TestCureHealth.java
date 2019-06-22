import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.appointments.AppointmentPage;
import pageObjects.appointments.FinalPage;
import pageObjects.appointments.HomePage;
import pageObjects.appointments.LoginPage;

public class TestCureHealth {

    WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;
    AppointmentPage appointmentPage;
    FinalPage finalPage;
    String usuario = "John Doe";
    String password = "ThisIsNotAPassword";
    SoftAssert SA;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com");
        homePage = new HomePage(driver);
        SA = new SoftAssert();
    }


    @Test
    public void login() {
        loginPage = homePage.clickAppointmentButton();
        Assert.assertTrue(loginPage.verifyIsLoginPage());
        appointmentPage = loginPage.loginSuccess(usuario, password);
        Assert.assertTrue(appointmentPage.textDisplayedAfterLogin());
    }

    @Test
    public void testAppointment(){
        loginPage = homePage.clickAppointmentButton();
        appointmentPage = loginPage.loginSuccess(usuario, password);

        finalPage = appointmentPage.addAppointment("17/06/2019",
                "Comentario","Hongkong CURA Healthcare Center",
                "Medicaid", true);

        Assert.assertTrue(finalPage.titleIsDisplayed());
        Assert.assertTrue(finalPage.titleContain());

        SA.assertTrue(finalPage.titleContain());
        SA.assertTrue(finalPage.titleIsDisplayed());
        SA.assertTrue(finalPage.facilityContain("Hongkong CURA Healthcare Center"));
        SA.assertTrue(finalPage.hospitalContain(true));
        SA.assertTrue(finalPage.healthcareProgram("Medicaid"));
        SA.assertTrue(finalPage.verifyDate("17/06/2019"));
        SA.assertTrue(finalPage.commentContain("Comentario"));

    }

    @AfterMethod
    public void tearDown(){
        SA.assertAll();
        driver.quit();
    }

}
