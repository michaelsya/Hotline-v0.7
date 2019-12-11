package PageObjects;
import Helpers.DriverManager;
import Elements.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class SearchResultPage extends AbstractPage {
    private By firstItemInTheListLR = new By.ByCssSelector("li:nth-of-type(1) > .item-price.stick-bottom > " +
            "div:nth-of-type(1) > div:nth-of-type(3) > .link");
    private By nextPageLR = new By.ByCssSelector("a[title='Следующая']");
    private By sortByDropDownLR = new By.ByCssSelector("[name='sort']");
    private By allPricesOnCurrentPageLR = new By.ByXPath("//div[@class='price-md']/span[@class='value']");

    Button firstItemInTheList = new Button(firstItemInTheListLR, "First item from the Search Result page");
    Button nextPage = new Button(nextPageLR, "Show next page button");
    DropDownList sortByDropDown = new DropDownList(sortByDropDownLR, "Sort by drop down list");
    Description allPricesOnCurrentPage = new Description(allPricesOnCurrentPageLR, "item Price");

    public ItemPage clickOnFirstItemFromSearchResult() {
        DriverManager.getDriver().findElement(firstItemInTheListLR).click();
        return new ItemPage();
    }

    public SearchResultPage clickNextPage() {
        try{
            Thread.sleep(3000);
        } catch (Exception e){
            System.out.println("Warning, thread exception encountered");
        }
        DriverManager.getDriver().findElement(nextPageLR).click();
        return new SearchResultPage();
    }

    public SearchResultPage selectButtonFromDropDown(String buttonName){
        sortByDropDown.clickOnItemInsideDropDownList(buttonName);
        return this;
    }

    public List<Double> pagePriceList() {
        List<Double> elementListConvertedToDouble = new ArrayList<>();
        for (WebElement element:getWebElementsList(allPricesOnCurrentPageLR)) {
            String elementText = element.getText().replaceAll("\\s+", "");
            elementListConvertedToDouble.add(Double.parseDouble(elementText));
        }
        return elementListConvertedToDouble;
    }
}
