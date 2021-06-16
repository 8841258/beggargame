package model;

import java.util.Scanner;

public class Util {
	
	static Scanner sc = new Scanner(System.in);
	
	//숫자 입력받기
	public static int readInt() {
		int result = 0;

		while (true) {
			try {
				System.out.print("선택> ");
				String userInput = sc.next();
				result = Integer.parseInt(userInput);
				break;
			} catch (Exception e) {
				System.out.println("※ 숫자를 입력하세요.");
			}
		}
		return result;
	}
	
	//텀 두기
	public static void sleep(int second) {
		try {
			Thread.sleep(second);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	//타이핑 효과, 25밀리세컨드
	public static void typing(String one) {
		
		for (int i = 0; i < one.length(); i++) {
			try {
				Thread.sleep(25);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.print(one.charAt(i));
		}
		
	}
	
	//조금 더 느린 타이핑 효과, 50밀리세컨드
	public static void typingSlowly(String one) {
		
		for (int i = 0; i < one.length(); i++) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.print(one.charAt(i));
		}
		
	}
	
	// 10% 확률로 1, 20% 확률로 2, 70% 확률로 3을 출력하는 확률 메소드
	// 0부터 9까지의 난수를 생성한다. array의 index가 0~9이므로 1을 더하지 않는다.
	public static int probability() {
		
		int[] arr = {1, 2, 2, 3, 3, 3, 3, 3, 3, 3};
		
		int random = (int)(Math.random() * 10);
		
		return arr[random];
	
	}
	
	
}
