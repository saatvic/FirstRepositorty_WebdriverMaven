import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class PVR_Test {

    public static void main(String[] args){

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://10.100.22.4:8080/reports/login/auth");

        driver.findElement(By.xpath("//input[@name='j_username']")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@name='j_password']")).sendKeys("admin");
        driver.findElement(By.id("loginSubmit")).click();

        Actions action=new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//*[@id='sidebar-menu']/ul/li[6]/a/i"))).perform();
        driver.findElement(By.linkText("New Case Line Listing Template")).click();

    }
}
