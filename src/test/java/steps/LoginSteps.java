package steps;

import io.cucumber.java.pt.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

public class LoginSteps {
    LoginPage loginPage = new LoginPage(Hooks.driver);

    @Dado("que eu esteja na página de login")
    public void que_eu_esteja_na_página_de_login() {
       loginPage.carregarPagina();
    }

    @Quando("eu inserir o usuário {string}")
    public void eu_inserir_o_usuário(String usuario) {
        loginPage.preencherUsuario(usuario);
    }

    @Quando("a senha {string}")
    public void a_senha(String senha) {
        loginPage.preencherSenha(senha);
    }

    @Quando("clicar no botão de login")
    public void clicar_no_botão_de_login() {
        loginPage.clicarNoLogin();
    }

    @Então("devo ser redirecionado para a vitrine de produtos")
    public void devo_ser_redirecionado_para_a_vitrine_de_produtos() {
        Assert.assertEquals("Products", loginPage.obterTituloDaPagina());
    }

    @Então("devo ver a mensagem de erro {string}")
    public void devo_ver_a_mensagem_de_erro(String mensagemEsperada) {
        String mensagemAtual = loginPage.obterMensagemDeErro();
        Assert.assertEquals(mensagemEsperada, mensagemAtual);
    }
}