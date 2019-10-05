import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class PVR_adhoc_report_creation {

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
        action.moveToElement(driver.findElement(By.xpath("//*[@id=\"sidebar-menu\"]/ul/li[2]/a"))).perform();
        driver.findElement(By.linkText("New Report")).click();

        WebDriverWait wait=new WebDriverWait(driver,10);

        WebElement DateRangeType=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"select2-chosen-11\"]")));
        DateRangeType.sendKeys("Safety Receipt Date");

    }
}
