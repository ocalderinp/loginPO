package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.opencart.NavBar;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected NavBar navBar;

    public BasePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
        navBar = new NavBar(driver);
    }

    public void searchProduct(String product){
        navBar.searchProduct(product);
    }
}
