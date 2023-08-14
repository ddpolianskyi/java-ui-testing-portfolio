package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ComponentsPage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(id = "autocomplete") WebElement autocompleteAddressField;
    @FindBy(id = "street_number") WebElement autocompleteStreetAddressField;
    @FindBy(id = "route") WebElement autocompleteSecondStreetAddressField;
    @FindBy(id = "locality") WebElement autocompleteCityField;
    @FindBy(id = "administrative_area_level_1") WebElement autocompleteStateField;
    @FindBy(id = "postal_code") WebElement autocompleteZipCodeField;
    @FindBy(id = "country") WebElement autocompleteCountryField;

    public ComponentsPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[text()='Primary']") WebElement buttonsPrimaryBtn;
    @FindBy(xpath = "//button[text()='Success']") WebElement buttonsSuccessBtn;
    @FindBy(xpath = "//button[text()='Info']") WebElement buttonsInfoBtn;
    @FindBy(xpath = "//button[text()='Warning']") WebElement buttonsWarningBtn;
    @FindBy(xpath = "//button[text()='Danger']") WebElement buttonsDangerBtn;
    @FindBy(xpath = "//button[text()='Link']") WebElement buttonsLinkBtn;
    @FindBy(xpath = "//button[text()='Left']") WebElement buttonsLeftBtn;
    @FindBy(xpath = "//button[text()='Middle']") WebElement buttonsMiddleBtn;
    @FindBy(xpath = "//button[text()='Right']") WebElement buttonsRightBtn;
    @FindBy(xpath = "//button[text()='1']") WebElement buttonsFirstBtn;
    @FindBy(xpath = "//button[text()='2']") WebElement buttonsSecondBtn;
    @FindBy(css = "button[data-toggle='dropdown']") WebElement buttonsDropdownBtn;
    @FindBy(css = ".btn-group .dropdown-menu") WebElement buttonsDropdownMenu;
    @FindBy(xpath = "//a[text()='Dropdown link 1']") WebElement buttonsDropdownLinkFirstBtn;
    @FindBy(xpath = "//a[text()='Dropdown link 2']") WebElement buttonsDropdownLinkSecondBtn;

    @FindBy(id = "checkbox-1") WebElement checkboxCheckboxFirst;
    @FindBy(id = "checkbox-2") WebElement checkboxCheckboxSecond;
    @FindBy(id = "checkbox-3") WebElement checkboxCheckboxThird;

    @FindBy(id = "datepicker") WebElement datepickerField;
    @FindBy(className = "datepicker") WebElement datepickerDropdown;
    @FindBy(css = "div.datepicker-days th.prev") WebElement datepickerPrevMonthBtn;
    @FindBy(css = "div.datepicker-days th.datepicker-switch") WebElement datepickerCurrentMonth;
    @FindBy(css = "div.datepicker-days th.next") WebElement datepickerNextMonthBtn;
    @FindBy(xpath = "//td[@class='new day' and text()='1']") WebElement datepickerDay;

    @FindBy(id = "image") WebElement dragAndDropImg;
    @FindBy(id = "box") WebElement dragAndDropBox;

    @FindBy(id = "dropdownMenuButton") WebElement dropdownDropdownBtn;
    WebElement dropdownDropdownItem(String title){ return driver.findElement(By.xpath("//div[@class='dropdown-menu show']/a[text()='" + title + "']")); }

    @FindBy(id = "disabledInput") WebElement enabledAndDisabledElementsDisabledField;
    @FindBy(id = "input") WebElement enabledAndDisabledElementsField;

    @FindBy(id = "name") WebElement keyAndMousePressField;
    @FindBy(id = "button") WebElement keyAndMousePressBtn;

    @FindBy(id = "modal-button") WebElement modalOpenModalBtn;
    @FindBy(className = "modal") WebElement modalModal;
    @FindBy(className = "modal-body") WebElement modalModalBody;
    @FindBy(id = "close-button") WebElement modalModalCloseBtn;
    @FindBy(id = "ok-button") WebElement modalModalOkBtn;

    @FindBy(id = "name") WebElement pageScrollFullNameField;
    @FindBy(id = "date") WebElement pageScrollDateField;

    @FindBy(css = "input[value='option1']") WebElement radioButtonRadioButtonFirst;
    @FindBy(css = "input[value='option2']") WebElement radioButtonRadioButtonSecond;
    @FindBy(css = "input[value='option3']") WebElement radioButtonRadioButtonThird;

    @FindBy(id = "new-tab-button") WebElement switchWindowOpenNewTabBtn;
    @FindBy(id = "alert-button") WebElement switchWindowOpenAlertBtn;

    @FindBy(id = "first-name") WebElement completeWebFormFirstNameField;
    @FindBy(id = "last-name") WebElement completeWebFormLastNameField;
    @FindBy(id = "job-title") WebElement completeWebFormJobTitleField;
    WebElement completeWebFormEducationRadioBtn(Integer num){ return driver.findElement(By.cssSelector("input[id='radio-button-" + num + "']")); };
    WebElement completeWebFormSexCheckbox(Integer num){ return driver.findElement(By.cssSelector("input[id='checkbox-" + num + "']")); };
    @FindBy(id = "select-menu") WebElement completeWebFormExperienceField;
    WebElement completeWebFormExperienceOption(String option){ return driver.findElement(By.xpath("//select/option[text()='" + option + "']")); };
    @FindBy(id = "datepicker") WebElement completeWebFormDateField;
    @FindBy(css = "a[role='button']") WebElement completeWebFormSubmitBtn;
    @FindBy(css = "div[class*='alert-success']") WebElement completeWebFormSuccessMessage;

    public void checkAutocompleteComponent(String address, String streetAddress, String secondStreetAddress, String city, String state, String zipCode, String country){
        wait.until(ExpectedConditions.visibilityOf(autocompleteAddressField));
        WebElement[] fields = { autocompleteAddressField, autocompleteStreetAddressField, autocompleteSecondStreetAddressField, autocompleteCityField, autocompleteStateField, autocompleteZipCodeField, autocompleteCountryField };
        String[] values = { address, streetAddress, secondStreetAddress, city, state, zipCode, country };
        for (int i = 0; i < fields.length; i++){
            fields[i].sendKeys(values[i]);
            String fieldValue = fields[i].getAttribute("value");
            Assert.assertEquals(fieldValue, values[i]);
        }
    }

    public void checkButtonsComponent() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(buttonsPrimaryBtn));
        WebElement[] buttons = { buttonsPrimaryBtn, buttonsSuccessBtn, buttonsInfoBtn, buttonsWarningBtn, buttonsDangerBtn, buttonsLinkBtn, buttonsLeftBtn, buttonsMiddleBtn, buttonsRightBtn, buttonsFirstBtn, buttonsSecondBtn };
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].click();
        }
        buttonsDropdownBtn.click();
        buttonsDropdownLinkFirstBtn.click();
        Thread.sleep(1000);
        buttonsDropdownBtn.click();
        buttonsDropdownLinkSecondBtn.click();
    }

    public void checkCheckboxComponent(){
        WebElement[] checkboxes = { checkboxCheckboxFirst, checkboxCheckboxSecond, checkboxCheckboxThird };
        wait.until(ExpectedConditions.visibilityOf(checkboxCheckboxFirst));
        for (int i = 0; i < checkboxes.length; i++) {
            checkboxes[i].click();
            Assert.assertTrue(checkboxes[i].isSelected());
        }
    }

    public void checkDatepickerComponent(){
        wait.until(ExpectedConditions.visibilityOf(datepickerField));
        datepickerField.click();
        Assert.assertTrue(datepickerDropdown.isDisplayed());
        String currentMonth = datepickerCurrentMonth.getText();
        for (int i = 0; i < 4; i++){
            datepickerNextMonthBtn.click();
        }
        Assert.assertNotEquals(datepickerCurrentMonth.getText(), currentMonth);
        datepickerDay.click();
    }

    public void checkDragAndDropComponent(){
        Actions actions = new Actions(driver);
        driver.navigate().refresh();
        wait.until(ExpectedConditions.visibilityOf(dragAndDropImg));
        actions.dragAndDrop(dragAndDropImg, dragAndDropBox).build().perform();
    }

    public void checkDropdownComponent() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(dropdownDropdownBtn));
        String[] items = { "Autocomplete", "Buttons", "Checkbox", "Datepicker", "Drag and Drop", "Dropdown", "Enabled and disabled elements", "File Upload", "File Download", "Key and Mouse Press", "Modal", "Page Scroll", "Radio Button", "Switch Window", "Complete Web Form" };
        String[] expectedURLs = { "/autocomplete", "/buttons", "/checkbox", "/datepicker", "/dragdrop", "/dropdown", "/enabled", "/fileupload", "/filedownload", "/keypress", "/modal", "/scroll", "/radiobutton", "/switch-window", "/form" };
        for (int i = 0; i < items.length; i++){
            dropdownDropdownBtn.click();
            dropdownDropdownItem(items[i]).click();
            Thread.sleep(1000);
            Assert.assertTrue(driver.getCurrentUrl().endsWith(expectedURLs[i]));
            if (!driver.getCurrentUrl().endsWith("/dropdown")){
                driver.navigate().back();
            }
        }
    }

    public void checkEnabledAndDisabledElementsComponent(){
        wait.until(ExpectedConditions.visibilityOf(enabledAndDisabledElementsDisabledField));
        Assert.assertFalse(enabledAndDisabledElementsDisabledField.isEnabled());
        Assert.assertTrue(enabledAndDisabledElementsField.isEnabled());
    }

    public void checkKeyAndMousePressComponent(){
        wait.until(ExpectedConditions.visibilityOf(keyAndMousePressField));
        keyAndMousePressField.sendKeys("Test", Keys.ENTER);
        Assert.assertTrue(driver.getCurrentUrl().endsWith("/keypress?"));
        driver.navigate().back();
        keyAndMousePressField.clear();
        keyAndMousePressField.sendKeys("Test");
        keyAndMousePressBtn.click();
        Assert.assertTrue(driver.getCurrentUrl().endsWith("/keypress"));
    }

    public void checkModalComponent(){
        wait.until(ExpectedConditions.visibilityOf(modalOpenModalBtn));
        modalOpenModalBtn.click();
        wait.until(ExpectedConditions.visibilityOf(modalModal));
        Assert.assertTrue(modalModal.isDisplayed());
        modalModalOkBtn.click();
        wait.until(ExpectedConditions.visibilityOf(modalModal));
        Assert.assertTrue(modalModal.isDisplayed());
        modalModalCloseBtn.click();
        wait.until(ExpectedConditions.invisibilityOf(modalModal));
        Assert.assertFalse(modalModal.isDisplayed());
    }

    public void checkPageScrollComponent(String fullName, String date){
        wait.until(ExpectedConditions.visibilityOf(pageScrollFullNameField));
        pageScrollFullNameField.sendKeys(fullName);
        pageScrollDateField.sendKeys(date);
    }

    public void checkRadioButtonComponent(){
        WebElement[] radioButtons = {radioButtonRadioButtonFirst, radioButtonRadioButtonSecond, radioButtonRadioButtonThird};
        wait.until(ExpectedConditions.visibilityOf(radioButtonRadioButtonFirst));
        for (int i = 1; i < radioButtons.length; i++){
            radioButtons[i].click();
            Assert.assertTrue(radioButtons[i].isSelected());
        }
    }

    public void checkSwitchWindowComponent(){
        wait.until(ExpectedConditions.visibilityOf(switchWindowOpenNewTabBtn));
        switchWindowOpenNewTabBtn.click();
        String[] tabs = driver.getWindowHandles().toArray(new String[0]);
        driver.switchTo().window(tabs[1]).close();
        driver.switchTo().window(tabs[0]);
        switchWindowOpenAlertBtn.click();
        driver.switchTo().alert().accept();
    }

    public void checkCompleteWebFormComponent(String firstName, String lastName, String jobTitle, Integer education, Integer sex, String experience, String date){
        wait.until(ExpectedConditions.visibilityOf(completeWebFormFirstNameField));
        completeWebFormFirstNameField.sendKeys(firstName);
        completeWebFormLastNameField.sendKeys(lastName);
        completeWebFormJobTitleField.sendKeys(jobTitle);
        completeWebFormEducationRadioBtn(education).click();
        completeWebFormSexCheckbox(sex).click();
        completeWebFormExperienceField.click();
        completeWebFormExperienceOption(experience).click();
        completeWebFormDateField.sendKeys(date);
        completeWebFormSubmitBtn.click();
        wait.until(ExpectedConditions.visibilityOf(completeWebFormSuccessMessage));
        Assert.assertTrue(completeWebFormSuccessMessage.isDisplayed());
    }
}
