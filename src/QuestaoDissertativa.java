public class QuestaoDissertativa extends Questao{
	
	private String dica;
	
	public QuestaoDissertativa(String enunciado, String gabarito, double peso, String id, String dica){
		super(enunciado, gabarito, peso, id);
		this.dica = "dica";
	}
	
	public QuestaoDissertativa(){
		super("Sem enunciado","Sem gabarito", 0.0, "sem id");
		this.dica = "sem dica";
	}
	
	public double getPontuacaoParaResposta(String resposta){
		if(resposta.equalsIgnoreCase(super.getGabarito())){
			return super.getPeso();
		}else{
			return 0;
		}
	}
	
	public String getDica(){
		return this.dica;
	}
	
	public void setDica(String dica){
		this.dica = dica;
	}
	
	public String toString(){
		return "( " + super.getPeso() + " ) " + super.getEnunciado() + "\n" +"ID: " + super.getId() +"\n" + "Dica:" + " ( " + getDica() + " ) " + "\n";
		
	}
	
	public String toString2(){
		String mostrar = "QUESTÃODISSERTATIVA" + "\n" + super.getEnunciado() + "\n" + super.getGabarito() + "\n" + super.getPeso() + "\n" + super.getId() + "\n" + this.dica + "\n";
		return mostrar;
	}

}
