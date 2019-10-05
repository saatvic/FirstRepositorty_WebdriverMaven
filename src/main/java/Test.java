import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class Test {

    public static void main(String[] args){

        WebDriverManager.chromedriver().setup();
        ChromeDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //WebDriverWait wait=new WebDriverWait(driver,20);
        Wait<WebDriver> wait=new FluentWait<WebDriver>(driver)
                .withTimeout(10,TimeUnit.SECONDS)
                .pollingEvery(2,TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class)
                .withMessage("timed out 30 seconds");

        driver.manage().window().maximize();
        driver.get("http://gmail.com");
        driver.findElement(By.xpath("//*[@id='identifierId']")).sendKeys("saatvic.batra@gmail.com");
        driver.findElement(By.xpath("//*[@id=\'identifierNext\']/span/span")).click();
        driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys("abcd");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"passwordNext\"]/span/span"))).click();
        //driver.close();

    }
}
