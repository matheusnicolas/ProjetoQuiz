import java.util.List;

public interface QuizMakerIF {

	public String cadastrarQuestao(Questao q) throws QuestaoJaExisteException;

	/**
	 * Cadastra a quest�o q atribuindo-lhe um id
	 * 
	 * @param q
	 *            A quest�o a cadastrar
	 * @return O identificador da questao cadastrada
	 */

	public List<Questao> obterQuiz(int n) throws QuestoesInsuficientesException;

	/**
	 * Obtem uma lista de n questoes
	 * 
	 * @param n
	 *            O n�mero de questoes que se quer no Quiz
	 */

	public Questao pesquisarQuestao(String idQuestao)throws QuestaoNaoExisteException;

	/**
	 * Pesquisa uma quest�o pelo seu identificador
	 * 
	 * @param idQuestao
	 *            O identificador da quest�o, atualizado ap�s o cadastro no
	 *            sistema.
	 * @return a quest�o cujo identificador � idQuestao.
	 */

	/**
	 * Cadastra uma resposta de quest�o
	 * 
	 * @param resp
	 *            A resposta de quest�o.
	 */
	public void cadastrarRespostaDeQuestao(RespostaDeQuestao resp);

	/**
	 * Obtem uma lista com as respostas oferecidas pelo usu�rio com o login
	 * passado como par�metro.
	 * 
	 * @param loginUsuario
	 *            O login do usu�rio cujas respostas se quer obter
	 * @return uma lista com objetos RespostaDeQuestao relativos ao usu�rio
	 *         pesquisado.
	 */
	public List<RespostaDeQuestao> obterRespostasDadasPeloUsuario(String loginUsuario);

	/**
	 * Obtem o total de pontos obtidos por um certo usu�rio considerando suas
	 * respostas.
	 * 
	 * @param loginUsuario
	 *            O login do usu�rio cuja pontua��o se quer obter
	 * @return o total de pontos do usu�rio pesquisado.
	 */
	public double obterTotalDePontosDoUsuario(String loginUsuario);

	/**
	 * Apaga uma quest�o pelo seu identificador
	 * 
	 * @param idQuestao
	 *            O identificador da quest�o a ser apagada.
	 */
	public void apagarQuestao(String idQuestao)throws QuestaoNaoExisteException;

	/**
	 * Apaga uma resposta de quest�o dada por um certo usu�rio para uma quest�o
	 * cujo identificador � passado
	 * 
	 * @param idQuestao
	 *            O identificador da quest�o cuja resposta ser� apagada.
	 * @param loginUsuario
	 *            O login do usu�rio cuja resposta de uma certa quest�o ser�
	 *            apagada.
	 */
	public void apagarRespostaDeQuestao(String idQuestao, String loginUsuario)throws RespostaNaoExisteException;
		

}