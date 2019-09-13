package FunctionalTestingTestSuites.Desktop.Regression.Scenarios.Success;

import FunctionalTestingTestSuites.Utils.Properties.N11PropertyUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.openqa.selenium.*;
import org.testng.annotations.*;
import org.openqa.selenium.support.ui.*;



import static FunctionalTestingTestSuites.Constant.Constants.*;
import static FunctionalTestingTestSuites.Desktop.Regression.Constant.N11Constant.*;

public class N11SuccessRegression extends N11PropertyUtils {

    private static final Logger logger = Logger.getLogger(N11SuccessRegression.class);
    private WebDriver driver;

    @BeforeTest
    public void launchWebApplication() {
        loadProperties();

        logger.info(N11 + "Launch N11 Web Application | " + getProperties(N11_URL));

        System.setProperty(getProperties(CHROME_DRIVER), getProperties(CHROME_DRIVER_LIB));
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to(getProperties(N11_URL));
        Assert.assertEquals(getProperties(N11_URL), driver.getCurrentUrl());
        driver.manage().window().maximize();

        logger.info(N11 + " Regression Successful Scenarios TestSuites Started ");
    }

    @Test(priority = 1)
    public void regressionSuccess() {
        logger.info(N11 + " Regression Success Login, Search, Basket Test Case Started");

        try {

            Actions action = new Actions(driver);
            WebDriverWait wait = new WebDriverWait(driver, 10);

    /* n11.com login page and login */
            WebElement signInButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(SIGNIN_BUTTON_ELEMENT)));
            signInButton.click();

            WebElement inputEmail = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(EMAIL_ELEMENT)));
            WebElement inputPassword = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(PASSWORD_ELEMENT)));
            WebElement loginButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(LOGIN_BUTTON_ELEMENT)));

            action.moveToElement(inputEmail).click().perform();
            inputEmail.sendKeys(getProperties(EMAIL));
            action.moveToElement(inputPassword).click().perform();
            inputPassword.sendKeys(getProperties(PASSWORD));
            loginButton.click();

            WebElement loginText = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(LOGIN_CHECK_TEXT_ELEMENT)));
            Assert.assertEquals(getProperties(LOGIN_NAME), loginText.getText());

    /* home page search and next page */
            WebElement search = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(SEARCH_ELEMENT)));
            search.click();
            search.sendKeys(SEARCH_TEXT);
            WebElement searchButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(SEARCH_BUTTON_ELEMENT)));
            searchButton.click();

            driver.findElement(By.linkText("2")).click();
            Thread.sleep(5000);
            Assert.assertEquals(getProperties(N11_WEBSITE_URL) + SEARCH_RESULT_PAGE_NUMBER_CHECK_URL, driver.getCurrentUrl());
            WebElement selectProduct = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(SELECT_PRODUCT_ELEMENT)));
            selectProduct.click();

    /* search result, product detail and basket (add, piece, delete)  */
            WebElement addBasket = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ADD_BASKET_ELEMENT)));
            addBasket.click();
            Thread.sleep(2000);
            /*
            WebElement productPrice = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(PRODUCT_PRICE_CHECK_ELEMENT)));
            Assert.assertEquals(PRODUCT_PRICE_TEXT, productPrice.getText());
            Thread.sleep(2000);
            WebElement basketPrice = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(BASKET_PRICE_CHECK_ELEMENT)));
            Assert.assertEquals(BASKET_PRICE_TEXT, basketPrice.getText());
            Thread.sleep(2000);
            */
            WebElement goBasket = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(GO_BASKET_ELEMENT)));
            goBasket.click();
            WebElement pieceUp = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(PIECE_UP_BASKET_ELEMENT)));
            pieceUp.click();
            WebElement deleteBasket = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(DELETE_BASKET_ELEMENT)));
            deleteBasket.click();
            WebElement emptyBasket = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(EMPTY_CHECK_BASKET_ELEMENT)));
            Assert.assertEquals(EMPTY_BASKET_TEXT, emptyBasket.getText());

            logger.info(N11 + " Regression Success Login, Search, Basket Test Case Finished");
        } catch (Exception e) {
            logger.error(N11_ERR + " Regression Success Login, Search, Basket Test Case Failure | Reason: " + ExceptionUtils.getMessage(e));
        }
    }

    @AfterTest
    public void afterTest() throws InterruptedException {

        logger.info(N11 + " Regression Successful Scenarios TestSuites Finished ");
        Thread.sleep(1000);
        driver.close();
        System.exit(0);
    }

}
