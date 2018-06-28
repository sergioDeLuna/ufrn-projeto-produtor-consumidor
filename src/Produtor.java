/**
 * Classe Produtor - Thread
 * @author sergioluna
 *
 */
public class Produtor extends Thread {
	//Monitor
	private Monitor monitor;
	
	//Item
	int item;
	
	
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
		try {
			for (int i = 0; i < 10; i++) {
				item = (int)(Math.random() * 100 + 1);
				System.out.println(Thread.currentThread().getName() + " colocando item " + item + " no buffer...");
				monitor.inserir(item);
				Thread.sleep((long)(Math.random() * 500));
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		
	
}
