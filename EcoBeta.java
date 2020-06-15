import java.util.Scanner;

public class EcoBeta{
	
	private static int round = 1;
	private int roundsWon = 0;
	private int roundsLost = 0;
	private static int enemyLossBonus = 1;
	private static int enemyMoney = 4000;
	private static boolean enemyPreviousRoundWon = true;
	
	public static void CTSide() {
		
		Scanner in = new Scanner(System.in);
		
		while (round <= 15) {
			System.out.println("Round " + round);
			System.out.println("Enemy Money: $" + enemyMoney);
			System.out.println("Enemy Average: $" + enemyMoney/5);
			
			int roundSpent = moneySpent();
			enemyMoney = enemyMoney - roundSpent;
			
			int roundGot = moneyGot();
			enemyMoney = enemyMoney + roundGot;
			
			System.out.println("Did you Win(1) or Lose(2) round?");
			int winlose = in.nextInt();
			in.nextLine();
			
			if(winlose == 1) {
				
				enemyPreviousRoundWon = false;
				
				if(enemyLossBonus == 0) {
					enemyMoney = enemyMoney + 7000;
				} else if(enemyLossBonus == 1) {
					enemyMoney = enemyMoney + 9500;
				} else if(enemyLossBonus == 2) {
					enemyMoney = enemyMoney + 12000;
				} else if(enemyLossBonus == 3) {
					enemyMoney = enemyMoney + 14500;
				} else if(enemyLossBonus == 4) {
					enemyMoney = enemyMoney + 17000;
				}
				
				System.out.println("Did the enemy plant the bomb? Y/N");
				String didPlant = in.nextLine();
				if(didPlant.equalsIgnoreCase("y")) {
					enemyMoney = enemyMoney + 4000;
				} else {
					System.out.println("Did you win by running down the time? Y/N");
					String didTime = in.nextLine();
					if(didTime.equalsIgnoreCase("y")) {
						System.out.println("How many players did you kill after time? 0-5");
						int howManyAfter = in.nextInt();
						in.nextLine();
						if(enemyLossBonus == 0) {
							enemyMoney = enemyMoney - (1400*howManyAfter);
						} else if(enemyLossBonus == 1) {
							enemyMoney = enemyMoney - (1900*howManyAfter);
						} else if(enemyLossBonus == 2) {
							enemyMoney = enemyMoney - (2400*howManyAfter);
						} else if(enemyLossBonus == 3) {
							enemyMoney = enemyMoney - (2900*howManyAfter);
						} else if(enemyLossBonus == 4) {
							enemyMoney = enemyMoney - (3400*howManyAfter);
						}
					}
				}
				
				if(enemyLossBonus < 5) {
					enemyLossBonus++;
				}
				
			} else if(winlose == 2) {
				if (enemyPreviousRoundWon == false) {
					if (enemyLossBonus == 1) {
						enemyLossBonus--;
					} else if (enemyLossBonus>1) {
						enemyLossBonus = enemyLossBonus - 2;
					}
				} else if (enemyLossBonus>0) {
					enemyLossBonus--;
				}
				
				enemyPreviousRoundWon = true;
						
				System.out.println("Enemy won by Bomb Detonation(1), Team Elimenation(2)");
				int howWin = in.nextInt();
				in.nextLine();
				if(howWin == 1) {
					enemyMoney = enemyMoney + 17500;
				} else if(howWin == 2) {
					enemyMoney = enemyMoney + 16250;
					System.out.println("Did the enemy plant the bomb? Y/N");
					String didPlant2 = in.nextLine();
					if(didPlant2.equalsIgnoreCase("y")) {
						enemyMoney = enemyMoney + 1500;
					}
				}
				
			}
			
			round++;
		}
	}
	
