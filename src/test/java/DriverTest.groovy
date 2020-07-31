import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver
import spock.lang.Specification

import java.util.concurrent.TimeUnit

class DriverTest extends Specification{
    WebDriver driver

    // Configurações do driver, URL, timeout para carregamento dos elementos.
    def setup(){
        System.setProperty("webdriver.chrome.driver", "/opt/webdriver/chromedriver_linux64/chromedriver")

        driver = new ChromeDriver()
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) // Aguarda 10 segundos, tempo de carregar todos elementos da pagina.
        driver.get("https://www.mercadolivre.com.br/")
    }

    // Assim que finalizado os testes, o navegador é encerrado após 3 segundos.
    def cleanup(){
        Thread.sleep(3000)
        driver?.quit()
    }

    def "Limpar caixa de busca"(){
        expect:
        WebElement caixaDeBusca = driver.findElement(By.name("as_word"))
        caixaDeBusca.sendKeys("teste")
        caixaDeBusca.clear()

    }

    def "Acessar Carrinho de compras"(){

        expect: "Usuário deverá conseguir acessar seu 'Carrinho de compras'"
        WebElement btCarrinho = driver.findElement(By.id("nav-cart"))
        btCarrinho.click()
    }

    /* Pesquisar produtos

    1. Abre o navegador e acessa 'https://www.mercadolivre.com.br'.
    2. Digita na caixa de pesquisa os produtos do enum 'Produtos'.
    3. Localiza um dos elementos da pesquisa, e verifica se é pertinente ao que foi pesquisado.
    */

    def "Pesquisar Produtos"() {
        expect: "Usuario deverá digitar um produto, e a pesquisa deverá retornar corretamente"

        // Playstation
        driver.findElement(By.name("as_word")).sendKeys(Produtos.PLAYSTATION.getDescricao())
        driver.findElement(By.className("nav-search-btn")).click();
        driver.findElement(By.className("main-title")).getText().toLowerCase()
        assert(driver.findElement(By.className("main-title"))
                .getText().toLowerCase().contains
                (Produtos.PLAYSTATION.getDescricao()))
        driver.navigate().back()

        // Fogão
        driver.findElement(By.name("as_word")).sendKeys(Produtos.FOGAO.getDescricao())
        driver.findElement(By.className("nav-search-btn")).click();
        driver.findElement(By.className("main-title")).getText().toLowerCase()
        assert(driver.findElement(By.className("main-title"))
                .getText().toLowerCase().contains
                (Produtos.FOGAO.getDescricao()))
        driver.navigate().back()

        // Geladeira
        driver.findElement(By.name("as_word")).sendKeys(Produtos.GELADEIRA.getDescricao())
        driver.findElement(By.className("nav-search-btn")).click();
        driver.findElement(By.className("main-title")).getText().toLowerCase()
        assert(driver.findElement(By.className("main-title"))
                .getText().toLowerCase().contains
                (Produtos.GELADEIRA.getDescricao()))
        driver.navigate().back()

        // Impressora
        driver.findElement(By.name("as_word")).sendKeys(Produtos.IMPRESSORA.getDescricao())
        driver.findElement(By.className("nav-search-btn")).click();
        driver.findElement(By.className("main-title")).getText().toLowerCase()
        assert(driver.findElement(By.className("main-title"))
                .getText().toLowerCase().contains
                (Produtos.IMPRESSORA.getDescricao()))
        driver.navigate().back()

        // Notebook
        driver.findElement(By.name("as_word")).sendKeys(Produtos.NOTEBOOK.getDescricao())
        driver.findElement(By.className("nav-search-btn")).click();
        driver.findElement(By.className("main-title")).getText().toLowerCase()
        assert(driver.findElement(By.className("main-title"))
                .getText().toLowerCase().contains
                (Produtos.NOTEBOOK.getDescricao()))
        driver.navigate().back()

        // Caneca
        driver.findElement(By.name("as_word")).sendKeys(Produtos.CANECA.getDescricao())
        driver.findElement(By.className("nav-search-btn")).click();
        driver.findElement(By.className("main-title")).getText().toLowerCase()
        assert(driver.findElement(By.className("main-title"))
                .getText().toLowerCase().contains
                (Produtos.CANECA.getDescricao()))
        driver.navigate().back()

        // Mesa
        driver.findElement(By.name("as_word")).sendKeys(Produtos.MESA.getDescricao())
        driver.findElement(By.className("nav-search-btn")).click();
        driver.findElement(By.className("main-title")).getText().toLowerCase()
        assert(driver.findElement(By.className("main-title"))
                .getText().toLowerCase().contains
                (Produtos.MESA.getDescricao()))
        driver.navigate().back()
    }
}