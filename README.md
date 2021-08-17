<!-- Visualizador online: https://stackedit.io/ -->
 ![Logo da UDESC Alto Vale](http://www1.udesc.br/imagens/id_submenu/2019/marca_alto_vale_horizontal_assinatura_rgb_01.jpg)

---

# TRABALHO FINAL

Atividade desenvolvida para a disciplina de Desenvolvimento de Sistemas Paralelos e Distribuídos do [Centro de Educação Superior do Alto Vale do Itajaí (CEAVI/UDESC)](https://www.udesc.br/ceavi)<br>

# Sumário
* [Equipe](#equipe)
* [Atividade](#atividade)
* [Especificações](#especificações)
* [Diagramas](#diagramas)

## [Equipe](#equipe)
 - [**Rodrigo Souza Tassoni**](mailto:tazzsoni@gmail.com) - [GitHub](https://github.com/tazzsoni)
 - [**Samuel Koepsel**](mailto:sjoepsel@hotmail.com.br) - [GitHub](https://github.com/samuelkoepsel1)
 
## [Atividade](#atividade)

**OBJETIVO DO TRABALHO**<br>
Praticar o desenvolvimento de sistemas concorrentes e distribuídos através da implementação de um sistema distribuído de livre escolha pelos alunos.

Partindo desta premissa, optamos por desenvolver um aplicativo em java para mensagens entre clientes. Neste aplicativo o cliente criará um login simples e assim poderá efetuar o login, após isso verá quais os usuários do sistema estão disponíveis para conversação, selecionará um usuário e abrirá uma nova janela onde ocorrerá a conversação.

## [Especificações](#especificações)

*REQUISITOS NÃO FUNCIONAIS DO SISTEMA A SER DESENVOLVIDO (Pedido na descrição do trabalho)*

- **RNF1**. Deve ser distribuído e executar simultanamente em no mínimo 3 clientes (hosts) diferentes.<br>
a) Considerar o uso do ngrok para comunicação entre os diferentes hosts.<br>
- **RNF2**. Deve haver comunicação entre os diferentes clientes através de:<br>
a) Sockets, ou<br>
b) RMI. Ler seções 5.4 e 5.5 de (COULOURIS, DOLLIMORE, et al., 2013) ou,<br>
c) CORBA. Ler seção 8.3 de (COULOURIS, DOLLIMORE, et al., 2013).<br>
- **RNF3**. A comunicação cliente/cliente deve ser direta, ou seja, sem passar por qualquer servidor.<br>
- **RNF4**. Deve ser possível realizar comunicação entre diversos clientes simultaneamente.<br>
- **RNF5**. Se necessário, pode ser implementado um servidor simples para ser acessado pelos clientes.<br>
a) Este servidor jamais deve criar conexões com clientes, apenas receber conexões.<br>
b) A comunicação cliente→servidor deve ser a mínima possível. O funcionamento do sistema deve
ser baseado principalmente na comunicação ser cliente→cliente.<br>
c) Não se deve utilizar nenhuma implementação pronta de qualquer servidor (ex: Express JS). Em
caso de dúvida, consulte o professor.<br>
- **RNF6**. Se utilizar Sockets no requisito (2), então deve-se observar os seguintes requisitos:<br>
a) Sockets ociosos não podem existir (todos devem ser fechados logo após a comunicação).<br>
b) Os dados enviados entre cliente/servidor e cliente/cliente podem estar no formato JSON ou
XML. Não é permitido o uso de serialização de objetos.<br>
- **RNF7**. A aplicação cliente deve ter interface gráfica.<br>
a) A equipe pode utilizar interface gráfica disponível em outros projetos, citando a fonte/projeto.<br>
MAS ATENÇÃO: o projeto utilizado como base não pode ser distribuído (não pode já ter
comunicação entre clientes)

Requisitos do sistema

1.	REQUISITOS FUNCIONAIS (RF) 
 
- RF1: Desenvolver uma aplicação para conversação por mensagens entre clientes;

-	RF2: O Sistema deve permitir o registro em memória de Pessoas.
- RF2.1: Dados de pessoas: <br>
•	Nome<br>
•	Porta privada<br>
•	Porta pública<br>

-	RF3: O sistema deve permitir redigir mensagens;

-	RF4: O sistema deve permitir o envio de mensagens entre dois ou mais usuários;

-	RF5: O sistema deve guardar histórico de mensagens enquanto o aplicativo estiver aberto;

-	RF6: O sistema deve informar da falha no envio de mensagens.


2.	REQUISITOS NÃO FUNCIONAIS

-	RNF1: Deve haver comunicação entre os diferentes clientes através de:
•	Sockets;

-	RNF2: A comunicação cliente/cliente deve ser direta, ou seja, sem passar por qualquer servidor.

-	RNF3: Deve ser possível realizar comunicação entre até 3 clientes simultaneamente.

3.	REGRAS DE NEGÓCIO

-	RN1: A conexão entre usuários de ser feito via número de ip;

-	RN2: As mensagens devem conter o nome do usuário que enviou;

-	RN3: As mensagens não poderão ser editadas;

-	RN4: As mensagens não poderão ser excluídas;

-	RN5: As mensagens de uma conversa devem ser impressas em tela;

-	RN6: Deve ser mostrado em tela o nome do usuário que enviou a mensagem, seguindo RN2;


## [Diagramas](#diagramas)

*DIAGRAMA DE SEQUÊNCIA CLIENTE/CLIENTE*

![image](https://user-images.githubusercontent.com/45270751/129808443-b0b55964-6ea7-4bc4-b66a-04855af5cd6c.png)

*DIAGRAMA DE SEQUÊNCIA CLIENTE/SERVIDOR*

![image](https://user-images.githubusercontent.com/45270751/129814986-6a3a7da5-8ebf-4913-9e23-f240e535e69a.png)

*DIAGRAMA DE CLASSES SERVIDOR*

![image](https://user-images.githubusercontent.com/45270751/129814274-5b2746ef-dfb1-4e84-9fff-275b9cb06108.png)
