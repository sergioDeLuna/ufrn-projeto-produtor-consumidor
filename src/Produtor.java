/**
 * Classe Produtor - Thread
 * @author sergioluna
 *
 */
public class Produtor extends Thread {
	
	private Monitor monitor;
	int item = 1;
	
	
	/**
	 * Método de Inicialização
	 * @param nome
	 * @param jornal
	 */
	public Produtor(String nome, Monitor monitor){
		super(nome);
		this.monitor = monitor;
	}
	
	/**
	 * Start de uma thread produtor
	 */
	@Override
	public void run() {
		System.out.println("Trabalho de produzir solicitado pelo " + Thread.currentThread().getName());
		try {
			monitor.inserir(item);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		
	
}
