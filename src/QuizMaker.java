import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;



public class QuizMaker implements QuizMakerIF {

	private List <Questao> questoes;
	private List <RespostaDeQuestao> respostasDeQuestao;
	
	public QuizMaker(){
		this.questoes = new LinkedList<Questao>();
		this.respostasDeQuestao = new LinkedList <RespostaDeQuestao>();
	}
	
	public void setQuestoes(List<Questao> quest){
		this.questoes = quest;
	}
	
	public List<Questao> getQuestoes(){
		return this.questoes;
	}
	
	public List <RespostaDeQuestao> getRespostas(){
		return this.respostasDeQuestao;
	}
	
	public void setRespostas(List<RespostaDeQuestao> resposta){
		this.respostasDeQuestao = resposta;
	}
	
	
	private String geradorDeId(){
		return "Q" + this.questoes.size();
	}
		
	public String cadastrarQuestao(Questao q) throws QuestaoJaExisteException{
		
		if(q.getId().equalsIgnoreCase("")){
			q.setId(geradorDeId());
		}
		
		for(Questao e: this.questoes){
			if(q.getId().equals(e.getId())){
				throw new QuestaoJaExisteException("Uma questão com o mesmo id, já está cadastrada.");
			}
		} 
		
		questoes.add(q);
		return q.getId();	
		}
	
	
	public List <Questao> obterQuiz(int n)throws QuestoesInsuficientesException{
		
			if(n > this.questoes.size()){
				throw new QuestoesInsuficientesException("Consta apenas "+ this.questoes.size() + " quiz cadastrado(s), informe uma quantidade menor que " + this.questoes.size());
			}
			List <Questao> quizCadastrados = new LinkedList<Questao>();
			for(int x = 0; x<n; x++){
				quizCadastrados.add(this.questoes.get(x));
			}
			
	
		return quizCadastrados;
	}
	
	
	public Questao pesquisarQuestao(String idQuestao) throws QuestaoNaoExisteException{
		
		for(int x = 0; x<this.questoes.size(); x++){
			if(questoes.get(x).getId().equals(idQuestao)){
				return this.questoes.get(x);
			}
		}
		
		
		throw new QuestaoNaoExisteException("Não foi encontrado nenhum quiz com o seguinte ID informado.");
		
	}
	
	public void cadastrarRespostaDeQuestao(RespostaDeQuestao resp) {
		this.respostasDeQuestao.add(resp);
	}

	
	public List<RespostaDeQuestao> obterRespostasDadasPeloUsuario(String loginUsuario){
		List <RespostaDeQuestao> respostasPeloLogin = new LinkedList<RespostaDeQuestao>();
			for(RespostaDeQuestao respostas: this.respostasDeQuestao){
				if(loginUsuario.equalsIgnoreCase(respostas.getLoginUsuario())){
					respostasPeloLogin.add(respostas);
				}
			}
		
		return respostasPeloLogin;
	}


	public double obterTotalDePontosDoUsuario(String loginUsuario) {
		double pontuacao = 0;
		List <RespostaDeQuestao> pontuacaoUsuario = obterRespostasDadasPeloUsuario(loginUsuario);
		for(RespostaDeQuestao respostas: pontuacaoUsuario){
			pontuacao += respostas.getPontuacao();
			}
		return pontuacao;
		}
	
	public void apagarQuestao(String idQuestao)throws QuestaoNaoExisteException {
		Questao id = pesquisarQuestao(idQuestao);
		this.questoes.remove(id);
	}
		
	
	public void apagarRespostaDeQuestao(String idQuestao, String loginUsuario)throws RespostaNaoExisteException {
		boolean condicao = false;
		for(RespostaDeQuestao respostas: this.respostasDeQuestao){
			if(respostas.getQuestao().getId().equalsIgnoreCase(idQuestao) && respostas.getLoginUsuario().equalsIgnoreCase(loginUsuario)){
				this.respostasDeQuestao.remove(respostas);
				condicao = true;
				
			}
		}
		if(!condicao){
			throw new RespostaNaoExisteException("Esta resposta não existe");
		}
	}
	
