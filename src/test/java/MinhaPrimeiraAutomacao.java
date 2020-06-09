import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MinhaPrimeiraAutomacao {


    @Test
    public void executarLogin()  {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://seubarriga.wcaquino.me/login");

        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("teste123@teste.com.br");
        driver.findElement(By.id("senha")).sendKeys("1234");
        driver.findElement(By.xpath("//button")).click();

        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Bem vindo')]")));

        driver.close();

    }

}
