
import java.util.ArrayList;
import java.util.List;

/**
 * UI is designed to print all context
 * @author zhaoyuyin
 */
public class UI {

	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";

	/**
	 * print the game introduction
	 */
	public void Intro() {
		System.out.println("--------------------------------Legends Monsters and Heroes---------------------------\n");
		System.out.println("-----------------Welcome to Legends of Monsters and Heroes" +
				         "\n-----------------In this Game you need to choose heros and control their action" +
				         "\n-----------------You can fight with monsters to get money and experience" +
				         "\n-----------------Weapons and Spells can be bought from the market\n");
		System.out.println("Please determine the size of the world first");
	}

	/**
	 * print the hero list that is selected by the player
	 */
	public void HeroSelect() {
		System.out.println("\n-----------------------------------------------------------------------------------");
		System.out.println("\n                                 Select your Heroes                                ");
		System.out.println("-------------You can choose at most three heroes with different types--------------");
		System.out.println("\n-----------------------------------------------------------------------------------\n");
	}

	/**
	 * print all weapons in a weapon arraylist
	 * @param WeaponPool
	 */
	public void DisplayWeapon(ArrayList<Weapon> WeaponPool) {
		System.out.println("# Name           cost/  level/   damage/  required hands");
		for(int i = 0; i < WeaponPool.size(); i++) {
			System.out.println( String.valueOf(i+1) + "  " +
								WeaponPool.get(i).getName() + "       " +
								WeaponPool.get(i).getCost() + "      " +
								WeaponPool.get(i).getLevel() + "     " +
								WeaponPool.get(i).getDamage() + "     " +
								WeaponPool.get(i).getCapacity());
		}
	}

	/**
	 * print all weapons in an armory arraylist
	 * @param ArmoryPool
	 */
	public void DisplayArmory(ArrayList<Armory> ArmoryPool) {
		System.out.println("# Name          cost/ required level/ damage reduction");
		for(int i = 0; i < ArmoryPool.size(); i++) {
			System.out.println( String.valueOf(i+1) + "  " +
								ArmoryPool.get(i).getName() + "       " +
								ArmoryPool.get(i).getCost() + "     " +
								ArmoryPool.get(i).getLevel() + "    " +
								ArmoryPool.get(i).getDamReduction());
		}
	}

	/**
	 * print all weapons in a potion arraylist
	 * @param PotionsPool
	 */
	public void DisplayPotions(ArrayList<Potions> PotionsPool) {
		System.out.println("# Name        cost/ required level/ attribute increase/ attribute affected");
		for(int i = 0; i < PotionsPool.size(); i++) {
			String attributes = "";
			if(PotionsPool.get(i).getHealth()) attributes += "Health/";
			if(PotionsPool.get(i).getStrength()) attributes += "Strength/";
			if(PotionsPool.get(i).getMana()) attributes += "Mana/";
			if(PotionsPool.get(i).getDexterity()) attributes += "Dexterity/";
			if(PotionsPool.get(i).getDefense()) attributes += "Defense/";
			if(PotionsPool.get(i).getAgility()) attributes += "Agility";
			System.out.println( String.valueOf(i+1) + "  " +
					PotionsPool.get(i).getName() + "    " +
					PotionsPool.get(i).getCost() + "   " +
					PotionsPool.get(i).getLevel() + "  " +
					PotionsPool.get(i).getBoost() + "  " +
					attributes);
		}
	}

	/**
	 * print all weapons in a spell arraylist
	 * @param spells
	 */
	public void DisplaySpell(List<? extends Spells> spells) {
		System.out.println("# Name        cost/ required level/ damage/ mana cost");
		for(int i = 0; i < spells.size(); i++) {
			System.out.println( String.valueOf(i+1) + "  " +
							spells.get(i).getName() + "    " +
							spells.get(i).getCost() + "   " +
							spells.get(i).getLevel() + "  " +
							spells.get(i).getDamage() + "  " +
							spells.get(i).getManaCost());
		}
	}

	/**
	 * print the armor that is equipped by a hero
	 * @param armor
	 */
	public void DisplayEquipArmor(Armory armor) {
		System.out.println("# Name        cost/ required level/ damage reduction");
		if(armor != null) {
			System.out.println( "1" + "  " +
					armor.getName() + "    " +
					armor.getCost() + "   " +
					armor.getLevel() + "  " +
					armor.getDamReduction());
		}
	}

	/**
	 * display a team's information in a battle
	 * @param team
	 */
	public void DisplayBattleTeam(Team team) {
		System.out.println("Heroes in team: ");
		System.out.println("\n# Name         Level/  HP/  Mana");
		for(int i = 0; i < team.getTeamSize(); i++) {
			System.out.print(String.valueOf(i+1) + " " +
								team.getHero(i).getName() + "     " +
								team.getHero(i).getLevel() + "    ");
			System.out.print(ANSI_GREEN + team.getHero(i).getHealth() + "    " + ANSI_RESET);
			System.out.println(ANSI_BLUE + team.getHero(i).getMana() + ANSI_RESET);
		}
	}

	/**
	 * display a monster's information in a battle
	 * @param monsters
	 */
	public void DisplayBattleMonster(List<Monster> monsters) {
		System.out.println("Monsters in team: ");
		System.out.println("# Name        Level/  HP/ Damage/  Defense");
		for(int i = 0; i < monsters.size(); i++) {
			System.out.print(String.valueOf(i+1) + "  " +
								monsters.get(i).getName() + "  " +
								monsters.get(i).getLevel() + "  ");
			System.out.print(ANSI_GREEN + monsters.get(i).getHealth() + "  " + ANSI_RESET);
			System.out.print(ANSI_RED + monsters.get(i).getDamage() + "  " + ANSI_RESET);
			System.out.println(monsters.get(i).getDefense());
		}
	}

	/**
	 * show the battle statrs
	 */
	public void BattleStart() {
		System.out.println("\n-----------------------------------------------------------------------------------");
		System.out.println("\n                                 Battle Starts                                ");
		System.out.println("--------------------Brave Heroes Try Your Best to Defeat Monsters--------------------");
		System.out.println("\n-----------------------------------------------------------------------------------\n");
	}

	/**
	 * show the battle ends
	 */
	public void BattleEnd() {
		System.out.println("\n-----------------------------------------------------------------------------------");
		System.out.println("\n                                 Battle Ends                                ");
		System.out.println("--------------------          Let's Settle Right Now             --------------------");
		System.out.println("\n-----------------------------------------------------------------------------------\n");
	}

	/**
	 * show goodbye
	 */
	public void End() {
		System.out.println(" ");
		System.out.println("░██████╗░░█████╗░░█████╗░██████╗░██████╗░██╗░░░██╗███████╗");
		System.out.println("██╔════╝░██╔══██╗██╔══██╗██╔══██╗██╔══██╗╚██╗░██╔╝██╔════╝");
		System.out.println("██║░░██╗░██║░░██║██║░░██║██║░░██║██████╦╝░╚████╔╝░█████╗░░");
		System.out.println("██║░░╚██╗██║░░██║██║░░██║██║░░██║██╔══██╗░░╚██╔╝░░██╔══╝░░");
		System.out.println("╚██████╔╝╚█████╔╝╚█████╔╝██████╔╝██████╦╝░░░██║░░░███████╗");
		System.out.println("░╚═════╝░░╚════╝░░╚════╝░╚═════╝░╚═════╝░░░░╚═╝░░░╚══════╝");
	}





}
