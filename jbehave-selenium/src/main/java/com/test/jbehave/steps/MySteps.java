package com.test.jbehave.steps;

import javax.inject.Named;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Pending;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MySteps {
    
    static WebDriver driver;
    String cartao;
    
    @Given("acesso o site da Americanas")
	public void acesso(){
    	System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
    	driver =new FirefoxDriver();
    	driver.get("https://www.americanas.com.br/");
	}
	
	@When("devo acessar minha conta")
	@Then("devo acessar minha conta")
	public void acessarconta(){
		driver.findElement(By.xpath(".//*[@id='h_user']/span[2]/a/span")).click();
		driver.findElement(By.xpath(".//*[@id='h_user']/span[2]/div/ul/li[1]/a")).click();
	}
	
	@When("Validar que o usuario nao possui pedidos recentes")
	@Then("Validar que o usuario nao possui pedidos recentes")
	public void validarPedidosRecentes() throws Exception{
		Thread.sleep(4000);
		Assert.assertEquals("você não tem pedidos recentes.", driver.findElement(By.xpath(".//*[@id='mainUiView']/div/div[5]/div/div/h4[1]/strong")).getText());
	}
	
	@When("Validar a presença do botão “ver todos os pedidos”")
	@Then("Validar a presença do botão “ver todos os pedidos”")
	public void validarBotaoVerPedidos(){
		driver.findElement(By.xpath(".//*[@id='mainUiView']/div/div[6]/div/button")).isEnabled();
	}
	
	@When("Validar se o endereço informado é o mesmo que o cadastrado: $endereco")
	@Then("Validar se o endereço informado é o mesmo que o cadastrado: $endereco")
	public void validaEndereco(@Named("email") final String endereco){
		Assert.assertEquals(endereco, driver.findElement(By.xpath(".//*[@id='mainUiView']/div/div[9]/div/div[1]/div/div/div/div[1]/div[2]/div/p[2]")).getText());
	}	
	
	@When("Validar se o nome do Usuário corresponde ao mesmo que foi cadastrado: $nome")
	@Then("Validar se o nome do Usuário corresponde ao mesmo que foi cadastrado: $nome")
	public void validaNome(@Named("nome") final String nome){
		Assert.assertEquals(nome, driver.findElement(By.xpath(".//*[@id='mainUiView']/div/div[9]/div/div[1]/div/div/div/div[1]/div[2]/div/p[1]")).getText());
	}	
	
	@When("realizar login com o usuario: $email e senha: $senha")
	@Then("realizar login com o usuario: $email e senha: $senha")
	public void realizarLogin(@Named("email") final String email, @Named("senha") final String senha) throws Exception{
		driver.findElement(By.xpath(".//*[@id='h_user']/span[1]/div")).click();
		driver.findElement(By.xpath(".//*[@id='h_user']/span[2]/div/a[1]")).click();
		Thread.sleep(4000);
		driver.findElement(By.name("email")).click();
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("password")).click();
		driver.findElement(By.name("password")).sendKeys(senha);
		driver.findElement(By.name("submit_button")).click();
	}	
	
	@Given("retorno a pagina inicial do site Americanas")
	public void retornarPaginaInicial(){
		driver.findElement(By.className("brd-link")).click();
	}
	
	@When("irei buscar o produto com o código: $produto e selecionar o mesmo")
	@Then("irei buscar o produto com o código: $produto e selecionar o mesmo")
	@Given("irei buscar o produto com o código: $produto e selecionar o mesmo")
	public void buscaProduto(@Named("produto") final String produto) throws Exception{
		driver.findElement(By.name("conteudo")).click();
		driver.findElement(By.name("conteudo")).sendKeys(produto);
		driver.findElement(By.name("conteudo")).sendKeys(Keys.ENTER);
		Thread.sleep(4000);
		driver.findElement(By.xpath(".//*[@id='root']/div/div/div/div[3]/div/div[1]/div/div[2]/div[3]/div/div/div/div[2]/div/section/a/div[1]/figure/div/div/picture/img")).click();
	}	
	
	@When("Validar todas as informações referentes ao produto: $produtook")
	@Then("Validar todas as informações referentes ao produto: $produtook")
	public void buscaProdutook(@Named("produtook") final String produtook){
		Assert.assertEquals(produtook, driver.findElement(By.className("product-name")).getText());
	}	
	
	@When("validar que a mensagem de Garantia e Seguro a seguir é exibida: $garantia")
	@Then("validar que a mensagem de Garantia e Seguro a seguir é exibida: $garantia")
	public void validarGarantia(@Named("garantia") final String garantia){
		String atual = driver.findElement(By.className("hidden-xs")).getText();
		Assert.assertTrue(atual.contains(garantia));
	}	
	
	@When("verifico se a opção de garantia a seguir é exibida: $garantiaEst")
	@Then("verifico se a opção de garantia a seguir é exibida: $garantiaEst")
	public void validarGarantiaEst(@Named("garantiaEst") final String garantiaEst){
		String atual = driver.findElement(By.className("installment-description-default")).getText();
		Assert.assertTrue(atual.contains(garantiaEst));
	}	
	
	@When("deverei informar o Cep: $cep")
	@Then("deverei informar o Cep: $cep")
	public void informarCep(@Named("cep") final String cep){
		driver.findElement(By.name("cep")).sendKeys(cep);
		driver.findElement(By.name("cep")).sendKeys(Keys.ENTER);	
	}	
	
	@When("devo informar o tipo de entrega: $tipoEntrega")
	@Then("devo informar o tipo de entrega: $tipoEntrega")
	public void informarEntrega(@Named("tipoEntrega") final String tipoEntrega){
		driver.findElement(By.xpath("//*[contains(text(),'"+tipoEntrega+"')]")).click();
	}	
	
	@When("irei clicar no botão Comprar")
	@Then("irei clicar no botão Comprar")
	public void clicarComprar() throws Exception{
		Thread.sleep(4000);
		driver.findElement(By.xpath(".//*[@id='bt-buy-product']")).click();
	}	
	
	@When("irei clicar no botão Continuar")
	@Then("irei clicar no botão Continuar")
	public void clicarContinuar() throws Exception{
		Thread.sleep(4000);
		driver.findElement(By.xpath(".//*[@id='content']/div/main/div[2]/div/div/div[2]/section/div[3]/div[1]/button")).click();
	}	
	
	@When("deverei validar o valor da entrega de: $valorEntrega e o valor total do produto de: $valorTotal")
	@Then("deverei validar o valor da entrega de: $valorEntrega e o valor total do produto de: $valorTotal")
	public void validaFreteTotalProduto(@Named("valorEntrega") final String valorEntrega, @Named("valorTotal") final String valorTotal){
		Assert.assertEquals(valorEntrega, driver.findElement(By.xpath(".//*[@id='app']/section/article/div[2]/div[2]/div/div/table/tbody/tr[2]/td[3]")).getText());
		Assert.assertEquals(valorTotal, driver.findElement(By.xpath(".//*[@id='total-amount']")).getText());
		driver.findElement(By.id("upper-buy-button")).click();
	}	
	
	@Given("acesso um site para gerar um numero do cartao")
	public void gerarNumeroCartao(){
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
    	driver =new FirefoxDriver();
		driver.get("http://www.4devs.com.br/gerador_de_numero_cartao_credito");
		driver.manage().window().maximize();
		driver.findElement(By.id("bt_gerar_cc")).click();
		cartao = driver.findElement(By.id("cartao_numero")).getText();
	}	
	
	@When("informar o numero do cartao de credito")
	@Then("informar o numero do cartao de credito")
	public void informarNumeroCartao(){
		driver.findElement(By.id("creditCard-cardNumber")).sendKeys(cartao);
	}	
}
