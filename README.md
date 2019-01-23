# iSoccer
Funcionalidades: 
- O projeto tem como objetivo permitir a administração de um time de futebol por meio de um sistema de login com acesso a um devido funcionário que disponibiliza informações tanto aos funcionários quanto aos recursos do time. No sistema é possivel adicionar funcionários, modificar o status dos jogadores do time (apto ou não apto a jogar), adicionar e/ou acessar os sócios-torcedores do time como editar suas dadas contribuições e se o sócio está adimplente ou não. Também é possivel gerenciar or recursos físicos do time e solicitar relatórios em relação aos mesmos e aos funcionários.
- O sistema fornece um login de acesso e senha(gerada aleatoriamente) ao ínicio de suas execução. Para a aleatoriedade da senha foi utilizado o Random fornecido pela linguagem e com concatenação.
- Para modificar o status dos jogadores foi utilizada a ideia de cada jogador tem uma variável relacionada a seu status e ela pode ser modificada pelo funcionário com acesso por meio de verificações, ou seja, é verificado se o jogador pode jogar ou não, e dependendo da resposta é possivel mudar esse status devidamente.
- Em relação ao acesso aos sócios-torcedores, é possivel definir as contribuições para cada tipo de sócio e modificar seu status para saber se o mesmo é adimplente ou inadimplente(o processo é semelhante a mudança de status dos jogadores).
- O gerenciamento de recurso é feito por meio checagens para cada recurso, se disponivel ou não.
- Os relatórios são onde são fornecidas as informações sobre os time em geral.
- Métodos: 
 - Adicionar Funcionário(add): Além de adicionar os funcionários ao ArrayList de funcionários, esse método o vai selecionar de acordo com seu tipo, ou seja, dependendo do tipo de funcionário ele será "construido" de uma maneira diferente pelo sistema.
 - Adicionar Sócios(add): Além de adicionar os sócios-torcedores ao ArrayList de sócios-torcedores, esse método o vai selecionar de acordo com seu tipo, ou seja, dependendo do tipo de sócio ele será "construido" de uma maneira diferente pelo sistema.
 - Adicionar Recurso(addBus): Permite a adição de recursos se for do tipo ônibus ao ArrayList de recursos.
 - Adicionar Estádio(addStadium): Permite a adição de recursos se for do tipo estádio ao ArrayList de recursos.
 - Adicionar Centro de Treinamento(addCenter): Permite a adição de recursos se for do tipo centro de treinamento ao ArrayList de recursos.
 - Os demais métodos são sets e gets.
- Todas as funcionalidades acima funcionam corretamente.


Classes:
O sistema contém dez classes divididas em tipos para funcionários, recursos físicos e a classe main. Três delas são as principais e as demais estão ligadas a herança. 
- MainSystem: 
	Motivação: Utilizada para administrar e acessar as demais classes do sistema. É nela em que o funcionário com acesso poderá fazer escolhas relacionadas as funcionalidades do sistema. Principalmente criada como meio de inicialização e organização das devidas partes do código.
	Solução: É uma classe principal para a implementação já que ela contém a main e apresenta os "loops" necessários para o acesso as todas as funcionalidades apresentadas. Também contém as variáveis do tipo booleana para melhor acesso a "loops" em que a booleana além de ajudar na manutenção desses "loops" por meio de sua capacidade de ser "true" e "false", é utilizada para que o funcionário com acesso possa entrar em partes do sistema somente quando permitido, além disso, são apresentados os tipo double, para valores associados no sistema e os ArrayList utilizados para armazenar os devidos funcionário, os sócios e os recursos físicos. Essa classe é também a que cria os logins do sistema quando inicializada.
	Vantagens: Como classe principal, ela pode acessar as outras e fazer todas as alterações em partes opcionais do sistema.
	Desvantagens: Extensa, logo é fácil se perder em alguma parte do código quando a mesma pode ser ligada a outra parte.
- People: 
	Motivação: Fazer uma classe que contenha as informações minimas necessárias para que o que se deseja adicionar seja considerado uma pessoa(funcionário ou sócio) pelo sistema.
	Solução: A classe é a que contém as variáveis associadas ao nome completo, email, cpf e número de telefone dos associados, onde ela apresenta um construtor para "setar" devidas variáveis.
	Vantagens: Organização, já que somente acessando a ela pode-se fazer as associações.
