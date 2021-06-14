package model;

public class Loading implements Runnable{
	
	public void run() {
		char[] arr = {' ', 'L', 'O', 'A', 'D', 'I', 'N', 'G', '.', '.', '.'};
		
		
		for (int i=0; i<=10; i++) {
			System.out.println(arr[i]);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
	}
}
