package FunctionalTestingTestSuites.Desktop.Regression.Constant;

public class N11Constant {

    public static final String SEARCH_TEXT = "bilgisayar";
    public static final String EMPTY_BASKET_TEXT = "Sepetiniz Boş";
    public static final String BASKET_PRICE_TEXT = "3.259,99 TL";
    public static final String PRODUCT_PRICE_TEXT = "3.259,99 TL\n" +
            "KDV\n" +
            "DAHİL";

    public static final String N11_WEBSITE_URL  = "n11.website.url";
    public static final String EMAIL  = "n11.login.successful.email";
    public static final String PASSWORD  = "n11.login.successful.password";
    public static final String LOGIN_NAME  = "n11.login.name";

    public static final String SEARCH_RESULT_PAGE_NUMBER_CHECK_URL = "arama?q=bilgisayar&pg=2";
    public static final String LOGIN_CHECK_TEXT_ELEMENT = "//a[@class='menuLink user']";
    public static final String EMPTY_CHECK_BASKET_ELEMENT = "//h2[@class='title']";
    public static final String PRODUCT_PRICE_CHECK_ELEMENT = "//div[@class='newPrice']";
    public static final String BASKET_PRICE_CHECK_ELEMENT = "//ins[@class='newPrice inline ']";

    public static final String EMAIL_ELEMENT = "email";
    public static final String PASSWORD_ELEMENT = "password";

    public static final String SIGNIN_BUTTON_ELEMENT = "//a[@href='https://www.n11.com/giris-yap']";
    public static final String LOGIN_BUTTON_ELEMENT = "//div[@id='loginButton']";
    public static final String SEARCH_ELEMENT = "//input[@id='searchData']";
    public static final String SEARCH_BUTTON_ELEMENT = "//span[@class='icon iconSearch']";
    public static final String SELECT_PRODUCT_ELEMENT = "//div[@id='view']//li[@class='column']//h3[@class='productName bold']";
    public static final String ADD_BASKET_ELEMENT = "//a[@class='btn btnGrey btnAddBasket']";
    public static final String GO_BASKET_ELEMENT = "//a[@class='btn btnBlack btnGoBasket']";
    public static final String PIECE_UP_BASKET_ELEMENT = "//span[@class='spinnerUp spinnerArrow']";
    public static final String DELETE_BASKET_ELEMENT = "//span[@class='removeProd svgIcon svgIcon_trash']";

}