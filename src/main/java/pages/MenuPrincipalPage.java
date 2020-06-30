package pages;

import core.DriverManager;
import core.Report;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MenuPrincipalPage extends DriverManager {

    private By lblNomeUsuario = By.xpath("//div[contains(text(),'Bem vindo')]");

    public boolean isPresent(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        Report.takeScreeShot();
        return wait.until(ExpectedConditions.presenceOfElementLocated(lblNomeUsuario)).isDisplayed();
    }

    public void selecionarMenu(String titulo){
        driver.findElement(By.linkText(titulo)).click();

    }

}
