package manage;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;


public class MainSystem {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String entry = null,trash = null,login = "admin",password =  "a";
		boolean first_entry = true,loggedin = false,correctInput = false;
		double juniorcontribution = 100,seniorcontribution = 200,elitecontribution = 300;
		ArrayList<People> employees = new ArrayList<People>();
		ArrayList<People> supporters = new ArrayList<People>();
		ArrayList<Resources> teamresources = new ArrayList<Resources>();
		
		while(true) {
			if(first_entry) {
			    Random ran = new Random();
			    password = password + Integer.toString(ran.nextInt());
				System.out.println("Primera vez no Sistema? " + "\nSeu Login de Admistrador e: " + login);
				System.out.println("Sua Senha e: " + password + "\n");
				first_entry = false;
			}
			if(!loggedin) {
				System.out.println("Entrar(1)\n\nFechar(0)");
				entry = input.nextLine();
				if(entry.equals("1")) {
					while(!loggedin) {
						String currentlogin,currentpassword;
						System.out.println("Informe o Login: ");
						currentlogin = input.nextLine();
						System.out.println("Informe a Senha: ");
						currentpassword = input.nextLine();
						if(currentlogin.equals(login)) {
							if(currentpassword.equals(password)) loggedin = true;
							else System.out.println("Senha incorreta. Tente novamente.");
						}
						else System.out.println("Login incorreto. Tente novamente.");
					}
				}
				else if(entry.equals("0")) {
					System.out.println("Fim!" + trash);
					break;
				}
			}
			if(loggedin) {
				while(true) {
					System.out.println("Funcionarios(1)\n\nSocios(2)\n\nGerenciar Recursos Fisicos(3)\n\nSolicitar Relatorios(4)\n\nVoltar(0)");
					entry = input.nextLine();
					//Option 1 - Employees
					if(entry.equals("1")) {
						String option;
						System.out.println("Adicionar Funcionarios(1)\n\nModificar Status de Jogadores(2)\n");
						option = input.nextLine();
						if(option.equals("1")) {
							double newsalary = 0;
							boolean acceptentry = false;
							String newname,newemail,newtype = null,newcpf,newphonenumber;
							System.out.println("Nome Completo: ");
							newname = input.nextLine();
							System.out.println("Email: ");
							newemail = input.nextLine();
							System.out.println("CPF: ");
							newcpf = input.nextLine();
							System.out.println("Numero de telefone: ");
							newphonenumber = input.nextLine();
							while(!acceptentry) {
								System.out.println("Tipo(Presidente, Medico, Tecnico, Preparador Fisico, Motorista, Cozinheiro, Advogado, Jogador):");;
								newtype = input.nextLine();
								if(newtype.equals("Presidente") || newtype.equals("Medico") || newtype.equals("Tecnico") || newtype.equals("Preparador Fisico") || newtype.equals("Motorista") || newtype.equals("Cozinheiro") || newtype.equals("Advogado") || newtype.equals("Jogador")) acceptentry = true;
								else System.out.println("Tipo nao aceito. Tente novamente.");
							}
							System.out.println("Salario: ");
							//Try
							while(!correctInput) {
								try{
									newsalary = input.nextDouble();
									correctInput = true;
								}
								catch(NumberFormatException e){
									input.reset();
									System.out.println("Valor no formato incorreto.");
								}
								catch(InputMismatchException e) {
									input.reset();
									System.out.println("Valor no formato incorreto.");
								}
								if(newsalary <= 0) {
									System.out.println("Valor nao aceito. Digite novamente: ");
									correctInput = false;
								}
								trash = input.nextLine();
							}
							correctInput = false;
							//Begin of add
							TeamEmployees newperson = null;
							if(newtype.equals("Medico")) {
								String ncrm;
								System.out.println("CRM: ");
								ncrm = input.nextLine();
								newperson = new Doctor(newname,newemail,newcpf,newphonenumber,newtype,newsalary,ncrm);
							}
							else if(newtype.equals("Motorista")) {
								String nlisence;
								System.out.println("Numero de Licenca: ");
								nlisence = input.nextLine(); 
								newperson =  new Driver(newname,newemail,newcpf,newphonenumber,newtype,newsalary,nlisence);
							}
							else if(newtype.equals("Jogador")) {
								String ptype = null,status = null;
								boolean accept = false;
								while(!accept) {
									System.out.println("Tipo de Jogador(volante, zagueiro, meia, goleiro, atacante, lateral esquerdo, lateral direito): ");
									ptype = input.nextLine();
									if(ptype.equals("volante") || ptype.equals("zagueiro") || ptype.equals("meia") || ptype.equals("goleiro") || ptype.equals("atacante") || ptype.equals("lateral esquerdo") || ptype.equals("lateral direito")) accept = true;
									else System.out.println("Tipo nao aceito. Tente novamente.");
								}
								System.out.println("Status do Jogador(Pode Jogar(1) ou Nao pode Jogar(2)): ");
								status = input.nextLine();
								newperson = new Player(newname,newemail,newcpf,newphonenumber,newtype,newsalary,ptype,status);
							}
							else {
								newperson = new TeamEmployees(newname,newemail,newcpf,newphonenumber,newtype,newsalary);
							}
							if(employees.contains(newperson)) {
								System.out.println("Nao foi possivel adicionar. Empregado ja existe");
							}
							else {
								System.out.println("Adicionado com sucesso.");
								newperson.add(employees,newperson);
							}
						}
						else if(option.equals("2")) {
							if(employees.size() > 0) {
								boolean available = false;
								String currentname,currentemail;
								System.out.println("Jogadores atuais: ");
								for(int i = 0;i < employees.size();i++) {
									if(employees.get(i) instanceof People) {
										TeamEmployees current = (TeamEmployees) employees.get(i);
										if(current.getType().equals("Jogador")) {
											available = true;
											Player currentplayer = (Player) current;
											System.out.println("Jogador: ");
											System.out.println("Nome: " + currentplayer.getFullname());
											System.out.println("Email: " + currentplayer.getEmail());
											System.out.println("CPF: " + currentplayer.getCpf());
											System.out.println("Numero de telefone: " + currentplayer.getPhonenumber());
											System.out.println("Salario: " + currentplayer.getSalary());
											System.out.println("Posicao no time: " + currentplayer.getPlayertype());
											System.out.print("Status atual: ");
											if(currentplayer.getCanPlay().equals("1")) System.out.println("Pode jogar.");
											else if(currentplayer.getCanPlay().equals("2")) System.out.println("Nao pode jogar.");
											System.out.println("---------------------------------------------");
										}
									}
								}
								if(available) {
									System.out.println("Informe o Nome do Jogador que deseja modificar o Status: ");
									currentname = input.nextLine();
									System.out.println("Informe o Email do Jogador que deseja modificar o Status: ");
									currentemail = input.nextLine();
									int currentplayerindex = -1;
									for(int i = 0;i < employees.size();i++) {
										if(employees.get(i) instanceof People) {
											TeamEmployees current = (TeamEmployees) employees.get(i);
											if(current.getType().equals("Jogador")) {
												Player currentplayer = (Player) current;
												if(currentplayer.getEmail().equals(currentemail) && currentplayer.getFullname().equals(currentname)) {
													currentplayerindex = i;
													break;
												}
											}
										}
									}
									if(currentplayerindex != -1) {
										if(employees.get(currentplayerindex) instanceof People) {
											TeamEmployees current = (TeamEmployees) employees.get(currentplayerindex);
											if(current.getType().equals("Jogador")) {
												Player currentplayer = (Player) current;
												if(currentplayer.getCanPlay().equals("1")) {
													currentplayer.setCanPlay("2");
													System.out.println("Status Modificado. Jogador nao esta mais apto a jogar.");
												}
												else if(currentplayer.getCanPlay().equals("2")) {
													currentplayer.setCanPlay("1");
													System.out.println("Status Modificado. Jogador esta apto a jogar.");
												}
											}
										}
									}
									else System.out.println("Nao foi possivel encontrar o jogador.");
								}
								else System.out.println("Nao ha jogadores disponiveis.");
							}
							else System.out.println("Nao ha jogadores disponiveis.");
						}
						System.out.println("Pressione enter para continuar.");
						trash = input.nextLine();
					}
					//Option 2 - Supporters
					else if(entry.equals("2")) {
						String option = null;
						System.out.println("Adicionar Socios(1)\n\nModificar Status de Socios(2)\n\nDefinir Contribuicoes(3)\n");
						option = input.nextLine();
						if(option.equals("1")) {
							boolean acceptentry = false;
							String newname,newemail,newtype = null,newcpf,newphonenumber, newaddress;
							System.out.println("Nome Completo: ");
							newname = input.nextLine();
							System.out.println("Email: ");
							newemail = input.nextLine();
							System.out.println("CPF: ");
							newcpf = input.nextLine();
							System.out.println("Numero de telefone: ");
							newphonenumber = input.nextLine();
							System.out.println("Endereco: ");
							newaddress = input.nextLine();
							while(!acceptentry) {
								System.out.println("Tipo(Junior, Senior, Elite):");
								newtype = input.nextLine();
								if(newtype.equals("Junior") || newtype.equals("Senior") || newtype.equals("Elite")) acceptentry = true;
								else System.out.println("Tipo nao aceito. Tente novamente.");
							}
							//Begin of add
							TeamSupporters newperson = null;
							if(newtype.equals("Junior")) {
								newperson = new TeamSupporters(newname,newemail,newcpf,newphonenumber,newaddress,newtype,juniorcontribution);
								System.out.println("Valor de contribuicao inicial: R$ " + juniorcontribution);
							}
							else if(newtype.equals("Senior")) {
								newperson = new TeamSupporters(newname,newemail,newcpf,newphonenumber,newaddress,newtype,seniorcontribution);
								System.out.println("Valor de contribuicao inicial: R$ " + seniorcontribution);
							}
							else if(newtype.equals("Elite")) {
								newperson = new TeamSupporters(newname,newemail,newcpf,newphonenumber,newaddress,newtype,elitecontribution);
								System.out.println("Valor de contribuicao inicial: R$ " + elitecontribution);
							}
							if(supporters.contains(newperson)) System.out.println("Nao foi possivel adicionar. Torcedor ja existe.");
							else{
								System.out.println("Adicionado com sucesso.");
								newperson.add(supporters,newperson);
							}
						}
						else if(option.equals("2")) {
							if(supporters.size() > 0) {
								System.out.println("Socios atuais: ");
								for(int i = 0;i < supporters.size();i++) {
									if(supporters.get(i) instanceof People) {
										TeamSupporters current = (TeamSupporters) supporters.get(i);
										System.out.println("Tipo: " + current.getSupportertype());
										System.out.println("Nome: " + current.getFullname());
										System.out.println("Email: " + current.getEmail());
										System.out.println("CPF: " + current.getCpf());
										System.out.println("Numero de telefone: " + current.getPhonenumber());
										System.out.println("Contribuicao: " + current.getContribution());
										System.out.print("Status: ");
										if(current.getPaymentstatus().equals("1")) System.out.println("Adimplente");
										else if(current.getPaymentstatus().equals("2")) System.out.println("Inadimplente");
										System.out.println("---------------------------------------------");
									}
								}
								String currentname,currentemail;
								int currentindex = -1;
								System.out.println("Informe o Nome do Socio que deseja modificar o Status: ");
								currentname = input.nextLine();
								System.out.println("Informe o Email do Socio que deseja modificar o Status: ");
								currentemail = input.nextLine();
								for(int i = 0;i < supporters.size();i++) {
									if(supporters.get(i) instanceof People) {
										TeamSupporters current = (TeamSupporters) supporters.get(i);
										if(current.getFullname().equals(currentname) && current.getEmail().equals(currentemail)) {
											currentindex = i;
											break;
										}
									}
								}
								if(currentindex != -1) {
									if(supporters.get(currentindex ) instanceof People) {
										TeamSupporters current = (TeamSupporters) supporters.get(currentindex );
										if(current.getPaymentstatus().equals("1")) {
											current.setPaymentstatus("2");
											System.out.println("Status modificado. Socio inadimplente");
										}
										else if(current.getPaymentstatus().equals("2")) {
											current.setPaymentstatus("1");
											System.out.println("Status modificado. Socio adimplente");
										}
									}
								}
								else System.out.println("Nao foi possivel encontrar o Socio.");
							}
							else System.out.println("Nao existem Socios.");
						}
						else if(option.equals("3")) {
							boolean acceptentry = false;
							String stype = null;
							double contribution = 0;
							while(!acceptentry) {
								System.out.println("Para qual tipo de Socio deseja definir a contibuicao(Junior, Senior, Elite): ");
								stype = input.nextLine();
								if(stype.equals("Junior") || stype.equals("Senior") || stype.equals("Elite")) acceptentry = true;
								else System.out.println("Tipo nao aceito. Tente novamente.");
							}
							System.out.println("Valor da Contribuicao: ");
							//Try
							while(!correctInput) {
								try{
									contribution = input.nextDouble();
									correctInput = true;
								}
								catch(NumberFormatException e){
									input.reset();
									System.out.println("Valor no formato incorreto.");
								}
								catch(InputMismatchException e) {
									input.reset();
									System.out.println("Valor no formato incorreto.");
								}
								if(contribution <= 0) {
									System.out.println("Valor nao aceito. Digite novamente: ");
									correctInput = false;
								}
								trash = input.nextLine();
							}
							correctInput = false;
							if(stype.equals("Junior")) juniorcontribution = contribution;
							else if(stype.equals("Senior")) seniorcontribution = contribution;
							else if(stype.equals("Elite")) elitecontribution = contribution;
							System.out.println("Modificado.");
							if(supporters.size() > 0) {
								for(int i = 0;i < supporters.size();i++) {
									if(supporters.get(i) instanceof People) {
										TeamSupporters current = (TeamSupporters) supporters.get(i);
										if(current.getSupportertype().equals("Junior")) current.setContribution(juniorcontribution); 
										else if(current.getSupportertype().equals("Senior")) current.setContribution(seniorcontribution);
										else if(current.getSupportertype().equals("Elite")) current.setContribution(elitecontribution);
									}
								}
							}
							else System.out.println("Nao existem Socios.");
						}
						System.out.println("Pressione enter para continuar.");
						trash = input.nextLine();
					}
					//Option 3 - Resources
					else if(entry.equals("3")) {
						String option;
						System.out.println("Onibus(1)\n\nEstadio(2)\n\nCentro de Treinamento(3)\n");
						option = input.nextLine();
						//Bus
						if(option.equals("1")) {
							System.out.println("Adicionar(1)\n\nVerificar(2)\n\nModificar(3)\n");
							option = input.nextLine();
							if(option.equals("1")) {
								Resources.addBus(teamresources, "Onibus");
							}
							else if(option.equals("2")) {
								boolean available = false;
								for(int i = 0;i < teamresources.size();i++) {
									if(teamresources.get(i).getResourcetype().equals("Onibus") && teamresources.get(i).getIsAvailable().equals("1")) available = true;
								}
								if(available) System.out.println("Onibus esta disponivel");
								else System.out.println("Onibus nao esta disponivel");
							}
							else if(option.equals("3")) {
								System.out.println("Modificar Disponibilidade? Se sim, pressione 1. Caso contrario, pressione enter");
								option = input.nextLine();
								if(option.equals("1")) {
									int currentresource = -1;
									for(int i = 0;i < teamresources.size();i++) {
										if(teamresources.get(i).getResourcetype().equals("Onibus")) currentresource = i;
									}
									if(currentresource != -1) {
										if(teamresources.get(currentresource).getIsAvailable().equals("1")) teamresources.get(currentresource).setIsAvailable("2");
										else if(teamresources.get(currentresource).getIsAvailable().equals("2")) teamresources.get(currentresource).setIsAvailable("1");
										System.out.println("Modificado.");
									}
									else System.out.println("Recurso nao existe.");
								}
							}
						}
						//Stadium
						else if(option.equals("2")) {
							System.out.println("Adicionar(1)\n\nVerificar(2)\n\nModificar(3)\n");
							option = input.nextLine();
							if(option.equals("1")) {
								int capacity = 0,bathrooms = 0,diners = 0;
								System.out.println("Informe a capacidade do estadio: ");
								//Try
								while(!correctInput) {
									try{
										capacity = input.nextInt();
										correctInput = true;
									}
									catch(NumberFormatException e){
										System.out.println("Valor no formato incorreto.");
									}
									catch(InputMismatchException e) {
										System.out.println("Valor no formato incorreto.");
									}
									if(capacity <= 0) {
										System.out.println("Valor nao aceito. Digite novamente:");
									}
									trash = input.nextLine();
								}
								correctInput = false;
								System.out.println("Informe a quantidade de banheiros do estadio: ");
								//Try
								while(!correctInput) {
									try{
										bathrooms = input.nextInt();
										correctInput = true;
									}
									catch(NumberFormatException e){
										System.out.println("Valor no formato incorreto.");
									}
									catch(InputMismatchException e) {
										System.out.println("Valor no formato incorreto.");
									}
									if(bathrooms <= 0) {
										System.out.println("Valor nao aceito. Digite novamente:");
									}
									trash = input.nextLine();
								}
								correctInput = false;
								System.out.println("Informe a quantidade de lanchonetes do estadio: ");
								//Try
								while(!correctInput) {
									try{
										diners = input.nextInt();
										correctInput = true;
									}
									catch(NumberFormatException e){
										System.out.println("Valor no formato incorreto.");
									}
									catch(InputMismatchException e) {
										System.out.println("Valor no formato incorreto.");
									}
									if(diners <= 0) {
										System.out.println("Valor nao aceito. Digite novamente:");
									}
									trash = input.nextLine();
								}
								correctInput = false;
								Resources.addStadium(teamresources, "Estadio", capacity, bathrooms, diners);
							}
							else if(option.equals("2")) {
								boolean available = false;
								int currentresource = -1;
								for(int i = 0;i < teamresources.size();i++) {
									if(teamresources.get(i).getResourcetype().equals("Estadio") && teamresources.get(i).getIsAvailable().equals("1")) {
										available = true;
										currentresource = i;
									}
								}
								if(available) {
									System.out.println("Estadio esta disponivel");
									if(teamresources.get(currentresource) instanceof Resources) {
										Stadium current = (Stadium) teamresources.get(currentresource);
										System.out.println("Capacidade: " + current.getCapacity());
										System.out.println("Numero de banheiros: " + current.getNumberofbathrooms());
										System.out.println("Numero de lanchonetes: " + current.getNumberofdiners());
									}
								}
								else System.out.println("Estadio nao esta disponivel");
							}
							else if(option.equals("3")) {
								System.out.println("Modificar Disponibilidade? Se sim, pressione 1. Caso contrario, pressione enter");
								option = input.nextLine();
								if(option.equals("1")) {
									int currentresource = -1;
									for(int i = 0;i < teamresources.size();i++) {
										if(teamresources.get(i).getResourcetype().equals("Estadio")) currentresource = i;
									}
									if(currentresource != -1) {
										if(teamresources.get(currentresource).getIsAvailable().equals("1")) teamresources.get(currentresource).setIsAvailable("2");
										else if(teamresources.get(currentresource).getIsAvailable().equals("2")) teamresources.get(currentresource).setIsAvailable("1");
										System.out.println("Modificado.");
									}
									else System.out.println("Recurso nao existe.");
								}
								System.out.println("Modificar numero de banheiros? Se sim, pressione 1. Caso contrario, pressione enter");
								option = input.nextLine();
								if(option.equals("1")) {
									int currentresource = -1;
									for(int i = 0;i < teamresources.size();i++) {
										if(teamresources.get(i).getResourcetype().equals("Estadio")) currentresource = i;
									}
									if(currentresource != -1) {
										int bathrooms = 0;
										System.out.println("Informe a quantidade de banheiros do estadio: ");
										//Try
										while(!correctInput) {
											try{
												bathrooms = input.nextInt();
												correctInput = true;
											}
											catch(NumberFormatException e){
												System.out.println("Valor no formato incorreto.");
											}
											catch(InputMismatchException e) {
												System.out.println("Valor no formato incorreto.");
											}
											if(bathrooms <= 0) {
												System.out.println("Valor nao aceito. Digite novamente:");
											}
											trash = input.nextLine();
										}
										correctInput = false;
										if(teamresources.get(currentresource) instanceof Resources) {
											Stadium current = (Stadium) teamresources.get(currentresource);
											current.setNumberofbathrooms(bathrooms);
											System.out.println("Modificado.");
										}
									}
									else System.out.println("Recurso nao existe.");
								}
								System.out.println("Modificar numero de lanchonetes? Se sim, pressione 1. Caso contrario, pressione enter");
								option = input.nextLine();
								if(option.equals("1")) {
									int currentresource = -1;
									for(int i = 0;i < teamresources.size();i++) {
										if(teamresources.get(i).getResourcetype().equals("Estadio")) currentresource = i;
									}
									if(currentresource != -1) {
										int diners = 0;
										System.out.println("Informe a quantidade de lanchonetes do estadio: ");
										//Try
										while(!correctInput) {
											try{
												diners = input.nextInt();
												correctInput = true;
											}
											catch(NumberFormatException e){
												System.out.println("Valor no formato incorreto.");
											}
											catch(InputMismatchException e) {
												System.out.println("Valor no formato incorreto.");
											}
											if(diners <= 0) {
												System.out.println("Valor nao aceito. Digite novamente:");
											}
											trash = input.nextLine();
										}
										correctInput = false;
										if(teamresources.get(currentresource) instanceof Resources) {
											Stadium current = (Stadium) teamresources.get(currentresource);
											current.setNumberofdiners(diners);
											System.out.println("Modificado.");
										}
									}
									else System.out.println("Recurso nao existe.");
								}
							}
						}
						//Training Center
						else if(option.equals("3")) {
							System.out.println("Adicionar(1)\n\nVerificar(2)\n\nModificar(3)\n");
							option = input.nextLine();
							if(option.equals("1")) {
								int dormitories = 0;
								System.out.println("Informe a quantidade de dormitorios do Centro de Treinamento: ");
								//Try
								while(!correctInput) {
									try{
										dormitories = input.nextInt();
										correctInput = true;
									}
									catch(NumberFormatException e){
										System.out.println("Valor no formato incorreto.");
									}
									catch(InputMismatchException e) {
										System.out.println("Valor no formato incorreto.");
									}
									if(dormitories <= 0) {
										System.out.println("Valor nao aceito. Digite novamente:");
									}
									trash = input.nextLine();
								}
								correctInput = false;
								Resources.addCenter(teamresources, "Centro de Treinamento", dormitories);
							}
							else if(option.equals("2")) {
								boolean available = false;
								int currentresource = -1;
								for(int i = 0;i < teamresources.size();i++) {
									if(teamresources.get(i).getResourcetype().equals("Centro de Treinamento") && teamresources.get(i).getIsAvailable().equals("1")) {
										available = true;
										currentresource = i;
									}
								}
								if(available) {
									System.out.println("Centro de Treinamento esta disponivel");
									if(teamresources.get(currentresource) instanceof Resources) {
										TCenter current = (TCenter) teamresources.get(currentresource);
										System.out.println("Numero de dormitorios: " + current.getDormitories());
									}
								}
								else System.out.println("Centro de Treinamento nao esta disponivel");
							}
							else if(option.equals("3")) {
								System.out.println("Modificar Disponibilidade? Se sim, pressione 1. Caso contrario, pressione enter");
								option = input.nextLine();
								if(option.equals("1")) {
									int currentresource = -1;
									for(int i = 0;i < teamresources.size();i++) {
										if(teamresources.get(i).getResourcetype().equals("Centro de Treinamento")) currentresource = i;
									}
									if(currentresource != -1) {
										if(teamresources.get(currentresource).getIsAvailable().equals("1")) teamresources.get(currentresource).setIsAvailable("2");
										else if(teamresources.get(currentresource).getIsAvailable().equals("2")) teamresources.get(currentresource).setIsAvailable("1");
										System.out.println("Modificado.");
									}
									else System.out.println("Recurso nao existe.");
								}
								System.out.println("Modificar numero de dormitorios? Se sim, pressione 1. Caso contrario, pressione enter");
								option = input.nextLine();
								if(option.equals("1")) {
									int currentresource = -1;
									for(int i = 0;i < teamresources.size();i++) {
										if(teamresources.get(i).getResourcetype().equals("Centro de Treinamento")) currentresource = i;
									}
									if(currentresource != -1) {
										int dormitories = 0;
										System.out.println("Informe a quantidade de dormitorios do Centro de Treinamento: ");
										//Try
										while(!correctInput) {
											try{
												dormitories = input.nextInt();
												correctInput = true;
											}
											catch(NumberFormatException e){
												System.out.println("Valor no formato incorreto.");
											}
											catch(InputMismatchException e) {
												System.out.println("Valor no formato incorreto.");
											}
											if(dormitories <= 0) {
												System.out.println("Valor nao aceito. Digite novamente:");
											}
											trash = input.nextLine();
										}
										correctInput = false;
										if(teamresources.get(currentresource) instanceof Resources) {
											TCenter current = (TCenter) teamresources.get(currentresource);
											current.setDormitories(dormitories);
											System.out.println("Modificado.");
										}
									}
									else System.out.println("Recurso nao existe.");
								}
							}
						}
						System.out.println("Pressione enter para continuar.");
						trash = input.nextLine();
					}
					//Option 4 - Report
					else if(entry.equals("4")) {
						String option;
						System.out.println("Funcionarios(1)\n\nRecursos Fisicos(2)\n\nSocios(3)\n");
						option = input.nextLine();
						//Employees
						if(option.equals("1")) {
							System.out.println("Time(1)\n\nServicos Gerais(2)\n");
							option = input.nextLine();
							if(option.equals("1")) {
								System.out.println("Ver informacoes do time(1)\n\nVer jogadores aptos e nao aptos a jogar(2)\n");
								option = input.nextLine();
								if(option.equals("1")) {
									for(int i = 0;i < employees.size();i++) {
										if(employees.get(i) instanceof People) {
											TeamEmployees current = (TeamEmployees) employees.get(i);
											if(current.getType().equals("Tecnico")) {
												System.out.println("Treinador: ");
												System.out.println("Nome: " + current.getFullname());
												System.out.println("Email: " + current.getEmail());
												System.out.println("CPF: " + current.getCpf());
												System.out.println("Numero de telefone: " + current.getPhonenumber());
												System.out.println("Salario: " + current.getSalary());
												System.out.println("---------------------------------------------");
											}
											else if(current.getType().equals("Jogador")) {
												Player currentplayer = (Player) current;
												System.out.println("Jogador: ");
												System.out.println("Nome: " + currentplayer.getFullname());
												System.out.println("Email: " + currentplayer.getEmail());
												System.out.println("CPF: " + currentplayer.getCpf());
												System.out.println("Numero de telefone: " + currentplayer.getPhonenumber());
												System.out.println("Salario: " + currentplayer.getSalary());
												System.out.println("Posicao no time: " + currentplayer.getPlayertype());
												System.out.print("Status atual: ");
												if(currentplayer.getCanPlay().equals("1")) System.out.println("Pode jogar.");
												else if(currentplayer.getCanPlay().equals("2")) System.out.println("Nao pode jogar.");
												System.out.println("---------------------------------------------");
											}
										}
									}
								}
								else if(option.equals("2")) {
									System.out.println("Jogadores aptos a jogar: ");
									int aptos = 0,naoaptos = 0;
									for(int i = 0;i < employees.size();i++) {
										if(employees.get(i) instanceof People) {
											TeamEmployees current = (TeamEmployees) employees.get(i);
											if(current.getType().equals("Jogador")) {
												Player currentplayer = (Player) current;
												if(currentplayer.getCanPlay().equals("1")) {
													System.out.println("Jogador: ");
													System.out.println("Nome: " + currentplayer.getFullname());
													System.out.println("Email: " + currentplayer.getEmail());
													System.out.println("CPF: " + currentplayer.getCpf());
													System.out.println("Numero de telefone: " + currentplayer.getPhonenumber());
													System.out.println("Salario: " + currentplayer.getSalary());
													System.out.println("Posicao no time: " + currentplayer.getPlayertype());
													System.out.println("---------------------------------------------");
													aptos++;
												}
											}
										}
									}
									if(aptos == 0) System.out.println("Nao existem jogadores aptos a jogar.");
									System.out.println("Jogadores nao aptos a jogar: ");
									for(int i = 0;i < employees.size();i++) {
										if(employees.get(i) instanceof People) {
											TeamEmployees current = (TeamEmployees) employees.get(i);
											if(current.getType().equals("Jogador")) {
												Player currentplayer = (Player) current;
												if(currentplayer.getCanPlay().equals("2")) {
													System.out.println("Jogador: ");
													System.out.println("Nome: " + currentplayer.getFullname());
													System.out.println("Email: " + currentplayer.getEmail());
													System.out.println("CPF: " + currentplayer.getCpf());
													System.out.println("Numero de telefone: " + currentplayer.getPhonenumber());
													System.out.println("Salario: " + currentplayer.getSalary());
													System.out.println("Posicao no time: " + currentplayer.getPlayertype());
													System.out.println("---------------------------------------------");
													naoaptos++;
												}
											}
										}
									}
									if(naoaptos == 0) System.out.println("Nao existem jogadores nao aptos a jogar.");
								}
							}
							else if(option.equals("2")) {
								for(int i = 0;i < employees.size();i++) {
									if(employees.get(i) instanceof People) {
										TeamEmployees current = (TeamEmployees) employees.get(i);
										if(current.getType().equals("Presidente") || current.getType().equals("Preparador Fisico") || current.getType().equals("Cozinheiro") || current.getType().equals("Advogado")) {
											System.out.println(current.getType() + ": ");
											System.out.println("Nome: " + current.getFullname());
											System.out.println("Email: " + current.getEmail());
											System.out.println("CPF: " + current.getCpf());
											System.out.println("Numero de telefone: " + current.getPhonenumber());
											System.out.println("Salario: " + current.getSalary());
											System.out.println("---------------------------------------------");
										}
										else if(current.getType().equals("Medico")) {
											Doctor currentdoctor = (Doctor) current;
											System.out.println("Medico: ");
											System.out.println("Nome: " + currentdoctor.getFullname());
											System.out.println("Email: " + currentdoctor.getEmail());
											System.out.println("CPF: " + currentdoctor.getCpf());
											System.out.println("Numero de telefone: " + currentdoctor.getPhonenumber());
											System.out.println("Salario: " + currentdoctor.getSalary());
											System.out.println("CRM: " + currentdoctor.getCRM());
											System.out.println("---------------------------------------------");
										}
										else if(current.getType().equals("Motorista")) {
											Driver currentdriver = (Driver) current;
											System.out.println("Motorista: ");
											System.out.println("Nome: " + currentdriver.getFullname());
											System.out.println("Email: " + currentdriver.getEmail());
											System.out.println("CPF: " + currentdriver.getCpf());
											System.out.println("Numero de telefone: " + currentdriver.getPhonenumber());
											System.out.println("Salario: " + currentdriver.getSalary());
											System.out.println("Numero de habilitacao: " + currentdriver.getLicensenumber());
											System.out.println("---------------------------------------------");
										}
									}
								}
							}
						}
						//Resources
						else if(option.equals("2")) {
							System.out.println("Transporte(1)\n\nCentro de Treinamento(2)\n\nEstadio(3)\n");
							option = input.nextLine();
							if(option.equals("1")) {
								boolean available = false;
								for(int i = 0;i < teamresources.size();i++) {
									if(teamresources.get(i).getResourcetype().equals("Onibus")) {
										available = true;
										System.out.println("Onibus: ");
										if(teamresources.get(i).getIsAvailable().equals("1")) System.out.println("Onibus esta disponivel.");
										else if(teamresources.get(i).getIsAvailable().equals("2")) System.out.println("Onibus nao esta disponivel.");
										System.out.println("---------------------------------------------");
									}
								}
								if(!available) System.out.println("Onibus nao esta disponivel.");
							}
							else if(option.equals("2")) {
								boolean available = false;
								System.out.println("Centro de Treinamento: ");
								for(int i = 0;i < teamresources.size();i++) {
									if(teamresources.get(i).getResourcetype().equals("Centro de Treinamento")) {
										available = true;
										TCenter current = (TCenter) teamresources.get(i);
										if(current.getIsAvailable().equals("1")) {
											System.out.println("Centro de Treinamento esta disponivel.");
											System.out.println("Numero de dormitorios: " + current.getDormitories());
										}
										else if(current.getIsAvailable().equals("2")) System.out.println("Centro de Treinamento nao esta disponivel.");
										System.out.println("---------------------------------------------");
									}
								}
								if(!available) System.out.println("Onibus nao esta disponivel.");
							}
							else if(option.equals("3")) {
								boolean available = false;
								System.out.println("Estadio: ");
								for(int i = 0;i < teamresources.size();i++) {
									if(teamresources.get(i).getResourcetype().equals("Estadio")) {
										available = true;
										Stadium current = (Stadium) teamresources.get(i);
										if(current.getIsAvailable().equals("1")) {
											System.out.println("Estadio esta disponivel.");
											System.out.println("Capacidade: " + current.getCapacity());
											System.out.println("Numero de banheiros: " + current.getNumberofbathrooms());
											System.out.println("Numero de lanchonetes: " + current.getNumberofdiners());
										}
										else if(current.getIsAvailable().equals("2")) System.out.println("Estadio nao esta disponivel.");
										System.out.println("---------------------------------------------");
									}
								}
								if(!available) System.out.println("Onibus nao esta disponivel.");
							}
						}
						//Supporters
						else if(option.equals("3")) {
							int cont1 = 0,cont2 = 0;
							for(int i = 0;i < supporters.size();i++) {
								if(supporters.get(i) instanceof People) {
									TeamSupporters current = (TeamSupporters) supporters.get(i);
									if(current.getPaymentstatus().equals("1")) cont1++;
									else if(current.getPaymentstatus().equals("2")) cont2++;
								}
							}
							System.out.println("Quantidade de Socios: " + supporters.size());
							System.out.println("Quantidade de Socios Adimplentes: " + cont1);
							System.out.println("Quantidade de Socios Inadimplentes: " + cont2);
							System.out.println("\nInformacoes dos Socios: ");
							for(int i = 0;i < supporters.size();i++) {
								if(supporters.get(i) instanceof People) {
									TeamSupporters current = (TeamSupporters) supporters.get(i);
									System.out.println("Tipo: " + current.getSupportertype());
									System.out.println("Nome: " + current.getFullname());
									System.out.println("Email: " + current.getEmail());
									System.out.println("CPF: " + current.getCpf());
									System.out.println("Numero de telefone: " + current.getPhonenumber());
									System.out.println("Contribuicao: " + current.getContribution());
									System.out.print("Status: ");
									if(current.getPaymentstatus().equals("1")) System.out.println("Adimplente");
									else if(current.getPaymentstatus().equals("2")) System.out.println("Inadimplente");
									System.out.println("---------------------------------------------");
								}
							}
						}
						System.out.println("Pressione enter para continuar.");
						trash = input.nextLine();
					}
					//Exit
					else if(entry.equals("0")) {
						System.out.println("Deslogado.");
						loggedin = false;
						break;
					}
				}
			}
		}
		input.close();
	}
}
