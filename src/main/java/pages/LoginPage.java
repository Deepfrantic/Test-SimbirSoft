package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class LoginPage {
    private WebDriver driver;

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By firstNameField = By.id("firstName");
    private By lastNameField = By.id("lastName");
    private By emailField = By.id("userEmail");
    private By genderRadioButton = By.xpath("//label[contains(@for,'gender-radio-2')]");
    private By phoneNumberField = By.id("userNumber");
    private By dateOfBirthInput = By.id("dateOfBirthInput");
    private By monthSelect = By.cssSelector(".react-datepicker__month-select");
    private By yearSelect = By.cssSelector(".react-datepicker__year-select");
    private By daySelect = By.cssSelector(".react-datepicker__day--00");
    private By subjectsInput = By.id("subjectsInput");
    private By hobbyCheckbox = By.xpath("//label[contains(text(),'Sports')]");
    private By uploadPicture = By.id("uploadPicture");
    private By currentAddressField = By.id("currentAddress");
    private By stateDropdown = By.id("state");
    private By cityDropdown = By.id("city");
    private By submitButton = By.id("submit");

    // Actions

    public void setFirstName(String firstName) {
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void setEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void selectGender() {
        driver.findElement(genderRadioButton).click();
    }

    public void setPhoneNumber(String phoneNumber) {
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
    }

    public void setDateOfBirth(String month, String year, String day) {
        driver.findElement(dateOfBirthInput).click();
        new Select(driver.findElement(monthSelect)).selectByVisibleText(month);
        new Select(driver.findElement(yearSelect)).selectByVisibleText(year);
        driver.findElement(By.cssSelector(".react-datepicker__day--0" + day)).click();
    }

    public void setSubject(String subject) {
        WebElement subjectField = driver.findElement(subjectsInput);
        subjectField.sendKeys(subject);
        subjectField.sendKeys("\n"); // Выбор предмета
    }

        public void selectHobby(String hobby) {
        WebElement checkbox = driver.findElement(hobbyCheckbox);
            checkbox.click();

    }

    public void uploadPicture(String filePath) {
        driver.findElement(uploadPicture).sendKeys(filePath);
    }

    public void setAddress(String address) {
        driver.findElement(currentAddressField).sendKeys(address);
    }

    public void selectState(String state) {
        driver.findElement(stateDropdown).click();
        driver.findElement(By.xpath("//*[text()='" + state + "']")).click();
    }

    public void selectCity(String city) {
        driver.findElement(cityDropdown).click();
        driver.findElement(By.xpath("//*[text()='" + city + "']")).click();
    }

    public void submitForm() {
        driver.findElement(submitButton).click();
    }


}

