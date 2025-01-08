// 1 - bibliotecas / imports
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver; //biblioteca principal do Selenium
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver; // biblioteca do ChromeDriver

// 2 - classe
public class Ticket{
   // 2.1 - atributos
private WebDriver driver; // objeto do Selenium

   // 2.2 - Funções e Métodos

// Antes do Teste
@BeforeEach
public void iniciar() {
    driver = new ChromeDriver(); // instanciar o objeto do Selenium com o ChromeDriver
    driver.manage().window().maximize(); // maximiza a janela do browser
    driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000)); // paciência (esperar 3 s)
}
// Depois do Teste
@AfterEach
public void finalizar() {
    driver.quit();  //destroi o objeto do Selenium
} 
//Teste
@Test
public void buyTicket() {
    driver.get("https://www.blazedemo.com"); // abre o site (Blazedemo)
    //Seleciona origem, destino e aperta o botão "Find flights"

    //combo Origem
    driver.findElement(By.name("fromPort")).click(); //clica no combo=dropdown
    {
        WebElement dropdown = driver.findElement(By.name("fromPort"));
      dropdown.findElement(By.xpath("//option[. = 'São Paolo']")).click();}
    
    //combo Destino 

    {WebElement dropdown = driver.findElement(By.name("toPort"));
    dropdown.click(); //clica no combo
    dropdown.findElement(By.xpath("//option[. = 'Cairo']")).click();

}

    // Clicar no botão
    driver.findElement(By.cssSelector("input.btn.btn-primary")).click();

    // Transição de Página

    // Verifica se foi realizado o login e a pesquisa dos voos
    assertEquals("Flights from São Paolo to Cairo:", 
        driver.findElement(By.cssSelector("h3")).getText());
        


} //final do TicketTest



}

