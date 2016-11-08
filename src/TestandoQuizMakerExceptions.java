import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class TestandoQuizMakerExceptions {

	public static void main(String[] args) {
		QuizMakerIF quizMaker = new QuizMaker();
		for (int k = 0; k < 3; k++) {
			try {
				quizMaker.cadastrarQuestao(leQuestaoMultiplaEscolha());
				JOptionPane.showMessageDialog(null, "Quest�o cadastrada com sucesso");
			} catch (QuestaoJaExisteException e) {
				JOptionPane.showMessageDialog(null, "J� existia essa quest�o. Cadastro n�o realizado");
			}
		}

	}

	public static Questao leQuestaoMultiplaEscolha() {
		QuestaoMultiplaEscolha q1 = new QuestaoMultiplaEscolha();
		String enunciadoQ1 = JOptionPane.showInputDialog("Professor, digite o enunciado da quest�o de M�ltipla escolha");
		q1.setEnunciado(enunciadoQ1);
		double peso = Double.parseDouble(JOptionPane.showInputDialog("Qual o peso da quest�o? Quanto ela vale?"));
		q1.setPeso(peso);
		int numAlternativas = Integer.parseInt(JOptionPane.showInputDialog("Quantas alternativas?"));
		List<String> alternativas = new ArrayList<String>();
		for (int k = 0; k < numAlternativas; k++) {
			alternativas.add(JOptionPane.showInputDialog("Qual a alternativa [" + (k + 1) + "]"));
		}
		q1.setAlternativas(alternativas);
		q1.setGabarito(JOptionPane.showInputDialog("Qual o gabarito (resposta correta)?"));
		q1.setId(JOptionPane.showInputDialog("Qual o id da quest�o?"));
		return q1;
	}

}