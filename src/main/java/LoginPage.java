import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private By txtUser = By.xpath("//input[@name='email']");
    private By txtSenha = By.id("senha");
    private By btnLogar = By.xpath("//button");
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void logar(String user, String pass ){
        driver.findElement(txtUser).sendKeys(user);
        driver.findElement(txtSenha).sendKeys(pass);
        driver.findElement(btnLogar).click();
    }

}
