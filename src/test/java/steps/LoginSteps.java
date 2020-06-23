package steps;

import cucumber.api.PendingException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import org.junit.Assert;
import pages.LoginPage;
import pages.MenuPrincipalPage;

public class LoginSteps {

    private LoginPage loginPage = new LoginPage();
    private MenuPrincipalPage menuPrincipalPage = new MenuPrincipalPage();

    @Dado("^eu acesso a url \"([^\"]*)\"$")
    public void euAcessoAUrl(String url) throws Throwable {
        loginPage.acessaAplicacao(url);
    }

    @Quando("^eu logar na aplicacao com usuario \"([^\"]*)\" e senha \"([^\"]*)\"$")
    public void euLogarNaAplicacaoComUsuarioESenha(String user, String senha) throws Throwable {
        loginPage.logar(user, senha);
    }

    @Entao("^sera apresentado a tela do menu principal$")
    public void seraApresentadoATelaDoMenuPrincipal() throws Throwable {
        Assert.assertTrue(menuPrincipalPage.isPresent());
    }

    @Entao("^sera apresentado um mensagem \"([^\"]*)\" de login invalido$")
    public void seraApresentadoUmMensagemDeLoginInvalido(String msg) throws Throwable {
        Assert.assertTrue(loginPage.validarLoginInvalido(msg));
    }
}
