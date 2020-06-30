# language: pt
# charset: UTF-8

Funcionalidade: Login
  Eu como cliente gostaria de acessar o sistema via login somente com credenciais validas

  @dev
  Cenario: Executar login com credenciais validas
    Dado eu acesso a url "https://seubarriga.wcaquino.me/login"
    Quando eu logar na aplicacao com usuario "teste123@teste.com.br" e senha "1234"
    Entao sera apresentado a tela do menu principal

  Cenario: Executar Login Invalido
    Dado eu acesso a url "https://seubarriga.wcaquino.me/login"
    Quando eu logar na aplicacao com usuario "1234@teste.com" e senha "1234"
    Entao  sera apresentado um mensagem "Problemas com o login do usuário" de login invalido