import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver
import spock.lang.Specification

import java.util.concurrent.TimeUnit

class DriverTest extends Specification{
    WebDriver driver

    // Configurado o caminho do executavel 'WebDriver'
    def setup(){
        System.setProperty("webdriver.chrome.driver", "/opt/webdriver/chromedriver_linux64/chromedriver")
    }

    // Assim que finalizado os testes, o navegador é encerrado após 3 segundos
    def cleanup(){
        Thread.sleep(3000)
        driver?.quit()
    }

    /* Pesquisar produtos

        1. Abre o navegador e acessa 'https://www.mercadolivre.com.br'.
        2. Digita na caixa de pesquisa o produto 'Panela de Pressão'.
        3. Localiza um dos elementos da pesquisa, e verifica se é pertinente ao que foi pesquisado.
     */

    def "Pesquisar Produtos"() {
        setup:
        driver = new ChromeDriver()
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) // Aguarda 10 segundos, tempo de carregar todos elementos da pagina.
        driver.get("https://www.mercadolivre.com.br/")

        expect: "Usuario deverá digitar um produto, e a pesquisa deverá retornar corretamente"
        WebElement caixaDeBusca = driver.findElement(By.name("as_word"))
        caixaDeBusca.sendKeys("Panela de Pressão")

        WebElement btPesquisar = driver.findElement(By.className("nav-search-btn"));
        btPesquisar.click();

        WebElement resultadoPesquisa = driver.findElement(By.className("main-title"));
        String resultado = resultadoPesquisa.getText();

        assert(resultado.toLowerCase().contains("panela"))
        assert(resultado.toLowerCase().contains("pressão"))
    }
}