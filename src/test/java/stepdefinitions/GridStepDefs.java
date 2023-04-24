package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class GridStepDefs {
    WebDriver driver;
    @Given("user is on the homepage {string} by chrome")
    public void userIsOnTheHomepageByChrome(String url) throws MalformedURLException {
        driver = new RemoteWebDriver(new URL("http://192.168.0.81:4444"), new ChromeOptions());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
    }

    @Then("verify title is {string}")
    public void verifyTitleIs(String title) {
        assertEquals(title, driver.getTitle());
        
    }

    @And("close the remote driver")
    public void closeTheRemoteDriver() {
        driver.quit();
    }


    @Given("user is on the homepage {string} by edge")
    public void userIsOnTheHomepageByEdge(String url) throws MalformedURLException {
        driver = new RemoteWebDriver(new URL("http://192.168.0.81:4444"), new EdgeOptions());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);

    }

    @Given("user is on the homepage {string} by firefox")
    public void userIsOnTheHomepageByFirefox(String url) throws MalformedURLException {
        driver = new RemoteWebDriver(new URL("http://192.168.0.81:4444"), new FirefoxOptions());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);

    }
}
