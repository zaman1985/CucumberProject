package stepDef;

import base.Config;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.testng.util.Strings;

public class Hook extends Config {
    public static String url;
    public static String baseUrl=System.getProperty("env");
    public static String browserType=System.getProperty("browser");
    @Before
    public void openBrowser(){
        if(Strings.isNullOrEmpty(browserType)){
            browserType="ch";
        }
        if(Strings.isNullOrEmpty(baseUrl)){
            baseUrl="qa";
        }
        driver=initDriver(browserType);
        switch (baseUrl){
            case "qa":
                url=url = "http://qa.taltektc.com";
                break;
            case "stage":
                url=url = "http://stage.taltektc.com";
                break;
            case "prod":
                url=url = "http://taltektc.com";
                break;
        }
        driver.get(url);
    }
    @After
    public void tearDown(){
       // driver.quit();
    }
}
