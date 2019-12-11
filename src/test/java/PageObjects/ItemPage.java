package PageObjects;

import Helpers.DriverManager;
import Elements.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ItemPage extends AbstractPage {

    private By itemDescriptionLR = By.cssSelector(".text:nth-child(2) p");
    Description itemDescription = new Description(itemDescriptionLR, "Item Description");

    public String getFirstItemDescriptionText() {

        DriverManager.wait.until(ExpectedConditions.visibilityOfElementLocated(itemDescriptionLR));
        return DriverManager.getDriver().findElement(itemDescriptionLR).getText();
    }

}
