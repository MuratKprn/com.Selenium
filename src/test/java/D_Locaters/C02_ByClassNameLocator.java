package D_Locaters;

import Z_Utilities.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_ByClassNameLocator {

    public static void main(String[] args) {

        System.setProperty("Webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 1- Go to the page "testotomasyonu.com"
        driver.get("https://testotomasyonu.com");

        /// 2- Type 'phone' in the search box and perform the search.
        WebElement searchBox = driver.findElement(By.id("global-search"));
        searchBox.sendKeys("phone" + Keys.ENTER);

        // 3- After the search, test that the number of categories in the Categories menu on the left side is 8.
        List< WebElement> categoriesElementsList = driver.findElements(By.className("acc_head"));
        int expectedNumberOfCategories = 1;
        int actualNumberOfCategories = categoriesElementsList.size();

        if (expectedNumberOfCategories == actualNumberOfCategories){
            System.out.println("Category test PASSED");
        }else{
            System.out.println("Category test FAILED");
            System.out.println("Number of categories: " + actualNumberOfCategories);
        }

        // 4- Print the categories.
        System.out.println(categoriesElementsList);

        for (WebElement each : categoriesElementsList) {
            System.out.println(each.getText());
        }

        System.out.println(ReusableMethods.convertToStringList(categoriesElementsList));

        driver.quit();
    }
}