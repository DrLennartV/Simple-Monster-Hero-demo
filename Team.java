
import java.util.ArrayList;

/**
 * representative of a team, which is also the
 * basic unit that the player can move
 * attributes:
 * 		teamName
 * 		rowPosition -- records x axis position
 * 		colPosition -- records y axis position
 * 		heroes -- a team contains
 * Constructor:
 * 		with arguments: create a team with name
 * 		no arguments: create a team empty name
 * @author zhaoyuyin
 *
 */
public class Team {

	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";


	private String teamName;
	private int rowPosition;
	private int colPosition;
	private ArrayList<Hero> heroes = new ArrayList<>();

	public Team(String name) {
		setTeamName(name);
	}

	public Team() {
		this("Default team name");
	}

	/**
	 * set team's name
	 * @param name
	 */
	public void setTeamName(String name) {
		this.teamName = name;
	}

	/**
	 * get team's name
	 * @return a string
	 */
	public String getTeamName() {
		return this.teamName;
	}

	/**
	 * set x-axis position
	 * @param row
	 */
	public void setRowPosition(int row) {
		this.rowPosition = row;
	}

	/**
	 * set y-axis position
	 * @param col
	 */
	public void setColPosition(int col) {
		this.colPosition = col;
	}

	/**
	 * get row position
	 * @return
	 */
	public int getRowPosition() {
		return this.rowPosition;
	}

	/**
	 * get col position
	 * @return
	 */
	public int getColPosition() {
		return this.colPosition;
	}

	/**
	 * add a hero to the arraylist
	 * @param <T>
	 * @param hero
	 */
	public <T extends Hero> void addHero(T hero) {
		heroes.add(hero);
	}

	/**
	 * remove a hero from the arraylist
	 * @param hero
	 */
	public void removeHero(Hero hero) {
		heroes.remove(hero);
	}


	/**
	 * get the number of heroes in this team
	 * @return
	 */
	public int getTeamSize() {
		return heroes.size();
	}

	/**
	 * get a specific hero
	 * @param index
	 * @return
	 */
	public Hero getHero(int index) {
		return heroes.get(index);
	}

	/**
	 * check if the hero is on the market
	 * @param world
	 * @return boolean
	 */
	public boolean isOnMarket(WorldBoard world) {
		if(world.getCell(this.getRowPosition(), this.getColPosition()).getIsMarket()) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * show a team's member information
	 */
	public void teamMemberDisplay() {
		System.out.println("\n------------------------- Team " + teamName + " -------------------------");
		System.out.println("# Hero         Level/HP/Mana/Experience/Money/Strength/Agility/Dexterity");
		for(int i = 0; i < heroes.size(); i++) {
			System.out.print( String.valueOf(i+1) + ". " +
					heroes.get(i).getName() + "      "+
					heroes.get(i).getLevel() + "  ");
			System.out.print(ANSI_GREEN + heroes.get(i).getHealth() + "  "+ ANSI_RESET);
			System.out.print(ANSI_BLUE + heroes.get(i).getMana() + "  " + ANSI_RESET);
			System.out.print(heroes.get(i).getExp() + "  ");
			System.out.print(ANSI_YELLOW + heroes.get(i).getMoney() + "  " + ANSI_RESET);
			System.out.println(heroes.get(i).getStrength() + "  " +
					heroes.get(i).getAgility() + "  " +
					heroes.get(i).getDexterity());
		}
	}

	/**
	 * provide players with several basic functions such as
	 * check inventory, unequip or equip weapons and use a position
	 * @param gameUI
	 * @param userInput
	 */
	public void infoShow(UI gameUI, InputCheck userInput) {
		boolean Flag_CheckInfo = true;
		while(Flag_CheckInfo) {
			this.teamMemberDisplay();
			String operation = userInput.infoChoose();
			if(operation.equalsIgnoreCase("b")) {
				Flag_CheckInfo = false;
			}
			else {
				//check inventory
				if(operation.equals("1")) {
					this.teamMemberDisplay();
					String heroSelect = userInput.teamHeroSelect(this);
					int heroIndex = Integer.valueOf(heroSelect) - 1;
					System.out.println("\n-------------------------------------------------------------------------------");
					System.out.println("Display Hero " + this.getHero(heroIndex).getName() + "'s equipped Weapons and Armory");
					System.out.println("Equipped Weapon: ");
					gameUI.DisplayWeapon(this.getHero(heroIndex).getEquipWeapon());
					System.out.println("\nEquipped Armor: ");
					gameUI.DisplayEquipArmor(this.getHero(heroIndex).getEquipArmor());
					System.out.println("\n-------------------------------------------------------------------------------");

					System.out.println("Display Hero " + this.getHero(heroIndex).getName() + "'s items in Inventory");
					System.out.println("Weapons: ");
					gameUI.DisplayWeapon(this.getHero(heroIndex).getweapons());
					System.out.println("\nArmors: ");
					gameUI.DisplayArmory(this.getHero(heroIndex).getarmory());
					System.out.println("\nPotions: ");
					gameUI.DisplayPotions(this.getHero(heroIndex).getpotions());
					System.out.println("\nSpells: ");
					gameUI.DisplaySpell(this.getHero(heroIndex).getspells());
				}
				//change weapons and armory
				else if(operation.equals("2")) {
					this.teamMemberDisplay();
					String heroSelect = userInput.teamHeroSelect(this);
					int heroIndex = Integer.valueOf(heroSelect) - 1;
					this.getHero(heroIndex).changeWeapon(gameUI, userInput);
				}
				//use potions
				else if(operation.equals("3")) {
					this.teamMemberDisplay();
					System.out.print("\nChoose the hero to use Potions");
					String heroSelect = userInput.teamHeroSelect(this);
					int heroIndex = Integer.valueOf(heroSelect) - 1;
					this.getHero(heroIndex).usePotion(gameUI, userInput);
				}
			}
		}
	}
}
