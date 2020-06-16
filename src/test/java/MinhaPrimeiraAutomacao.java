import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;

public class MinhaPrimeiraAutomacao {

    WebDriver driver;
    LoginPage loginPage;
    MenuPrincipalPage menuPrincipalPage;
    CriarMovimentacaoPage criarMovimentacaoPage;

    @Before
    public void init(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://seubarriga.wcaquino.me/login");
        System.out.println("Before");
    }

    @Test
    public void executarLogin()  {
        System.out.println("Teste");
        loginPage = new LoginPage(driver);
        menuPrincipalPage = new MenuPrincipalPage(driver);
        loginPage.logar("teste123@teste.com.br","1234");
        Assert.assertTrue(menuPrincipalPage.isPresent());
        menuPrincipalPage.selecionarMenu("Criar Movimentação");
    }

    @Test
    public void executarCadastroMovimentacao()  {
        System.out.println("Teste");
        loginPage = new LoginPage(driver);
        menuPrincipalPage = new MenuPrincipalPage(driver);
        criarMovimentacaoPage = new CriarMovimentacaoPage(driver);

        loginPage.logar("teste123@teste.com.br","1234");
        Assert.assertTrue(menuPrincipalPage.isPresent());

        menuPrincipalPage.selecionarMenu("Criar Movimentação");

        Assert.assertTrue(criarMovimentacaoPage.isPresent());

        criarMovimentacaoPage.cadastrarMovimentacao("Despesa","10","teste","pago");

        Assert.assertTrue(criarMovimentacaoPage.validaMensagemSucesso());
    }

    @After
    public void tearDown(){
        System.out.println("After");
        driver.close();
    }

}
