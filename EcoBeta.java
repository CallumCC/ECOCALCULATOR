import java.util.Scanner;

public class EcoBeta{
	
	public static void main(String[] args){

		int ak47 = 2700;
		int m4a4 = 3100;
		int m4a1 = 2900;
		int kevlar = 650;
		int helmet = 1000;
		int awp = 4750;

		int round = 1;
		int currentEco = 4000;
		int enemyLossBonus = 1;

		Scanner in = new Scanner(System.in);

		System.out.println("\n" + "CSGO Economy Calculator" + "\n");

		while(true) {
			System.out.println("Round " + round);
			
			if(round == 1){
				System.out.println("Enemy economy: $" + currentEco);
			} else {
				System.out.println("Enemy economy estimate: $" + currentEco);
				System.out.println("Average per player: $" + currentEco/4);
			}

			System.out.println("\n" + "Input enemy buys (Example : 1133333 = 2 kevlar and 5 AKs)");
			System.out.println("Kevlar(1)");
			System.out.println("Kev + Helmet(2)");
			System.out.println("AK-47(3)");
			System.out.println("M4A4(4)");
			System.out.println("M4A1-S(5)");
			System.out.println("AWP(6)");
			
			
			String enemyBuys = in.nextLine();
			
			int[] result = new int[enemyBuys.length()];
			int temp = 0;
			for(int i = 0; i < enemyBuys.length(); i++) {
		        result[i] = Integer.parseInt(enemyBuys.charAt(i)+"");
		         
		        if(result[i] == 1) {
		        	temp = temp + kevlar;
		        } else if(result[i] == 2) {
		        	temp = temp + helmet;
		        } else if(result[i] == 3) {
		        	temp = temp + ak47;
		        } else if(result[i] == 4) {
		        	temp = temp + m4a4;
		        } else if(result[i] == 5) {
		        	temp = temp + m4a1;
		        } else if(result[i] == 6) {
		        	temp = temp + awp;
		        }
		     }
			
			currentEco = currentEco - temp;
			
			System.out.println("Win(1) or Lose(2) round?");
			int winlose = in.nextInt();
			
			if(winlose == 1) {
				if(enemyLossBonus == 0) {
					currentEco = currentEco + 7000;
				} else if(enemyLossBonus == 1) {
					currentEco = currentEco + 8500;
				} else if(enemyLossBonus == 2) {
					currentEco = currentEco + 12000;
				} else if(enemyLossBonus == 3) {
					currentEco = currentEco + 14500;
				} else if(enemyLossBonus == 4) {
					currentEco = currentEco + 17000;
				}
				enemyLossBonus++;
			} else if(winlose == 2) {
				//team elim win bonus 4 now.
				currentEco = currentEco + 15000;
			}
			
			round++;
		
		}
	}
}