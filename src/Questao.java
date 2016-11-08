public abstract class Questao implements Comparable <Questao> {

	private String enunciado;
	private double peso;
	private String gabarito;
	private String id;
	
	public Questao(String enunciado, String gabarito, double peso, String id){
		this.enunciado = enunciado;
		this.gabarito = gabarito;
		this.peso = peso;
		this.id = id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((enunciado == null) ? 0 : enunciado.hashCode());
		result = prime * result
				+ ((gabarito == null) ? 0 : gabarito.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		long temp;
		temp = Double.doubleToLongBits(peso);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Questao other = (Questao) obj;
		if (enunciado == null) {
			if (other.enunciado != null)
				return false;
		} else if (!enunciado.equals(other.enunciado))
			return false;
		if (gabarito == null) {
			if (other.gabarito != null)
				return false;
		} else if (!gabarito.equals(other.gabarito))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (Double.doubleToLongBits(peso) != Double
				.doubleToLongBits(other.peso))
			return false;
		return true;
	}
	public Questao(){
		this("", "", 0.0, "");
		
	}
	
	public String getId(){
		return this.id;
	}
	
	public void setId(String ID){
		this.id = ID;
	}
	
	public String getEnunciado(){
		return this.enunciado;
	}
	
	public double getPeso(){
		return this.peso;
	}
	
	public String getGabarito(){
		return this.gabarito;
	}
	
	public void setEnunciado(String enunciado){
		this.enunciado = enunciado;
	}
	
	public void setPeso(double peso){
		this.peso = peso;
	}

	public void setGabarito(String gabarito){
		this.gabarito = gabarito;
	}

	public abstract double getPontuacaoParaResposta(String n);
	
	public int compareTo(Questao q){
		if(q.getPeso() == this.peso){
			return 0;
		}else if(q.getPeso() < 0){
			return -1;
		}else{
			return 1;
		}
	}
	
	public abstract String toString2();
}