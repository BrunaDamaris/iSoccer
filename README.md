#iSoccer

**Funcionalidades:** 
* O projeto tem como objetivo permitir a administração de um time de futebol por meio de um sistema. Esse sistema é acessado por meio de login com acesso a um devido funcionário onde os próprio sistema disponibilizará as informações de acesso. Esses sistema terá tanto aos funcionários quanto aos recursos do time. Nele é possivel adicionar funcionários, modificar o status dos jogadores do time (apto ou não apto a jogar), adicionar e/ou acessar os sócios-torcedores do time, como editar suas dadas contribuições e se o sócio está adimplente ou não. Também é possivel gerenciar os recursos físicos do time e solicitar relatórios em relação aos mesmos e aos funcionários.

* O sistema fornece um login de acesso e senha(gerada aleatoriamente) ao ínicio de sua execução. Para a aleatoriedade da senha foi utilizado o Random fornecido pela linguagem e com concatenação.

* Para modificar o status dos jogadores foi utilizada a ideia de que cada jogador tem uma variável relacionada a seu status e ela pode ser modificada pelo funcionário com acesso por meio de verificações, essas verificações foram implementadas por meio de primeiro, verifica-se se existem jogadores no time e em seguida, se existirem, são mostradas as informações de cada jogador, ou seja, é verificado se o jogador pode jogar ou não, e dependendo da resposta é possivel mudar esse status devidamente.

* Em relação ao acesso aos sócios-torcedores, é possivel definir as contribuições para cada tipo de sócio e modificar seu status para saber se o mesmo é adimplente ou inadimplente (o processo é semelhante a mudança de status dos jogadores).

* O gerenciamento de recursos é feito por meio checagens para cada recurso, se disponível ou não. As checagens são feitas através de uma variável associada a cada tipo de recurso que vai apontar de o mesmo está disponível ou não disponível. O funcionário com acesso poderá modificar essa disponibilidade após a checagem. 

* Os relatórios são onde são fornecidas as informações sobre o time em geral. O funcionário com acesso poderá escolher entre ver os relatórios dos funcionários, dos sócios-torcedores ou dos recursos físicos do time. As informações dos relatórios são acessadas atráves de gets associados com o que o funcionário com acesso deseja saber, por exemplo, quais jogadores estão aptos a jogar, quais sócios são adimplentes ou quais recursos estão disponíveis.

* Métodos: 
 - Adicionar Funcionário(add)/Adicionar Sócios(add): Ambos os métodos foram criados para adicionar o objeto a sua devida lista. A ideia desses métodos é que os mesmos sejão ligados a interface implementada no sistema em suas respectivas classes em que foi necessário fazer um cast para seu devido tipo já que deve-se associá-lo corretamente. É previamente definido o tipo desse funcionário na classe principal.
 - Adicionar Recurso(addBus)/Adicionar Estádio(addStadium)/Adicionar Centro de Treinamento(addCenter): Foi preferível dividir as partes da adição de recursos em três métodos distintos, cada um ligado a sua classe por simples questões de não querer utilizar comparações extensas já que é possível saber o tipo do recurso anteriormente. O método basicamente adiciona o objeto se na ArrayList de seu tipo não houver um igual.
 - Os demais métodos são sets e gets.

* Todas as funcionalidades funcionam corretamente.



**Classes:**

O sistema contém dez classes divididas em tipos para funcionários, recursos físicos e a classe main. Três delas são as principais e as demais estão ligadas a herança. 
	* MainSystem: 
	
	-Motivação: Utilizada para administrar e acessar as demais classes do sistema. Principalmente criada como meio de inicialização e organização das devidas partes do código. Foi feita em base de escolhas em que para cada entrada informada pelo funcionário, é acessada uma parte do código desejada.

	-Solução: É uma classe principal para a implementação já que ela contém a main e apresenta os "loops" necessários para o acesso as todas as funcionalidades apresentadas. Também contém as variáveis do tipo booleana para melhor acesso a "loops" em que a booleana além de ajudar na manutenção, é utilizada para que o funcionário com acesso possa entrar em partes do sistema somente quando permitido, além disso, são apresentados os tipo double, para valores associados a contribuições de sócios no sistema e também, ArrayList utilizados para armazenar os devidos funcionário, os sócios e os recursos físicos. Essa classe é também a que cria os logins do sistema quando inicializada.

	-Vantagens: Como classe principal, ela pode acessar as outras e fazer todas as alterações em partes opcionais do sistema, é nela que ocorrem as chamadas dos métodos de adição necessários.

	-Desvantagens: Extensa, logo é fácil se perder em alguma parte do código quando a mesma pode ser ligada a outra parte.

* People: 
	
		-Motivação: Fazer uma classe que contenha as informações minimas necessárias para que o que se deseja adicionar seja considerado uma pessoa(funcionário ou sócio) pelo sistema em que essa seria a super classe do sistema. Ela contém os sets e gets necessários para cada variável e o construtor da super classe. É acessada pela classe MainSystem quando é necessário adicionar pessoas após serem associadas as suas devidas subclasses quando exigido, e para retornar informações dos objetos com gets e modificar informações com os sets.

		-Solução: A classe é a que contém as variáveis associadas ao nome completo, email, cpf e número de telefone dos associados.

		-Vantagens: Organização, já que somente a acessando podem-se fazer as associações.

