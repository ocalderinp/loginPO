package pageObjects.opencart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavBar {
    private WebDriver driver;

    @FindBy(name = "search")
    WebElement searchInput;

    @FindBy(xpath = "//*[contains(@class, 'fa-search')]/ancestor::button")
    WebElement btnSearch;

    public NavBar(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchProduct(String product){
        searchInput.sendKeys(product);
        btnSearch.click();
    }
}
