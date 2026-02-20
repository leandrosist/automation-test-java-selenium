package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.ByteArrayInputStream;
import java.time.Duration;

public class Hooks {

    public static WebDriver driver;

    @Before
    public void setup() {
        ChromeOptions options = new ChromeOptions();

        // Permite conexões de origens remotas (evita erros de handshake)
        options.addArguments("--remote-allow-origins=*");

        // Lógica para rodar no GitHub Actions (CI) sem abrir janela
        // Se o sistema detectar que está rodando no GitHub, ativa o modo Headless
        if ("true".equals(System.getenv("GITHUB_ACTIONS"))) {
            options.addArguments("--headless=new");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--window-size=1920,1080");
        }

        driver = new ChromeDriver(options);

        // Maximiza apenas se não estiver em modo headless (no CI o tamanho já foi definido acima)
        if (!"true".equals(System.getenv("GITHUB_ACTIONS"))) {
            driver.manage().window().maximize();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void tearDown(Scenario scenario) {
        // Se o teste falhar, tira um print e anexa ao Allure automaticamente
        if (scenario.isFailed()) {
            try {
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                Allure.addAttachment("Screenshot de Falha", new ByteArrayInputStream(screenshot));
            } catch (Exception e) {
                System.out.println("Erro ao capturar screenshot: " + e.getMessage());
            }
        }

        if (driver != null) {
            driver.quit();
        }
    }
}