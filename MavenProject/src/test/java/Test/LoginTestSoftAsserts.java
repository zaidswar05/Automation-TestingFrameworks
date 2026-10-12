package Test;

import base.baseTest;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTestSoftAsserts extends baseTest {

        @Test(priority = 1, description = "Verify invalid credentials keep user on login page")
        public void testInvalidLogin() {
            log.info("=== Starting testInvalidLogin (Priority 1) ===");

            LoginPage loginPage = new LoginPage(driver);

            log.info("Navigating to target URL");
            loginPage.URL();

            log.info("Attempting login with invalid credentials");
            loginPage.performLogin("paragbhadane@gmail.com", "WrongPassword!456");

            String currentUrl = driver.getCurrentUrl();
            String expectedUrlFragment = "/login";

            log.info("Performing soft assertion on URL for invalid login");
            soft.assertTrue(
                    currentUrl.contains(expectedUrlFragment),
                    "SoftAssert Failed: User navigated away from login page! Actual URL: " + currentUrl
            );

            log.info("=== Completed testInvalidLogin execution steps ===");
        }

        @Test(priority = 2, dependsOnMethods = "testInvalidLogin", description = "Verify valid credentials redirect to home page")
        public void testValidLogin() {
            log.info("=== Starting testValidLogin (Priority 2) ===");

            LoginPage loginPage = new LoginPage(driver);

            log.info("Navigating to target URL");
            loginPage.URL();

            log.info("Attempting login with valid credentials");
            loginPage.performLogin("paragbhadane@gmail.com", "Pass@123");

            String expectedUrl = "https://www.automationexercise.com/";
            String actualUrl = driver.getCurrentUrl();

            log.info("Performing soft assertion on destination URL for valid login");
            soft.assertEquals(
                    actualUrl,
                    expectedUrl,
                    "SoftAssert Failed: Landing URL mismatch after successful login!"
            );

            log.info("=== Completed testValidLogin execution steps ===");
        }
    }