package model;

import view.BeggarGame;

public class Beg extends BeggarGame implements Runnable {

	@Override
	public void run() {
		
		for (int i=1; i<=100; i++) {
			double min = 100 * level;
			double max = 1000 * level;
			double random = (int) ((Math.random() * (max - min)) + min);
			
			System.out.println("거리에 앉아 구걸을 시작합니다.");
			System.out.println(random + "원을 얻었습니다.");
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
	}

}
