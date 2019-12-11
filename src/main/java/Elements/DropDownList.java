package Elements;

import Helpers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.ui.Select;


public class DropDownList {
    private By dropDownLocator;
    public DropDownList(By locator, String description) {
        dropDownLocator = locator;
    }

    public void clickOnItemInsideDropDownList(String uiButtonName) {
        new Select(DriverManager.getDriver().findElement(dropDownLocator )).selectByVisibleText(uiButtonName);
    }
}
