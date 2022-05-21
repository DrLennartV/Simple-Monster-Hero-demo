
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * InitialGame is designed to initial and set all necessary
 * attributes and static variable, objects for the game
 * attributes:
 * 		gameUI -- controls all UI context in this game
 * 		userInput -- check all user's input
 * 		market -- control the process of buying and selling
 * 		battle -- control the battle process
 * 		MonsterPool -- contain all kinds of monsters
 * 		HeroPool -- contain all three kinds of heroes
 * @author zhaoyuyin
 */
public class InitialGame {

	private final int minimalWorldSize = 5;
	private final int maximalWorldSize = 12;
	private static UI gameUI = new UI();
	private static InputCheck userInput = new InputCheck();
	private Market market = new Market();
	private List<Monster> MonsterPool = new ArrayList<>();
	private List<ArrayList<? extends Hero>> HeroPool = new ArrayList<>();
	//private ArrayList<Team> Teams = new ArrayList<Team>();

	/**
	 * initial game, record selected heroes, team move
	 * @throws IOException
	 */
	public void run() throws IOException {

		gameUI.Intro();
		int worldSize = userInput.worldSize(minimalWorldSize, maximalWorldSize);
		WorldBoard world = new WorldBoard(worldSize);

		TxtFileScan txtScan = new TxtFileScan();
		txtScan.scanTxtFiles(MonsterPool, HeroPool, market);

		/*
		int teamNumber = userInput.teamNumber();
		for(int i = 1; i < teamNumber + 1; i++) {
			Team team = new Team(String.valueOf(i));
			Teams.add(team);
		}
		*/

		Team team = new Team("A");
		world.initialWorld(team);
		gameUI.HeroSelect();
		int heroNumber = userInput.heroNumber();
		int count = 1;
		while(count <= heroNumber) {
			System.out.println("Please select Hero " + count);
			int heroType = userInput.heroType();
			int heroSelect = userInput.heroSelect(heroType, HeroPool);
			team.addHero(HeroPool.get(heroType-1).get(heroSelect-1));
			count += 1;
		}

		team.teamMemberDisplay();

		boolean Flag_Game = true;
		while(Flag_Game) {
			world.showWorld(team);
			String playerOption = userInput.playerAction();
			if(playerOption.equalsIgnoreCase("i")) team.infoShow(gameUI, userInput);
			else if(playerOption.equalsIgnoreCase("w")) {
				if(team.getRowPosition()==0 || world.upIsInaccess(team)) {
					System.out.println("\nYou cannot move upwards. Please enter again.");
				}
				else {
					move(world, team, "up");
				}
			}
			else if(playerOption.equalsIgnoreCase("a")) {
				if(team.getColPosition()==0 || world.leftIsInaccess(team)) {
					System.out.println("\nYou cannot move left. Please enter again.");
				}
				else {
					move(world, team, "left");
				}
			}
			else if(playerOption.equalsIgnoreCase("s")) {
				if(team.getRowPosition()==worldSize-1 || world.downIsInaccess(team)) {
					System.out.println("\nYou cannot move down. Please enter again.");
				}
				else {
					move(world, team, "down");
				}
			}
			else if(playerOption.equalsIgnoreCase("d")) {
				if(team.getColPosition()==worldSize-1 || world.rightIsInaccess(team)) {
					System.out.println("\nYou cannot move right. Please enter again.");
				}
				else {
					move(world, team, "right");
				}
			}
			else {
				Flag_Game = false;
			}
		}
		InputCheck.input.close();
		gameUI.End();
	}

	/**
	 * move is designed to trigger events when the team hits different cells
	 * @param world -- a board that represents world map
	 * @param team -- selected heroes
	 * @param option -- wasd, quit or information
	 */
	public void move(WorldBoard world, Team team, String option) {
		if(option.equals("up")) {
			team.setRowPosition(team.getRowPosition()-1);
		}
		else if(option.equals("left")) {
			team.setColPosition(team.getColPosition()-1);
		}
		else if(option.equals("down")) {
			team.setRowPosition(team.getRowPosition()+1);
		}
		else if(option.equals("right")) {
			team.setColPosition(team.getColPosition()+1);
		}

		if(team.isOnMarket(world)) {
			String choice = userInput.enterMarket();
			if(choice.equalsIgnoreCase("y")) {
				market.Action(team, userInput, gameUI);
			}
		}
		else {
			BattleLogic battle = new BattleLogic();
			double randomNumber;
			randomNumber = Math.random();
			if(randomNumber >= 0 && randomNumber <= 0.3) {
				battle.run(team, MonsterPool, gameUI, userInput);
			}
		}
	}
}
