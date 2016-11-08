public class RespostaDeQuestao {
	private Questao questao;
	private String resposta;
	private String loginUsuario;
	
	public RespostaDeQuestao(Questao questao, String resposta, String loginUsuario){
		this.questao = questao;
		this.resposta = resposta;
		this.loginUsuario = loginUsuario;
	}
	
	public RespostaDeQuestao() {
		this(null, "Sem resposta", "Sem loginUsuario");
	}
	
	public String getLoginUsuario(){
		return this.loginUsuario;
	}
	
	public void setLoginUsuario(String login){
		this.loginUsuario = login;
	}

	public Questao getQuestao() {
		return this.questao;
	}

	public void setQuestao(Questao questao) {
		this.questao = questao;
	}

	public String getResposta() {
		return this.resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}
	
	public boolean estahCorreta(){
		if(this.questao.getPontuacaoParaResposta(this.resposta) == questao.getPeso()){
			return true;
		}
		return false;
	}
	
	public double getPontuacao(){
		return this.questao.getPontuacaoParaResposta(this.resposta);
	}
	
	public String toString(){
		String mostrar = "ID da questão: " + this.getQuestao().getId() + "\n" + "Resposta: " + this.getResposta() + "\n" + "Do usuário: " + this.getLoginUsuario() + "\n" + "Pontução: " + this.getPontuacao();
		return mostrar;
	}
	
	public String toString2(){
		String mostrar = this.getResposta() +"\n" + this.getLoginUsuario() + "\n" + this.getQuestao().toString2();
		return mostrar;
	
}
	}

