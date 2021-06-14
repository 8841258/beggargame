package view;

import java.util.ArrayList;
import java.util.Scanner;

import model.Beggar;
import model.BeggarDAO;

public class BeggarGame {

	int num;
	String name;
	int money;
	int hunger;
	int tiredness;
	int level;
	
	int begCnt = 0;

	BeggarDAO bdao = new BeggarDAO();
	Scanner sc = new Scanner(System.in);

	public void titlePrint() {
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("				    거지 키우기 게임");
		System.out.println("					");
		System.out.println("    1.새로 시작하기          2.게임 불러오기          3.게임 설명 보기          0.게임 종료하기");
		System.out.println("		                       				");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

	}

	public void mainTitlePrint() {
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("					");
		System.out.println("    1.상태 확인하기     2.구걸하기      3.잠자기      4.쇼핑하기     5.게임저장     0.초기화면");
		System.out.println("		                       				");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

	}
	
	public void shopMenuPrint() {
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("		          원하는 물품을 구매하세요!");
		System.out.println("    1.눈물 젖은 빵     2.박카스      3.?      4.?     5.?     0.이전으로");
		System.out.println("		                       				");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

	}
	
	//입력받기
	public int readInt() {
		int result=0;

		while (true) {
		try {
			String userInput = sc.next();
			result = Integer.parseInt(userInput);
			break;
		} catch (Exception e) {
			System.out.println("(Error) 숫자를 입력하세요.");
		}
		}
		return result;	
	}

	
	// 새로 시작하기

	public void start() {
		

		int selectNum = 0;

		while (true) {
			titlePrint();
			System.out.print("선택> ");
			selectNum = readInt();

			if (selectNum == 1) {
				newGame();
			}
			if (selectNum == 2) {
				ArrayList<Beggar> array = bdao.beggarList();

				if (array.size() == 0) {
					System.out.println("불러올 게임이 없습니다. 우선 <새로 시작하기>에서 거지를 생성하세요.");

				} 
				else {
				lastGameList();

				
				
				int gameNum = 0;
				do {
					// 게임 메인 화면 출력
					mainTitlePrint();

					System.out.print("거지의 행동을 선택하세요.> ");
					gameNum = readInt();

					switch (gameNum) {
					case 1: // 상태 확인
						status();
						break;
					case 2:
						beg();
						break; // 구걸하기
					case 3: 
						sleep();
						break; // 잠자기
					case 4:
						shop();
						break; // 쇼핑하기
					case 5:
						gameSave();
						break;

					}

				} while (gameNum != 0);

				}
			}
			if (selectNum == 3) {
				help();
			}
			if (selectNum == 0) {
				break;
			}

		} // while 괄호
	}// start() 괄호

	
	
	//게임 설명
	public void help() {
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.println("과거 무려 500명의 사원을 책임지며 규모있는 어느 기업의 사장이었던 거지...");
		System.out.println("그러나 코로나로 인해 그의 사업은 쫄딱 망하고 말았다...");
		System.out.println("지금 수중에는 천 원짜리 지폐 한 장 뿐이다...");
		System.out.println("과연 그는 거지 생활을 청산할 수 있을까?");
		System.out.println("목표액 1000만원을 모아 거지 생활을 청산하고 거지가 새 인생을 살 수 있도록 도와주세요!");
		System.out.println();
		System.out.println("**거지의 Max Level은 10입니다.");
		System.out.println("**거지의 피로도가 100이 되면 과로로 사망합니다.");
		System.out.println("**거지의 허기가 100이 되면 굶주림으로 사망합니다.");
		System.out.println("**거지");
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");

	}

	
	//거지 생성
	public void newGame() {
		System.out.println("거지의 새 이름을 입력해주세요!");
		name = sc.next();

		//이름을 거지의 초기값과 함께 저장. 초기자금1000원, 허기50, 피로도30, 레벨1
		Beggar b = new Beggar(0, name, 1000, 50, 30, 1);
		bdao.newBeggar(b);

	}

	// 게임 리스트 불러오기
	public void lastGameList() { //fafwfeafawfwaefwaef
		//거지 리스트 불러오기
		ArrayList<Beggar> array = bdao.beggarList();

			System.out.println("-----------지난 게임 목록-----------");
			System.out.println("번호             거지 이름");
			for (Beggar b : array) {
				System.out.println(b.getNum() + "               " + b.getName());
			}
			System.out.println("---------------------------------");
			
			//거지 선택하기
			System.out.print("불러올 거지의 번호> ");
			int beggarNum = sc.nextInt();

			
			Beggar b = bdao.selectOne(beggarNum);

			
			num = b.getNum();
			name = b.getName();
			money = b.getMoney();
			hunger = b.getHunger();
			tiredness = b.getTiredness();
			level = b.getLevel();
			
		}


	//게임 저장
	public void gameSave() {
		Beggar b = new Beggar();
		b.setName(name);
		b.setNum(num);
		b.setMoney(money);
		b.setHunger(hunger);
		b.setLevel(level);
		b.setTiredness(tiredness);
		bdao.saveGame(b);
		
	}


