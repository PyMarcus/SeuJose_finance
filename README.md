A nível de estrutura, foi utilizado a arquitetura MVC, desse modo, no que tange às views, como já predefinido pelo professor, está a interface com a qual o usuário irá interagir. Contudo, foi necessário acrescentar algumas funções para tratar os eventos do usuário, durante a interação deste com o sistema. 

Em vista disso, todas as funções da view enviam mensagens para o controller para buscar dados, inserir dados e, por demais, até remover dados do banco de dados do sistema. 

Agora, consoante ao controller, este é responsavel por emitir mensagens para o model, que, por sua vez, está dividido seguindo o padrão de projeto DAO, que conta com interfaces para cada tabela estipulada, a fim de criar um contrato de implementações. 

Essas implementações, de fato, são responsáveis por fazer as interações com o banco de dados. Para fins de facilidades individuais, foi utilizado o banco de dados Postgres e o diagrama que representa as tabelas é exibido abaixo: 

 

Com base no supracitado, as tabelas foram definidas para terem como identificadores de cada registro, um dado do tipo UUID, pois, normalmente, é mais seguro e permite maiores possibilidades de combinações.  

Além disso, as tabelas de ganhos e gastos foram divididas para facilitar os cálculos posteriormente. Desse modo, ha modelos para cada tabela e todos eles recebem a respectiva referência da tabela de finanças. 

Por fim, foram criadas algumas classes para facilitar operações no projeto, como, por exemplo, uma classe geradora de log (com rotatividade por dia para otimizar a escrita em ), seguindo o padrão Singleton, uma classe para trabalho com datas e outra para recuperar as credenciais de conexão com o banco, oriundas de um arquivo de extensão .ini 


 



 ![Screenshot from 2023-08-26 12-42-35](https://github.com/PyMarcus/SeuJose_finance/assets/88283829/b9223f09-46c6-471a-a07a-846965f6d4e4)


 

 

 

 

 

 

 

 

 

 

