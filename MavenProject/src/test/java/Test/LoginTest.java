package Test;

import base.baseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends baseTest {


    @Test(priority = 1, description = "This is 1st priority test")
    public void testInvalidLogin() {
        log.info("=== Starting testInvalidLogin (Priority 1) ===");

        LoginPage loginPage = new LoginPage(driver);

        log.info("Navigating to target URL");
        loginPage.URL();

        log.info("Attempting login with invalid credentials");
        loginPage.performLogin("paragbhadane@gmail.com", "WrongPassword!456");

        String currentUrl = driver.getCurrentUrl();
        String expectedLoginUrl = "https://www.automationexercise.com/login";

        try {
            Assert.assertTrue(currentUrl.contains("/login"), "User navigated away despite invalid credentials.");
            log.info("Assertion passed: User remained on the login endpoint.");
        } catch (AssertionError e) {
            log.error("Assertion failed: Expected to stay on login page, but URL was: {}", currentUrl, e);
            throw e;
        }

        log.info("=== Completed testInvalidLogin successfully ===");
    }

    @Test(priority = 2, dependsOnMethods = "testInvalidLogin")
    public void testValidLogin() {
        log.info("=== Starting testValidLogin (Priority 2) ===");

        LoginPage loginPage = new LoginPage(driver);

        log.info("Navigating to target URL");
        loginPage.URL();

        log.info("Attempting login with valid credentials");
        loginPage.performLogin("paragbhadane@gmail.com", "Pass@123");

        String expectedUrl = "https://www.automationexercise.com/";
        String actualUrl = driver.getCurrentUrl();

        try {
            Assert.assertEquals(actualUrl, expectedUrl, "URL mismatch after successful login.");
            log.info("Assertion passed: User redirected to correct landing URL.");
        } catch (AssertionError e) {
            log.error("Assertion failed: URL mismatch! Expected: {}, but got: {}", expectedUrl, actualUrl, e);
            throw e;
        }

        log.info("=== Completed testValidLogin successfully ===");
    }
}