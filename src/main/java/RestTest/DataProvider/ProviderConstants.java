package RestTest.DataProvider;

import org.testng.annotations.DataProvider;

public class ProviderConstants {

    @DataProvider(name="seasons_Circuit")
    public Object[][] seasons_CircuitId() {
        return new Object[][] {

                {"2017",20},
                {"2016",21},
                {"1966",9}
        };
    }

    @DataProvider (name="seasons_RacesRound")
    public Object[][] seasons_RacesRound() {
        return new Object[][] {

                {"2017",1},
                {"2016",1},
                {"1966",1}
        };
    }

    @DataProvider (name="seasons_Status")
    public Object[][] seasons_Status() {
        return new Object[][] {

                {"2017",3,1},
                {"2016",5,1},
                {"1966",6,1}
        };
    }
}
