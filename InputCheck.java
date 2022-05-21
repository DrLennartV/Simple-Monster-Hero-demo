
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 	InputCheck class is the class that checks the
 * 		validation of all inputs from user in different
 * 		prompts.
 */
public class InputCheck {
	
	public static Scanner input = new Scanner(System.in);
	
	public int worldSize(int minimum, int maximum) {
		int size = -1;
		input = new Scanner(System.in);
		do {
			System.out.print("Please enter row/column number here (minimum " + String.valueOf(minimum) + ", maximum " + String.valueOf(maximum) + "): " );
			//if input is not an integer, ask to enter again
			while (!input.hasNextInt()) {
				input.nextLine();
				System.out.print("Please enter an integer: ");
			}
			size = input.nextInt();
			//if size is not between 5 and maximum, ask to enter again
		}while(!(size >= 5 && size <= maximum));
		return size;
	}
	
	/**
	 * set user's choice of number of teams
	 * @return number of teams in a game
	 */
	public int teamNumber() {
		String number;
		do {
			System.out.print("Please enter the number of teams(maximum: 3): ");
			number = input.next();
		}while(!number.matches("^[1-3]$"));
		
		return Integer.parseInt(number);
	}
	
	/**
	 * set user's choice of number of heroes
	 * @return number of heroes
	 */
	public int heroNumber() {
		String number;
		do {
			System.out.print("Please enter the number of heroes(maximum: 3): ");
			number = input.next();
		}while(!number.matches("^[1-3]$"));
		
		return Integer.parseInt(number);
	}
	
	/**
	 * set user's choice of the type of hero
	 * @return type of the hero
	 */
	public int heroType() {
		String number;
		do {
			System.out.println("1. Warrior");
			System.out.println("2. Sorcerer");
			System.out.println("3. Paladin");
			System.out.print("Please enter the type of hero: ");
			number = input.next();
		}while(!number.matches("^[1-3]$"));
		
		return Integer.parseInt(number);
	}
	
	public int heroSelect(int herotype, List<ArrayList<? extends Hero>> HeroPool) {
		String heroSelect;
		int heroTypeSize;
		do {
			if(herotype == 1) {
				heroTypeSize = HeroPool.get(0).size();
				System.out.println("Next are all Warriors: ");
			}
			else if(herotype == 2) {
				heroTypeSize = HeroPool.get(1).size();
				System.out.println("Next are all Sorcerers: ");
			}
			else {
				heroTypeSize = HeroPool.get(2).size();
				System.out.println("Next are all Paladins: ");
			}
			System.out.println("Name/mana/strength/agility/dexterity/starting money/starting experience");
			for(int i = 0; i < heroTypeSize; i++) {
				System.out.println( String.valueOf(i+1) + ". " +
									HeroPool.get(herotype-1).get(i).getName() + "  "+ 
									HeroPool.get(herotype-1).get(i).getMana() + "  " + 
									HeroPool.get(herotype-1).get(i).getStrength() + "  " +
									HeroPool.get(herotype-1).get(i).getAgility() + "  " +
									HeroPool.get(herotype-1).get(i).getDexterity() + "  " +
									HeroPool.get(herotype-1).get(i).getMoney() + "  " +
									HeroPool.get(herotype-1).get(i).getExp());
			}
			System.out.print("Please enter the number of hero: ");
			heroSelect = input.next();
		}while(!heroSelect.matches("^[1-" + String.valueOf(heroTypeSize) + "]$"));
		
		return Integer.parseInt(heroSelect);
	}
	
	public String playerAction() {
		String option;
		do {
			System.out.println(" ");
			System.out.println("W/w: move up");
			System.out.println("A/a: move left");
			System.out.println("S/s: move down");
			System.out.println("D/d: move right");
			System.out.println("Q/q: quit game");
			System.out.println("I/i: show information(equip weapon ..)");
			System.out.print("Please enter your Action: ");
			option = input.next();
		}while(!option.matches("^[WwAaSsDdQqIi]$"));
		
		return option;
	}
	
