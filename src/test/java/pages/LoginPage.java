package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    // Locadores mapeados por ID ou CSS
    private By campoUsuario = By.id("user-name");
    private By campoSenha = By.id("password");
    private By botaoLogin = By.id("login-button");
    private By tituloPagina = By.className("title");

    // Adicione isso aos atributos da classe
    private By msgErro = By.xpath("//h3[@data-test='error']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void carregarPagina() {
        driver.get("https://www.saucedemo.com");
    }

    public void preencherUsuario(String usuario) {
        driver.findElement(campoUsuario).sendKeys(usuario);
    }

    public void preencherSenha(String senha) {
        driver.findElement(campoSenha).sendKeys(senha);
    }

    public void clicarNoLogin() {
        driver.findElement(botaoLogin).click();
    }

    public String obterTituloDaPagina() {
        return driver.findElement(tituloPagina).getText();
    }

    public String obterMensagemDeErro() {
        return driver.findElement(msgErro).getText();
    }
}