package view;

import java.util.ArrayList;
import java.util.Scanner;

import model.Beggar;
import model.BeggarDAO;
import model.Util;

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

	int fightEnding;
	String ending = "아직";

	BeggarDAO bdao = new BeggarDAO();
	Scanner sc = new Scanner(System.in);

	public void titlePrint() {
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("					");
		System.out.println("    1.새로 시작하기          2.게임 불러오기          3.게임 설명 보기          0.게임 종료하기");
		System.out.println("		             ");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
	}

	public void mainTitlePrint() {
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("					");
		System.out.println("    1.상태 확인하기   2.구걸하기    3.배우기    4.상점가기    5.거지 탈출하기    6.게임저장   0.초기화면");
		System.out.println("		                       				");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

	}

	public void shopMenuPrint() {
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("		                원하는 물품을 구매하세요!");
		System.out.println("    1.소시지빵 구매(2000원) - 허기를 5 감소시킨다.");
		System.out.println("    2.아메리카노 구매(5000원) - 스트레스를 10 감소시킨다.");
		System.out.println("    3.상점 쓰레기통 뒤지기 - ★ 춥고 배고픈 저렙 거지에게 추천! 운이 좋으면 무언가를 발견할 수도...?");
		System.out.println("    0.돌아간다");
		System.out.println("		                       				");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
	}
	
	// 게임 설명
	public void help() {
		System.out.println();
		System.out.println("<거지 키우기 게임 설명>");
		System.out.println("춥고 배고픈 거지를 살려주세요!");
		System.out.println();
		System.out.println();
		System.out.println("**주요 스테이터스 - 돈, 허기, 스트레스");
		System.out.println("    1.돈 - 구걸을 하면 일정량 얻을 수 있습니다.");
		System.out.println("       게임에서 가장 중요합니다. 돈으로 모든 것을 해결할 수 있습니다.");
		System.out.println();
		System.out.println("    2.허기 - 구걸을 하면 증가합니다. 상점에서 빵을 사먹거나, 쓰레기통을 뒤지는 것으로 감소시킬 수 있습니다.");
		System.out.println("       100이 되면 거지는 굶주림으로 쓰러집니다.(Bad Ending)");
		System.out.println();
		System.out.println("    3.스트레스 - 구걸을 하면 증가합니다. 상점에서 아메리카노를 사먹는 것으로 감소시킬 수 있습니다.");
		System.out.println("       100이 되면 거지는 스트레스 과다로 쓰러집니다.(Bad Ending)");
		System.out.println();
		System.out.println();
		System.out.println("**부가 스테이터스 - 레벨, 날렵한 손기술, 묵직한 손기술");
		System.out.println("    1.레벨 - 구걸을 5번 하면 1 증가합니다. 레벨이 오르면 구걸로 얻을 수 있는 돈의 양이 증가합니다.");
		System.out.println();
		System.out.println("    2.날렵한 손기술 - <배우기> 메뉴를 통해 올릴 수 있습니다.");
		System.out.println("       구걸을 할 때 이웃 거지의 돈을 슬쩍할 수 있습니다. 손기술이 높아지면 슬쩍할 수 있는 돈도 증가합니다.");
		System.out.println();
		System.out.println("    3.묵직한 손기술 - <배우기> 메뉴를 통해 올릴 수 있습니다.");
		System.out.println("       왕초를 쓰러뜨리려면 필요합니다.");
		System.out.println();
		System.out.println();
		System.out.println("**엔딩 - 게임의 트루 엔딩을 보려면 레벨 10(Max)이 되어야 합니다.");
		System.out.println("       스테이터스의 상태에 따라 고급 엔딩 / 중급 엔딩 / 초급 엔딩으로 나누어집니다.");
		System.out.println("       고급 엔딩을 노려보세요!");
		System.out.println();
	}

	public void start() {

		int selectNum = 0;

		while (true) {
			// 게임 시작 화면
			titlePrint();
			//선택
			selectNum = Util.readInt();

			if (selectNum == 1) {   //새 게임

				newGame(); 

			}
			
			else if (selectNum == 2) {   //지난 게임
				ArrayList<Beggar> array = bdao.beggarList();

				//지난 게임 리스트가 1개도 없으면 1번을 하라는 메세지 출력
				if (array.size() == 0) {
					System.out.println();
					System.out.println("불러올 게임이 없습니다.");
					System.out.println("우선 <새로 시작하기>에서 거지를 생성하세요.");
					System.out.println();
				}
				// 목록이 있으면 지난 게임 목록 출력
				else { 
					
					lastGameList();

					// 거지 선택
					Beggar b = selectBeggar();
					
					//목록에 없는 거지 번호를 입력하면 번호를 다시 확인하라는 메세지 출력
					if (b == null) {
						System.out.println("※ 지난 게임 목록에 저장된 번호가 아닙니다.\n번호를 다시 확인하세요.");
					}
					//번호를 맞게 입력하면 번호에 해당하는 캐릭터를 불러온다
					else { 
						int gameNum = 0;

						Util.sleep(500); //텀 두기
						
						// 캐릭터 불러오는 메세지
						System.out.println();
						System.out.println(" < " + b.getName() + " > 캐릭터를 불러옵니다.");
						System.out.println();

						Util.sleep(1000);

						do {

							// 게임 메인 화면 출력
							mainTitlePrint();

							gameNum = Util.readInt();

							switch (gameNum) {
							case 1: 
								status();
								break; // 상태 확인
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
								break; //거지 탈출
							case 6:
								gameSave(); //거지 탈출
								break;
							}
						} while (gameNum != 0);
					}
				}
			}
			
			else if (selectNum == 3) {
				help(); //프롤로그, 게임 설명 다시 보기
			}
			
			else if (selectNum == 0) {
				break; //게임 종료
				
			}
			// 1, 2, 3, 0 이외의 숫자를 입력하면
			else {
				System.out.println("※ 숫자를 다시 확인하세요.");
			}

		} // while 괄호
	}// start() 괄호

	// 거지 생성
	public void newGame() {

		System.out.println();
		System.out.println("거지의 새 이름을 입력해주세요!");
		name = sc.next();

		// 이름을 거지의 초기값과 함께 저장. 초기자금1000원, 허기50, 스트레스30, 레벨1, 싸움기술0, 도둑질기술0, 구걸횟수0, 왕초처치0, 엔딩 아직
		Beggar b = new Beggar(0, name, 1000, 50, 30, 1, 0, 0, 0, 0, ending);
		bdao.newBeggar(b);

		System.out.println("<게임 불러오기> 의 목록에서 생성된 거지를 확인하세요.");
		System.out.println();
	}

	// 거지 리스트 불러오기
	public void lastGameList() {
		
		ArrayList<Beggar> array = bdao.beggarList();

		System.out.println("-----------지난 게임 목록---------------------");
		System.out.println("번호           거지 이름           엔딩");
		for (Beggar b : array) { //번호과 거지 이름만 출력
			System.out.println(b.getNum() + "             " + b.getName() + "           " + b.getEnding());
		}
		System.out.println("-------------------------------------------");

	}

	//거지 선택하기
	public Beggar selectBeggar() {

		int beggarNum = Util.readInt();

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
			begCnt = b.getBegCnt();
			fightEnding = b.getFightEnding();
			ending = b.getEnding();
		}
		return b;
	}

	// 게임 저장
	public void gameSave() {
		
		while (true) {
			System.out.println("지금까지의 모든 플레이를 저장하시겠습니까? (y/n)");
			String yesNo = sc.next();
			if (yesNo.equals("y")) {
				Beggar b = new Beggar(num, name, money, hunger, tiredness, level, fight, thief, begCnt, fightEnding, ending);
				bdao.saveGame(b);
				break;
			} else if (yesNo.equals("n")) {
				break;
			} else {
				System.out.println("※ y/n 중 하나를 입력하세요.");
			}
		}
		
	}

	// 거지 상태 보기
	public void status() {
		if (tiredness >= 100 || hunger >= 100) {

			System.err.println("\n" + name + ", 그는 성실한 거지였습니다...\n\n삼가 고인의 명복을 빕니다...\n");

		} else {
			System.out.println("------------------------");
			System.out.println("   < " + name + "의 상태 >");
			System.out.println("가진 돈         " + money + " 원");
			System.out.println("허기             " + hunger);
			System.out.println("스트레스          " + tiredness);
			System.out.println("묵직한 손기술       " + fight);
			System.out.println("날렵한 손기술       " + thief);
			System.out.println("레벨             " + level);
			System.out.println("------------------------");


			if (hunger >= 90) {
				System.err.println("**거지가 아사하기 직전입니다. 빨리 무언가를 먹여주세요!");
			} else if (hunger >= 60) {
				System.out.println("**거지는 슬슬 배가 고픕니다.");
			}

			if (tiredness >= 90) {
				System.err.println("**거지가 스트레스로 인해 쓰러지기 직전입니다. 휴식이 필요합니다......");
			} else if (tiredness >= 60) {
				System.out.println("**거지가 스트레스를 많이 받고 있습니다..");
			}

			System.out.println();
		}
	}

	// 구걸하기
	public void beg() {

		// 죽은 상태면 할 수 없다.
		if (tiredness >= 100 || hunger >= 100) {

			System.err.println("그는 방금 생을 마감했습니다...\n귀신은 할 수 없습니다...");

		} else {

			int min = 1000 * level ;
			int max = 2000 * level;
			int random = (int) ((Math.random() * (max - min)) + min);

			System.out.println();
			String beg1 = name + "는(은) 열심히 구걸했다.          \n" + "짤그랑 짤그랑 돈 떨어지는 소리가 들린다......                 ";

			Util.typing(beg1);

			System.out.println();
			System.out.println();

			String beg2 = random + "원을 얻었습니다.\n";

			Util.typing(beg2);

			System.out.println("스트레스가 3 증가합니다.");
			System.out.println("허기가 3 증가합니다.\n");

			// 구걸 횟수 증가
			begCnt++;

			// 스테이터스 증감
			money += random;
			hunger += 3;
			tiredness += 3;

			//도둑질 기술이 10 이상이면, 이웃 거지의 돈을 훔칠 수 있다.
			if (thief >= 10) {
				
				Util.sleep(100);
				
				String thi = name + "는(은) 이웃 거지의 돈을 슬쩍했다.          \n" + 100*thief + "원을 획득했다.                 \n";

				Util.typing(thi);
				
				money += 100*thief;
			}
			
			
			// 구걸 횟수가 5의 배수가 되면 레벨이 오른다. 10까지만 올릴 수 있다.
			if (begCnt % 5 == 0 && level < 10) {
				level++;

				// 레벨업 메세지 출력
				System.out.println();
				System.out.println();
				String levelUp = "거지의 레벨이 " + level + "으로 올랐습니다!               \n" + "이제 더 많은 돈을 구걸할 수 있습니다.\n";

				Util.typingSlowly(levelUp);

			}
			System.out.println();
			
			// 구걸횟수가 4의 배수마다 왕초 출몰, 왕초를 쓰러뜨리면 왕초는 더이상 나타나지 않는다.
			if (begCnt % 4 == 0 && fightEnding == 0) {

				int stealMin = 3000 * level;
				int stealMax = 4000 * level;
				int stealMoney = (int) ((Math.random() * (stealMax - stealMin)) + stealMin);

				System.err.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
				System.err.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
				System.err.println("이 구역 왕초 출몰!");

				String steal = "거지가 힘들게 번 돈을 갈취합니다.\n" + "수중의 돈이 " + stealMoney + "원 감소합니다.\n";

				Util.typing(steal);

				Util.sleep(300);

				
				if (fight >= 80) { //싸움 기술이 높으면 왕초 처치
					String fitt = "묵직한 손기술로 왕초에게 반격했습니다!            \n"
								+"왕초를 쓰러뜨렸습니다!           \n"
								+"왕초의 전재산을 가져왔습니다!         \n"
								+"소지금이 100,000,000 증가합니다!        \n"
								+"**이제 구걸해도 왕초가 등장하지 않습니다.";

					Util.typingSlowly(fitt);
					
					System.out.println();
					
					money += 100000000;
					fightEnding++;
					
				}
				else { //싸움 기술이 없으면 
					
					String tired = "왕초에게 맞았습니다. 스트레스가 8 증가합니다..........         \n";

					Util.typing(tired);
					
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
			}

			// 피로도나 허기가 100이 되면 사망.
			if (ending != "귀신" && (tiredness >= 100 || hunger >= 100)) {
				System.err.println("***GAME OVER...***");
				System.err.println("거지가 생을 마감했습니다...");
				System.err.println("그의 넋이 이곳저곳을 배회하고 있습니다...");
				ending = "귀신";
			}

		}

	
	//배우기
	public void learn() {
		if (tiredness >= 100 || hunger >= 100) {
			System.err.println("그는 방금 생을 마감했습니다...\n귀신은 할 수 없습니다...");
		} 
		else {
			System.out.println();
			System.out.println("뒷골목에서 생존에 필요한 각종 기술을 배울 수 있습니다.");
			System.out.println("배울 기술을 선택하세요.");
			System.out.println("1.날렵한 손놀림       2.묵직한 손놀림");
			int num = Util.readInt();
			
			//도둑질을 배우면 다른 거지의 돈을 훔칠 수 있다
			if (num == 1) {
				System.out.println("소매치기에게 날렵한 손놀림을 배우시겠습니까? (수강료 : 10000원)");
				System.out.println("1.ㅇㅇ      2.ㄴㄴ");
				int yesNo = Util.readInt();
				
				if (yesNo == 1) {
					if (money < 10000) {
						System.err.println("돈이 부족합니다.");
					}
					else {
					System.out.println("기술을 배웠습니다.");
					System.out.println("당장이라도 슬쩍할 수 있을 것만 같습니다.");
					System.out.println("날렵한 손기술이 10 증가합니다.");
					money -= 10000;
					thief += 10;
					}
				}

			}
			
			//주먹질을 피로도가 훨씬 적게 줄어든다
			else if (num == 2) {
				System.out.println("깡패에게 묵직한 손놀림을 배우시겠습니까? (수강료 : 10000원)");
				System.out.println("1.ㅇㅇ      2.ㄴㄴ");
				int yesNo = Util.readInt();
				
				if (yesNo == 1) {
					if (money < 10000) {
						System.err.println("돈이 부족합니다.");
					}
					else {
					System.out.println("기술을 배웠습니다.");
					System.out.println("당장이라도 쓰러뜨릴 수 있을 것만 같습니다.");
					System.out.println("묵직한 손기술이 10 증가합니다.");
					money -= 10000;
					fight += 10;
					}
				}
			}
			
			else {
				System.out.println("1, 2번 중 하나를 선택하세요.");
			}
			
			
		}
		
		
		
		
	}

	public void newLife() {
		if (tiredness >= 100 || hunger >= 100) {
			System.err.println("그는 방금 생을 마감했습니다...\n귀신은 할 수 없습니다...");
		} else if (level != 10) {
			System.out.println();
			System.out.println("레벨 10이 되어야 거지 생활을 탈출할 수 있습니다. (현재 레벨 : " + level + ")");
			System.out.println("우선 <구걸하기>를 통해 거지의 레벨을 올리세요.");
			System.out.println();
		} else {
			System.out.println();
			String newLi = name + "는(은) 이제 길바닥 생활을 청산하려 합니다........               \n" + "거지의 앞날을 지켜보시겠습니까?\n";

			Util.typing(newLi);

			System.out.println("1.지켜보겠습니다      2.아직 시간이 필요합니다");

			int newLif = Util.readInt();

			if (newLif == 1) {
				
				//왕초를 쓰러뜨렸다면 고급 엔딩
					if (fightEnding == 1) {
					
					System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
					System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
					System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
					Util.sleep(300);
					String top = name + "는(은) 왕초를 쓰러뜨리고 이 구역의 새 왕초가 되었습니다......          \n"
								+ "그러나 " + name + "는(은) 그동안의 거지 생활을 청산하기로 했습니다.          \n\n\n"
								+ "왜냐하면, " + name + "는(은) 더이상 거지가 아니기 때문입니다!           \n"
								+ name + "는(은) 이제 무려 " + money + "원을 가진 부자입니다!                   \n"
								+ name + "이(가) 부자가 되도록 도와주셔서 감사합니다!                      \n\n\n\n\n";
					
					Util.typingSlowly(top);
					
					ending = "고급 엔딩";
					
					String end = "\nT H E E N D . . .☆\n";
					
					for (int i = 0; i < end.length(); i++) { 
						try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
				      System.out.print( end.charAt(i) );
				    }
					
					Beggar b = new Beggar(num, name, money, hunger, tiredness, level, fight, thief, begCnt, fightEnding, ending);
					bdao.saveGame(b);
					
					System.exit(0);
					
				}
				//왕초를 쓰러뜨리지 않았고, 돈이 50만원 이상이면 중급 엔딩
					else if (fightEnding==0 && money >= 500000) {
					
					System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
					System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
					System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
					Util.sleep(300);
					String middle = name + "는(은) 이제 꽤나 돈을 모은 것 같습니다.         \n"
									+ "보세요! 무려 " + money + "원이나 모았습니다.           \n"
									+ "이 정도면......... 소박한 인생을 시작할 수 있겠죠?            \n"
									+ name + "! 괜찮습니다. 돈이 인생의 전부는 아니니까요!             \n\n\n\n\n";
					
					Util.typingSlowly(middle);
					
					ending = "중급 엔딩";
					
					String end = "\nT H E E N D . . .☆\n";
					
					for (int i = 0; i < end.length(); i++) { 
						try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
				      System.out.print( end.charAt(i) );
				    }
					
					Beggar b = new Beggar(num, name, money, hunger, tiredness, level, fight, thief, begCnt, fightEnding, ending);
					bdao.saveGame(b);
					
					System.exit(0);
					
				}
				
				//이도 저도 아니면 초급 엔딩
				else {
					
					System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
					System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
					System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
					Util.sleep(300);
					String low = name + "는(은).............                   \n"
								+ "이때까지 " + money + "원을 벌었습니다만........             \n"
								+ "아무래도 거지 생활을 청산하기엔 조금 이른 듯합니다......           \n\n\n\n\n";
					
					Util.typingSlowly(low);
					
					ending = "초급 엔딩";
					
					String end = "\nT H E E N D . . .☆\n";
					
					for (int i = 0; i < end.length(); i++) { 
						try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
				      System.out.print( end.charAt(i) );
				    }
					
					Beggar b = new Beggar(num, name, money, hunger, tiredness, level, fight, thief, begCnt, fightEnding, ending);
					bdao.saveGame(b);
					
					System.exit(0);

					
				}

			}
			

		}

	}

	//구매하기
	public void shop() {
		
		if (tiredness >= 100 || hunger >= 100) {
			System.err.println("그는 방금 생을 마감했습니다...\n귀신은 할 수 없습니다...");
		}
		
		else {
			int menuNum;
			do {
				shopMenuPrint();

				menuNum = Util.readInt();

				switch (menuNum) {
				case 1: // 빵
					System.out.println("----------------------------");
					System.out.println("거지의 눈물로 젖은 소시지빵입니다.");
					System.out.println("구매하시겠습니까? (현재 소지한 금액 : " + money + "원)");
					System.out.println("1.ㅇㅇ      2.ㄴㄴ");

					int breadNum = Util.readInt();

					if (breadNum == 1) {
						System.out.println("몇 개를 구매하시겠습니까?");
						int bread = Util.readInt();
						if (bread <= 0) {
							System.out.println("1 이상의 수량을 입력하세요.");
							break;
						} else {

							if (money < 2000 * bread) {
								System.err.println("돈이 부족합니다.");
								break;
							} else {
								System.out.println("----------------------------");
								System.out.println("구매에 성공했습니다!");
								System.out.println("허기가 가시는 것이 느껴집니다.");
								System.out.println("허기가 " + 5 * bread + " 감소하였습니다.");
								System.out.println("----------------------------");
								if (hunger < 5*bread) {
									hunger = 0;
									money -= 2000 * bread;
								}
								else {
								hunger -= 5 * bread;
								money -= 2000 * bread;
								}
							}
						}
					}

					if (breadNum == 2) {
						break;
					}

					break;

				case 2: // 박카스
					System.out.println("----------------------------");
					System.out.println("스트레스가 확 풀릴 것 같은 뜨거운 아이스 아메리카노입니다.");
					System.out.println("구매하시겠습니까? (현재 소지한 금액 : " + money + "원)");
					System.out.println("1.ㅇㅇ      2.ㄴㄴ");

					int americanoNum = Util.readInt();

					if (americanoNum == 1) {
						System.out.println("몇 개를 구매하시겠습니까?");
						int americano = Util.readInt();
						if (americano <= 0) {
							System.out.println("1 이상의 수량을 입력하세요.");
							break;
						} else {

							if (money < 5000 * americano) {
								System.err.println("돈이 부족합니다.");
								break;
							} else {
								System.out.println("----------------------------");
								System.out.println("구매에 성공했습니다!");
								System.out.println("스트레스가 풀리는 것이 느껴집니다.");
								System.out.println("스트레스가 " + 10 * americano + " 감소하였습니다.");
								System.out.println("----------------------------");
								if (tiredness < 10*americano) {
									tiredness = 0;
									money -= 5000*americano;
								}
								else {
								tiredness -= 10 * americano;
								money -= 5000 * americano;
								}
							}
						}
					}

					break;

				case 3: // 쓰레기통 뒤지기
					System.out.println();
					String trash = "쓰레기통을 뒤적거려봅니다.                 \n";

					Util.typing(trash);

					Util.sleep(100);

					int a = Util.probability();
					
					
					if (a == 1) { //1이 나올 확률은 10%

						String trash2 = "대박! 만 원짜리 지폐를 발견했습니다!\n" + "소지금이 10000원 증가합니다.\n";

						Util.typing(trash2);

						money += 10000;

						// 텀 두기
						Util.sleep(100);

					}
					
					else if (a == 2) { //2가 나올 확률은 20%

						String trash3 = "쓰레기통에서 남은 식재료를 발견했습니다!\n" + "허기가 3 감소합니다.\n";

						Util.typing(trash3);

						if (hunger-3 < 0) {
							hunger = 0;
						}
						else {
							hunger -= 3;
						}
							

						// 텀 두기
						Util.sleep(100);

					}
					
					else if (a == 3) { // 3이 나올 확률은 70%

						String trash4 = "쓰레기통에는 쓰레기 뿐이었습니다...        \n";

						Util.typing(trash4);

					}

					System.out.println(); //띄우기

					break;

				}

			} while (menuNum != 0);

		}

	}

}
