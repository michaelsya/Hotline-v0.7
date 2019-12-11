package PageObjects;

import Elements.*;
import Helpers.DriverManager;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

@Getter
public class AbstractPage {
    private By searchFieldLR = By.id("searchbox");
    private By homePageLR = By.cssSelector("[href] [alt='Hotline – сравнить цены в интернет-магазинах Украины']");
    private By magnifyingGlassButtonLR = By.id("doSearch");
    Button homePage = new Button(homePageLR, "Home Page");
    Field searchField = new Field(searchFieldLR, "Search Field");
    Button magnifyingGlassButton = new Button(magnifyingGlassButtonLR, "Magnifying " +
            "Glass Button to perform search");
    public List<WebElement> getWebElementsList(By elementsLocator) {
        return DriverManager.getDriver().findElements(elementsLocator);
    }
    public static void closeBrowser(){
        DriverManager.killDriver();
    }
}
