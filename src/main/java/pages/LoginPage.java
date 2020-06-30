package pages;

import core.DriverManager;
import core.Report;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends DriverManager {

    private By txtUser = By.xpath("//input[@name='email']");
    private By txtSenha = By.id("senha");
    private By btnLogar = By.xpath("//button");

    public void acessaAplicacao(String url){
        driver.get(url);
    }

    public void logar(String user, String pass ){
        driver.findElement(txtUser).sendKeys(user);
        driver.findElement(txtSenha).sendKeys(pass);
        Report.takeScreeShot();
        driver.findElement(btnLogar).click();
    }

    public boolean validarLoginInvalido(String msg){
        WebDriverWait wait = new WebDriverWait(driver,10);
        Report.takeScreeShot();
        return wait.until(ExpectedConditions
                .presenceOfElementLocated(
                        By.xpath("//div[contains(text(),'"+msg+"')]")))
                .isDisplayed();
    }

}
