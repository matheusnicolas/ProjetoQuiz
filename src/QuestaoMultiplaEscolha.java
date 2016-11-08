import java.util.List;
import java.util.LinkedList;
public class QuestaoMultiplaEscolha extends Questao {

	private List<String> alternativas;

	public QuestaoMultiplaEscolha(String enunciado, String gabarito, double peso, String id, List<String> alternativas) {
		super(enunciado, gabarito, peso, id);
		this.alternativas = new LinkedList<String>();
		

	}
	
	public QuestaoMultiplaEscolha(){
		this("Sem enunciado", "Sem gabarito", 0.0,"sem id", null);
	}

	public double getPontuacaoParaResposta(String alternativas) {
		if (alternativas.equalsIgnoreCase(super.getGabarito())) {
			return super.getPeso();

		}
		return 0;
	}

	public void setAlternativas(List<String> alternativas) {
		this.alternativas = alternativas;
	}

	public List<String> getAlternativas() {
		return this.alternativas;
	}

	public String toString() {
		String mostrar = "(" + super.getPeso() + ") " + super.getEnunciado() + "\n"  + super.getId() + "\n";
		for (String s : this.alternativas) {
			mostrar += s +"\n";
		}

		return mostrar;
	}
	
	public String toString2(){
		String mostrar = "QUESTÃOMÚLTIPLAESCOLHA" + "\n" + super.getEnunciado() + "\n" + super.getGabarito() + "\n" + super.getPeso() + "\n" + super.getId() + "\n";
		mostrar += this.alternativas.size() + "\n";
		for(int x = 0; x<this.alternativas.size(); x++){
			mostrar += (this.alternativas.get(x) + "\n");
		}
		return mostrar;
	}

	

}

