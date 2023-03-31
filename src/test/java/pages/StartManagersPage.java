package pages;
import base.BasePages;
import org.openqa.selenium.*;
import org.testng.Assert;
import utils.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class StartManagersPage extends BasePages {
    public StartManagersPage(WebDriver driver) {
        super(driver);
    }

    public final By addCustomerBtn = By.cssSelector("button[ng-click='addCust()']");
    public By openAccountBtn = By.cssSelector("button[ng-click='openAccount()']");
    public final By CustomersBtn = By.cssSelector("button[ng-click='showCust()']");

    public final By inputFirstName = By.xpath("//input[@ng-model= 'fName']");
    public final By inputLastName = By.xpath("//input[@ng-model= 'lName']");
    public final By inputPostCode = By.xpath("//input[@ng-model= 'postCd']");
    public final By readyCustomerBtn =  By.xpath("//button[@type='submit']");

    public final By sortByName = By.xpath("//thead/tr/td[1]/a");
    public final By nameColumn = By.xpath("//tbody/tr/td[1]");
    public final By searchField = By.xpath("//input[@ng-model='searchCustomer']");

    public final By rowOfCustomersTable = By.xpath("//table[@class='table table-bordered table-striped']/tbody/tr");

    public StartManagersPage fieldsForCustomer(){
        Data testData = new Data();
        driver.get(testData.getUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(addCustomerBtn).click();
        driver.findElement(readyCustomerBtn).click();
        driver.findElement(inputFirstName).sendKeys(testData.firstName);
        driver.findElement(readyCustomerBtn).click();
        driver.findElement(inputFirstName).clear();
        driver.findElement(inputLastName).sendKeys(testData.lastName);
        driver.findElement(readyCustomerBtn).click();
        driver.findElement(inputLastName).clear();
        driver.findElement(inputPostCode).sendKeys(testData.postCode);
        driver.findElement(readyCustomerBtn).click();
        driver.findElement(inputPostCode).clear();
        return this;
    }

    public StartManagersPage createNewCustomer() {
        Data testData = new Data();
        driver.get(testData.getUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(addCustomerBtn).click();
        driver.findElement(inputFirstName).sendKeys(testData.firstName);
        driver.findElement(inputLastName).sendKeys(testData.lastName);
        driver.findElement(inputPostCode).sendKeys(testData.postCode);
        driver.findElement(readyCustomerBtn).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        return this;
    }


    public StartManagersPage sortingListOfCustomers() {
        Data testData = new Data();
        driver.get(testData.getUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(CustomersBtn).click();
        driver.findElement(sortByName).click();
        List<String> obtainedList = new ArrayList<>();
        List<WebElement> elementList = driver.findElements(nameColumn);
        for (WebElement we:elementList) {
            obtainedList.add(we.getText());
        }
        ArrayList<String> sortedList = new ArrayList<>();
        sortedList.addAll(obtainedList);
        Collections.sort(sortedList);
        Collections.reverse(sortedList);
        Assert.assertEquals(obtainedList, sortedList);
        return this;
    }

    public StartManagersPage searchCustomer() {
        Data testData = new Data();
        driver.get(testData.getUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(CustomersBtn).click();
        driver.findElement(searchField).sendKeys("Ha");
        List<WebElement> searchResultRows = driver.findElements(rowOfCustomersTable);
        Assert.assertTrue(searchResultRows.size() > 0, "Результатов поиска в нет");
        driver.findElement(searchField).clear();
        driver.findElement(searchField).sendKeys("Ne");
        List<WebElement> searchResultRows2 = driver.findElements(rowOfCustomersTable);
        Assert.assertTrue(searchResultRows2.size() > 0, "Результатов поиска нет");
        driver.findElement(searchField).clear();
        driver.findElement(searchField).sendKeys("10");
        List<WebElement> searchResultRows3 = driver.findElements(rowOfCustomersTable);
        Assert.assertTrue(searchResultRows3.size() > 0, "Результатов поиска нет");
        driver.findElement(searchField).clear();
        return this;
    }


}



