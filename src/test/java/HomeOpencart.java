import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.BasePage;

import java.util.ArrayList;
import java.util.List;

public class HomeOpencart extends BasePage {

    @FindBy(className = "product-layout")
    List<WebElement> listado;


    public HomeOpencart(WebDriver driver) {
        super(driver);
    }

    public List<ProductItem> getProducts(){
        List<ProductItem> listadoProductos = new ArrayList<>();
        for(WebElement e : listado){
            listadoProductos.add(new ProductItem(e));
        }
        return listadoProductos;
    }


}
