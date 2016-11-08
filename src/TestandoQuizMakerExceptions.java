import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class TestandoQuizMakerExceptions {

	public static void main(String[] args) {
		QuizMakerIF quizMaker = new QuizMaker();
		for (int k = 0; k < 3; k++) {
			try {
				quizMaker.cadastrarQuestao(leQuestaoMultiplaEscolha());
				JOptionPane.showMessageDialog(null, "Questão cadastrada com sucesso");
			} catch (QuestaoJaExisteException e) {
				JOptionPane.showMessageDialog(null, "Já existia essa questão. Cadastro não realizado");
			}
		}

	}

	public static Questao leQuestaoMultiplaEscolha() {
		QuestaoMultiplaEscolha q1 = new QuestaoMultiplaEscolha();
		String enunciadoQ1 = JOptionPane.showInputDialog("Professor, digite o enunciado da questão de Múltipla escolha");
		q1.setEnunciado(enunciadoQ1);
		double peso = Double.parseDouble(JOptionPane.showInputDialog("Qual o peso da questão? Quanto ela vale?"));
		q1.setPeso(peso);
		int numAlternativas = Integer.parseInt(JOptionPane.showInputDialog("Quantas alternativas?"));
		List<String> alternativas = new ArrayList<String>();
		for (int k = 0; k < numAlternativas; k++) {
			alternativas.add(JOptionPane.showInputDialog("Qual a alternativa [" + (k + 1) + "]"));
		}
		q1.setAlternativas(alternativas);
		q1.setGabarito(JOptionPane.showInputDialog("Qual o gabarito (resposta correta)?"));
		q1.setId(JOptionPane.showInputDialog("Qual o id da questão?"));
		return q1;
	}

}