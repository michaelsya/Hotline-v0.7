package tests;

import Helpers.DriverManager;
import PageObjects.AbstractPage;
import PageObjects.HomePage;
import PageObjects.ItemPage;
import PageObjects.SearchResultPage;
import org.junit.*;

public class TestSearchFeature {

    @Before
    public void setupForTVTests() {
        new HomePage().openHomePage("http://hotline.ua/")
                .inputToSearchField("телевизоры")
                .doSearch();
    }

    @Test
    public void priceTestForFirstFivePages() {
        SearchResultPage searchResultPage = new SearchResultPage();
        searchResultPage.selectButtonFromDropDown("возрастанию цены");
        for (int i = 0; i < 5; i++) {
            boolean priceVerifier = searchResultPage.pagePriceList().stream().allMatch(price -> price < 10000);
            Assert.assertTrue(priceVerifier);
            searchResultPage.clickNextPage();

        }
    }

    @Test
    public void tvSearchTest() {
        String firstItemDescriptionText = new SearchResultPage()
                .clickOnFirstItemFromSearchResult()
                .getFirstItemDescriptionText();
        Assert.assertTrue(firstItemDescriptionText.contains("телевизор"));
    }

    @After
    public void closeBrowser(){
        AbstractPage.closeBrowser();
    }


}