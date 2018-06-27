/**
 * Classe que gerencia o problema
 * @author sergioluna
 *
 */
public class Main {
	//Quantidade de Jornalistas - Constante
	private static final int QUANTIDADE_JORNALISTAS = 5;
	
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
		Monitor monitor = new Monitor();
		
		inicializaJornalistas(monitor);

	   try {
	      startJornalistas();
	      waitingJornalistas();
	    } catch (InterruptedException e) {
	      e.printStackTrace();
	    } 
	   
	   System.out.println("\nOs jornalistas finalizaram seus trabalhos!");
        
	}
	
	/**
	 * Método para inicializar os jornalistas
	 * @param jornal
	 */
	 private static void inicializaJornalistas(Monitor monitor) {
		
		consumidores = new Consumidor[QUANTIDADE_JORNALISTAS];
	    for (int i = 0; i < QUANTIDADE_JORNALISTAS; i++) {
	    	consumidores[i] = new Consumidor("Consumidor: " + (i + 1), monitor);
	    }
	    
		produtores = new Produtor[QUANTIDADE_JORNALISTAS];
	    for (int i = 0; i < QUANTIDADE_JORNALISTAS; i++) {
	    	produtores[i] = new Produtor("Produtor: " + (i + 1), monitor);
	    }
	 }
	
	  /**
	   * Método para fazer com os processos aguardem
	   * @throws InterruptedException 
	   */
	  private static void waitingJornalistas() throws InterruptedException {
		    
		  	for (Consumidor consumidor : consumidores) {
		  		consumidor.join();
		    }
		    
		    for (Produtor produtor : produtores) {
		    	produtor.join();
		    }
	  }
	
	  /**
	   * Realiza o start dos jornalistas
	   */
	  private static void startJornalistas() {
		  for (Consumidor consumidor : consumidores) {
			  consumidor.start();
		    }
		    
		    for (Produtor produtor : produtores) {
		    	produtor.start();
		    }
	  }

}
