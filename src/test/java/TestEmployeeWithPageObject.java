import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.employee.EmployeePage;
import pageObjects.employee.HomePage;

public class TestEmployeeWithPageObject {
    private WebDriver driver;
    private HomePage homePage;
    private EmployeePage employeePage;

    @BeforeMethod
    public void setupTest(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://verstandqa.com/login-employee-v2/");
        homePage = new HomePage(driver);
    }

    @Test
    public void testLogin(){
        employeePage = homePage.login("admin", "admin123");
        Assert.assertTrue(employeePage.textoPaginaIsDisplayed());
        Assert.assertTrue(employeePage.textoPaginaContainsText("Add Employee"));
    }

    @Test
    public void testLoginIncorrecto(){
        homePage.incorrectLogin("administrador", "admin1234");
        Assert.assertTrue(homePage.messageErrorIsDisplayed());
    }

    @Test
    public void addEmployed(){
        employeePage = homePage.login("admin","admin123");
        employeePage.addEmployee("Simon", "Rivera 123","Montevideo","Montevideo",
                "123456","s.s@gmail.com","3216548");

        Assert.assertTrue(employeePage.messageSuccessIsDisplayed());
        Assert.assertTrue(employeePage.messageSuccessTextRight());
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