- Resources:
	Motivação: Fazer uma classe que contenha as informações ligadas aos recursos físicos do time. Foi necessária para distribuir tais recursos e nela foi "setada" as informações minimas dos mesmos.
	Solução: Ela contém variáveis como, se o recurso está disponivel e o tipo dele. Seus métodos são os de adição, onde é necessário selecionar o método certo para cada tipo de recurso do time.
	Vantagens: Distribuição dos recursos.

Distribuição dos Métodos:
 - Adicionar Funcionário(add): Está presente na classe TeamEmployees porque esta classe é a que apresenta as informações referentes aos funcionários.
 - Adicionar Sócios(add): Presente na classe TeamSupporters porque esta classe é a que apresenta as informações referentes aos sócios-torcedores.
 - Adicionar Ônibus(addBus): Presente na classe Resources porque esta classe contém as informações minimas para os recursos.
 - Adicionar Estádio(addStadium): Presente na classe Resources porque esta classe contém as informações minimas para os recursos.
 - Adicionar Centro de Treinamento(addCenter): Presente na classe Resources porque esta classe contém as informações minimas para os recursos.
	Motivação: Organização. Para não ser extremamente necessário a busca extensiva de determinado método quando desejado se os mesmos já tiverem em classes relacionadas a suas funcionalidades.
	Solução: A distribuição foi feita em base de associações para cada método e a classe em que está presente com a ideia de manter um padrão onde por exemplo, se quero adicionar um funcionário esse método vai estar na classe relacionada aos funcionários e assim pro diante.
	Vantagens: Quando necessária a utilização dos métodos eles podem ser associados mais facilmente.


Herança:
- TeamEmployees:
	Motivação: Fazer uma classe de funcionários em que possa, além de adicionar as informações referentes a People, extender para mais informações que são o salário e o tipo e que só são necessários para os funcionários do time.
	Solução: Essa classe apresenta uma extensão da classe People e nela é possivel adicionar mais informações as pessoas, no caso, funcionários. Apresenta um método de adição que é utilizado para checar o tipo de funcionário que deseja ser adicionado e o associar a sua devida classe já que, nesse sistema, é possivel que mesmo quando é explicito que designada pessoa é um funcionário, pode associa-lá a outra classe extendida para que sejam guardadas todas as informações referentes ao funcinário. É nesse método em que o a atribuição é feita se o funcionário for criado com sucesso e ainda, se o mesmo ainda não existir no sistema ele é adicionado ao ArrayList dos funcionários.
	Vantagens: Manipulação em relação a adição de funcionários, já que como é uma extensão da classe People, ela me permite adicionar mais informações referentes somente a aquele grupo seleto.
	Desvantagens: A manipulação em relação ao acesso a esse meio em alguns momentos do código pela classe ser uma extensão de outra então foi necessário fazer atribuições para ter suporte a variáveis especificas ligadas a essa classe.
- TeamSupporters: 
	Motivação: A classe é também uma extensão da classe People e nela é possivel adicionar informações referentes aos sócios-torcedores com a adição das variáveis de endereço, tipo(guarda uma tipo diferente da classe TeamEmployees), contribuição mensal e status de pagamento.
	Solução: Criação das variáveis necessárias para a adição de sócios e contém o método da adição dos sócios.
	Vantagens: Manipulação em relação a adição, já que como é uma extensão da classe People, ela me permite adicionar mais informações referentes somente a aquele grupo seleto.
	Desvantagens: A manipulação em relação ao acesso a esse meio em alguns momentos do código pela classe ser uma extensão de outra então foi necessário fazer atribuições para ter suporte a variáveis especificas ligadas a essa classe.
- Doctor: 
	Motivação: Foi criada em vista de que a classe precisava de uma variável CRM em relação a esse funcionário.
	Solução: Assim, não foram utilizadas variáveis desnecessárias para outros tipos já que o CRM só está ligado a essa.
	Vantagens: Manipulação em relação a adição, já que como é uma extensão da classe TeamEmployees, ela me permite adicionar mais informações referentes somente a aquele grupo seleto.
	Desvantagens: A manipulação em relação ao acesso a esse meio em alguns momentos do código pela classe ser uma extensão de outra então foi necessário fazer atribuições para ter suporte a variáveis especificas ligadas a essa classe.
