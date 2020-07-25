import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/opt/webdriver/chromedriver_linux64/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.mercadolivre.com.br/");

        WebElement caixaDeBusca = driver.findElement(By.name("as_word"));
        caixaDeBusca.sendKeys("Panela de Pressão");

        WebElement btPesquisar = driver.findElement(By.className("nav-search-btn"));
        btPesquisar.click();

        WebElement resultadoPesquisa = driver.findElement(By.className("main-title"));
        String resultado = resultadoPesquisa.getText();

        if (resultado.toLowerCase().contains("panela") || resultado.toLowerCase().contains("pressão")) {
            System.out.println("sucesso");
        } else {
            System.out.println("Erro na pesquisa");
        }
    }
}
