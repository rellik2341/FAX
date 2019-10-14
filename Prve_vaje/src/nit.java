
public class nit extends Thread{

	@Override
	public void run() {
		//Thread.currentThread().setName("Wanker");
		
		System.out.println("Hello from: " + Thread.currentThread().getName());
		
		for (int i = 0; i < 1000000000; i++) {
			Main.banana.incrementAndGet();
			//Main.banana++;
		}
		
		System.out.println("Have slept");
	}

}
