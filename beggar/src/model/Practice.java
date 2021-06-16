package model;

import view.BeggarGame;

public class Practice {

	public static void main(String[] args) throws InterruptedException {
		
//		String s2 = "\nLoading...\n";
//		
//		for (int i = 0; i < s2.length(); i++) { // 로딩 타이핑 효과
//			Thread.sleep(300);
//	      System.out.print( s2.charAt(i) );
//	    }
//		
//		Thread.sleep(1000);
//		
//		titlePrint(); // 게임 제목 출력
//		
//		Thread.sleep(1000);
//		
//		String s = "과거 무려 500명의 사원을 책임지며 규모있는 어느 기업의 사장이었던 거지...                    \n\n"
//				+ "그러나 코로나로 인해 그의 사업은 쫄딱 망하고 말았다...                    \n\n"
//				+ "지금 수중에는 천 원짜리 지폐 한 장 뿐이다...                    \n\n"
//				+ "녹록치 않은 길바닥 인생.... 과연 그는 거지 생활을 청산할 수 있을까?                    \n\n"
//				+ "목표액 1000만원을 모아 거지 생활을 청산하고 거지가 새 인생을 살 수 있도록 도와주세요!                    \n\n"
//				+ "**거지의 Max Level은 10입니다.\n"
//				+ "**거지의 피로도가 100이 되면 과로로 사망합니다.\n"
//				+ "**거지의 허기가 100이 되면 굶주림으로 사망합니다.\n\n\n";
//		
//
//		for (int i = 0; i < s.length(); i++) { // 프롤로그 타이핑 효과
//				Thread.sleep(25);
//		      System.out.print( s.charAt(i) );
//		    }
//
//		Thread.sleep(1000);

		BeggarGame bg = new BeggarGame();
		bg.start();
		
	
		
	}
	
	
	public static void titlePrint() {
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("		                       				");
		System.out.println("				      거지 키우기 게임");
		System.out.println("		                       				");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		System.out.println("		                       				");
	}

}
