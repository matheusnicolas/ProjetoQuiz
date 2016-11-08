import javax.swing.JOptionPane;
import java.util.List;
import java.util.LinkedList;
public class TestaQuizMaker {

	public static void main(String[] args){
		
/**zMaker quiz = new QuizMaker();
		
		
		boolean condicao = true;
			
		while(condicao == true){
			
			int escolha = Integer.parseInt(JOptionPane.showInputDialog("Bem vindo ao Quiz \n1. Cadastrar questões: \n2. Pesquisar questões pelo ID:\n3. Obter um quiz e respondelo:\n4. Sair "));
			switch(escolha){
			
			case 1:
				
				int opcao = Integer.parseInt(JOptionPane.showInputDialog("1. Cadastrar questões de V/F \n 2. Cadastrar questões de múltipla escolha: "));
				
				if(opcao == 1){
					
					List <String> afirmativas = new LinkedList <String> ();
					String enunciado = JOptionPane.showInputDialog("Informe o enunciado da questão: ");
					double peso = Double.parseDouble(JOptionPane.showInputDialog("Informe o peso da questão"));
					int quantAfirmativas = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de afirmativas da questão: "));
					QuestaoVF VF = new QuestaoVF(enunciado, peso);
					for(int x = 0; x<quantAfirmativas; x++){
						afirmativas.add("(   )" + JOptionPane.showInputDialog("Informe a " + (x+1) + "° afirmativa da questão: "));
					}
					VF.setGabarito(JOptionPane.showInputDialog("O enunciado contém " + afirmativas.size() + " afirmativa(s), informe o gabarito (V ou F): "));
					VF.setAfirmativas(afirmativas);
					
					quiz.cadastrarQuestao(VF);
					break;
				
				}else if(opcao == 2){
				
					List <String> alternativas = new LinkedList <String>();
					String enunciado2 = JOptionPane.showInputDialog("Informe o enunciado da questão: ");
					double peso2 = Double.parseDouble(JOptionPane.showInputDialog("Informe o peso da questão: "));
					int quantAlternativas = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de alternativas da questão: "));
					QuestaoMultiplaEscolha QME = new QuestaoMultiplaEscolha(enunciado2, peso2);
					
					for(int x = 0; x<quantAlternativas; x++){
						alternativas.add("(  " + (JOptionPane.showInputDialog("Informe a " + (x+1) + "° alternativa da questão: "))+ " )\n");
						
					}
				
					QME.setGabarito(JOptionPane.showInputDialog("O enunciado contém " + alternativas.size() + " alternativa(s) e apenas uma está correta, informe a resposta correta: "));
					QME.setAlternativas(alternativas);
					quiz.cadastrarQuestao(QME);
					break;
				}
			
			case 2:
				String pesquisarPeloID = JOptionPane.showInputDialog("Informe o ID que você deseja obter o quiz: ");
				JOptionPane.showMessageDialog(null, quiz.pesquisarQuestao(pesquisarPeloID));
				break;
				
			case 3:
				double total = 0;
				int quantObter = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de questões que deseja responder: "));
				List <Questao> questoesSalvas = quiz.obterQuiz(quantObter);
				
				for(Questao q: questoesSalvas){
					
					String resposta = JOptionPane.showInputDialog(q, "Responda");
					double pontuacao = q.getPontuacaoParaResposta(resposta);
					total += pontuacao;
				}
				JOptionPane.showMessageDialog(null, "Sua pontuaçao foi: " + total);
				break;
				
			case 4:
				condicao = false;
				break;
				
				
			}
				
		}
		
	
	
	}**/
	}
}