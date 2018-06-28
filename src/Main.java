/**
 * Classe que gerencia o problema
 * @author sergioluna
 *
 */
public class Main {
	//Quantidade de Consumidores e Produtores - Constante
	private static final int QUANTIDADE_CONSUMIDORES_PRODUTORES = 3;
	
	//Limite do buffer
	private static final int LIMITE_BUFFER = 5;
	
	//Array para armazenar os consumidores
	private static Consumidor[] consumidores;
	
	//Array para armazenar os produtores
	private static Produtor[] produtores;

	/**
	 * Método principal do projeto
	 * Gerencia as principais funcionalidades
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException{
		
		Monitor monitor = new Monitor(LIMITE_BUFFER);
		
		inicializaConsumidoresProdutores(monitor);

	   try {
		  startConsumidoresProdutores();
		  waitingConsumidoresProdutores();
	    } catch (InterruptedException e) {
	      e.printStackTrace();
	    } 
	   
	   System.out.println("\nOs Consumidores e Produtores finalizaram seus trabalhos!");
        
	}
	
	/**
	 * Método para inicializar os consumidores e produtores
	 * @param monitor
	 */
	 private static void inicializaConsumidoresProdutores(Monitor monitor) {
		
		consumidores = new Consumidor[QUANTIDADE_CONSUMIDORES_PRODUTORES];
	    for (int i = 0; i < QUANTIDADE_CONSUMIDORES_PRODUTORES; i++) {
	    	consumidores[i] = new Consumidor("Consumidor #" + (i + 1), monitor);
	    }
	    
		produtores = new Produtor[QUANTIDADE_CONSUMIDORES_PRODUTORES];
	    for (int i = 0; i < QUANTIDADE_CONSUMIDORES_PRODUTORES; i++) {
	    	produtores[i] = new Produtor("Produtor #" + (i + 1), monitor);
	    }
	 }
	
	  /**
	   * Método para fazer com os processos aguardem
	   * @throws InterruptedException 
	   */
	  private static void waitingConsumidoresProdutores() throws InterruptedException {
		    
		  	for (Consumidor consumidor : consumidores) {
		  		consumidor.join();
		    }
		    
		    for (Produtor produtor : produtores) {
		    	produtor.join();
		    }
	  }
	
	  /**
	   * Realiza o start dos consumidores e dos produtores 
	   */
	  private static void startConsumidoresProdutores() {
		  for (Consumidor consumidor : consumidores) {
			  consumidor.start();
		    }
		    
		    for (Produtor produtor : produtores) {
		    	produtor.start();
		    }
	  }

}
