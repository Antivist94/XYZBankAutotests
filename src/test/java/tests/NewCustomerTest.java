package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import jdk.jfr.Description;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.StartManagersPage;
@Listeners(io.qameta.allure.testng.AllureTestNg.class)
@Epic("Клиенты")
@Feature("Создание и управление данным о клиенте")
@Story("Новый клиент")
public class NewCustomerTest {
    private ChromeDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Test
    @Description("Проверка полей оздания нового пользователя на валидность")
    public void testFieldsForCustomer() {
        StartManagersPage startPage = new StartManagersPage(driver);
        startPage.fieldsForCustomer();
    }

    @Test
    @Description("Проверка функционала создания нового пользователя")
    public void createNewCustomer() {
        StartManagersPage startPage = new StartManagersPage(driver);
        startPage.createNewCustomer();
    }
    @Test
    @Description("Проверка функционала сортировки списка пользователей по столбцу FirsName")
    public void checkSortingList() {
        StartManagersPage startPage = new StartManagersPage(driver);
        startPage.sortingListOfCustomers();
    }

    @Test
    @Description("Проверка функционала поиска клиентов")
    public void  checkSearchOfCustomer() {
        StartManagersPage startPage = new StartManagersPage(driver);
        startPage.searchCustomer();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}


