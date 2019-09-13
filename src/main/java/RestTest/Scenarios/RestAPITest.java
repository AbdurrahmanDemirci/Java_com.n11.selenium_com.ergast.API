package RestTest.Scenarios;

import FunctionalTestingTestSuites.Utils.Properties.N11PropertyUtils;
import RestTest.DataProvider.ProviderConstants;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static FunctionalTestingTestSuites.Constant.Constants.*;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class RestAPITest extends N11PropertyUtils {

    private static final Logger logger = Logger.getLogger(RestAPITest.class);

    @BeforeTest
    public void launchWebApplication() {
        loadProperties();
        RestAssured.baseURI = "http://ergast.com";
        RestAssured.basePath = "/api/f1";

        logger.info(ERGAST + " Launch ERGAST Web Application | " + getProperties(ERGAST_URL));
        logger.info(ERGAST + " Rest Assured Web Service RestAPITest Started ");
    }

    @Test (dataProvider = "seasons_Circuit",dataProviderClass= ProviderConstants.class)
    public void test_seasonsCircuitId (String season, int number ){

        logger.info(ERGAST + " Web Service RestAPITest seasons_Circuit Started " + season);
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET);

        try {
            given().
                    pathParam("raceSeason",season).
            when().
                    get("/{raceSeason}/circuits.json").
            then().
                    assertThat().
                    statusCode(HttpStatus.OK.value()).
            and().
                    body("MRData.CircuitTable.Circuits.circuitId",hasSize(number));

            logger.info(ERGAST + " Web Service RestAPITest seasons_Circuit Finished " + season);
        }catch (Exception e) {
            logger.error(ERGAST_ERR + " Web Service RestAPITest seasons_Circuit Failure | Reason: " + ExceptionUtils.getMessage(e));
        }

        System.out.println("Response :\n" + response.asString());
        System.out.println("Status Code : " + response.getStatusLine());
    }

    @Test (dataProvider = "seasons_RacesRound",dataProviderClass= ProviderConstants.class)
    public void test_seasonsRacesRound(String season, int totalRound){

        logger.info(ERGAST + " Web Service RestAPITest seasons_RacesRound Started " + season);
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET);

        try {
            given().
                    pathParam("raceSeason",season).
            when().
                    get("/{raceSeason}/1.json").
            then().
                    assertThat().
                    statusCode(HttpStatus.OK.value()).
            and().
                    body("MRData.RaceTable.Races.round",hasSize(totalRound));

        logger.info(ERGAST + " Web Service RestAPITest seasons_RacesRound Finished " + season);
    }catch (Exception e) {
        logger.error(ERGAST_ERR + " Web Service RestAPITest seasons_RacesRound Failure | Reason: " + ExceptionUtils.getMessage(e));
    }

        System.out.println("Response :\n" + response.asString());
        System.out.println("Status Code : " + response.getStatusLine());
    }

    @Test (dataProvider = "seasons_Status",dataProviderClass= ProviderConstants.class)
    public void test_seasonsStatus (String season, int statusId, int number ){

        logger.info(ERGAST + " Web Service RestAPITest seasons_Status Started " + statusId);
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET);

        try {
            given().
                pathParam("raceSeason",season).
                pathParam("statusId",statusId).
            when().
                get("/{raceSeason}/status/{statusId}.json").
            then().
                assertThat().
                statusCode(HttpStatus.OK.value()).
            and().
                body("MRData.StatusTable.Status.statusId",hasSize(number));

            logger.info(ERGAST + " Web Service RestAPITest seasons_Status Finished " + statusId);
        }catch (Exception e) {
            logger.error(ERGAST_ERR + " Web Service RestAPITest seasons_Status Failure | Reason: " + ExceptionUtils.getMessage(e));
        }

        System.out.println("Response :\n" + response.asString());
        System.out.println("Status Code : " + response.getStatusLine());
    }

    @Test
    public void test_driverDriverId (){

        logger.info(ERGAST + " Web Service RestAPITest test_driverDriverId Started ");
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET);
        int totalDriver = 30;

        try {
            given().
            when().
                get("/drivers.json").
            then().
                assertThat().
                statusCode(HttpStatus.OK.value()).
            and().
                body("MRData.DriverTable.Drivers.driverId",hasSize(totalDriver)).
            and().
                header("Content-Length",equalTo("5509"));

            logger.info(ERGAST + " Web Service RestAPITest test_driverDriverId Finished ");
        }catch (Exception e) {
            logger.error(ERGAST_ERR + " Web Service RestAPITest test_driverDriverId Failure | Reason: " + ExceptionUtils.getMessage(e));
        }

        System.out.println("Response :\n" + response.asString());
        System.out.println("Status Code : " + response.getStatusLine());
    }

    @AfterTest
    public void afterTest() throws InterruptedException {

        logger.info(ERGAST + " Rest Assured Web Service RestAPITest Finished ");
        Thread.sleep(1000);
    }

}
