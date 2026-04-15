package PokemonController;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import PokemonDAO.PokemonDAO;
import PokemonDTO.PokemonDTO;
import PokemonDTO.TrainerDTO;

public class ActCon {
	Scanner sc = new Scanner(System.in);
	PokemonDAO pdao = new PokemonDAO();
	PokemonDTO pdto = new PokemonDTO();
	ArrayList<PokemonDTO> t_pdto = new ArrayList<PokemonDTO>();
	static PokemonController.AsciiArt pconArt = new PokemonController.AsciiArt();
	static PokemonController.BattleCon pconBattle = new PokemonController.BattleCon();
	static PokemonController.MusicCon pconMusic = new PokemonController.MusicCon();
	int input;

	public void exitGame() {
	    // 게임 종료 전에 해야 할 일들을 작성합니다.
	    // ...

	    System.exit(0); // JVM을 종료합니다.
	}
	
	// 시작 시 프롤로그
	public void Start() {
		
		try {
			for (int i = 0; i < 1; i++) {

				System.out.println("포켓몬마스터가 되기 위해 모험을 떠난 '너!'와 친구들, 긴 여정을 마치고 환상의 포켓몬과의 최종결전을 앞두고 있다.");
				Thread.sleep(1050);
				System.out.println("결전에 앞서 혹독하고 처절한 트레이닝을 계획하는데...");
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	// 오박사님 등장시 대사
	public void Doctorate() {
		try {
			for (int i = 0; i < 1; i++) {
				pconArt.Okid();
				System.out.println("그동안 고생많았다 이제 근본중에 근본인 그 녀석만 남았구나! 그간 함께했던 수많은 에이스포켓몬중에서 3마리를 엄선했단다.");
				Thread.sleep(1050);
				System.out.println("마지막으로 너와 함께할 포켓몬을 딱 1마리만 골라보렴");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	

	public void act(String id) {
		pconMusic.P(6);
		while (true) {
			
			t_pdto = pdao.state(id); //진화한 애들을 가진 트레이너 로그인시 선택지 추가함
			if (t_pdto.get(0).getPNAME().equals("라이츄")) {
				System.out.print("1.채찍질  2.놀아주기  3.잠자기  4.포켓몬 상태 확인  5.최종배틀  [선택]>>");
				input = sc.nextInt();

			} else if (t_pdto.get(0).getPNAME().equals("님피아")) {
				System.out.print("1.채찍질  2.놀아주기  3.잠자기  4.포켓몬 상태 확인  5.최종배틀  [선택]>>");
				input = sc.nextInt();

			} else if (t_pdto.get(0).getPNAME().equals("베이리프")) {
				System.out.print("1.채찍질  2.놀아주기  3.잠자기  4.포켓몬 상태 확인  5.최종배틀  [선택]>>");
				input = sc.nextInt();

			} else {
				System.out.println("행동을 선택해주세요");
				System.out.print("1.채찍질  2.놀아주기  3.잠자기  4.포켓몬 상태 확인   [선택]>>");
				input = sc.nextInt();

			}

			switch (input) {
			case 1:
				t_pdto = pdao.state(id);
				if (t_pdto.get(0).getPNAME().equals("라이츄")) {
					System.out.println("더이상 성장할 수 없습니다.");
					System.out.println("아무 키나 입력하시면 메인화면으로 이동합니다.");
					input = sc.nextInt();
					main();
				} else if (t_pdto.get(0).getPNAME().equals("님피아")) {
					System.out.println("더이상 성장할 수 없습니다.");
					System.out.println("아무 키나 입력하시면 메인화면으로 이동합니다.");
					input = sc.nextInt();
					main();
				} else if (t_pdto.get(0).getPNAME().equals("베이리프")) {
					System.out.println("더이상 성장할 수 없습니다.");
					System.out.println("아무 키나 입력하시면 메인화면으로 이동합니다.");
					input = sc.nextInt();
					main();

				}
				if (t_pdto.get(0).getT_ID().equals(id)) {
					if (t_pdto.get(0).getHP() < 30) {

						System.out.println("체력이 부족합니다.");
					} else if (t_pdto.get(0).getT_ID().equals(id) && t_pdto.get(0).getPNAME().equals("피카츄")) {
						pconArt.pikachae();
						pdao.Whip(id);
						System.out.println("===============================================");
						System.out.println(t_pdto.get(0).getPNAME() + "은(는) 트레이너를 위해 견뎌냈다! ");
						System.out.println("공격력이 올랐다! 경험치가 올랐다! 체력이 30 깎였다...");
						System.out.println("===============================================");
						System.out.println();

					} else if (t_pdto.get(0).getT_ID().equals(id) && t_pdto.get(0).getPNAME().equals("이브이")) {
						pconArt.Eeveechae();
						pdao.Whip(id);

						System.out.println("===============================================");
						System.out.println(t_pdto.get(0).getPNAME() + "은(는) 트레이너를 위해 견뎌냈다! ");
						System.out.println("공격력이 올랐다! 경험치가 올랐다! 체력이 30 깎였다...");
						System.out.println("===============================================");

						System.out.println();

					} else if (t_pdto.get(0).getT_ID().equals(id) && t_pdto.get(0).getPNAME().equals("치코리타")) {
						pconArt.Chikochae();
						pdao.Whip(id);

						System.out.println("===============================================");
						System.out.println(t_pdto.get(0).getPNAME() + "은(는) 트레이너를 위해 견뎌냈다! ");
						System.out.println("공격력이 올랐다! 경험치가 올랐다! 체력이 30 깎였다...");
						System.out.println("===============================================");

						System.out.println();
					}
				}

				if (t_pdto.get(0).getT_ID().equals(id)) {
					if (t_pdto.get(0).getLOVE() >= 20 && t_pdto.get(0).getEXP() >= 20 && t_pdto.get(0).getATK() >= 50) {
						// 진화 메소드 실행 (스토리용 출력문 있어야함)
						// 만약 노래가 재생중이라면 노래를 멈추고 진화 노래를 시작한다

						pconMusic.P(2);
						System.out.println("오잉?! [ " + t_pdto.get(0).getPNAME() + " ]의 상태가?");

						if (t_pdto.get(0).getPNAME().equals("피카츄")) {
							pdao.naming(id, "라이츄");
							t_pdto = pdao.state(id);
							pconArt.Rai();
							System.out.println("피카츄는 [ " + t_pdto.get(0).getPNAME() + " ]로 진화했다!");
							System.out.println();

							System.out.println("이 다음은 최종배틀이 진행됩니다.");
							System.out.println("현재 포켓몬의 상태를 확인하시고 진행하세요");
							while (true) {
								System.out.println("1.포켓몬센터  2.포켓몬상태확인  3.배틀진행  4.메인화면  [선택]>> ");
								input = sc.nextInt();
								switch (input) {
								case 1:
									pdao.Sleep(id);
									System.out.println("체력이 모두 회복 되었다 !");
									System.out.println();
									break;

								case 2:
									t_pdto = pdao.state(id);
									for (PokemonDTO pdto : t_pdto) {
										if (pdto.getT_ID().equals(id)) {
											System.out.println(
													"==============================================================================================");
									
											System.out.printf("%8s\t%8s\t%8s\t%8s\t%8s\t%8s\n", "트레이너명", "HP", "ATK",
													"LOVE", "EXP", "포켓몬이름");

											System.out.printf("%8s\t%8d\t%8d\t%8d\t%8d\t%8s\n", pdto.getT_ID(),
													pdto.getHP(), pdto.getATK(), pdto.getLOVE(), pdto.getEXP(),
													pdto.getPNAME());
											System.out.println(
													"==============================================================================================");
										}
									}
									break;
								case 3:
									pconBattle.Battle(id);
									break;
								case 4:
									main();
									break;

								default:
									System.out.println("잘못된 입력입니다. 다시 입력하세요.");
									System.out.println();
									break;
								}
							}

						} else if (t_pdto.get(0).getPNAME().equals("이브이")) {
							pdao.naming(id, "님피아");
							t_pdto = pdao.state(id);
							pconArt.Nim();
							System.out.println("이브이는 [ " + t_pdto.get(0).getPNAME() + " ]로 진화했다!");
							System.out.println();
							System.out.println("이 다음은 최종배틀이 진행됩니다.");
							System.out.println("현재 포켓몬의 상태를 확인하시고 진행하세요");
							while (true) {
								System.out.println("1.포켓몬센터  2.포켓몬상태확인  3.배틀진행  4.메인화면  [선택]>> ");
								input = sc.nextInt();
								switch (input) {
								case 1:
									pdao.Sleep(id);
									System.out.println("체력이 모두 회복 되었다 !");
									System.out.println();
									break;

								case 2:
									t_pdto = pdao.state(id);
									for (PokemonDTO pdto : t_pdto) {
										if (pdto.getT_ID().equals(id)) {
											System.out.println(
													"==============================================================================================");
									
											System.out.printf("%8s\t%8s\t%8s\t%8s\t%8s\t%8s\n", "트레이너명", "HP", "ATK",
													"LOVE", "EXP", "포켓몬이름");

											System.out.printf("%8s\t%8d\t%8d\t%8d\t%8d\t%8s\n", pdto.getT_ID(),
													pdto.getHP(), pdto.getATK(), pdto.getLOVE(), pdto.getEXP(),
													pdto.getPNAME());
											System.out.println(
													"==============================================================================================");
										}
									}
									break;
								case 3:
									pconBattle.Battle(id);
									break;
								case 4:
									main();
									break;

								default:
									System.out.println("잘못된 입력입니다. 다시 입력하세요.");
									System.out.println();
									break;
								}
							}

						} else if (t_pdto.get(0).getPNAME().equals("치코리타")) {
							pdao.naming(id, "베이리프");
							t_pdto = pdao.state(id);
							pconArt.Bay();
							System.out.println("치코리타는 [ " + t_pdto.get(0).getPNAME() + " ]로 진화했다!");
							System.out.println();
							System.out.println("이 다음은 최종배틀이 진행됩니다.");
							System.out.println("현재 포켓몬의 상태를 확인하시고 진행하세요");
							while (true) {
								System.out.println("1.포켓몬센터  2.포켓몬상태확인  3.배틀진행  4.메인화면  [선택]>> ");
								input = sc.nextInt();
								switch (input) {
								case 1:
									pdao.Sleep(id);
									System.out.println("체력이 모두 회복 되었다 !");
									System.out.println();
									break;

								case 2:
									t_pdto = pdao.state(id);
									for (PokemonDTO pdto : t_pdto) {
										if (pdto.getT_ID().equals(id)) {
											System.out.println(
													"==============================================================================================");
									
											System.out.printf("%8s\t%8s\t%8s\t%8s\t%8s\t%8s\n", "트레이너명", "HP", "ATK",
													"LOVE", "EXP", "포켓몬이름");

											System.out.printf("%8s\t%8d\t%8d\t%8d\t%8d\t%8s\n", pdto.getT_ID(),
													pdto.getHP(), pdto.getATK(), pdto.getLOVE(), pdto.getEXP(),
													pdto.getPNAME());
											System.out.println(
													"==============================================================================================");
										}
									}
									break;
								case 3:
									pconBattle.Battle(id);
									break;
								case 4:
									main();
									break;

								default:
									System.out.println("잘못된 입력입니다. 다시 입력하세요.");
									System.out.println();
									break;
								}
							}
						}
					} else {
						// 충족하지 못하면 act 첫줄부터 반복하게 비워두기
					}
				}
//					// 만약 HP가 30미만이라면
//					// 1번,2번 선택시에 HP가 부족합니다
//					// act 첫줄부터 반복하게 비워두기
				//

				break;
			case 2:
				t_pdto = pdao.state(id);
				if (t_pdto.get(0).getPNAME().equals("라이츄")) {
					System.out.println("더이상 성장할 수 없습니다.");
					System.out.println("아무 키나 입력하시면 메인화면으로 이동합니다.");
					input = sc.nextInt();
					main();
				} else if (t_pdto.get(0).getPNAME().equals("님피아")) {
					System.out.println("더이상 성장할 수 없습니다.");
					System.out.println("아무 키나 입력하시면 메인화면으로 이동합니다.");
					input = sc.nextInt();
					main();
				} else if (t_pdto.get(0).getPNAME().equals("베이리프")) {
					System.out.println("더이상 성장할 수 없습니다.");
					System.out.println("아무 키나 입력하시면 메인화면으로 이동합니다.");
					input = sc.nextInt();
					main();

				}

				if (t_pdto.get(0).getT_ID().equals(id)) {
					if (t_pdto.get(0).getHP() < 30) {

						System.out.println("체력이 부족합니다.");
					} else if (t_pdto.get(0).getT_ID().equals(id) && t_pdto.get(0).getPNAME().equals("피카츄")) {
						pconArt.pikaplay();
						pdao.Play(id);
						System.out.println("===============================================");
						System.out.println("하하하하하하하~호호호호호호~흐헤흐헤흐히흐히히히히~");
						System.out.println("친밀도가 올랐다! 경험치가 올랐다! 체력이 30 깎였다...");
						System.out.println("===============================================");
						System.out.println();

					} else if (t_pdto.get(0).getT_ID().equals(id) && t_pdto.get(0).getPNAME().equals("이브이")) {
						pconArt.Eeveeplay();
						pdao.Play(id);
						System.out.println("===============================================");
						System.out.println("하하하하하하하~호호호호호호~흐헤흐헤흐히흐히히히히~");
						System.out.println("친밀도가 올랐다! 경험치가 올랐다! 체력이 30 깎였다...");
						System.out.println("===============================================");
						System.out.println();

					} else if (t_pdto.get(0).getT_ID().equals(id) && t_pdto.get(0).getPNAME().equals("치코리타")) {
						pconArt.Chikoplay();
						pdao.Play(id);
						System.out.println("===============================================");
						System.out.println("하하하하하하하~호호호호호호~흐헤흐헤흐히흐히히히히~");
						System.out.println("친밀도가 올랐다! 경험치가 올랐다! 체력이 30 깎였다...");
						System.out.println("===============================================");
						System.out.println();

					}
				}

				if (t_pdto.get(0).getT_ID().equals(id)) {
					if (t_pdto.get(0).getLOVE() >= 20 && t_pdto.get(0).getEXP() >= 20 && t_pdto.get(0).getATK() >= 50) {
						// 진화 메소드 실행 (스토리용 출력문 있어야함)
						// 만약 노래가 재생중이라면 노래를 멈추고 진화 노래를 시작한다

						pconMusic.P(2);
						System.out.println("오잉?! [ " + t_pdto.get(0).getPNAME() + " ]의 상태가?");

						if (t_pdto.get(0).getPNAME().equals("피카츄")) {
							pdao.naming(id, "라이츄");
							t_pdto = pdao.state(id);
							pconArt.Rai();
							System.out.println("피카츄는 [ " + t_pdto.get(0).getPNAME() + " ]로 진화했다!");
							System.out.println();
							System.out.println("이 다음은 최종배틀이 진행됩니다.");
							System.out.println("현재 포켓몬의 상태를 확인하시고 진행하세요");
							while(true) {
								System.out.println("1.포켓몬센터  2.포켓몬상태확인  3.배틀진행  4.메인화면  [선택]>> ");
								input = sc.nextInt();
								switch (input) {
								case 1:
									pdao.Sleep(id);
									System.out.println("체력이 모두 회복 되었다 !");
									System.out.println();
									break;
									
								case 2:
									t_pdto = pdao.state(id);
									for (PokemonDTO pdto : t_pdto) {
										if (pdto.getT_ID().equals(id)) {
											System.out.println(
													"==============================================================================================");
									
											System.out.printf("%8s\t%8s\t%8s\t%8s\t%8s\t%8s\n", "트레이너명", "HP", "ATK",
													"LOVE", "EXP", "포켓몬이름");

											System.out.printf("%8s\t%8d\t%8d\t%8d\t%8d\t%8s\n", pdto.getT_ID(),
													pdto.getHP(), pdto.getATK(), pdto.getLOVE(), pdto.getEXP(),
													pdto.getPNAME());
											System.out.println(
													"==============================================================================================");
										}
									}
									break;
								case 3:
									pconBattle.Battle(id);
									break;
								case 4:
									main();
									break;
									
								default:
									System.out.println("잘못된 입력입니다. 다시 입력하세요.");
									System.out.println();
									break;
								}
							}

						} else if (t_pdto.get(0).getPNAME().equals("이브이")) {
							pdao.naming(id, "님피아");
							t_pdto = pdao.state(id);
							pconArt.Nim();
							System.out.println("이브이는 [ " + t_pdto.get(0).getPNAME() + " ]로 진화했다!");
							System.out.println();
							System.out.println("이 다음은 최종배틀이 진행됩니다.");
							System.out.println("현재 포켓몬의 상태를 확인하시고 진행하세요");
							while(true) {
								System.out.println("1.포켓몬센터  2.포켓몬상태확인  3.배틀진행  4.메인화면  [선택]>> ");
								input = sc.nextInt();
								switch (input) {
								case 1:
									pdao.Sleep(id);
									System.out.println("체력이 모두 회복 되었다 !");
									System.out.println();
									break;
									
								case 2:
									t_pdto = pdao.state(id);
									for (PokemonDTO pdto : t_pdto) {
										if (pdto.getT_ID().equals(id)) {
											System.out.println(
													"==============================================================================================");
									
											System.out.printf("%8s\t%8s\t%8s\t%8s\t%8s\t%8s\n", "트레이너명", "HP", "ATK",
													"LOVE", "EXP", "포켓몬이름");

											System.out.printf("%8s\t%8d\t%8d\t%8d\t%8d\t%8s\n", pdto.getT_ID(),
													pdto.getHP(), pdto.getATK(), pdto.getLOVE(), pdto.getEXP(),
													pdto.getPNAME());
											System.out.println(
													"==============================================================================================");
										}
									}
									break;
								case 3:
									pconBattle.Battle(id);
									break;
								case 4:
									main();
									break;
									
								default:
									System.out.println("잘못된 입력입니다. 다시 입력하세요.");
									System.out.println();
									break;
								}
							}
							// 배틀 메소드 실행
						} else if (t_pdto.get(0).getPNAME().equals("치코리타")) {
							pdao.naming(id, "베이리프");
							t_pdto = pdao.state(id);
							pconArt.Bay();
							System.out.println("치코리타는 [ " + t_pdto.get(0).getPNAME() + " ]로 진화했다!");
							System.out.println();
							System.out.println("이 다음은 최종배틀이 진행됩니다.");
							System.out.println("현재 포켓몬의 상태를 확인하시고 진행하세요");
							while(true) {
								System.out.println("1.포켓몬센터  2.포켓몬상태확인  3.배틀진행  4.메인화면  [선택]>> ");
								input = sc.nextInt();
								switch (input) {
								case 1:
									pdao.Sleep(id);
									System.out.println("체력이 모두 회복 되었다 !");
									System.out.println();
									break;
									
								case 2:
									t_pdto = pdao.state(id);
									for (PokemonDTO pdto : t_pdto) {
										if (pdto.getT_ID().equals(id)) {
											System.out.println(
													"==============================================================================================");
									
											System.out.printf("%8s\t%8s\t%8s\t%8s\t%8s\t%8s\n", "트레이너명", "HP", "ATK",
													"LOVE", "EXP", "포켓몬이름");

											System.out.printf("%8s\t%8d\t%8d\t%8d\t%8d\t%8s\n", pdto.getT_ID(),
													pdto.getHP(), pdto.getATK(), pdto.getLOVE(), pdto.getEXP(),
													pdto.getPNAME());
											System.out.println(
													"==============================================================================================");
										}
									}
									break;
								case 3:
									pconBattle.Battle(id);
									break;
								case 4:
									main();
									break;
									
								default:
									System.out.println("잘못된 입력입니다. 다시 입력하세요.");
									System.out.println();
									break;
								}
							}
							// 배틀 메소드 실행
						}
					} else {
						// 충족하지 못하면 act 첫줄부터 반복하게 비워두기
					}
				}

				break;
			case 3:
				t_pdto = pdao.state(id);
				pdao.Sleep(id);
				if (t_pdto.get(0).getPNAME().equals("피카츄")) {
					pconArt.pikasleep();
					System.out.println("===============================================");
					System.out.println("우리 [ " + t_pdto.get(0).getPNAME() + " ]은(는) 자는 모습이 제일 귀엽당><");
					System.out.println("체력이 전부 회복되었다! 경험치가 올랐다!");
					System.out.println("===============================================");
					System.out.println();

				} else if (t_pdto.get(0).getPNAME().equals("이브이")) {
					pconArt.Eeveesleep();
					System.out.println("===============================================");
					System.out.println("우리 [ " + t_pdto.get(0).getPNAME() + " ]은(는) 자는 모습이 제일 귀엽당><");
					System.out.println("체력이 전부 회복되었다! 경험치가 올랐다!");
					System.out.println("===============================================");
					System.out.println();

				} else if (t_pdto.get(0).getPNAME().equals("치코리타")) {
					pconArt.Chikosleep();
					System.out.println("===============================================");
					System.out.println("우리 [ " + t_pdto.get(0).getPNAME() + " ]은(는) 자는 모습이 제일 귀엽당><");
					System.out.println("체력이 전부 회복되었다! 경험치가 올랐다!");
					System.out.println("===============================================");
					System.out.println();

				}
				if (t_pdto.get(0).getPNAME().equals("라이츄")) {
					System.out.println();
					System.out.println("===============================================");
					System.out.println("우리 [ " + t_pdto.get(0).getPNAME() + " ]은(는) 자는 모습이 제일 귀엽당><");
					System.out.println("체력이 전부 회복되었다! 경험치가 올랐다!");
					System.out.println("===============================================");
					System.out.println();

				} else if (t_pdto.get(0).getPNAME().equals("님피아")) {
					System.out.println();
					System.out.println("===============================================");
					System.out.println("우리 [ " + t_pdto.get(0).getPNAME() + " ]은(는) 자는 모습이 제일 귀엽당><");
					System.out.println("체력이 전부 회복되었다! 경험치가 올랐다!");
					System.out.println("===============================================");
					System.out.println();

				} else if (t_pdto.get(0).getPNAME().equals("베이리프")) {
					System.out.println();
					System.out.println("===============================================");
					System.out.println("우리 [ " + t_pdto.get(0).getPNAME() + " ]은(는) 자는 모습이 제일 귀엽당><");
					System.out.println("체력이 전부 회복되었다! 경험치가 올랐다!");
					System.out.println("===============================================");
					System.out.println();

				}

				break;

			// 포켓몬 상태
			// select 메소드로 불러와서
			// 이름 , hp , atk , love , exp만 출력
			case 4:
				t_pdto = pdao.state(id);
				for (PokemonDTO pdto : t_pdto) {
					if (pdto.getT_ID().equals(id)) {
						System.out.println(
								"==============================================================================================");
				
						System.out.printf("%8s\t%8s\t%8s\t%8s\t%8s\t%8s\n", "트레이너명", "HP", "ATK",
								"LOVE", "EXP", "포켓몬이름");

						System.out.printf("%8s\t%8d\t%8d\t%8d\t%8d\t%8s\n", pdto.getT_ID(),
								pdto.getHP(), pdto.getATK(), pdto.getLOVE(), pdto.getEXP(),
								pdto.getPNAME());
						System.out.println(
								"==============================================================================================");
					}
				}
				break;
			case 5:
				System.out.println("배틀을 시작합니다.");
				System.out.println();
				pconBattle.Battle(id);

			default:
				System.out.println("잘못 입력하셨습니다. 다시입력해주세요.");
				System.out.println();
				break;

			}

		}

		// .getLove , .getExp 로 대조해야할 것 같은데 어떻게 로직 짜야하는지 조금만 더 생각해봄
		// ArrayList로 담아야할것같다

	}

	// 메인페이지
	public void main() {
		pconMusic.S();
		pconMusic.P(5);
		int input = 0;

		while (input != 3) {
			pconArt.Progo();
			System.out.println();
			System.out.print("1.회원가입  2.로그인   3.종료    [선택]>> ");
			
			
		    try {
		        input = sc.nextInt();
		    } catch (InputMismatchException e) {
		        // 정수가 아닌 입력을 받았을 경우 실행되는 블록
		        System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
		        System.out.println();
		        sc.nextLine(); // 입력 버퍼를 비워줍니다.
		        continue; // 다시 while 루프의 처음으로 돌아갑니다.
		    }

			switch (input) {
			case 1:
				Start();
				System.out.print("당신의 [이름]을 알려주세요 >> ");
				String id = sc.next();
				// 중복 체크 기능 넣고싶은데 어케함

				System.out.print("비밀번호  >> ");
				String pw = sc.next();
				Doctorate();
				System.out.println();

				int pcode = 0;

				while (pcode != 3) {

					pconArt.pika();
					pconArt.Eevee();
					pconArt.Chiko(); // 포켓몬 그림 메소드 불러와주세요
					System.out.print("1.피카츄  2.이브이  3.치코리타   [선택]>> ");
					pcode = sc.nextInt();
					switch (pcode) {
					case 1:
						pdao.insertTrainer(id, pw, pcode);
						System.out.println("게임을 시작합니다");
						System.out.println();
						act(id);
						// gameStart 메소드
						break;

					case 2:
						pdao.insertTrainer(id, pw, pcode);
						System.out.println("게임을 시작합니다");
						System.out.println();
						act(id);
						// gameStart 메소드
						break;

					case 3:
						pdao.insertTrainer(id, pw, pcode);
						System.out.println("게임을 시작합니다");
						System.out.println();
						act(id);
						// gameStart 메소드
						break;

					default:
						System.out.println("잘못 입력하셨습니다.");
						System.out.println("포켓몬 선택창으로 이동합니다.");
						System.out.println();
						break;

					}

				}

				break;
			case 2:
				pconMusic.P(7);
				System.out.println("로그인 선택하셨습니다.");
				System.out.print("이름 입력 >> ");
				id = sc.next();
				System.out.print("비밀번호 입력 >> ");
				pw = sc.next();
				// 로그인 DB 가져오는 메소드 (SELECT)
				TrainerDTO t_pdto = pdao.login(id, pw);
				if (t_pdto != null) {
					System.out.println("로그인 성공");
					System.out.println();
					ArrayList<PokemonDTO> poke_list = pdao.state(t_pdto.getT_id());

					act(poke_list.get(0).getT_ID());

				} else {
					System.out.println("로그인 정보를 다시 확인해주세요. 메인화면으로 이동합니다.");
					System.out.println();
				}
				break;
			case 3:
				System.out.println("게임을 종료합니다.");
				exitGame();
				break;
			default:
				System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
				System.out.println();

				break;

			}
		}

	}

}
