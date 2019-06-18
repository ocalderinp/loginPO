import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.appointments.*;

public class TestCureHealth {

    WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;
    AppointmentPage appointmentPage;
    FinalPage finalPage;
    String usuario = "John Doe";
    String password = "ThisIsNotAPassword";

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com");
        homePage = new HomePage(driver);
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

        finalPage = appointmentPage.addAppointment("17/06/2019","Comentario","Hongkong CURA Healthcare Center","Medicaid");

        Assert.assertTrue(finalPage.titleIsDisplayed());
        Assert.assertTrue(finalPage.titleText());
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