* Resources:

		-Motivação: Fazer uma classe que contenha as informações ligadas aos recursos físicos do time. Foi necessária para distribuir tais recursos corretamente e nela foram colocadas as informações minimas dos mesmos. É acessada pela classe MainSystem quando é necessário adicionar pessoas após serem associadas as suas devidas subclasses quando exigido.

		-Solução: Ela contém variáveis como se o recurso está disponível e o tipo dele. Seus métodos são os de adição, onde é necessário selecionar o método certo para cada tipo de recurso do time.

		-Vantagens: Distribuição dos recursos.


**Distribuição dos Métodos:**
	Para cada método foi analisado onde seria melhor de encontrá-lo no código em relação a sua funcionalidade. 
 * Adicionar Funcionário(add): Está presente na classe TeamEmployees porque esta classe é a que apresenta as informações referentes aos funcionários.
 * Adicionar Sócios(add): Presente na classe TeamSupporters porque esta classe é a que apresenta as informações referentes aos sócios-torcedores.
 * Adicionar Ônibus(addBus): Presente na classe Resources porque esta classe contém as informações minimas para os recursos.
 * Adicionar Estádio(addStadium): Presente na classe Resources porque esta classe contém as informações minimas para os recursos.
 * Adicionar Centro de Treinamento(addCenter): Presente na classe Resources porque esta classe contém as informações minimas para os recursos.

		-Motivação: Organização. Para não ser extremamente necessário a busca extensiva de determinado método quando desejado se os mesmos já tiverem em classes relacionadas a suas funcionalidades.

		-Solução: A distribuição foi feita em base de associações para cada método e a classe em que está presente com a ideia de manter um padrão onde por exemplo, se quero adicionar um funcionário esse método vai estar na classe relacionada aos funcionários e assim pro diante.

		-Vantagens: Quando necessária a utilização dos métodos eles podem ser associados mais facilmente.


**Herança:**
	Foi necessário o uso de herança apresentado nessa parte do sistema para que se dividam melhores os tipos de funcionários com os de recursos, como por exemplo, a criação de um diferencial para os tipos médico e motorista do time já que esses irão conter variáveis isoladas dos demais.

* TeamEmployees:

		-Motivação: Fazer uma classe de funcionários em que possa, além de adicionar as informações referentes a People, extender para mais informações que são o salário e o tipo e que só são necessários para os funcionários do time.

		-Solução: Essa classe apresenta uma extensão da classe People e nela é possivel adicionar mais informações as pessoas, no caso, funcionários. Apresenta um método de adição em que se o funcionário ainda não existir no sistema ele é adicionado ao ArrayList dos funcionários. É acessada na adição de funcionários e para retornar informações dos objetos com gets e modificar informações com os sets.

		-Vantagens: Manipulação em relação a adição de funcionários, já que como é uma extensão da classe People, ela me permite adicionar mais informações referentes somente a aquele grupo seleto.

		-Desvantagens: A manipulação em relação ao acesso a esse meio em alguns momentos do código pela classe ser uma extensão de outra então, foi necessário serem feitas atribuições para ter suporte a variáveis específicas ligadas a essa classe.

* TeamSupporters: 

		-Motivação: A classe é também uma extensão da classe People e nela é possivel adicionar informações referentes aos sócios-torcedores com a adição das variáveis de endereço, tipo (guarda um tipo diferente da classe TeamEmployees), contribuição mensal e status de pagamento.

		-Solução: Criação das variáveis necessárias para a adição de sócios e contém o método da adição dos sócios.

		-Vantagens: Manipulação em relação a adição, já que como é uma extensão da classe People, ela me permite adicionar mais informações referentes somente a aquele grupo seleto.

		-Desvantagens: A manipulação em relação ao acesso a esse meio em alguns momentos do código pela classe ser uma extensão de outra então foi necessário fazer atribuições para ter suporte a variáveis específicas ligadas a essa classe.
* Doctor: 

		-Motivação: Foi criada em vista de que a classe precisava de uma variável CRM em relação a esse funcionário.
	
		-Solução: Assim, não foram utilizadas variáveis desnecessárias para outros tipos já que o CRM só está ligado a essa.
	
		-Vantagens: Manipulação em relação a adição, já que como é uma extensão da classe TeamEmployees, ela me permite adicionar mais informações referentes somente a aquele grupo seleto.
	
		-Desvantagens: A manipulação em relação ao acesso a esse meio em alguns momentos do código pela classe ser uma extensão de outra então foi necessário fazer atribuições para ter suporte a variáveis específicas ligadas a essa classe.

