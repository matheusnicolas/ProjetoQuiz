import javax.swing.JOptionPane;
import java.util.List;
import java.util.LinkedList;
import java.io.IOException;
public class QuizMakerMenu{
	
	public static void main(String[] args) throws IOException{
		
		QuizMaker quiz = new QuizMaker();
		GravadorDeQuestoes gravador = new GravadorDeQuestoes("ArquivoDeQuestoes.txt", "ArquivoDeRespostas.txt");
		try{
			quiz.setQuestoes(gravador.recuperaQuestao());
		
		}catch(IOException info){
			JOptionPane.showMessageDialog(null, info.getMessage());
		}
		
		try{
			quiz.setRespostas(gravador.recuperaRespostas());
		}catch(IOException info){
			JOptionPane.showMessageDialog(null, info.getMessage());
		}
		
		boolean saida = true;
		
		while(saida){
			
			int escolha = Integer.parseInt(JOptionPane.showInputDialog("Bem vindo ao quiz, as seguintes op��es est�o dispon�veis. Divirta-se."
					+ "\n 1. Cadastrar quest�o."
					+ "\n 2. Pesquisar quest�o pelo id."
					+ "\n 3. Obter uma quantidade de quiz e responde-lo:"
					+ "\n 4. Obter resposta do usu�rio pelo nome. "
					+ "\n 5. Obter total de pontos de um usu�rio."
					+ "\n 6. Remover quest�o pelo ID."
					+ "\n 7. Apagar resposta de quest�o."
					+ "\n 8. Quest�o com maior percentual de erro."
					+ "\n 9. Pesquisar o percentual de acertos de uma quest�o."
					+ "\n 10. Pesquisar percentual de acertos de um usu�rio."
					+ "\n 11. Pesquisar usu�rio com maior percentual de acertos."
					+ "\n 12. Mostrar todas as quest�es."
					+ "\n 13. Mostrar todas as respostas de uma quest�o."
					+ "\n 14. Sair"));
		
			switch(escolha){
				
			case 1:
				int opcao = Integer.parseInt(JOptionPane.showInputDialog("Os seguintes tipos de cadastro, est�o dispon�veis:\n 1. Cadastrar quest�es de V ou F.\n 2. Cadastrar quest�es de m�ltipla escolha.\n 3. Cadastrar quest�es dissertativa."));
				
				if(opcao == 1){
					List <String> afirmativas = new LinkedList<String>();
					QuestaoVF questaoVF = new QuestaoVF();
					
					String enunciado = JOptionPane.showInputDialog("Informe o enunciado da quest�o: ");
					double peso = Double.parseDouble(JOptionPane.showInputDialog("Qual o peso da quest�o?"));
					int quantidadeDeAfirmativas = Integer.parseInt(JOptionPane.showInputDialog("Quantas afirmativas ter� a quest�o: "));
					for(int x = 0; x<quantidadeDeAfirmativas; x++){
						afirmativas.add((x+1) + " - " + "(   ) " + JOptionPane.showInputDialog("Informe a " + (x+1) + "� "+ " afirmativa: "));
					}
					String gabarito = JOptionPane.showInputDialog("O gabarito cont�m " + quantidadeDeAfirmativas + " afirmativa(s)" + "Informe o gabarito(V ou F):");
					String id = JOptionPane.showInputDialog("Informe o ID da quest�o: ");
					questaoVF.setId(id);
					questaoVF.setEnunciado(enunciado);
					questaoVF.setPeso(peso);
					questaoVF.setAfirmativas(afirmativas);
					questaoVF.setGabarito(gabarito);
					try{
						quiz.cadastrarQuestao(questaoVF);
						//gravador.gravaQuestoes(quiz.getQuestoes());
						JOptionPane.showMessageDialog(null, "A respostas foi cadastrada com sucesso:\n" +"Enunciado: "+ questaoVF.getEnunciado()+"\n" + "Peso: " + questaoVF.getPeso() + "\n" +"ID: "+ questaoVF.getId()+"\n" + "Afirmativa(s): " + questaoVF.getAfirmativas());
						
					}catch(QuestaoJaExisteException info){
						JOptionPane.showMessageDialog(null, info.getMessage());
					} 
					
					
					
				}else if(opcao == 2){
					List <String> alternativas = new LinkedList<String>();
					QuestaoMultiplaEscolha QME = new QuestaoMultiplaEscolha();
					
					String enunciado = JOptionPane.showInputDialog("Informe o enunciado da quest�o: ");
					double peso = Double.parseDouble(JOptionPane.showInputDialog("Qual o peso da quest�o?"));
					int quantidadeDeAlternativas = Integer.parseInt(JOptionPane.showInputDialog("Quantas alternativas ter� a quest�o: "));
					for(int x = 0; x<quantidadeDeAlternativas; x++){
						alternativas.add((x+1)+" - " + JOptionPane.showInputDialog("Informe a " + (x+1) + "� " + " alternativa(s) "));
					}
					String gabarito = JOptionPane.showInputDialog("O gabarito cont�m " + quantidadeDeAlternativas + " alternativa(s), apenas uma est� correta, informe a resposta: ");
					String id = JOptionPane.showInputDialog("Informe o ID da quest�o: ");
					QME.setId(id);
					QME.setEnunciado(enunciado);
					QME.setPeso(peso);
					QME.setAlternativas(alternativas);
					QME.setGabarito(gabarito);
					try{
						quiz.cadastrarQuestao(QME);
						//gravador.gravaQuestoes(quiz.getQuestoes());
						JOptionPane.showMessageDialog(null, "A respostas foi cadastrada com sucesso:\n" +"Enunciado: "+ QME.getEnunciado()+"\n" + "Peso: " + QME.getPeso() + "\n" +"ID: "+ QME.getId()+"\n" + "Alternativa(s): "+ QME.getAlternativas());
					}catch(QuestaoJaExisteException info){
						JOptionPane.showMessageDialog(null, info.getMessage());
					}
					
				}else if(opcao == 3){
					
					QuestaoDissertativa questaoDissertativa = new QuestaoDissertativa();
					String enunciado = JOptionPane.showInputDialog("Informe o enunciado da quest�o: ");
					double peso = Double.parseDouble(JOptionPane.showInputDialog("Qual o peso da quest�o?"));
					String gabarito = JOptionPane.showInputDialog("Informe a resposta da quest�o dissertativa(gabarito): ");
					String dica = JOptionPane.showInputDialog("Informe da dica da quest�o: ");
					String id = JOptionPane.showInputDialog("Informe o ID da quest�o: ");
					questaoDissertativa.setId(id);
					questaoDissertativa.setEnunciado(enunciado);
					questaoDissertativa.setPeso(peso);
					questaoDissertativa.setDica(dica);
					questaoDissertativa.setGabarito(gabarito);
					try{
						quiz.cadastrarQuestao(questaoDissertativa);
						//gravador.gravaQuestoes(quiz.getQuestoes());
						JOptionPane.showMessageDialog(null, "A respostas foi cadastrada com sucesso:\n" +"Enunciado: "+ questaoDissertativa.getEnunciado()+"\n" + "Peso: " + questaoDissertativa.getPeso() + "\n" +"ID: "+ questaoDissertativa.getId());
					}catch(QuestaoJaExisteException info){
						JOptionPane.showMessageDialog(null, info.getMessage());
					}
					
				}
			break;
			
			case 2:
				String pesquisarQuestaoPeloId = JOptionPane.showInputDialog("Informe o ID da quest�o a ser obtida.");
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
				
				JOptionPane.showMessageDialog(null, "Sua pontua��o foi: " + pontuacaoTotal);
				}catch(QuestoesInsuficientesException info){
					JOptionPane.showMessageDialog(null, info.getMessage());
				}
			break;
			
			case 4:
				String nomeUsuarioPontuacao = JOptionPane.showInputDialog("Informe o nome do usu�rio e obtenha a pontua��o total dele: ");
				List<RespostaDeQuestao>respostaDadaPeloUsuario = quiz.obterRespostasDadasPeloUsuario(nomeUsuarioPontuacao);
				for(RespostaDeQuestao respostas: respostaDadaPeloUsuario){
					JOptionPane.showMessageDialog(null, "Questao: " + "\n" + respostas.getQuestao() + "\n" + "A seguinte resposta foi informada pelo usu�rio: " + respostas.getResposta());
				}
				int quantidade = respostaDadaPeloUsuario.size();
				
				if(quantidade == 0){
					JOptionPane.showMessageDialog(null, "N�o existe usu�rio com o seguinte login!");
				}
				break;
			
			case 5:
				String loginUsuario = JOptionPane.showInputDialog("Digite o login do usu�rio que deseja saber a pontua��o");
				if(quiz.obterTotalDePontosDoUsuario(loginUsuario) == 0){
					JOptionPane.showMessageDialog(null,"O usu�rio " + loginUsuario + " n�o est� cadastrado, caso ele esteja, sua pontua��o foi: " + quiz.obterTotalDePontosDoUsuario(loginUsuario));	
				}else{
					JOptionPane.showMessageDialog(null,"O usu�rio " + loginUsuario + " conseguiu " +  quiz.obterTotalDePontosDoUsuario(loginUsuario) + " ponto(s)");
				}
				
				break;
				
			case 6:
				
				String removerQuestaoPeloId = JOptionPane.showInputDialog("Informe o id da quest�o que deseja apagar: ");
				try{
					quiz.apagarQuestao(removerQuestaoPeloId);
					JOptionPane.showMessageDialog(null, "Quest�o removida com sucesso!");
				}catch(QuestaoNaoExisteException info){
					JOptionPane.showMessageDialog(null, info.getMessage());
				}
				
			break;
			
			case 7:
				String apagarRespostaComId = JOptionPane.showInputDialog("Informe o id do quiz que deseja apagar a resposta: ");
				String apagarRespostaDoUsuario = JOptionPane.showInputDialog("Informe o login do usu�rio: ");
				try{
				quiz.apagarRespostaDeQuestao(apagarRespostaComId, apagarRespostaDoUsuario);
				JOptionPane.showMessageDialog(null, "Resposta removida com sucesso!");
				}catch(RespostaNaoExisteException info){
					JOptionPane.showMessageDialog(null, info.getMessage());
				}
				
			break;
			
			
			case 8:
				try{
					
					JOptionPane.showMessageDialog(null,"A Quest�o com maior pecentual de erros �: \n"+ quiz.questaoComMaiorPercentualDeErros().toString());
				}catch(QuestaoNaoExisteException info){
					JOptionPane.showMessageDialog(null, info.getMessage());
				}
				break;
			
			
			case 9:
				try{
					String porcentagem = JOptionPane.showInputDialog("Informe o ID da questao que deseja pesquisar: ");
					double usuario = quiz.percentualDeAcertosPeloID(porcentagem);
					JOptionPane.showMessageDialog(null, "A porcentagem de acerto para a quest�o � de " + usuario + "%");
				}catch(QuestaoNaoExisteException info){
					JOptionPane.showMessageDialog(null, info.getMessage());
				}
				break;
			
			
			case 10:
				try{
					String nome = JOptionPane.showInputDialog("Informe o nome do usu�rio: ");
					double usuario = quiz.pesquisaPercentualDeAcertosDoUsuario(nome);
					JOptionPane.showMessageDialog(null, "O percentual de acerto do usu�rio � de " + usuario + "%");
				}catch(QuestaoNaoExisteException info){
					JOptionPane.showMessageDialog(null, info.getMessage());
				}
				break;
				
			case 11:
				try{
				String Usuario = quiz.pesquisaUsuarioComMaiorPercentualDeAcertos();
				JOptionPane.showMessageDialog(null, "O usu�rio com maior percentual de acertos �: " + Usuario);
				}catch(QuestaoNaoExisteException info){
					JOptionPane.showMessageDialog(null, info.getMessage());
				}
				break;
			
			
			case 12:
				List<Questao> mostrarQuestoes = new LinkedList<Questao>();
				mostrarQuestoes = quiz.getQuestoes();
				for(Questao questoes: mostrarQuestoes){
					JOptionPane.showMessageDialog(null, questoes.toString());
				}
				break;
			
			case 13:
				List<RespostaDeQuestao> listaDeRespostasDeUmIDEspecifico = new LinkedList<RespostaDeQuestao>();
				listaDeRespostasDeUmIDEspecifico = quiz.obterTodasAsRespostasDeUmID(JOptionPane.showInputDialog("Informe o ID da quest�o que voc� deseja obter as respostas: "));
				
				
				for(RespostaDeQuestao respostas: listaDeRespostasDeUmIDEspecifico){
					JOptionPane.showMessageDialog(null, respostas.toString());
				}
				
				int quant = listaDeRespostasDeUmIDEspecifico.size();
				if(quant == 0){
					JOptionPane.showMessageDialog(null, "N�o existem respostas da quest�o do seguinte ID informado!");
				}
				break;
			
			
			case 14:
				saida = false;
				try{
					gravador.gravaQuestoes(quiz.getQuestoes());
					gravador.gravarRespostas(quiz.getRespostas());
				}catch(IOException info){
					JOptionPane.showMessageDialog(null, "Respostas n�o cadastradas. Erro: " + info.getMessage());
				}
				
				break;
				}
			}
		}
	}

