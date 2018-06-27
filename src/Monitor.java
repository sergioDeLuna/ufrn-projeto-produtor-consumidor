import java.util.LinkedList;
import java.util.Queue;

public class Monitor {
	
	Queue<Integer> fila = new LinkedList<Integer>();
	int contador = 0;
	int tamanhoDaFila = 5;
	
	public void inserir(int item) throws InterruptedException {
		synchronized (this) {
			
			if(contador == tamanhoDaFila)
				wait();
			
			fila.add(item);
			contador++;
			
//			if(contador == 1) 
//				signal();
			
	}
		
	}
	
	public void remover(int item) throws InterruptedException {
		synchronized (this) {
			
			if(contador == 0)
				wait();
			
			fila.remove(item);
			contador--;
			
//			if(contador == 1) 
//				signal();
		}	
	}
	
}
