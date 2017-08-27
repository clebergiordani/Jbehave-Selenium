Scenario: Su�te de Teste Efetuar �Pr� Compra

Given acesso um site para gerar um numero do cartao

Scenario: Caso de Teste Informar Dados Cadastrais

Given acesso o site da Americanas
Then realizar login com o usuario: cleber.giordani@zup.com e senha: eutuele1

!-- Resultados esperados: 
Then devo acessar minha conta
And Validar que o usuario nao possui pedidos recentes
Then Validar se o endere�o informado � o mesmo que o cadastrado: Rua Germano Wetzel, 545 - 101 - Chamar Portaria
Then Validar a presen�a do bot�o �ver todos os pedidos�
And Validar se o nome do Usu�rio corresponde ao mesmo que foi cadastrado: Cleber Giordani

Scenario: Caso de Teste Selecionar Compra

!-- Pr�-condi��o:
Given retorno a pagina inicial do site Americanas

!-- Resultado Esperado
Then irei buscar o produto com o c�digo: 131916705 e selecionar o mesmo
Then Validar todas as informa��es referentes ao produto:Philco PH49F30DSGWA Full HD com Conversor Digital 2 HDMI 2 USB Wi-Fi Android

Scenario: Caso de Teste Realizar Compra

!-- Pr�-condi��o:
Given irei buscar o produto com o c�digo: 131916705 e selecionar o mesmo
Then irei clicar no bot�o Comprar

!-- Resultado Esperado:
Then validar que a mensagem de Garantia e Seguro a seguir � exibida: Contrate a garantia estendida original e garanta tranquilidade e seguran�a por mais tempo
Then verifico se a op��o de garantia a seguir � exibida: Sem Garantia Estendida


Scenario: Preencher o CEP em �Minha Cesta�

!-- Pr�-condi��es:  Usu�rio deve estar na p�gina de op��es de seguro e garantia estendida.
Given irei buscar o produto com o c�digo: 131916705 e selecionar o mesmo
Then irei clicar no bot�o Comprar
Then verifico se a op��o de garantia a seguir � exibida: Sem Garantia Estendida

!-- Resultado Esperado
Then irei clicar no bot�o Continuar
Then deverei informar o Cep: 89070-530
Then devo informar o tipo de entrega: Econ�mica
Then devo informar o tipo de entrega: R�pida
Then deverei validar o valor da entrega de: 39.99 e o valor total do produto de: 2.089.98
And informar o numero do cartao de credito