	public static void TSide() {
		Scanner in = new Scanner(System.in);
		
		while (round <= 15) {
			System.out.println("Round " + round);
			System.out.println("Enemy Money: $" + enemyMoney);
			System.out.println("Enemy Average: $" + enemyMoney/5);
			
			int roundSpent = moneySpent();
			enemyMoney = enemyMoney - roundSpent;
			
			int roundGot = moneyGot();
			enemyMoney = enemyMoney + roundGot;
				
			System.out.println("Did you Win(1) or Lose(2) round?");
			int winlose = in.nextInt();
			in.nextLine();
				
			if(winlose == 1) {
				
				enemyPreviousRoundWon = false;
				
				if(enemyLossBonus == 0) {
					enemyMoney = enemyMoney + 7000;
				} else if(enemyLossBonus == 1) {
					enemyMoney = enemyMoney + 9500;
				} else if(enemyLossBonus == 2) {
					enemyMoney = enemyMoney + 12000;
				} else if(enemyLossBonus == 3) {
					enemyMoney = enemyMoney + 14500;
				} else if(enemyLossBonus == 4) {
					enemyMoney = enemyMoney + 17000;
				}
				if(enemyLossBonus < 5) {
					enemyLossBonus++;
				}
			} else if(winlose == 2) {
				if (enemyPreviousRoundWon == false) {
					if (enemyLossBonus == 1) {
						enemyLossBonus--;
					} else if (enemyLossBonus>1) {
						enemyLossBonus = enemyLossBonus - 2;
					}
				} else if (enemyLossBonus>0) {
					enemyLossBonus--;
				}
				
				enemyPreviousRoundWon = true;
				
				System.out.println("Enemy won by Bomb Defusal(1), Team Elimenation or Running Down The Time(2)");
				int howWin = in.nextInt();
				in.nextLine();
				if(howWin == 1) {
					enemyMoney = enemyMoney + 18000;
				} else if(howWin == 2) {
					enemyMoney = enemyMoney + 16250;
				}
					
			}
				
			round++;
		}
	}
	
	public static int moneySpent() {
		
		Scanner in = new Scanner(System.in);
		int ak47 = 2700;
		int m4a4 = 3100;
		int m4a1 = 2900;
		int kevlar = 650;
		int helmet = 1000;
		int awp = 4750;
		
		System.out.println("\n" + "Input enemy buys (Example : 1133333 = 2 kevlar and 5 AKs)");
		System.out.println("Kevlar(1)");
		System.out.println("Kev + Helmet(2)");
		System.out.println("AK-47(3)");
		System.out.println("M4A4(4)");
		System.out.println("M4A1-S(5)");
		System.out.println("AWP(6)");
		
		
		String enemyBuys = in.nextLine();
		
		int[] weapon = new int[enemyBuys.length()];
		int temp = 0;
		for(int i = 0; i < enemyBuys.length(); i++) {
	        weapon[i] = Integer.parseInt(enemyBuys.charAt(i)+"");
	         
	        if(weapon[i] == 1) {
	        	temp = temp + kevlar;
	        } else if(weapon[i] == 2) {
	        	temp = temp + helmet;
	        } else if(weapon[i] == 3) {
	        	temp = temp + ak47;
	        } else if(weapon[i] == 4) {
	        	temp = temp + m4a4;
	        } else if(weapon[i] == 5) {
	        	temp = temp + m4a1;
	        } else if(weapon[i] == 6) {
	        	temp = temp + awp;
	        }
	     }
		
		return temp;
	}
	
public static int moneyGot() {
		
		Scanner in = new Scanner(System.in);
		
		int riflePistolNade = 300;
		int awp = 100;
		int smg = 600;
		int shotgun = 900;
		int knife = 1500;
		
		System.out.println("\n" + "Input enemy kills (Example : 11333 = 2 Rifle kills and 3 SMG kills)");
		System.out.println("Rifle/Pistol/Nade/P90(1)");
		System.out.println("AWP,CZ-75(2)");
		System.out.println("SMG(3)");
		System.out.println("Shotgun(4)");
		System.out.println("Knife(5)");
		
		
		String enemyBuys = in.nextLine();
		
		int[] weapon = new int[enemyBuys.length()];
		int temp = 0;
		for(int i = 0; i < enemyBuys.length(); i++) {
	        weapon[i] = Integer.parseInt(enemyBuys.charAt(i)+"");
	         
	        if(weapon[i] == 1) {
	        	temp = temp + riflePistolNade;
	        } else if(weapon[i] == 2) {
	        	temp = temp + awp;
	        } else if(weapon[i] == 3) {
	        	temp = temp + smg;
	        } else if(weapon[i] == 4) {
	        	temp = temp + shotgun;
	        } else if(weapon[i] == 5) {
	        	temp = temp + knife;
	        }
	     }
		
		return temp;
	}
	
	public static void main(String[] args){
		
		System.out.println("\n" + "CSGO Economy Calculator" + "\n");

		Scanner in = new Scanner(System.in);

		while (true) {
			System.out.println("Are you CT or T");
			String side = in.nextLine();
			
			if(side.equalsIgnoreCase("CT")) {
				CTSide();
				System.out.println("\n" + "Switching Sides" + "\n");
				TSide();
			} else if(side.equalsIgnoreCase("T")) {
				TSide();
				System.out.println("\n" + "Switching Sides" + "\n");
				CTSide();
			}
		
		}
	}
}