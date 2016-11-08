import java.util.List;
import java.util.LinkedList;

public class QuestaoVF extends Questao{
	
	private List <String> afirmativas;
	
	public QuestaoVF(String enunciado, String gabarito, double peso, String id, List<String>afirmativas){
	
		super(enunciado, gabarito, peso, id);
		this.afirmativas = new LinkedList<String>();
	}
	
	public QuestaoVF(){
		this("Sem enunciado", "Sem gabarito", 0.0, "Sem id", null);
	}

	public void setAfirmativas(List <String> afirmativas){
		this.afirmativas = afirmativas;
	}
	
	public List <String> getAfirmativas(){
		return this.afirmativas;
	}

	public double getPontuacaoParaResposta(String resposta) {
		int quant = 0;
		for(int x = 0; x< resposta.length(); x++){
			if(resposta.charAt(x) == super.getGabarito().charAt(x)){
				quant ++;
			}
		}
	return ((double) quant / resposta.length()) * super.getPeso();

	}
	
	public String toString(){
		String mostrar = "(" + super.getPeso() + ") " + super.getEnunciado() + "\n" + " ID: " + super.getId() + "\n";
		for(String s: this.afirmativas){
			mostrar += s +"\n";
		}
	return mostrar;
	}

	/**
	public String toString2() {
		String mostrar = "QUESTÃOVF" + "\n";
		mostrar += super.getEnunciado() + "\n"; 
		mostrar += super.getGabarito() + "\n"; 
		mostrar += super.getPeso() + "\n"; 
		mostrar += super.getId() + "\n";
		
		mostrar += this.afirmativas.size() + "\n";
		for(int x = 0; x<this.afirmativas.size(); x++){
			mostrar += (this.afirmativas.get(x) + "\n");
		}
		return mostrar;
	}
**/
	public String toString2(){
		String mostrar = "QUESTÃOVF" + "\n" + super.getEnunciado() + "\n" + super.getGabarito() + "\n" + super.getPeso() + "\n" + super.getId() + "\n";
		mostrar += this.afirmativas.size() + "\n";
		for(int x = 0; x<this.afirmativas.size(); x++){
			mostrar += (this.afirmativas.get(x) + "\n");
		}
		return mostrar;
	}
	
	
	
}	
	