	public double percentualDeAcertosPeloID(String id) throws QuestaoNaoExisteException{
		double quantidadeDeQuestoes = 0;
		double quantidadeDeAcertos = 0;
		double porcentagemTotal = 100;
		for(RespostaDeQuestao respostas: this.respostasDeQuestao){
			if(respostas.getQuestao().getId().equalsIgnoreCase(id)){
				quantidadeDeQuestoes++;
				if(respostas.getQuestao().getPeso() == respostas.getPontuacao()){
					quantidadeDeAcertos++;
				}
			}
		if(quantidadeDeQuestoes == 0){
			throw new QuestaoNaoExisteException("Não existe questão com o seguinte ID");
		}
		}
		double resultado = (quantidadeDeAcertos/quantidadeDeQuestoes) * porcentagemTotal;
		return resultado;
		}
	
	public Questao questaoComMaiorPercentualDeErros()throws QuestaoNaoExisteException{
		double maiorPercentualDeErros = 0;
		double menorPercentual = 100;
		Questao questao = null;
		int cont = 0;
		int id = 0;
		while(cont < respostasDeQuestao.size()){
		for(RespostaDeQuestao respostas: this.respostasDeQuestao){
			if(respostas.getQuestao().getId().equals((id + 1) + "")){
				maiorPercentualDeErros = this.percentualDeAcertosPeloID(respostas.getQuestao().getId());
					
				}
			}
		
		if(maiorPercentualDeErros < menorPercentual){
			menorPercentual = maiorPercentualDeErros;
			questao = questoes.get(id);
			
		}
		id++;
		cont++;
	}
		return questao;
	}
	
	public double pesquisaPercentualDeAcertosDoUsuario(String login) throws QuestaoNaoExisteException{
		double totalAcertos = 0;
		double totalDeQuestoes = 0;
		double porcentagemTotal = 100;
		for(RespostaDeQuestao respostas: this.respostasDeQuestao){
			if(respostas.getLoginUsuario().equalsIgnoreCase(login)){
				totalDeQuestoes++;
				if(respostas.estahCorreta()){
					totalAcertos++;
				}
			}
		}
		if(totalDeQuestoes == 0){
			throw new QuestaoNaoExisteException("O usuário não foi encontrado!");
		}
		double total = (totalAcertos / totalDeQuestoes) * porcentagemTotal;
		return total;
	}
	
	public int totalDeRespostasDoUsuario(String usuario){
		int contador = 0;
		for(RespostaDeQuestao respostas: respostasDeQuestao){
			if(respostas.getLoginUsuario().equalsIgnoreCase(usuario)){
				contador++;
			}
		}
		return contador;
	}
	
	public List<String> obterTodosOsUsuarios(){
		List <String> listaDeUsuarios = new LinkedList<String>();
		boolean usuarioInLista = false;
		for(RespostaDeQuestao respostas: respostasDeQuestao){
			for(String a: listaDeUsuarios){
				if(respostas.getLoginUsuario().equalsIgnoreCase(a)){
					usuarioInLista = true;
					break;
				}
			}
			if(!usuarioInLista){
				listaDeUsuarios.add(respostas.getLoginUsuario());
			}
		}
		return listaDeUsuarios;
		
		
	}
	
	public String pesquisaUsuarioComMaiorPercentualDeAcertos() throws QuestaoNaoExisteException{
		
		List<String> listaDeUsuarios = new LinkedList<String>();
		listaDeUsuarios = this.obterTodosOsUsuarios();
		
		double maiorPercentual = -1;
		double menorPercentual = 0;
		String loginUsuario = "";
		int quantidadeDeRespostas = 0;
		for(String s: listaDeUsuarios){
			menorPercentual = this.pesquisaPercentualDeAcertosDoUsuario(s);
			if(menorPercentual > maiorPercentual){
				maiorPercentual = menorPercentual;
				loginUsuario = s;
				quantidadeDeRespostas = this.totalDeRespostasDoUsuario(s);
			}else if(menorPercentual == maiorPercentual){
				if(this.totalDeRespostasDoUsuario(s) > quantidadeDeRespostas){
				maiorPercentual = menorPercentual;
				loginUsuario = s;
				quantidadeDeRespostas = this.totalDeRespostasDoUsuario(s);
			}
			}
		}
		return loginUsuario;
	}
	
	public List<RespostaDeQuestao> obterTodasAsRespostasDeUmID(String id){
		List<RespostaDeQuestao> listaDeRespostasDeUmID = new ArrayList<RespostaDeQuestao>();
		for (RespostaDeQuestao respostas: respostasDeQuestao){
			if(respostas.getQuestao().getId().equals(id)){
				listaDeRespostasDeUmID.add(respostas);
			}
		}
		return listaDeRespostasDeUmID;
	}
}
	
	
	