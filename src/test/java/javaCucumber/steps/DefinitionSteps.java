package javaCucumber.steps;

import cucumber.api.PendingException;
import net.thucydides.core.annotations.Steps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import javaCucumber.steps.serenity.EndUserSteps;

public class DefinitionSteps {

    @Steps
    EndUserSteps endUserSteps;

    @Given("^open homepage \"([^\"]*)\"$")
    public void openHomepage(String url) throws Throwable {
        endUserSteps.open(url);
    }

    @Then("^close browser$")
    public void closeBrowser() throws Throwable {
        endUserSteps.close();
    }

    @When("^type \"([^\"]*)\" into search field$")
    public void typeIntoSearchField(String prod) throws Throwable {
        endUserSteps.enterRequiredProduct(prod);
    }

    @When("^click search button$")
    public void clickSearchButton() throws Throwable {
        endUserSteps.clickSearchButton();
    }

    @Then("^search page with current product should be shown$")
    public void searchPageWithCurrentProductShouldBeShown() throws Throwable {
        endUserSteps.checkProductOnThePage();
    }

    @When("^click right button to slide images to the right$")
    public void clickRightButtonToSlideImagesToTheRight() throws Throwable {
        endUserSteps.clickButtonToTheRight();
    }

    @Then("^next image should be shown$")
    public void nextImageShouldBeShown() throws Throwable {
        endUserSteps.checkNextImage();
    }

    @When("^click left button to slide images to the left$")
    public void clickLeftButtonToSlideImagesToTheLeft() throws Throwable {
        endUserSteps.clickButtonToTheLeft();
    }

    @Then("^previous image should be shown$")
    public void previousImageShouldBeShown() throws Throwable {
        endUserSteps.checkPrevImage();
    }

    @When("^click contact button in the top bar$")
    public void clickContactButtonInTheTopBar() throws Throwable {
        endUserSteps.clickContactsButton();
    }

    @Then("^contact page should be opened$")
    public void contactPageShouldBeOpened() throws Throwable {
        endUserSteps.checkContactsPage();
    }

    @When("^hover mouse on the change language button$")
    public void hoverMouseOnTheChangeLanguageButton() throws Throwable {
        endUserSteps.openLangContainer();
    }

    @When("^select \"([^\"]*)\" language$")
    public void selectLanguage(String lang) throws Throwable {
        endUserSteps.selectLang(lang);
    }

    @Then("^site should be shown in selected language$")
    public void siteShouldBeShownInSelectedLanguage() throws Throwable {
        endUserSteps.checkSiteLang();
    }

    @When("^type into search field require model \"([^\"]*)\"$")
    public void typeIntoSearchFieldRequireModel(String prod) throws Throwable {
        endUserSteps.typeRequiredProduct(prod);
    }

    @When("^click on the buy button$")
    public void clickOnTheBuyButton() throws Throwable {
        endUserSteps.clickBuyButton();
    }

    @Then("^check that cart page is opened$")
    public void checkThatCartPageIsOpened() throws Throwable {
        endUserSteps.checkCartPage();
    }

    @When("^click on the social \"([^\"]*)\"$")
    public void clickOnTheSocial(String link) throws Throwable {
        endUserSteps.clickOnTheSocial(link);
    }

    @Then("^social \"([^\"]*)\" should be opened$")
    public void socialShouldBeOpened(String site) throws Throwable {
        endUserSteps.checkSite(site);
    }

    @When("^click on the blog link$")
    public void clickOnTheBlogLink() throws Throwable {
        endUserSteps.clickBlogbutton();
    }

    @Then("^blog page should be opened$")
    public void blogPageShouldBeOpened() throws Throwable {
        endUserSteps.checkBlogPage();
    }

    @When("^hover mouse on the catalog button$")
    public void hoverMouseOnTheCatalogButton() throws Throwable {
        endUserSteps.openCatalogMenu();
    }

    @Then("^catalog menu should be shown$")
    public void catalogMenuShouldBeShown() throws Throwable {
        endUserSteps.checkCatalogMenu();
    }

    @When("^select required product type$")
    public void selectRequiredProductType() throws Throwable {
        endUserSteps.selectProduct();
    }

    @Then("^search page with selected products should be shown$")
    public void searchPageWithSelectedProductsShouldBeShown() throws Throwable {
        endUserSteps.checkProductsPage();
    }

    @When("^change page view with different \"([^\"]*)\"$")
    public void changePageViewWithDifferent(String view) throws Throwable {
        endUserSteps.changePageview(view);
    }

    @Then("^page should be shown in \"([^\"]*)\" format$")
    public void pageShouldBeShownInFormat(String checkView) throws Throwable {
        endUserSteps.checkPageView(checkView);
    }


}
