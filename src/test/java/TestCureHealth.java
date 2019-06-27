import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
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
    String usuario;
    String password;
    SoftAssert SA;

    @BeforeMethod(alwaysRun = true)
    @Parameters({"usuario", "password"})
    public void setUp(String usuario, String password){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com");
        homePage = new HomePage(driver);
        SA = new SoftAssert();
        this.usuario = usuario;
        this.password = password;
    }

    @Test
    public void login() {
        loginPage = homePage.clickAppointmentButton();
        Assert.assertTrue(loginPage.verifyIsLoginPage());
        appointmentPage = loginPage.loginSuccess(usuario, password);
        Assert.assertTrue(appointmentPage.textDisplayedAfterLogin());
    }

    @Test(dataProvider = "badLogin", dataProviderClass = badLoginDataProvider.class)
    public void badLogin(String usuario, String password) {
        loginPage = homePage.clickAppointmentButton();
        Assert.assertTrue(loginPage.verifyIsLoginPage());
        loginPage.loginFail(usuario, password);
        Assert.assertTrue(loginPage.loginFailed());
    }

//    @Parameters({"usuario", "password"})
    @Test(dataProvider = "addappointment", dataProviderClass = badLoginDataProvider.class)
    public void testAppointment(String Calendar, String comment, String radio, String facility, boolean check){
        loginPage = homePage.clickAppointmentButton();
        appointmentPage = loginPage.loginSuccess(usuario, password);

        finalPage = appointmentPage.addAppointment(Calendar, comment, facility, radio, check);

        Assert.assertTrue(finalPage.titleIsDisplayed());
        Assert.assertTrue(finalPage.titleContain());

        SA.assertTrue(finalPage.titleContain());
        SA.assertTrue(finalPage.titleIsDisplayed());
        SA.assertTrue(finalPage.facilityContain(facility));
        SA.assertTrue(finalPage.hospitalContain (check));
        SA.assertTrue(finalPage.healthcareProgram(radio));
        SA.assertTrue(finalPage.verifyDate(Calendar));
        SA.assertTrue(finalPage.commentContain(comment));
        SA.assertAll();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }

}
