import javax.swing.JOptionPane;
import java.util.List;
import java.util.LinkedList;
public class TestaQuizMaker {

	public static void main(String[] args){
		
/**zMaker quiz = new QuizMaker();
		
		
		boolean condicao = true;
			
		while(condicao == true){
			
			int escolha = Integer.parseInt(JOptionPane.showInputDialog("Bem vindo ao Quiz \n1. Cadastrar quest�es: \n2. Pesquisar quest�es pelo ID:\n3. Obter um quiz e respondelo:\n4. Sair "));
			switch(escolha){
			
			case 1:
				
				int opcao = Integer.parseInt(JOptionPane.showInputDialog("1. Cadastrar quest�es de V/F \n 2. Cadastrar quest�es de m�ltipla escolha: "));
				
				if(opcao == 1){
					
					List <String> afirmativas = new LinkedList <String> ();
					String enunciado = JOptionPane.showInputDialog("Informe o enunciado da quest�o: ");
					double peso = Double.parseDouble(JOptionPane.showInputDialog("Informe o peso da quest�o"));
					int quantAfirmativas = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de afirmativas da quest�o: "));
					QuestaoVF VF = new QuestaoVF(enunciado, peso);
					for(int x = 0; x<quantAfirmativas; x++){
						afirmativas.add("(   )" + JOptionPane.showInputDialog("Informe a " + (x+1) + "� afirmativa da quest�o: "));
					}
					VF.setGabarito(JOptionPane.showInputDialog("O enunciado cont�m " + afirmativas.size() + " afirmativa(s), informe o gabarito (V ou F): "));
					VF.setAfirmativas(afirmativas);
					
					quiz.cadastrarQuestao(VF);
					break;
				
				}else if(opcao == 2){
				
					List <String> alternativas = new LinkedList <String>();
					String enunciado2 = JOptionPane.showInputDialog("Informe o enunciado da quest�o: ");
					double peso2 = Double.parseDouble(JOptionPane.showInputDialog("Informe o peso da quest�o: "));
					int quantAlternativas = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de alternativas da quest�o: "));
					QuestaoMultiplaEscolha QME = new QuestaoMultiplaEscolha(enunciado2, peso2);
					
					for(int x = 0; x<quantAlternativas; x++){
						alternativas.add("(  " + (JOptionPane.showInputDialog("Informe a " + (x+1) + "� alternativa da quest�o: "))+ " )\n");
						
					}
				
					QME.setGabarito(JOptionPane.showInputDialog("O enunciado cont�m " + alternativas.size() + " alternativa(s) e apenas uma est� correta, informe a resposta correta: "));
					QME.setAlternativas(alternativas);
					quiz.cadastrarQuestao(QME);
					break;
				}
			
			case 2:
				String pesquisarPeloID = JOptionPane.showInputDialog("Informe o ID que voc� deseja obter o quiz: ");
				JOptionPane.showMessageDialog(null, quiz.pesquisarQuestao(pesquisarPeloID));
				break;
				
			case 3:
				double total = 0;
				int quantObter = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de quest�es que deseja responder: "));
				List <Questao> questoesSalvas = quiz.obterQuiz(quantObter);
				
				for(Questao q: questoesSalvas){
					
					String resposta = JOptionPane.showInputDialog(q, "Responda");
					double pontuacao = q.getPontuacaoParaResposta(resposta);
					total += pontuacao;
				}
				JOptionPane.showMessageDialog(null, "Sua pontua�ao foi: " + total);
				break;
				
			case 4:
				condicao = false;
				break;
				
				
			}
				
		}
		
	
	
	}**/
	}
}