- Driver: 
	Motivação: Foi criada em vista de que a classe precisava de uma variável para o número de licença em relação a esse funcionário.
	Solução: Assim, não foram utilizadas variáveis desnecessárias para outros tipos já que o número de licença só está ligado a essa.
	Vantagens: Manipulação em relação a adição, já que como é uma extensão da classe TeamEmployees, ela me permite adicionar mais informações referentes somente a aquele grupo seleto.
	Desvantagens: A manipulação em relação ao acesso a esse meio em alguns momentos do código pela classe ser uma extensão de outra então foi necessário fazer atribuições para ter suporte a variáveis especificas ligadas a essa classe.
- Player: 
	Motivação: Foi criada em vista de que a classe precisava de variáveis relacionadas ao tipo de jogador e sua disponiblidade para jogar.
	Solução: Assim, não foram utilizadas variáveis desnecessárias para outros tipos já que o tipo de jogador e sua disponiblidade só está ligada a essa.
	Vantagens: Manipulação em relação a adição, já que como é uma extensão da classe TeamEmployees, ela me permite adicionar mais informações referentes somente a aquele grupo seleto.
	Desvantagens: A manipulação em relação ao acesso a esse meio em alguns momentos do código pela classe ser uma extensão de outra então foi necessário fazer atribuições para ter suporte a variáveis especificas ligadas a essa classe.
- TCenter: 
	Motivação: Criada em vista de que o centro de treinamento apresenta número de dormitórios, o que lhe difere dos outros.
	Solução: Assim, não foram utilizadas variáveis desnecessárias para outros tipos já que o número de dormitórios só está ligado a essa.
	Vantagens: Manipulação em relação a adição, já que como é uma extensão da classe Resources, ela me permite adicionar mais informações referentes somente a aquele grupo seleto.
	Desvantagens: A manipulação em relação ao acesso a esse meio em alguns momentos do código pela classe ser uma extensão de outra então foi necessário fazer atribuições para ter suporte a variáveis especificas ligadas a essa classe.
- Stadium:
	Motivação: Criada em vista de que o Estádio de apresentar capacidade, número de banheiros e número de lanchonetes.
	Solução: Assim, não foram utilizadas variáveis desnecessárias para outros tipos já que a capacidade, número de banheiros e número de lanchonetes só está ligado a essa.
	Vantagens: Manipulação em relação a adição, já que como é uma extensão da classe Resources, ela me permite adicionar mais informações referentes somente a aquele grupo seleto.
	Desvantagens: A manipulação em relação ao acesso a esse meio em alguns momentos do código pela classe ser uma extensão de outra então foi necessário fazer atribuições para ter suporte a variáveis especificas ligadas a essa classe.


Interface:
	Motivação: Foi observada a utilização de métodos semelhantes.
	Solução: Para tais métodos pode ser criada uma interface para serem utilizados nas classes necessárias.

Polimorfismo: 
	Motivação: É utilizada interface no sistema.
	Solução: Na interface são necessaárias a utilização de métodos de mesmo nome onde aplicada, gerando assim o polimorfismo.

Tratamento de Exceções:
	As exceções ultilizadas estão relacionadas a erros de digitação em certas situações.
- NumberFormatException:
	Motivação: Verificar se os valores digitados(int ou double) são mesmo números.
	Solução: Por exemplo, o usuario poderia digitar uma string somente com letras e nesse caso chegar a exception, então foi utilizada para tratar esse tipo de erro.
	Vantagens: Esse tratamento evita erros que podem causar a parada do sistema.
- InputMismatchException:
	Motivação: Verificar se os valores correspondem a entrada pedida.
	Solução: Por exemplo, o sistema pede um número do tipo inteiro e o usuario digita um tipo double, essa exception vai tratar esse e casos semelhantes.
	Vantagens: Esse tratamento evita erros que podem causar a parada de sistema.


Extensibilidade: 
	A classe TeamEmployees tem três tipos de extensões, a classe Player, Driver e Doctor.
	Motivação: Foi visto necessário utilizar essa extensões porque tais classes contêm variáveis que só estão relacionadas a elas no sistema.
	Solução: Foram utilizadas para maior organização do sistema.
	Vantagens: Organização.
	Desvantagens: Maior utilização de classes.
	
