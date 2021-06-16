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
	public int fight;
	public int thief;

	int begCnt;
	int tiredCnt;

	int thiefEnding;
	int fightEnding;
	int normalEnding;

	BeggarDAO bdao = new BeggarDAO();
	Scanner sc = new Scanner(System.in);

	public void titlePrint() {
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("					");
		System.out.println("    1.새로 시작하기          2.게임 불러오기          3.프롤로그 다시보기          0.게임 종료하기");
		System.out.println("		             ");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
	}

	public void mainTitlePrint() {
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("					");
		System.out.println("    1.상태 확인하기   2.구걸하기    3.배우기    4.돈쓰기   5.거지 탈출하기   6.게임저장   0.초기화면");
		System.out.println("		                       				");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

	}

	public void shopMenuPrint() {
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("		                원하는 물품을 구매하세요!");
		System.out.println("    1.소시지빵 구매(2000원) - 허기를 5 감소시킨다.");
		System.out.println("    2.박카스 구매(5000원) - 피로도를 10 감소시킨다.");
		System.out.println("    3.쓰레기통 뒤지기 - ★ 춥고 배고픈 저렙 거지에게 추천. 운이 좋으면 무언가를 발견할 수도...?");
		System.out.println("    0.돌아간다");
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
					System.out.println();
					System.out.println("불러올 게임이 없습니다.");
					System.out.println("우선 <새로 시작하기>에서 거지를 생성하세요.");
					System.out.println();
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

						// 캐릭터 불러오는 메세지
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println();
						System.out.println(" < " + b.getName() + " > 캐릭터를 불러옵니다.");
						System.out.println();
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}

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
								learn();
								break; // 잠자기
							case 4:
								shop();
								break; // 쇼핑하기
							case 5:
								newLife();
								break;
							case 6:
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
		System.out.println("과거 무려 500명의 사원을 책임지며 규모있는 어느 기업의 사장이었던 거지...");
		System.out.println("그러나 코로나로 인해 그의 사업은 쫄딱 망하고 말았다...");
		System.out.println("지금 수중에는 천 원짜리 지폐 한 장 뿐이다...");
		System.out.println("과연 그는 거지 생활을 청산할 수 있을까?");
		System.out.println("목표액 1000만원을 모아 거지 생활을 청산하고 거지가 새 인생을 살 수 있도록 도와주세요!");
		System.out.println();
		System.out.println("**거지의 Max Level은 10입니다.");
		System.out.println("**거지의 피로도가 100이 되면 과로로 사망합니다.");
		System.out.println("**거지의 허기가 100이 되면 굶주림으로 사망합니다.");

	}

	// 거지 생성
	public void newGame() {

		System.out.println();
		System.out.println("거지의 새 이름을 입력해주세요!");
		name = sc.next();

		// 이름을 거지의 초기값과 함께 저장. 초기자금1000원, 허기50, 피로도30, 레벨1, 싸움기술0, 도둑질기술0
		Beggar b = new Beggar(0, name, 1000, 50, 30, 1, 0, 0);
		bdao.newBeggar(b);

		System.out.println("<게임 불러오기> 의 목록에서 생성된 거지를 확인하세요. ");
		System.out.println();
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
			fight = b.getFight();
			thief = b.getThief();
		}
		return b;
	}

	// 게임 저장
	public void gameSave() {

		Beggar b = new Beggar(num, name, money, hunger, tiredness, level, fight, thief);
		bdao.saveGame(b);

	}

	// 거지 상태 보기
	public void status() {
		if (tiredness > 100 || hunger > 100) {

			System.err.println("\n" + name + ", 그는 성실한 거지였습니다...\n\n삼가 고인의 명복을 빕니다...\n");

		} else {
			System.out.println("------------------------");
			System.out.println("   < " + name + "의 상태 >");
			System.out.println("가진 돈         " + money + " 원");
			System.out.println("허기             " + hunger);
			System.out.println("피로도            " + tiredness);
			System.out.println("싸움기술          " + fight);
			System.out.println("도둑질기술         " + thief);
			System.out.println("레벨             " + level);
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

			System.out.println();
			String beg1 = name + "는(은) 열심히 구걸했다.          \n" + "짤그랑 짤그랑 돈 떨어지는 소리가 들린다......                 ";

			for (int i = 0; i < beg1.length(); i++) {
				try {
					Thread.sleep(25);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.print(beg1.charAt(i));
			}
			System.out.println();
			System.out.println();

			String beg2 = random + "원을 얻었습니다.\n";

			for (int i = 0; i < beg2.length(); i++) {
				try {
					Thread.sleep(25);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.print(beg2.charAt(i));
			}

			System.out.println("피로도가 3 증가합니다.");
			System.out.println("허기가 3 증가합니다.\n");

			// 구걸 횟수 증가
			begCnt++;

			// 스테이터스 증감
			money += random;
			hunger += 3;
			tiredness += 3;

			// 구걸 횟수가 5의 배수가 되면 레벨이 오른다.
			if (begCnt % 5 == 0 && level < 10) {
				level++;

				// 레벨업 메세지 출력
				System.out.println("-------------------------------------");
				String levelUp = "거지의 레벨이 " + level + "으로 올랐습니다!               \n" + "이제 더 많은 돈을 구걸할 수 있습니다.\n";

				for (int i = 0; i < levelUp.length(); i++) {
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.print(levelUp.charAt(i));
				}

			}
			System.out.println();
			// 구걸횟수가 4의 배수마다 왕초 출몰.
			if (begCnt % 4 == 0 && fightEnding == 0) {

				int stealMin = 2500 * level;
				int stealMax = 3500 * level;
				int stealMoney = (int) ((Math.random() * (stealMax - stealMin)) + stealMin);

				System.err.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
				System.err.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
				System.err.println("이 구역 왕초 출몰!");

				String steal = "거지가 힘들게 번 돈을 갈취합니다.\n" + "수중의 돈이 " + stealMoney + "원 감소합니다.\n"
							+ "피로도가 8 증가합니다......\n\n";

					for (int i = 0; i < steal.length(); i++) {
						try {
							Thread.sleep(25);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.print(steal.charAt(i));
					}

					try {
						Thread.sleep(300);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					// 빼앗는 돈이 가진 돈보다 많으면 돈은 0원으로 초기화.
					if (stealMoney >= money) {
						money = 0;
						tiredness += 8;
					} else {
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

	

	public void learn() {
		if (tiredness > 100 || hunger > 100) {
			System.err.println("그는 방금 생을 마감했습니다...\n귀신은 할 수 없습니다...");
		} 
		else {
			System.out.println("뒷골목에서 생존에 필요한 각종 기술을 배울 수 있습니다.");
			System.out.println("배울 기술을 선택하세요.");
			System.out.println("1.도둑질       2.");
			
			
			
		}
		
		
		
		
	}

	public void newLife() {
		if (tiredness > 100 || hunger > 100) {
			System.err.println("그는 방금 생을 마감했습니다...\n귀신은 할 수 없습니다...");
		} else if (level != 10) {
			System.out.println();
			System.out.println("레벨 10이 되어야 거지 생활을 탈출할 수 있습니다. (현재 레벨 : " + level + ")");
			System.out.println("우선 <구걸하기>를 통해 거지의 레벨을 올리세요.");
			System.out.println();
		} else {
			System.out.println();
			String newLi = name + "는(은) 이제 길바닥 생활을 청산하려 합니다........               \n" + "거지의 앞날을 지켜보시겠습니까?\n";

			for (int i = 0; i < newLi.length(); i++) {
				try {
					Thread.sleep(25);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.print(newLi.charAt(i));
			}

			System.out.println("1.지켜보겠습니다      2.아직 시간이 필요합니다");

			int num = readInt();

			if (num == 1) {

				// 싸움 기술 70 이상
				if (fight >= 70) {

					// 왕초와 싸움

					fightEnding++;
				}

				// 도둑질 기술 70 이상
				else if (thief >= 70) {

					// 왕초의 돈을 모두 뺏음, 새 사업 시작

					thiefEnding++;
				}

				// 평범한 엔딩
				else {

					System.out.println("거지는...");

					normalEnding++;
				}

			}

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
				case 1: // 빵
					System.out.println("----------------------------");
					System.out.println("거지의 눈물로 젖은 소시지빵입니다.");
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
								break;
							} else {
								System.out.println("----------------------------");
								System.out.println("구매에 성공했습니다!");
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
								break;
							} else {
								System.out.println("----------------------------");
								System.out.println("구매에 성공했습니다!");
								System.out.println("피로가 가시는 것이 느껴집니다.");
								System.out.println("피로도가 " + 10 * bacchus + " 감소하였습니다.");
								System.out.println("----------------------------");
								tiredness -= 10 * bacchus;
								money -= 5000 * bacchus;
							}
						}
					}

					break;

//				case 3: // thief 도둑질 기술 배우기
//
//					System.out.println();
//					String thi = "뒷골목의 이름난 소매치기에게 도둑질 기술을 배울 수 있습니다........             \n"
//							+ "소매치기에게 50000원을 주고 기술을 배우시겠습니까? (현재 소지한 금액 : " + money + "원)\n";
//
//					for (int i = 0; i < thi.length(); i++) {
//						try {
//							Thread.sleep(25);
//						} catch (InterruptedException e) {
//							e.printStackTrace();
//						}
//						System.out.print(thi.charAt(i));
//					}
//
//					System.out.println("1.ㅇㅇ      2.ㄴㄴ");
//
//					int thiefNum = readInt();
//
//					if (thiefNum == 1) {
//						if (money < 50000) {
//							System.err.println("돈이 부족합니다.");
//							break;
//						} else {
//							String thi2 = "소매치기에게 돈을 주었습니다.        \n" + "손기술을 배웠습니다. " + name
//									+ "은(는) 당장이라도 돈을 훔칠 수 있을 것만 같습니다.....!          \n";
//
//							for (int i = 0; i < thi2.length(); i++) {
//								try {
//									Thread.sleep(25);
//								} catch (InterruptedException e) {
//									e.printStackTrace();
//								}
//								System.out.print(thi2.charAt(i));
//							}
//							System.out.println("도둑질기술이 10 증가합니다.");
//							System.out.println();
//
//							money -= 50000;
//							thief += 10;
//						}
//
//					}
//
//					break;
//
//				case 4: // fight 싸움 기술 배우기
//
//					System.out.println();
//					String fig = "뒷골목의 깡패에게 싸움 기술을 배울 수 있습니다........             \n"
//							+ "깡패에게 50000원을 주고 기술을 배우시겠습니까? (현재 소지한 금액 : " + money + "원)\n";
//
//					for (int i = 0; i < fig.length(); i++) {
//						try {
//							Thread.sleep(25);
//						} catch (InterruptedException e) {
//							e.printStackTrace();
//						}
//						System.out.print(fig.charAt(i));
//					}
//
//					System.out.println("1.ㅇㅇ      2.ㄴㄴ");
//
//					int fightNum = readInt();
//
//					if (fightNum == 1) {
//						if (money < 50000) {
//							System.err.println("돈이 부족합니다.");
//							break;
//						} else {
//							String fig2 = "깡패에게 돈을 주었습니다.        \n" + "싸움기술을 배웠습니다. " + name
//									+ "는(은) 당장이라도 왕초를 쓰러뜨릴 수 있을 것 같습니다.....!          \n";
//
//							for (int i = 0; i < fig2.length(); i++) {
//								try {
//									Thread.sleep(25);
//								} catch (InterruptedException e) {
//									e.printStackTrace();
//								}
//								System.out.print(fig2.charAt(i));
//							}
//							System.out.println("싸움기술이 10 증가합니다.");
//							System.out.println();
//
//							money -= 50000;
//							fight += 10;
//						}
//
//					}
//
//					break;

				case 3: // 쓰레기통 뒤지기
					TrashCan t = new TrashCan();
					System.out.println();
					String trash = "쓰레기통을 뒤적거려봅니다.                 \n";

					for (int i = 0; i < trash.length(); i++) {
						try {
							Thread.sleep(25);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.print(trash.charAt(i));
					}

					// 텀 두기
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					int a = t.trashCan();
					if (a == 1) { //

						String trash2 = "대박! 만 원짜리 지폐를 발견했습니다!\n" + "소지금이 10000원 증가합니다.\n";

						for (int i = 0; i < trash2.length(); i++) {
							try {
								Thread.sleep(25);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							System.out.print(trash2.charAt(i));
						}

						money += 10000;

						// 텀 두기
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}

					} else if (a == 2) { //

						String trash3 = "남은 식재료를 발견했습니다!\n" + "허기가 3 감소합니다.\n";

						for (int i = 0; i < trash3.length(); i++) {
							try {
								Thread.sleep(25);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							System.out.print(trash3.charAt(i));
						}

						hunger -= 3;

						// 텀 두기
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}

					} else if (a == 3) { //

						String trash4 = "쓰레기통에는 쓰레기 뿐이었습니다...        \n";
						for (int i = 0; i < trash4.length(); i++) {
							try {
								Thread.sleep(25);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							System.out.print(trash4.charAt(i));
						}

					}

					System.out.println();

					break;

				}

			} while (menuNum != 0);

		}

	}

}
