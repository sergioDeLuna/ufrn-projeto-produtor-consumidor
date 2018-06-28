/**
 * Classe Consumidor - Thread
 * @author sergioluna
 *
 */
public class Consumidor extends Thread {
	//Monitor
	private Monitor monitor;
	
	//Item
	private int item;
	
	/**
	 * Método de Inicialização
	 * @param nome
	 */
	public Consumidor(String nome, Monitor monitor){
		super(nome);
		this.monitor = monitor;
	}
	
	/**
	 * Método Start da thread Consumidor
	 */
	@Override
	public void run() {
		try {
			for (int i = 0; i < 10; i++) {
				item = monitor.remover();
				System.out.println(Thread.currentThread().getName() + " retirando item " + item + " do buffer...");
				Thread.sleep((long)(Math.random() * 500));
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
}
