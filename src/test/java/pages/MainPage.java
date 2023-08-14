package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MainPage {
    WebDriver driver;
    public MainPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public @FindBy(className = "display-3") WebElement title;
    By componentsListItem(String itemTitle){ return By.xpath("//div/li/a[text()='" + itemTitle + "']"); }

    public void openComponentPageAndExpectURL(String itemTitle, String expectedURLEndsWith){
        driver.findElement(componentsListItem(itemTitle)).click();
        Assert.assertTrue(driver.getCurrentUrl().endsWith(expectedURLEndsWith));
    }
}
