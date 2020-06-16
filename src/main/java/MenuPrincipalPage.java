import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MenuPrincipalPage {

    WebDriver driver;
    private By lblNomeUsuario = By.xpath("//div[contains(text(),'Bem vindo')]");


    public MenuPrincipalPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isPresent(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        return wait.until(ExpectedConditions.presenceOfElementLocated(lblNomeUsuario)).isDisplayed();
    }

    public void selecionarMenu(String titulo){
        driver.findElement(By.linkText(titulo)).click();

    }

}
