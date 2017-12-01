package javaCucumber.steps.serenity;

import javaCucumber.pages.HomePage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

public class EndUserSteps extends ScenarioSteps {
HomePage homePage;

    @Step
    public void open(String url) {
        //getDriver().manage().window().maximize();
        getDriver().get(url);
    }

    @Step
    public void close() {
        getDriver().quit();
    }

    @Step
    public void enterRequiredProduct(String prod) {
        getDriver().findElement(By.xpath("//input[@class='input-text']")).sendKeys(prod);
    }

    @Step
    public void clickSearchButton() {
        getDriver().findElement(By.xpath("//*[@id='search_mini_form']/button")).click();
    }

    @Step
    public void checkProductOnThePage() {
        assertTrue(getDriver().findElement(By.xpath("(//a[@title = 'Sony Xperia XZ F8332 Dual Platinum'])[2]")).isDisplayed());
    }

    @Step
    public void clickButtonToTheRight() {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(getDriver().findElement(By.xpath("//div[@class = 'rubber-slide']")), 100, 100).perform();
        waitABit(3000);
        getDriver().findElement(By.xpath("//a[@class = 'mover next']")).click();
    }

    @Step
    public void checkNextImage() {
        waitABit(1000);
        assertTrue(getDriver().findElement(By.xpath("//div[@id = 'slide2']")).isDisplayed());
    }

    @Step
    public void clickButtonToTheLeft() {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(getDriver().findElement(By.xpath("//div[@class = 'rubber-slide']")), 100, 100).perform();
        getDriver().findElement(By.xpath("//a[@class = 'mover prev']")).click();
    }

    @Step
    public void checkPrevImage() {
        waitABit(1000);
        assertTrue(getDriver().findElement(By.xpath("//div[@id = 'slide1']")).isDisplayed());
    }

    @Step
    public void clickContactsButton() {
        getDriver().findElement(By.xpath("//a[@class = 'info1_kontakty']")).click();
    }

    @Step
    public void checkContactsPage() {
        assertTrue(getDriver().getTitle().contains("Контакты"));
        assertTrue(getDriver().findElement(By.xpath("//div[@class = 'breadcrumbs']//li[@class='cms_page']")).isDisplayed());
    }

    @Step
    public void openLangContainer() {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(getDriver().findElement(By.xpath("//div[@class = 'store-switcher-container']")), 54, 23).perform();
    }

    @Step
    public void selectLang(String lang) {
        getDriver().findElement(By.xpath("//span[contains(text(), '" + lang + "')]")).click();
    }

    @Step
    public void checkSiteLang() {
        waitABit(2000);
        assertTrue(getDriver().findElement(By.xpath("//span[@class='menu-icon']/following-sibling::span[@class='caption']")).getText().equals("Каталог товарів"));
    }

    @Step
    public void typeRequiredProduct(String prod) {
        getDriver().findElement(By.xpath("//input[@class='input-text']")).sendKeys(prod);
        getDriver().findElement(By.xpath("//*[@id='search_mini_form']/button")).click();
        getDriver().findElement(By.xpath("//div[@class='product-container-all catalogcolorconf']//p/a")).click();
    }

    @Step
    public void clickBuyButton() {
        getDriver().findElement(By.xpath("//button[@class='buy big']")).click();
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='button-checkout-popup']")));
        getDriver().findElement(By.xpath("//*[@id='button-checkout-popup']")).click();
    }

    @Step
    public void checkCartPage() {
        assertTrue(getDriver().findElement(By.xpath("//div[@class='checkout-container customer_not_logged_in']/h1")).getText().contains("Оформление заказа"));
    }

    @Step
    public void clickOnTheSocial(String link) {
        WebElement element = getDriver().findElement(By.xpath("//ul[@class='weinsocial_ul']"));
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        getDriver().findElement(By.xpath("//a[@href='https://" + link + ".com/allo']")).click();
        for (String winHandle : getDriver().getWindowHandles()) {
            getDriver().switchTo().window(winHandle);
        }
    }

    @Step
    public void checkSite(String site) {
        waitABit(3000);
        assertTrue(getDriver().getCurrentUrl().contains(site));
    }

    @Step
    public void clickBlogbutton() {
        getDriver().findElement(By.xpath("//a[contains(text(), 'Блог')]")).click();
        for (String winHandle : getDriver().getWindowHandles()) {
            getDriver().switchTo().window(winHandle);
        }
    }

    @Step
    public void checkBlogPage() {
        assertTrue(getDriver().getCurrentUrl().contains("blog"));
    }

    @Step
    public void openCatalogMenu() {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(getDriver().findElement(By.xpath("//span[.='Смартфоны и телефоны']")), 149, 15).perform();
    }

    @Step
    public void checkCatalogMenu() {
        assertTrue(getDriver().findElement(By.cssSelector("div#menu_mobile_phone[style='display: block;']")).isDisplayed());
    }

    @Step
    public void selectProduct() {
        getDriver().findElement(By.xpath("//div[@id ='menu_mobile_phone']//a[contains(text(), 'Sony')]")).click();
    }

    @Step
    public void checkProductsPage() {
        assertTrue(getDriver().findElement(By.xpath("//h1[contains(text(), 'Телефоны Sony')]")).isDisplayed());
    }

    @Step
    public void changePageview(String view) {
        getDriver().findElement(By.xpath("(//a[@class='" + view + "'])[1]")).click();
    }

    @Step
    public void checkPageView(String checkView) {
        waitABit(2000);
        assertTrue(getDriver().findElement(By.xpath(checkView)).isDisplayed());
    }


}