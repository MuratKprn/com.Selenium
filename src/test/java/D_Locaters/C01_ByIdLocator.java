package D_Locaters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_ByIdLocator {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("Webdriver.chrome.driver", "src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 1- Go to the "testotomasyonu.com"s main page
        driver.get("https://testotomasyonu.com");

        // 2- Type 'phone' in the search box and initiate the search.
        WebElement searchBox = driver.findElement(By.id("global-search"));
        searchBox.sendKeys("phone");
        searchBox.submit();

        // 3- Print the number of search results found
        WebElement results = driver.findElement(By.className("product-count-text"));
        System.out.println(results);

        System.out.println(results.getText());

        // 4- Test whether a product can be found in the search results.
        String numberOfResultsStr =results.getText().replaceAll("\\D","");
        int numberOfResultsInt = Integer.parseInt(numberOfResultsStr);

        if (numberOfResultsInt > 0){
            System.out.println("Search test PASSED");
        }else {
            System.out.println("Search test FAILED");
        }
        driver.quit();
    }
}