import javax.swing.JOptionPane;

public class MeuQuiz {
	
	public static void main(String[] args){//Início do main
		
		String[] perguntas = null;
		String[] respostas = null; 
		String[] gabarito = null;
		
		boolean sair = false;
		
		while(sair == false){
			
			int opcao = Integer.parseInt(JOptionPane.showInputDialog("O que voce deseja? \n1. Carregar perguntas do quiz \n2. Carregar gabarito \n3. Responder o quiz \n4. Corrigir respostas \n5. Sair"));
			switch(opcao){
				
				case 1:
					int quantidade = Integer.parseInt(JOptionPane.showInputDialog("Quantas perguntas deseja cadastrar?"));
					perguntas = carregaPerguntasDoQuiz(quantidade);
					break;
				
				case 2:
					respostas = carregaGabaritoDoQuiz(perguntas);
					break;
				
				case 3:
					gabarito = responderQuiz(perguntas);
					break;
				
				case 4:
					JOptionPane.showMessageDialog(null, corrigirRespostas(perguntas, respostas, gabarito));
					break;
					
				default:
					sair = true;
					break;
					
			}
		}
	}

	
	public static String[] carregaPerguntasDoQuiz(int quant){//Início do método carregaPerguntasDoQuiz
		
		
		String[] nomes = new String[quant];
		
		for(int x = 0; x < quant; x++){//Início do for
			
			nomes [x] = JOptionPane.showInputDialog("Digite a pergunta "+(x+1)+":");
			
			
		}//Fim do for
			
	return nomes;
	}//Fim da chave do método carregaPerguntasDoQuiz
	
	
	public static String[] carregaGabaritoDoQuiz(String[] quant){//Início do método carregarGabaritoDoQuiz
		
		
		String[] nomes = new String[quant.length];
		for(int x = 0; x < quant.length; x++){//Início da chave do for
			
			nomes [x] = JOptionPane.showInputDialog("Qual a resposta da pergunta: "+ quant[x]);
			
		}//Final da chave do for
		
	return nomes;
	}//Fim do método carregaGabaritoDoQuiz
	
	public static String[] responderQuiz(String[] perguntas){//Início do método responderQuiz
		
		String[] resposta = new String[perguntas.length];
		for(int x = 0; x < perguntas.length; x++){//Início da chave do for
			
			resposta [x] = JOptionPane.showInputDialog(perguntas[x]);
			
		}//Fim da chave do for
	
	return resposta;
	}//Fim do método responderQuiz
		
	public static String corrigirRespostas(String perguntas[], String respostas[], String gabarito[]){//Início do método corrigirRespostas
		int cont = 0;
		for(int x = 0; x<gabarito.length; x++){//Início do for
			
			if(respostas[x].equals(gabarito[x])){//Início do if
				cont+=1;
			}//Fim do if
			
		}//Fim do for
	
		int totalPerguntas = respostas.length;//Variável que pega o tamanho do array respostas
		double total = cont*100/totalPerguntas;
		String escolhido = "Você acertou "+ cont+" perguntas. Sua porcentagem de acerto foi " + total ;

		
	

	return escolhido;
	}//Fim do método	
		
}//Final do main