	public String enterMarket() {
		String option;
		do {
			System.out.println(" ");
			System.out.print("Enter Y/y to the market, Enter N/n to leave: ");
			option = input.next();
		}while(!option.matches("^[yYnN]$"));
		return option;
	}
	
	public String marketHeroSelect(Team team) {
		String option;
		do {
			System.out.println("\nType hero# to choose hero");
			System.out.println("Type E/e to exit ");
			System.out.print("Enter your choice: ");
			option = input.next();
		}while(!option.matches("^[1-" + String.valueOf(team.getTeamSize()) + "eE]$"));
		return option;
	}
	
	public String BuyorSell(int heroIndex) {
		String option;
		do {
			System.out.println(" ");
			System.out.println("To Hero " + String.valueOf(heroIndex+1) + " :");
			System.out.println("1. Buy Weapon");
			System.out.println("2. Buy Armory");
			System.out.println("3. Buy Potions");
			System.out.println("4. Buy Spells");
			System.out.println("5. Sell Weapon");
			System.out.println("6. Sell Armory");
			System.out.println("7. Sell Potions");
			System.out.println("8. Sell Spells");
			System.out.println("B/b Back");
			System.out.print("Enter your choice: ");
			option = input.next();
		}while(!option.matches("^[1-8bB]$"));
		return option;
	}
	
	public int goodSelect(ArrayList<? extends Equipment> alist, Team team, int heroIndex) {
		String option;
		do {
			System.out.println("\nHero " + team.getHero(heroIndex).getName() + " now has Money: " + String.valueOf(team.getHero(heroIndex).getMoney()));
			System.out.print("Enter # to buy: ");
			option = input.next();
		}while(!option.matches("^[1-" + String.valueOf(alist.size()) + "]$"));
		return Integer.valueOf(option);
	}
	
	public int inventorySelect(int number, String Message) {
		String option;
		do {
			System.out.print(Message);
			option = input.next();
		}while(!option.matches("^[1-" + String.valueOf(number) + "]$"));
		return Integer.valueOf(option);
	}
	
	public String spellSelect() {
		String option;
		do {
			System.out.println("\n1. Ice Spell");
			System.out.println("2. Fire Spell");
			System.out.println("3. Lightning Spell");
			System.out.println("B/b Go back");
			System.out.print("Enter your choice: ");
			option = input.next();
		}while(!option.matches("^[1-3Bb]$"));
		return option;
	}
	
	
	public String infoChoose() {
		String option;
		do {
			System.out.println("\n1. Check Inventory");
			System.out.println("2. Equip/Unequip weapons or Armor");
			System.out.println("3. Use a Potion");
			System.out.println("B/b Go back");
			System.out.print("Enter your choice: ");
			option = input.next();
		}while(!option.matches("^[1-3Bb]$"));
		return option;
	}
	
	public String teamHeroSelect(Team team) {
		String option;
		do {
			System.out.print("\nChoose hero #: ");
			option = input.next();
		}while(!option.matches("^[1-" + String.valueOf(team.getTeamSize()) + "eE]$"));
		return option;
	}
	
	public String equipSelect() {
		String option;
		do {
			System.out.println("\nChange or Equip weapons and armors");
			System.out.println("1. Unequip Weapons");
			System.out.println("2. Equip Weapons");
			System.out.println("3. Unequip Armory");
			System.out.println("4. Equip Armory");
			System.out.println("B/b Go back");
			System.out.print("Enter your Choice: ");
			option = input.next();
		}while(!option.matches("^[1-4Bb]$"));
		return option;
	}
	
	public String battleSelect() {
		String option;
		do {
			System.out.println("1. Regular Attack");
			System.out.println("2. Cast a Spell");
			System.out.println("3. Use a Potion");
			System.out.println("4. Change the Euippment");
			System.out.println("I/i Show Battle Information");
			System.out.print("Enter your Choice: ");
			option = input.next();
		}while(!option.matches("^[1-4Ii]$"));
		return option;
	}
	
	
}
