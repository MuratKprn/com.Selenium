package B_DriverMerhods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_GetMethods {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("Webdriver.chrome.driver","src/resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://testotomasyonu.com");
        Thread.sleep(3000);

        driver.get("https://youtube.com");
        Thread.sleep(3000);

        System.out.println(driver.getWindowHandle());

        driver.close();
    }
}