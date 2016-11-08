import javax.swing.JOptionPane;
import java.util.List;
import java.util.LinkedList;
import java.io.IOException;
public class QuizMakerMenu2{
	
	public static void main(String[] args){
		
		QuizMaker quiz = new QuizMaker();
		
		
		
		boolean saida = true;
		
		while(saida){
			
			int escolha = Integer.parseInt(JOptionPane.showInputDialog("Bem vindo ao quiz, as seguintes opções estão disponíveis. Divirta-se.\n 1. Cadastrar questão.\n 2. Pesquisar questão pelo id.\n 3. Obter uma quantidade de quiz e responde-lo:\n 4. Obter resposta do usuário pelo nome. \n 5. Obter total de pontos de um usuário.\n 6. Remover questão pelo ID.\n 7. Apagar resposta de questão.\n 8. Sair"));
		
			switch(escolha){
				
			case 1:
				int opcao = Integer.parseInt(JOptionPane.showInputDialog("Os seguintes tipos de cadastro, estão disponíveis:\n 1. Cadastrar questões de V ou F.\n 2. Cadastrar questões de múltipla escolha.\n 3. Cadastrar questões dissertativa."));
				
				if(opcao == 1){
					List <String> afirmativas = new LinkedList<String>();
					QuestaoVF questaoVF = new QuestaoVF();
					
					String enunciado = JOptionPane.showInputDialog("Informe o enunciado da questão: ");
					double peso = Double.parseDouble(JOptionPane.showInputDialog("Qual o peso da questão?"));
					int quantidadeDeAfirmativas = Integer.parseInt(JOptionPane.showInputDialog("Quantas afirmativas terá a questão: "));
					for(int x = 0; x<quantidadeDeAfirmativas; x++){
						afirmativas.add("(   ) " + JOptionPane.showInputDialog("Informe a " + (x+1) + "° "+ " afirmativa: "));
					}
					String gabarito = JOptionPane.showInputDialog("O gabarito contém " + quantidadeDeAfirmativas + " afirmativa(s)" + "Informe o gabarito(V ou F):");
					String id = JOptionPane.showInputDialog("Informe o ID da questão: ");
					questaoVF.setId(id);
					questaoVF.setEnunciado(enunciado);
					questaoVF.setPeso(peso);
					questaoVF.setAfirmativas(afirmativas);
					questaoVF.setGabarito(gabarito);
					try{
						quiz.cadastrarQuestao(questaoVF);
						JOptionPane.showMessageDialog(null, "A respostas foi cadastrada com sucesso:\n" +"Enunciado: "+ questaoVF.getEnunciado()+"\n" + "Peso: " + questaoVF.getPeso() + "\n" +"ID: "+ questaoVF.getId()+"\n" + "Afirmativa(s): " + questaoVF.getAfirmativas());
						
					}catch(QuestaoJaExisteException info){
						JOptionPane.showMessageDialog(null, info.getMessage());
					}
					
					
					
				}else if(opcao == 2){
					List <String> alternativas = new LinkedList<String>();
					QuestaoMultiplaEscolha QME = new QuestaoMultiplaEscolha();
					
					String enunciado = JOptionPane.showInputDialog("Informe o enunciado da questão: ");
					double peso = Double.parseDouble(JOptionPane.showInputDialog("Qual o peso da questão?"));
					int quantidadeDeAlternativas = Integer.parseInt(JOptionPane.showInputDialog("Quantas alternativas terá a questão: "));
					for(int x = 0; x<quantidadeDeAlternativas; x++){
						alternativas.add((x+1)+" = " + JOptionPane.showInputDialog("Informe a " + (x+1) + "° " + " alternativa(s) "));
					}
					String gabarito = JOptionPane.showInputDialog("O gabarito contém " + quantidadeDeAlternativas + " alternativa(s), apenas uma está correta, informe a resposta: ");
					String id = JOptionPane.showInputDialog("Informe o ID da questão: ");
					QME.setId(id);
					QME.setEnunciado(enunciado);
					QME.setPeso(peso);
					QME.setAlternativas(alternativas);
					QME.setGabarito(gabarito);
					try{
						quiz.cadastrarQuestao(QME);
						JOptionPane.showMessageDialog(null, "A respostas foi cadastrada com sucesso:\n" +"Enunciado: "+ QME.getEnunciado()+"\n" + "Peso: " + QME.getPeso() + "\n" +"ID: "+ QME.getId()+"\n" + "Alternativa(s): "+ QME.getAlternativas());
					}catch(QuestaoJaExisteException info){
						JOptionPane.showMessageDialog(null, info.getMessage());
					}
					
				}else if(opcao == 3){
					
					QuestaoDissertativa questaoDissertativa = new QuestaoDissertativa();
					String enunciado = JOptionPane.showInputDialog("Informe o enunciado da questão: ");
					double peso = Double.parseDouble(JOptionPane.showInputDialog("Qual o peso da questão?"));
					String gabarito = JOptionPane.showInputDialog("Informe a resposta da questão dissertativa: ");
					String id = JOptionPane.showInputDialog("Informe o ID da questão: ");
					questaoDissertativa.setId(id);
					questaoDissertativa.setEnunciado(enunciado);
					questaoDissertativa.setPeso(peso);
					questaoDissertativa.setGabarito(gabarito);
					try{
						quiz.cadastrarQuestao(questaoDissertativa);
						JOptionPane.showMessageDialog(null, "A respostas foi cadastrada com sucesso:\n" +"Enunciado: "+ questaoDissertativa.getEnunciado()+"\n" + "Peso: " + questaoDissertativa.getPeso() + "\n" +"ID: "+ questaoDissertativa.getId());
					}catch(QuestaoJaExisteException info){
						JOptionPane.showMessageDialog(null, info.getMessage());
					}
				}
			break;
			
			case 2:
				String pesquisarQuestaoPeloId = JOptionPane.showInputDialog("Informe o ID da questão a ser obtida.");
				try{
					JOptionPane.showMessageDialog(null, quiz.pesquisarQuestao(pesquisarQuestaoPeloId));
				}catch(QuestaoNaoExisteException info){
					JOptionPane.showMessageDialog(null, info.getMessage());
				}
			break;
			
			case 3:
				double pontuacaoTotal = 0;
				String nomeUsuario = JOptionPane.showInputDialog("Qual o seu nome?");
				int quantidadeDeQuizAObter = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de quiz que deseja responder: "));
				try{
					List <Questao> questoesSalvas = quiz.obterQuiz(quantidadeDeQuizAObter);
					for(Questao questoes: questoesSalvas){
						
						String respostas = JOptionPane.showInputDialog(questoes);
						double pontuacao = questoes.getPontuacaoParaResposta(respostas);
						pontuacaoTotal += pontuacao;
						RespostaDeQuestao respostaQuestao = new RespostaDeQuestao(questoes, respostas, nomeUsuario);
						quiz.cadastrarRespostaDeQuestao(respostaQuestao);
					}
				JOptionPane.showMessageDialog(null, "Sua pontuação foi: " + pontuacaoTotal);
				}catch(QuestoesInsuficientesException info){
					JOptionPane.showMessageDialog(null, info.getMessage());
				}
			break;
			
			case 4:
				String nomeUsuarioResposta = JOptionPane.showInputDialog("Informe o nome do usuário que você deseja obter respostas: ");
				List<RespostaDeQuestao> respostasUsuarios = quiz.obterRespostasDadasPeloUsuario(nomeUsuarioResposta);
				for(RespostaDeQuestao respostas: respostasUsuarios){
					JOptionPane.showMessageDialog(null, "Resposta: \n" + respostas.getResposta());
					
				}
			break;
			
			case 5:
				
				String nomeUsuarioPontuacao = JOptionPane.showInputDialog("Informe o nome do usuário e obtenha a pontuação total dele: ");
				JOptionPane.showMessageDialog(null, "O usuário "+ nomeUsuarioPontuacao + " obteu " + quiz.obterTotalDePontosDoUsuario(nomeUsuarioPontuacao) + " ponto(s)");
				break;
				
			case 6:
				
				String removerQuestaoPeloId = JOptionPane.showInputDialog("Informe o id da questão que deseja apagar: ");
				try{
					quiz.apagarQuestao(removerQuestaoPeloId);
					JOptionPane.showMessageDialog(null, "Questão removida com sucesso!");
				}catch(QuestaoNaoExisteException info){
					JOptionPane.showMessageDialog(null, info.getMessage());
				}
				
			break;
			
			case 7:
				String apagarRespostaComId = JOptionPane.showInputDialog("Informe o id do quiz que deseja apagar a resposta: ");
				String apagarRespostaDoUsuario = JOptionPane.showInputDialog("Informe o login do usuário: ");
				try{
				quiz.apagarRespostaDeQuestao(apagarRespostaComId, apagarRespostaDoUsuario);
				JOptionPane.showMessageDialog(null, "Resposta removida com sucesso!");
				}catch(RespostaNaoExisteException info){
					JOptionPane.showMessageDialog(null, info.getMessage());
				}
				
			break;
			
			case 8:
				saida = false;
				break;
			
			default:
					JOptionPane.showMessageDialog(null, "Opção, não existente. Por favor, informar opção correta!");
					break;
			}
			
			}
		
		}
	}
