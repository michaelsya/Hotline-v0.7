package StepDefs;

import PageObjects.HomePage;
import PageObjects.SearchResultPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class ItemSearch {

    @And("select sort by {string} dropdown option")
    public void selectSortByDropdownOption(String dropDownOption){
        new SearchResultPage().selectButtonFromDropDown(dropDownOption);
    }

    @Then("I see no prices higher than {string} on the first {string} pages")
    public void iSeeNoPricesHigherThanOnTheFirstPages(String targetPrice, String pagesToCheck) {
        SearchResultPage searchResultPage = new SearchResultPage();
        for (int i = 0; i < Integer.parseInt(pagesToCheck); i++ ) {
            boolean priceVerifier = searchResultPage.pagePriceList().stream().allMatch(price -> price
                    < Double.parseDouble(targetPrice));
            Assert.assertTrue(priceVerifier);
            searchResultPage.clickNextPage();

        }
    }



}