import java.util.LinkedList;
import java.util.Queue;
/**
 * Classe que gerencia os processos através do mecanismo de Monitor 
 * @author sergioluna
 *
 */
public class Monitor {
	//Buffer representado por uma fila
	Queue<Integer> fila;
	
	//Limite da Fila
	int limite;
	
	//Quantidade de Elementos
	int quantidadeElementos;
	
	public Monitor(int limite){
		this.limite = limite;
		this.quantidadeElementos = 0;
		fila = new LinkedList<Integer>();
	}
	
	/**
	 * Inserir itens
	 * @param item
	 * @throws InterruptedException
	 */
	public synchronized void inserir(int item) throws InterruptedException {
		while(quantidadeElementos == limite) {
			System.out.println(Thread.currentThread().getName() + " aguardando..");	
			wait();
		}
			
		fila.add(item);
		quantidadeElementos++;
		notifyAll();
		
	}
	
	/**
	 * Remover item
	 * @param item
	 * @throws InterruptedException
	 */
	public synchronized int remover() throws InterruptedException {
		while(quantidadeElementos == 0) {
			System.out.println(Thread.currentThread().getName() + " aguardando..");
			wait();
		}
		
		int valor = fila.remove();
		quantidadeElementos--;
		notifyAll();
		
		return valor;
	}	
	
}
