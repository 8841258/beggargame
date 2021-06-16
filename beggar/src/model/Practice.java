package model;

import view.BeggarGame;

public class Practice {

	public static void main(String[] args) throws InterruptedException {
		
//		String s2 = "\nLoading...\n";
//		
//		for (int i = 0; i < s2.length(); i++) { // 로딩 타이핑 효과
//			Thread.sleep(200);
//	      System.out.print( s2.charAt(i) );
//	    }
//		
//		Thread.sleep(500);
//		
//		titlePrint(); // 게임 제목 출력
//		
//		Thread.sleep(500);
//		
//		String s = "여기 춥고 배고픈 거지기 있습니다...                    \n\n"
//				+ "과거 그는 규모 있는 어느 기업의 사장이었을 정도로 잘나갔었으나.....             \n\n"
//				+ "이 시국으로 인해 그의 사업은 쫄딱 망하고 말았습니다...                    \n\n"
//				+ "지금 그의 수중에는 천 원짜리 지폐 한 장 뿐입니다...                    \n\n"
//				+ "녹록치 않은 길바닥 인생.... 과연 그는 거지 생활을 청산할 수 있을까요?                    \n\n"
//				+ "거지 생활을 청산하고, 거지가 새 인생을 살 수 있도록 도와주세요!                    \n\n\n";

//		
//
//		for (int i = 0; i < s.length(); i++) { // 프롤로그 타이핑 효과
//				Thread.sleep(25);
//		      System.out.print( s.charAt(i) );
//		    }
//
//		Thread.sleep(500);

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
