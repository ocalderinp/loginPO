import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestProducts {

    WebDriver driver;
    @Test
    public void verifySimbolTaxes(){
        System.setProperty("webdriver.chrome.driver",
                "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://opencart.abstracta.us/");
        HomeOpencart home = new HomeOpencart(driver);
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
}
