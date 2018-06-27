/**
 * Classe Consumidor - Thread
 * @author sergioluna
 *
 */
public class Consumidor extends Thread {
	
	private Monitor monitor;
	int item = 1;
	
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
		System.out.println("Trabalho de consumo solicitado pelo " + Thread.currentThread().getName());
		try {
			monitor.remover(item);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
}