	// 거지 상태 보기
	public void status() {
		if (tiredness > 100 || hunger > 100) {
			
			
			System.err.println("\n" + name + ", 그는 성실한 거지였습니다...\n\n삼가 고인의 명복을 빕니다...\n");

		}
		else {
		System.out.println("------------------------");
		System.out.println("<거지의 상태>");
		System.out.println("가진 돈      " + money + " 원");
		System.out.println("허기       " + hunger);
		System.out.println("피로도      " + tiredness);
		System.out.println("레벨        " + level);
		System.out.println("------------------------");

		if (hunger >= 90) {
			System.err.println("**거지가 아사하기 직전입니다. 빨리 무언가를 먹여주세요!");
		}
		else if (hunger >= 60) {
			System.err.println("**거지는 슬슬 배가 고픕니다.");
		}
		else if (hunger >= 30) {
			System.out.println("**거지의 상태가 양호합니다.");
		}
		
		if (tiredness >= 90) {
			System.err.println("**거지가 피로로 인해 쓰러지기 직전입니다. 휴식이 필요합니다......");
		}
		else if (tiredness >= 60) {
			System.err.println("**거지가 피로를 호소하고 있습니다.");
		}
		else if (tiredness >= 30) {
			System.out.println("**거지는 피곤하지 않습니다.");
		}

		System.out.println();
		}
	}



	// 구걸하기
	public void beg() {
		
		//죽은 상태면 할 수 없다.
		if (tiredness > 100 || hunger > 100) {
			
			System.err.println("그는 방금 생을 마감했습니다...\n귀신은 할 수 없습니다...");

		}
		else {
		
		int min = 1000 * level;
		int max = 2000 * level;
		int random = (int) ((Math.random() * (max - min)) + min);

		System.out.println("---------------------------");
		System.out.println("거리에 앉아 구걸을 시작합니다.");
		System.out.println(random + "원을 얻었습니다.");
		System.out.println("피로도가 3 증가합니다.");
		System.out.println("허기가 3 증가합니다.");
		System.out.println("---------------------------");

		// 구걸 횟수 증가
		begCnt++;

		// 스테이터스 증감
		money += random;
		hunger += 3;
		tiredness += 3;
		
		

		// 구걸 횟수가 10이 되면 레벨이 오르고, 구걸 횟수는 0으로 초기화
		if (begCnt == 10 && level < 10) {
			level++;
			begCnt = 0;

			// 레벨업 메세지 출력
			System.out.println("-------------------------------------");
			System.err.println("거지의 레벨이 " + level + "으로 올랐습니다!");
			System.out.println("이제 더 많은 돈을 구걸할 수 있습니다.");
			System.out.println("-------------------------------------");
		}
		
		
		//구걸을 5번 할때마다 왕초 출몰. 돈을 뺏는다.
		if (begCnt % 5 == 0) {
			
			int stealMin = 3000 * level;
			int stealMax = 4000 * level;
			int stealMoney = (int) ((Math.random() * (stealMax - stealMin)) + stealMin);
			
			System.out.println("-------------------------------------");
			System.err.println("이 구역 왕초 출몰!");
			System.out.println("거지가 힘들게 번 돈을 갈취합니다.");
			System.out.println("수중의 돈이 " + stealMoney + "원 감소합니다.");
			System.out.println("피로도가 8 증가합니다.");
			System.out.println("-------------------------------------");
			
			money -= stealMoney;
			tiredness += 8;
			
		}
		
		//피로도나 허기가 100이 되면 사망.
		if (tiredness > 100 || hunger > 100) {
			System.err.println("***GAME OVER...***");
			System.err.println("거지가 생을 마감했습니다...");
			System.err.println("그의 넋이 이곳저곳을 배회하고 있습니다...");
		}
		
		}
		
	}
	
	
	
	
	public void sleep() {
		if (tiredness > 100 || hunger > 100) {
			System.err.println("그는 방금 생을 마감했습니다...\n귀신은 할 수 없습니다...");
		}
		else {
			System.out.println("구석 자리에 누워 잠을 청합니다.");
			System.out.println("피로도가 2 감소합니다.");
			
			tiredness -= 2;	
		}
	}
	
	
	
	
	public void shop() {
		if (tiredness > 100 || hunger > 100) {
			System.err.println("그는 방금 생을 마감했습니다...\n귀신은 할 수 없습니다...");
		}
		else {
			int menuNum;
			do {
				shopMenuPrint();
				System.out.print("번호> ");
				menuNum = readInt();
				
				switch (menuNum) {
				case 1 : 
					System.out.println("----------------------------");
					System.out.println("먹음직스러워 보이는 빵입니다.");
					System.out.println("구매하시겠습니까?");
					System.out.println("1.ㅇㅇ      2.ㄴㄴ");
					
					int num = readInt();
					
					if (num == 1) {
						if (money < 2000) {
							System.err.println("돈이 부족합니다. (현재 소지한 돈 : " + money + "원)");
						}
						else {
							System.out.println("----------------------------");
							System.out.println("구매하였습니다.");
							System.out.println("허기가 가시는 것이 느껴집니다.");
							System.out.println("허기가 5 감소하였습니다.");
							System.out.println("----------------------------");
							hunger -= 5;
							money -= 2000;
							}
					}
					if (num == 2) {
						break;
					}
				case 2 : //박카스
					break;
				
				}
				
				
			} while (menuNum != 0);
				
		}
		
	}
	
	

}
