package StepDefs;

import PageObjects.HomePage;
import PageObjects.ItemPage;
import PageObjects.SearchResultPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class TVSearch {
    @Given("I am on the {string} website")
    public void iAmOnTheWebsite(String url) {
        new HomePage().openHomePage(url);
    }

    @When("I enter {string} in the search field")
    public void iEnterInTheSearchField(String textToSearch) {
        new HomePage().inputToSearchField(textToSearch);
    }

    @When("click on search")
    public void clickOnSearch() {
        new HomePage().doSearch();
    }

    @When("I click on the first item in the list on a search result page")
    public void iClickOnTheFirstItemInTheListOnASearchResultPage() {
        new SearchResultPage().clickOnFirstItemFromSearchResult();
    }

    @Then("I see a word {string} in the item description")
    public void iSeeAWordInTheItemDescription(String keyword) {
        Assert.assertTrue(new ItemPage().getFirstItemDescriptionText().contains(keyword));
    }
}
