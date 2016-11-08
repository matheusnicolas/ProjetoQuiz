import java.util.List;

public interface QuizMakerIF {

	public String cadastrarQuestao(Questao q) throws QuestaoJaExisteException;

	/**
	 * Cadastra a questão q atribuindo-lhe um id
	 * 
	 * @param q
	 *            A questão a cadastrar
	 * @return O identificador da questao cadastrada
	 */

	public List<Questao> obterQuiz(int n) throws QuestoesInsuficientesException;

	/**
	 * Obtem uma lista de n questoes
	 * 
	 * @param n
	 *            O número de questoes que se quer no Quiz
	 */

	public Questao pesquisarQuestao(String idQuestao)throws QuestaoNaoExisteException;

	/**
	 * Pesquisa uma questão pelo seu identificador
	 * 
	 * @param idQuestao
	 *            O identificador da questão, atualizado após o cadastro no
	 *            sistema.
	 * @return a questão cujo identificador é idQuestao.
	 */

	/**
	 * Cadastra uma resposta de questão
	 * 
	 * @param resp
	 *            A resposta de questão.
	 */
	public void cadastrarRespostaDeQuestao(RespostaDeQuestao resp);

	/**
	 * Obtem uma lista com as respostas oferecidas pelo usuário com o login
	 * passado como parâmetro.
	 * 
	 * @param loginUsuario
	 *            O login do usuário cujas respostas se quer obter
	 * @return uma lista com objetos RespostaDeQuestao relativos ao usuário
	 *         pesquisado.
	 */
	public List<RespostaDeQuestao> obterRespostasDadasPeloUsuario(String loginUsuario);

	/**
	 * Obtem o total de pontos obtidos por um certo usuário considerando suas
	 * respostas.
	 * 
	 * @param loginUsuario
	 *            O login do usuário cuja pontuação se quer obter
	 * @return o total de pontos do usuário pesquisado.
	 */
	public double obterTotalDePontosDoUsuario(String loginUsuario);

	/**
	 * Apaga uma questão pelo seu identificador
	 * 
	 * @param idQuestao
	 *            O identificador da questão a ser apagada.
	 */
	public void apagarQuestao(String idQuestao)throws QuestaoNaoExisteException;

	/**
	 * Apaga uma resposta de questão dada por um certo usuário para uma questão
	 * cujo identificador é passado
	 * 
	 * @param idQuestao
	 *            O identificador da questão cuja resposta será apagada.
	 * @param loginUsuario
	 *            O login do usuário cuja resposta de uma certa questão será
	 *            apagada.
	 */
	public void apagarRespostaDeQuestao(String idQuestao, String loginUsuario)throws RespostaNaoExisteException;
		

}