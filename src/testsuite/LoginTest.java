package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class LoginTest extends Utility {
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValid() {
        //sending username and password to elements
        sendTextToElement(By.id("user-name"), "standard_user");
        sendTextToElement(By.id("password"), "secret_sauce");
        //click on login button
        clickOnElement(By.id("login-button"));
        //this is from requirements
        String expectedMessage = "PRODUCTS";
        String actualMessage = getTextFromElement(By.xpath("//span[contains(text(),'Products')]"));
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        //sending  email to email field element
        sendTextToElement(By.id("user-name"), "standard_user");
        //sending password to password field element
        sendTextToElement(By.id("password"), "secret_sauce");
        // find log in link and click on log in link
        clickOnElement(By.id("login-button"));
//Find Element of products
        List<WebElement> products = driver.findElements(By.className("inventory_item"));
        //Print number of Items
        System.out.println("Items displayed : " + products.size());
        //to Count how many items
        for (WebElement element : products)
            Assert.assertEquals(true, element.isDisplayed());

    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
