package mantis.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class HomeworkTests {

    @Test
    public void issuesCountTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://academ-it.ru/mantisbt/login_page.php");
        driver.manage().window().maximize();

        WebElement usernameInput = driver.findElement(By.cssSelector("#username"));
        usernameInput.sendKeys("admin");
        driver.findElement(By.cssSelector("input[type='submit']")).click();

        driver.findElement(By.cssSelector("#password")).sendKeys("admin20");
        driver.findElement(By.cssSelector("input[type='submit']")).click();

        driver.findElement(By.xpath("//ul[@class=\"nav nav-list\"]/li[2]")).click();

        List<WebElement> list = driver.findElements(By.xpath("//table[@id=\"buglist\"]/tbody/tr"));
        Assertions.assertEquals(50, list.size());

        Thread.sleep(1000);

        driver.quit();
    }
}
