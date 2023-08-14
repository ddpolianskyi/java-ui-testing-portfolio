import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import pages.ComponentsPage;
import pages.MainPage;

import java.time.Duration;

public class MainPageTest {
    WebDriver driver;
    WebDriverWait wait;
    MainPage mainPage;
    ComponentsPage componentsPage;

    public String address = "San Francisco, CA 94108, United States";
    public String streetAddress = "Geary";
    public String secondStreetAddress = "Geary";
    public String city = "San Francisco";
    public String state = "California";
    public String zipCode = "07201";
    public String country = "USA";

    public String firstName = "John";
    public String lastName = "Doe";
    public String fullName = "John Doe";
    public String jobTitle = "QA Engineer";
    public String date = "06/30/2023";

    @BeforeTest
    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        mainPage = new MainPage(driver);
        componentsPage = new ComponentsPage(driver);
    }

    @BeforeMethod
    public void before(){
        driver.get("https://formy-project.herokuapp.com");
        driver.manage().window().setSize(new Dimension(1920, 1080));
        wait.until(ExpectedConditions.visibilityOf(mainPage.title));
        wait.until(ExpectedConditions.elementToBeClickable(mainPage.title));
    }

    @Test
    void checkAutocompleteComponent(){
        mainPage.openComponentPageAndExpectURL("Autocomplete", "/autocomplete");
        componentsPage.checkAutocompleteComponent(address, streetAddress, secondStreetAddress, city, state, zipCode, country);
    }

    @Test
    void checkButtonsComponent() throws InterruptedException {
        mainPage.openComponentPageAndExpectURL("Buttons", "/buttons");
        componentsPage.checkButtonsComponent();
    }

    @Test
    void checkCheckboxComponent(){
        mainPage.openComponentPageAndExpectURL("Checkbox", "/checkbox");
        componentsPage.checkCheckboxComponent();
    }

    @Test
    void checkDatepickerComponent(){
        mainPage.openComponentPageAndExpectURL("Datepicker", "/datepicker");
        componentsPage.checkDatepickerComponent();
    }

    @Test
    void checkDragAndDropComponent(){
        mainPage.openComponentPageAndExpectURL("Drag and Drop", "/dragdrop");
        componentsPage.checkDragAndDropComponent();
    }

    @Test
    void checkDropdownComponent() throws InterruptedException{
        mainPage.openComponentPageAndExpectURL("Dropdown", "/dropdown");
        componentsPage.checkDropdownComponent();
    }

    @Test
    void checkEnabledAndDisabledElementsComponent(){
        mainPage.openComponentPageAndExpectURL("Enabled and disabled elements", "/enabled");
        componentsPage.checkEnabledAndDisabledElementsComponent();
    }

    @Test
    void checkKeyAndMousePressComponent(){
        mainPage.openComponentPageAndExpectURL("Key and Mouse Press", "/keypress");
        componentsPage.checkKeyAndMousePressComponent();
    }

    @Test
    void checkModalComponent(){
        mainPage.openComponentPageAndExpectURL("Modal", "/modal");
        componentsPage.checkModalComponent();
    }

    @Test
    void checkPageScrollComponent(){
        mainPage.openComponentPageAndExpectURL("Page Scroll", "/scroll");
        componentsPage.checkPageScrollComponent(fullName, date);
    }

    @Test
    void checkRadioButtonComponent(){
        mainPage.openComponentPageAndExpectURL("Radio Button", "/radiobutton");
        componentsPage.checkRadioButtonComponent();
    }

    @Test
    void checkSwitchWindowComponent(){
        mainPage.openComponentPageAndExpectURL("Switch Window", "/switch-window");
        componentsPage.checkSwitchWindowComponent();
    }

    @Test
    void checkCompleteWebFormComponent(){
        mainPage.openComponentPageAndExpectURL("Complete Web Form", "/form");
        componentsPage.checkCompleteWebFormComponent(firstName, lastName, jobTitle, 1, 1, "10+", date);
    }

    @AfterTest
    public void shutDown(){
        driver.quit();
    }
}
