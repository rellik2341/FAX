import java.util.concurrent.atomic.AtomicLong;

public class Main {

	//public static long banana = 0;
	public static AtomicLong banana= new AtomicLong(0);
	
	public static void main(String[] args) {
		
		System.out.println(Thread.currentThread().getName());
		
		long start = System.currentTimeMillis();
		
		nit a = new nit();
		nit b = new nit();
		
		a.start();
		b.start();
		
		try {
			a.join();
			b.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("End: " + banana + " Time: " + (System.currentTimeMillis()-start));
		start = System.currentTimeMillis();
		
		Long banana2 = (long) 0;
		
		System.out.println("sekvencna banana");
		for (int i = 0; i < 1000000000; i++) {
			
		}
		

	}

}