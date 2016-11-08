import java.util.LinkedList;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.util.List;

public class GravadorDeQuestoes {
	private String nomeArquivoDeQuestao;
	private String nomeArquivoDeRespostas;
	
	public GravadorDeQuestoes(String nomeArquivoDeQuestoes, String nomeArquivoDeRespostas) {
		this.nomeArquivoDeQuestao = nomeArquivoDeQuestoes;
		this.nomeArquivoDeRespostas = nomeArquivoDeRespostas;
		
	}

	public void gravaQuestoes(List<Questao> questoes) throws IOException {
		BufferedWriter escritor = null;
		try {
			escritor = new BufferedWriter(new FileWriter(this.nomeArquivoDeQuestao));
			for (Questao q : questoes) {
				escritor.write(q.toString2());
			}
		} catch (IOException info) {
			info.getStackTrace();
		} finally {
			if (escritor != null) {
				escritor.close();
			}

		}
	}

	public List<Questao> recuperaQuestao() throws IOException {
		BufferedReader leitor = null;
		List<Questao> recuperarQuestoes = new LinkedList<Questao>();
		try {
			leitor = new BufferedReader(new FileReader(this.nomeArquivoDeQuestao));
			String linhaLida = null;
			do {
				linhaLida = leitor.readLine();
				if (linhaLida != null) {
					if (linhaLida.equalsIgnoreCase("QUESTÃOVF")) {
						QuestaoVF q1 = new QuestaoVF();
						q1.setEnunciado(leitor.readLine());
						q1.setGabarito(leitor.readLine());
						q1.setPeso(Double.parseDouble(leitor.readLine()));
						q1.setId(leitor.readLine());
						int tamanhoAfirmativas = Integer.parseInt(leitor.readLine());
						List<String> afirmativas = new LinkedList<String>();
						for (int x = 0; x < tamanhoAfirmativas; x++) {
							afirmativas.add(leitor.readLine());
						}
						q1.setAfirmativas(afirmativas);
						recuperarQuestoes.add(q1);
						
					} else if (linhaLida.equalsIgnoreCase("QUESTÃOMÚLTIPLAESCOLHA")) {
						QuestaoMultiplaEscolha QME = new QuestaoMultiplaEscolha();
						QME.setEnunciado(leitor.readLine());
						QME.setGabarito(leitor.readLine());
						QME.setPeso(Double.parseDouble(leitor.readLine()));
						QME.setId(leitor.readLine());
						int tamanhoAlternativas = Integer.parseInt(leitor.readLine());
						List<String> alternativas = new LinkedList<String>();
						for (int x = 0; x < tamanhoAlternativas; x++) {
							alternativas.add(leitor.readLine());
						}
						QME.setAlternativas(alternativas);
						recuperarQuestoes.add(QME);
						
					} else if (linhaLida.equalsIgnoreCase("QUESTÃODISSERTATIVA")) {
						QuestaoDissertativa questaoD = new QuestaoDissertativa();
						questaoD.setEnunciado(leitor.readLine());
						questaoD.setGabarito(leitor.readLine());
						questaoD.setPeso(Double.parseDouble(leitor.readLine()));
						questaoD.setId(leitor.readLine());
						questaoD.setDica(leitor.readLine());
						
						recuperarQuestoes.add(questaoD);
					}

				}

			} while (linhaLida != null);

		} catch (IOException info) {
			info.printStackTrace();
		} finally {
			if (leitor != null) {
				leitor.close();
			}
		}
		return recuperarQuestoes;
	}

	
	public void gravarRespostas(List<RespostaDeQuestao> resposta) throws IOException{
		BufferedWriter escritor = null;
		try{
			escritor = new BufferedWriter(new FileWriter(this.nomeArquivoDeRespostas));
			for(RespostaDeQuestao rdq: resposta){
				escritor.write(rdq.toString2());
			}
		}catch(IOException info){
			info.getStackTrace();
		}finally{
			if(escritor != null){
				escritor.close();
			}
		}
		
	}
	
	public List <RespostaDeQuestao> recuperaRespostas() throws IOException{
		BufferedReader leitor = null;
		List <RespostaDeQuestao> recuperarRespostas = new LinkedList<RespostaDeQuestao>();
		try{
			leitor = new BufferedReader(new FileReader(this.nomeArquivoDeRespostas));
			String linhaLida = null;
			do {
				
				RespostaDeQuestao resposta = new RespostaDeQuestao();
				linhaLida = leitor.readLine();
				if(linhaLida != null){
					resposta.setResposta(linhaLida);
					resposta.setLoginUsuario(leitor.readLine());
					linhaLida = leitor.readLine();
					if (linhaLida.equalsIgnoreCase("QUESTÃOVF")) {
							QuestaoVF q1 = new QuestaoVF();
							q1.setEnunciado(leitor.readLine());
							q1.setGabarito(leitor.readLine());
							q1.setPeso(Double.parseDouble(leitor.readLine()));
							q1.setId(leitor.readLine());
							int tamanhoAfirmativas = Integer.parseInt(leitor.readLine());
							List<String> afirmativas = new LinkedList<String>();
							for (int x = 0; x < tamanhoAfirmativas; x++) {
								afirmativas.add(leitor.readLine());
							}
							resposta.setQuestao(q1);
							recuperarRespostas.add(resposta);
							
							
						} else if (linhaLida.equalsIgnoreCase("QUESTÃOMÚLTIPLAESCOLHA")) {
							QuestaoMultiplaEscolha QME = new QuestaoMultiplaEscolha();
							QME.setEnunciado(leitor.readLine());
							QME.setGabarito(leitor.readLine());
							QME.setPeso(Double.parseDouble(leitor.readLine()));
							QME.setId(leitor.readLine());
							int tamanhoAlternativas = Integer.parseInt(leitor.readLine());
							List<String> alternativas = new LinkedList<String>();
							for (int x = 0; x < tamanhoAlternativas; x++) {
								alternativas.add(leitor.readLine());
							}
							
							resposta.setQuestao(QME);
							recuperarRespostas.add(resposta);
							
						} else if (linhaLida.equalsIgnoreCase("QUESTÃODISSERTATIVA")) {
							QuestaoDissertativa questaoD = new QuestaoDissertativa();
							questaoD.setEnunciado(leitor.readLine());
							questaoD.setGabarito(leitor.readLine());
							questaoD.setPeso(Double.parseDouble(leitor.readLine()));
							questaoD.setId(leitor.readLine());
							questaoD.setDica(leitor.readLine());
							
							resposta.setQuestao(questaoD);
							recuperarRespostas.add(resposta);
						}

					}
				
				
				
			}  while (linhaLida != null);

		} catch (IOException info) {
			info.printStackTrace();
		} finally {
			if (leitor != null) {
				leitor.close();
			}
		}
		return recuperarRespostas;
		}
	
	
}

	
