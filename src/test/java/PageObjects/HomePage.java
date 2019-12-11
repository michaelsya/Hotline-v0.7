package PageObjects;

import Helpers.DriverManager;

public class HomePage extends AbstractPage {
    public HomePage openHomePage(String homePageURL) {
        DriverManager.getDriver().get(homePageURL);
        return this;
    }

    public HomePage inputToSearchField(String input) {
        DriverManager.getDriver().findElement(getSearchFieldLR()).sendKeys(input);
        return this;
    }

    public SearchResultPage doSearch() {
        try{
            Thread.sleep(1000);
        } catch (Exception e){
            System.out.println("Warning, thread exception encountered");
        }
        DriverManager.getDriver().findElement(getMagnifyingGlassButtonLR()).click();
        return new SearchResultPage();
    }
}
