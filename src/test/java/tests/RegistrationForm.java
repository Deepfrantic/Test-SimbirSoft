package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPage;

import java.time.Duration;

public class RegistrationForm {
    private WebDriver driver;
    private LoginPage registrationPage;

    @BeforeClass
    @Step("Setup WebDriver and open the registration page")
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe"); // Specify the path to chromedriver
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/automation-practice-form");

        registrationPage = new LoginPage(driver);

    }


    @Test(description = "Fill and submit the registration form")
    @Description("This test fills out the registration form on DemoQA and submits it.")
    public void testRegistrationForm() {
        registrationPage.setFirstName("Лариса");
        registrationPage.setLastName("Иванова");
        registrationPage.setEmail("larisa@example.com");
        registrationPage.selectGender();
        registrationPage.setPhoneNumber("1234567890");
        registrationPage.setDateOfBirth("April", "2000", "23");
        registrationPage.setSubject("Computer Science");
        registrationPage.selectHobby("Sports");
        registrationPage.uploadPicture("main\\resources\\pecos.jpg"); // Specify the correct path to the file
        registrationPage.setAddress("Москва, ул. Ленина, д. 10");
        registrationPage.selectState("NCR");
        registrationPage.selectCity("Gurgaon");
        registrationPage.submitForm();

        // Verifying successful submission of the form
        Assert.assertTrue(driver.getPageSource().contains("Thanks for submitting the form"), "Form was not submitted successfully!");

    }

    @AfterClass
   @Step("Close the browser")
       public void tearDown() {
        if (driver != null) {
            driver.quit();
             }
        }

   }
