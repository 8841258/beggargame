package view;

import java.util.ArrayList;
import java.util.Scanner;

import model.Beggar;
import model.BeggarDAO;
import model.TrashCan;

public class BeggarGame {

	int num;
	String name;
	int money;
	int hunger;
	int tiredness;
	int level;

	int begCnt;
	int tiredCnt;

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
		System.out.println("    1.상태 확인하기     2.구걸하기      3.잠자기      4.돈쓰기     5.게임저장     0.초기화면");
		System.out.println("		                       				");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

	}

	public void shopMenuPrint() {
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("		          원하는 물품을 구매하세요!");
		System.out.println("    1.빵 구매(2000원) - 허기를 5 감소시킨다.");
		System.out.println("    2.박카스 구매(5000원) - 피로도를 10 감소시킨다.");
		System.out.println("3.      4.빚갚기     5.쓰레기통뒤지기     0.돌아간다");
		System.out.println("		                       				");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
	}

	// 입력받기
	public int readInt() {
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

	// 새로 시작하기

	public void start() {

		int selectNum = 0;

		while (true) {
			titlePrint();

			selectNum = readInt();

			if (selectNum == 1) {
				newGame();
			} else if (selectNum == 2) {
				ArrayList<Beggar> array = bdao.beggarList();

				if (array.size() == 0) {
					System.out.println("불러올 게임이 없습니다. 우선 <새로 시작하기>에서 거지를 생성하세요.");

				} else {
					// 지난 게임 목록 출력
					lastGameList();

					// 거지 선택
					Beggar b = selectBeggar();
					if (b == null) {
						System.out.println("※ 지난 게임 목록에 저장된 번호가 아닙니다.\n번호를 다시 확인하세요.");
					}

					else {
						int gameNum = 0;
						do {
							// 게임 메인 화면 출력
							mainTitlePrint();

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
								while (true) {
									System.out.println("지금까지의 모든 플레이를 저장하시겠습니까? (y/n)");
									String yesNo = sc.next();
									if (yesNo.equals("y")) {
										gameSave();
										break;
									} else if (yesNo.equals("n")) {
										break;
									} else {
										System.out.println("※ y/n 중 하나를 입력하세요.");
									}
								}
							}
						} while (gameNum != 0);
					}
				}
			} else if (selectNum == 3) {
				help();
			} else if (selectNum == 0) {
				break;
			} else {
				System.out.println("※ 숫자를 다시 확인하세요.");
			}

		} // while 괄호
	}// start() 괄호

	// 게임 설명
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

	// 거지 생성
	public void newGame() {

		System.out.println("거지의 새 이름을 입력해주세요!");
		name = sc.next();

		// 이름을 거지의 초기값과 함께 저장. 초기자금1000원, 허기50, 피로도30, 레벨1
		Beggar b = new Beggar(0, name, 1000, 50, 30, 1);
		bdao.newBeggar(b);

	}

	// 게임 리스트 불러오기
	public void lastGameList() {
		// 거지 리스트 불러오기
		ArrayList<Beggar> array = bdao.beggarList();

		System.out.println("-----------지난 게임 목록-----------");
		System.out.println("번호             거지 이름");
		for (Beggar b : array) {
			System.out.println(b.getNum() + "               " + b.getName());
		}
		System.out.println("---------------------------------");

	}

	public Beggar selectBeggar() {
		// 거지 선택하기
		int beggarNum = readInt();

		Beggar b = bdao.selectOne(beggarNum);

		if (b == null) {
			b = null;
		} else {
			num = b.getNum();
			name = b.getName();
			money = b.getMoney();
			hunger = b.getHunger();
			tiredness = b.getTiredness();
			level = b.getLevel();
		}
		return b;
	}

	// 게임 저장
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

		} else {
			System.out.println("------------------------");
			System.out.println("<거지의 상태>");
			System.out.println("가진 돈      " + money + " 원");
			System.out.println("허기       " + hunger);
			System.out.println("피로도      " + tiredness);
			System.out.println("레벨        " + level);
			System.out.println("------------------------");

			if (hunger >= 90) {
				System.err.println("**거지가 아사하기 직전입니다. 빨리 무언가를 먹여주세요!");
			} else if (hunger >= 60) {
				System.out.println("**거지는 슬슬 배가 고픕니다.");
			}

			if (tiredness >= 90) {
				System.err.println("**거지가 피로로 인해 쓰러지기 직전입니다. 휴식이 필요합니다......");
			} else if (tiredness >= 60) {
				System.out.println("**거지가 피로를 호소하고 있습니다.");
			}

			System.out.println();
		}
	}

	// 구걸하기
	public void beg() {

		// 죽은 상태면 할 수 없다.
		if (tiredness > 100 || hunger > 100) {

			System.err.println("그는 방금 생을 마감했습니다...\n귀신은 할 수 없습니다...");

		} else {

			int min = 1000 * level;
			int max = 2000 * level;
			int random = (int) ((Math.random() * (max - min)) + min);

			System.out.println("---------------------------");
			System.out.println("거리에 앉아 구걸을 시작합니다.");
			System.out.println(random + "원을 얻었습니다.");
			System.out.println("피로도가 3 증가합니다.");
			System.out.println("허기가 3 증가합니다.");

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
			}

			// 왕초 출몰. 돈을 뺏는다.
			if (begCnt % 5 == 0) {

				// 레벨이 10 이상에 돈이 10만원 이상이면 왕초는 더 많은 돈을 뺏으려고 함
				if (level == 10 && money > 100000) {
					System.out.println("-------------------------------------------------");
					System.out.println("왕초가 " + name + "의 돈냄새를 맡았습니다...");
					System.out.println("이제 구걸을 하려면 자릿세를 내야 한다... 그는 50만원을 요구합니다.");
					System.out.println("어떻게 대응하시겠습니까?");
					System.out.println("1.50만원을 낸다    2.");
					int a = readInt();
					if (a == 1) {
						// 가진 돈이 50만원보다 작으면
						if (money < 500000) {
							System.out.println("돈이 부족한데?");
							System.err.println("왕초는 거지가 가진 돈을 전부 빼앗아갔다...");
							money = 0;
						} else {
							System.out.println("왕초가 50만원을 가져갔다...");
							System.out.println("내 돈...");
							money -= 500000;
						}
					} else if (a == 2) {

					}

				} else {
					
					
					int stealMin = 4000 * level;
					int stealMax = 5000 * level;
					int stealMoney = (int) ((Math.random() * (stealMax - stealMin)) + stealMin);
					
					if (stealMoney >= money) {
						System.err.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
						System.err.println("이 구역 왕초 출몰!");
						System.err.println("거지가 힘들게 번 돈을 갈취합니다.");
						System.err.println("수중의 돈이 " + stealMoney + "원 감소합니다.");
						System.err.println("피로도가 8 증가합니다.");
						
						money = 0;
						tiredness += 8;
					}
					else {
					System.err.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
					System.err.println("이 구역 왕초 출몰!");
					System.err.println("거지가 힘들게 번 돈을 갈취합니다.");
					System.err.println("수중의 돈이 " + stealMoney + "원 감소합니다.");
					System.err.println("피로도가 8 증가합니다.");

					money -= stealMoney;
					tiredness += 8;
					}
				}
			}

			// 피로도나 허기가 100이 되면 사망.
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
		} else {
			System.out.println("구석 자리에 누워 잠을 청합니다.");
			System.out.println("피로도가 1 감소합니다.");

			tiredness -= 1;
			tiredCnt++;

			if (tiredCnt % 5 == 0) {
				System.out.println("이웃 거지가 나타나 행패를 부리기 시작합니다...");
				System.out.println("거지는 피곤해졌습니다... 피로도가 2 증가합니다.");
				tiredness += 2;
			}
//			// 피로도나 허기가 100이 되면 사망.
//			if (tiredness > 100 || hunger > 100) {
//				System.err.println("***GAME OVER...***");
//				System.err.println("거지가 생을 마감했습니다...");
//				System.err.println("그의 넋이 이곳저곳을 배회하고 있습니다...");
//			}
		}
	}

	public void shop() {
		if (tiredness > 100 || hunger > 100) {
			System.err.println("그는 방금 생을 마감했습니다...\n귀신은 할 수 없습니다...");
		} else {
			int menuNum;
			do {
				shopMenuPrint();

				menuNum = readInt();

				switch (menuNum) {
				case 1: //빵
					System.out.println("----------------------------");
					System.out.println("거지의 눈물로 젖은 빵입니다.");
					System.out.println("구매하시겠습니까? (현재 소지한 금액 : " + money + "원)");
					System.out.println("1.ㅇㅇ      2.ㄴㄴ");

					int breadNum = readInt();

					if (breadNum == 1) {
						System.out.println("몇 개를 구매하시겠습니까?");
						int bread = readInt();
						if (bread <= 0) {
							System.out.println("1 이상의 수량을 입력하세요.");
							break;
						} else {
							System.out.println("총 가격은 " + bread * 2000 + "입니다. 정말로 구매하시겠습니까?");
							System.out.println("1.ㅇㅇ      2.ㄴㄴ");

							if (money < 2000 * bread) {
								System.err.println("돈이 부족합니다.");
							} else {
								System.out.println("----------------------------");
								System.out.println("구매하였습니다.");
								System.out.println("허기가 가시는 것이 느껴집니다.");
								System.out.println("허기가 " + 5 * bread + " 감소하였습니다.");
								System.out.println("----------------------------");
								hunger -= 5 * bread;
								money -= 2000 * bread;
							}
						}
					}

					if (breadNum == 2) {
						break;
					}
					break;
					
				case 2: // 박카스
					System.out.println("----------------------------");
					System.out.println("피로가 싹 가실 것 같은 박카스입니다.");
					System.out.println("구매하시겠습니까? (현재 소지한 금액 : " + money + "원)");
					System.out.println("1.ㅇㅇ      2.ㄴㄴ");

					int bakNum = readInt();

					if (bakNum == 1) {
						System.out.println("몇 개를 구매하시겠습니까?");
						int bacchus = readInt();
						if (bacchus <= 0) {
							System.out.println("1 이상의 수량을 입력하세요.");
							break;
						} else {
							System.out.println("총 가격은 " + bacchus * 5000 + "입니다. 정말로 구매하시겠습니까?");
							System.out.println("1.ㅇㅇ      2.ㄴㄴ");

							if (money < 5000 * bacchus) {
								System.err.println("돈이 부족합니다.");
							} else {
								System.out.println("----------------------------");
								System.out.println("구매하였습니다.");
								System.out.println("피로가 가시는 것이 느껴집니다.");
								System.out.println("피로도가 " + 10 * bacchus + " 감소하였습니다.");
								System.out.println("----------------------------");
								tiredness -= 10 * bacchus;
								money -= 5000 * bacchus;
							}
						}
					}

				case 3:
					break;
				case 4:

					break;

				case 5: // 쓰레기통 뒤지기
					TrashCan t = new TrashCan();
					System.out.println("쓰레기통을 뒤적거려봅니다.");
					int a = t.trashCan();
					if (a == 1) { // 10%
						System.out.println("천 원짜리 지폐를 발견했습니다!");
						System.out.println("소지금이 1000원 증가합니다.");
						money += 1000;
					} else if (a == 2) { // 20%
						System.out.println("남은 식재료를 발견했습니다!");
						System.out.println("허기가 2 감소합니다.");
						hunger -= 2;
					} else if (a == 3) { // 30%
						System.out.println("쓰레기통에는 쓰레기 뿐이었습니다...");
					}

					break;

				}

			} while (menuNum != 0);

		}

	}

}
