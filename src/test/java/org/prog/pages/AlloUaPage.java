package org.prog.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class AlloUaPage {

    private final WebDriver driver;

    public AlloUaPage(WebDriver driver) {
        this.driver = driver;
    }

    public void loadPage() {
        driver.get("https://allo.ua/");
    }

    public void searchForGoods(String searchValue) {
        WebElement searchInput = driver.findElement(By.name("search"));
        searchInput.sendKeys(searchValue);
        searchInput.sendKeys(Keys.ENTER);
    }

    public List<WebElement> getSearchResults() {
        return new WebDriverWait(driver, Duration.ofSeconds(30L))
                .until(
                        ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector("div.product-card"),
                                1)
                );
    }

    public boolean searchResultsContain(String value) {
        List<WebElement> searchResults = getSearchResults();
        Assert.assertFalse(searchResults.isEmpty(), "Search results must not be empty!");
        boolean valueIsPresent = false;
        for (WebElement e : searchResults) {
            if (e.findElement(By.xpath("div/a")).getText().contains(value)) {
                valueIsPresent = true;
                break;
            }
        }
        return valueIsPresent;
    }

    public WebElement pagination(){
        return driver.findElement(By.className("pagination"));
    }

    public void scrollToElement(WebElement e) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e);
    }
}