* Driver:
 
		-Motivação: Foi criada em vista de que a classe precisava de uma variável para o número de licença em relação a esse funcionário.

		-Solução: Assim, não foram utilizadas variáveis desnecessárias para outros tipos já que o número de licença só está ligado a essa.

		-Vantagens: Manipulação em relação a adição, já que como é uma extensão da classe TeamEmployees, ela me permite adicionar mais informações referentes somente a aquele grupo seleto.

		-Desvantagens: A manipulação em relação ao acesso a esse meio em alguns momentos do código pela classe ser uma extensão de outra então foi necessário fazer atribuições para ter suporte a variáveis específicas ligadas a essa classe.
* Player: 

		-Motivação: Foi criada em vista de que a classe precisava de variáveis relacionadas ao tipo de jogador e sua disponiblidade para jogar.
	
		-Solução: Assim, não foram utilizadas variáveis desnecessárias para outros tipos já que o tipo de jogador e sua disponiblidade só está ligada a essa.
	
		-Vantagens: Manipulação em relação a adição, já que como é uma extensão da classe TeamEmployees, ela me permite adicionar mais informações referentes somente a aquele grupo seleto.
	
		-Desvantagens: A manipulação em relação ao acesso a esse meio em alguns momentos do código pela classe ser uma extensão de outra então foi necessário fazer atribuições para ter suporte a variáveis específicas ligadas a essa classe.

* TCenter:

		-Motivação: Criada em vista de que o centro de treinamento apresenta número de dormitórios, o que o difere dos outros.

		-Solução: Assim, não foram utilizadas variáveis desnecessárias para outros tipos já que o número de dormitórios só está ligado a essa.

		-Vantagens: Manipulação em relação a adição, já que como é uma extensão da classe Resources, ela me permite adicionar mais informações referentes somente a aquele grupo seleto.

		-Desvantagens: A manipulação em relação ao acesso a esse meio em alguns momentos do código pela classe ser uma extensão de outra então foi necessário fazer atribuições para ter suporte a variáveis específicas ligadas a essa classe.

* Stadium:

		-Motivação: Criada em vista de que o Estádio apresenta capacidade, número de banheiros e número de lanchonetes.

		-Solução: Assim, não foram utilizadas variáveis desnecessárias para outros tipos já que a capacidade, número de banheiros e número de lanchonetes só está ligado a essa.

		-Vantagens: Manipulação em relação a adição, já que como é uma extensão da classe Resources, ela me permite adicionar mais informações referentes somente a aquele grupo seleto.

		-Desvantagens: A manipulação em relação ao acesso a esse meio em alguns momentos do código pela classe ser uma extensão de outra então foi necessário fazer atribuições para ter suporte a variáveis específicas ligadas a essa classe.


**Interface:**

	-Motivação: Foi observada a utilização de métodos semelhantes já que, por exemplo, TeamEmployees e TeamSupporters são subclasses da mesma super classe People, é interessante apresentar essa interface com métodos necessários para ambas.

	-Solução: É utilizada nas classes necessárias, particulamente para os métodos de adição que funcionam similarmente.

	-Vantagem: Já que foram estendidas as funcionalidades da super classe People com a herança, a utilização de interface é vantajosa para garantir que suas subclasses sigam os mesmos métodos.

	-Desvantagens: Em alguns sistemas pode ser desvantajosa a obrigatoriedade de certos métodos.

**Polimorfismo:**

	-Motivação: É utilizada interface no sistema assim o polimorfismo é inevitável para os métodos implementados.

	-Solução: Na interface são necessaárias a utilização de métodos de mesmo nome onde aplicada, gerando assim o polimorfismo.



**Tratamento de Exceções:**
	As exceções utilizadas estão relacionadas a erros de digitação em certas situações, tais erros atrapalhavam na execução do programa já que ele parava de executar. Foram usados em todas as partes associadas a digitação de números no código, como por exemplo, quando o funcionário com acesso editar as contribuições de cada tipo de sócio-torcedor.

* NumberFormatException:

		-Motivação: Verificar se os valores digitados(int ou double) são mesmo números.

		-Solução: Por exemplo, o usuário poderia digitar uma string somente com letras e nesse caso chegar a exception, então foi utilizada para tratar esse tipo de erro.

		-Vantagens: Esse tratamento evita erros que podem causar a parada do sistema.

* InputMismatchException:

		-Motivação: Verificar se os valores correspondem a entrada pedida.

		-Solução: Por exemplo, o sistema pede um número do tipo inteiro e o usuário digita um tipo double, essa exception vai tratar esse e casos semelhantes.

		-Vantagens: Esse tratamento evita erros que podem causar a parada do sistema.



**Extensibilidade:**
A classe TeamEmployees tem três tipos de extensões, a classe Player, Driver e Doctor que foram necessariamente criadas utilizando herança.
	
	-Motivação: Foi visto necessário utilizar essa extensões porque tais classes contêm variáveis que só estão relacionadas a elas no sistema.

	-Solução: Foram utilizadas para maior organização do sistema.

	-Vantagens: Organização.

	-Desvantagens: Maior utilização de classes.
	
