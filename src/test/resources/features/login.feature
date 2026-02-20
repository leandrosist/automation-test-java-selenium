# language: pt
Funcionalidade: Login no sistema

  @Regressivo @CT01
  Cenário: Login com sucesso
    Dado que eu esteja na página de login
    Quando eu inserir o usuário "standard_user"
    E a senha "secret_sauce"
    E clicar no botão de login
    Então devo ser redirecionado para a vitrine de produtos

  @Regressivo @CT02
  Cenário: Login com senha incorreta
    Dado que eu esteja na página de login
    Quando eu inserir o usuário "standard_user"
    E a senha "senha_errada"
    E clicar no botão de login
    Então devo ver a mensagem de erro "Epic sadface: Username and password do not match any user in this service"