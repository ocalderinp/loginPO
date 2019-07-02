import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.appointments.AppointmentPage;
import pageObjects.appointments.HomePage;
import pageObjects.appointments.LoginPage;

import java.net.MalformedURLException;
import java.net.URL;

public class RemoteTest {

    WebDriver driver;
    String hub = "http://localhost:4444/wd/hub";
    LoginPage loginPage;
    HomePage homePage;
    AppointmentPage appointmentPage;
    String usuario = "John Doe";
    String password = "ThisIsNotAPassword";

    @BeforeMethod
    public void setup() throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
        driver = new RemoteWebDriver(new URL(hub), DesiredCapabilities.firefox());
        homePage = new HomePage(driver);
        driver.get("https://katalon-demo-cura.herokuapp.com");
        driver.manage().window().maximize();
    }

    @Test
    public void testLogin(){
        loginPage = homePage.clickAppointmentButton();
        Assert.assertTrue(loginPage.verifyIsLoginPage());
        appointmentPage = loginPage.loginSuccess(usuario, password);
        Assert.assertTrue(appointmentPage.textDisplayedAfterLogin());
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
