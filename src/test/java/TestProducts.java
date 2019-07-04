import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.opencart.HomeOpencart;
import pageObjects.opencart.ProductItem;

import java.util.List;

public class TestProducts {
    WebDriver driver;
    HomeOpencart home;

    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver",
                "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://opencart.abstracta.us/");
        home = new HomeOpencart(driver);
    }


    @Test
    public void verifySimbolTaxes(){

        List<ProductItem> listadoProductos =
                home.getProducts();
        for(ProductItem productItem : listadoProductos){
            Assert.assertTrue(productItem.getTaxes().contains("$"));
        }
        for(ProductItem p : listadoProductos){
            if (p.getName().equals("Apple Cinema 30\"")){
                p.addToWish();
            }
        }
    }

    @Test
    public void testSearch(){
        home.searchProduct("iMac");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
