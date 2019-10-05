import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class TestDropdown {

    public static void main(String[] args){
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        //driver.get("http://way2automation.com/way2auto_jquery/index.php");
        driver.get("https://www.wikipedia.org/");
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

        WebElement dropdown=driver.findElement(By.id("searchLanguage"));
        Select select=new Select(dropdown);
        select.selectByVisibleText("Eesti");


    }
}
