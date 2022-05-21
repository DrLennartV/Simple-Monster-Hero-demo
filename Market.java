
import java.util.ArrayList;
import java.util.List;

/**
 * representative the class of a market
 * attributes:
 * 		store all goods that can be bought in the market
 * write all logics how a hero can choose goods to buy or
 * choose items in the inventory to sell
 * @author zhaoyuyin
 *
 */
public class Market {
	
	private ArrayList<Weapon> WeaponPool = new ArrayList<Weapon>();
	private ArrayList<Armory> ArmoryPool = new ArrayList<Armory>();
	private List<ArrayList<? extends Spells>> SpellsPool = new ArrayList<>();
	private ArrayList<Potions> PotionsPool = new ArrayList<>();
	private final String sellMessage = "Enter # to sell: ";
	
	/**
	 * get weapon lists in the market
	 * @return
	 */
	public ArrayList<Weapon> getWeaponPool(){
		return this.WeaponPool;
	}
	
	/**
	 * get armory lists in the market
	 * @return
	 */
	public ArrayList<Armory> getArmoryPool(){
		return this.ArmoryPool;
	}
	
	/**
	 * get weapon spells in the market
	 * @return
	 */
	public List<ArrayList<? extends Spells>> getSpellsPool(){
		return this.SpellsPool;
	}
	
	/**
	 * get weapon potions in the market
	 * @return
	 */
	public ArrayList<Potions> getPotionsPool(){
		return this.PotionsPool;
	}
	
	/**
	 * write all logics how a hero can buy or sell
	 * @param team -- the list of heroes
	 * @param userInput --  input check
	 * @param gameUI -- interactive context
	 */
	public void Action(Team team, InputCheck userInput, UI gameUI) {
		boolean Flag_Action = true;
		while(Flag_Action) {
			team.teamMemberDisplay();
			String userSelect = userInput.marketHeroSelect(team);
			if(userSelect.equalsIgnoreCase("e")) {
				Flag_Action = false;
				System.out.println("\nTeam " + team.getTeamName() + " leaves the market\n");
			}
			else {
				
				boolean Flag_BuyorSell = true;
				int heroIndex = Integer.valueOf(userSelect) - 1;
				while(Flag_BuyorSell) {
					String operationSelect = userInput.BuyorSell(heroIndex);
					if(operationSelect.equalsIgnoreCase("b")) {
						Flag_BuyorSell = false;
					}
					else {
						//buy Weapons
						if(operationSelect.equals("1")) {
							System.out.println("\nWeapons in Stock: ");
							gameUI.DisplayWeapon(WeaponPool);
							int goods = userInput.goodSelect(WeaponPool, team, heroIndex);
							team.getHero(heroIndex).addEquipment(WeaponPool.get(goods-1));
						}
						
						//buy Armory
						else if(operationSelect.equals("2")) {
							System.out.println("\nArmory in Stock: ");
							gameUI.DisplayArmory(ArmoryPool);
							int goods = userInput.goodSelect(ArmoryPool, team, heroIndex);
							team.getHero(heroIndex).addEquipment(ArmoryPool.get(goods-1));
						}
						
						//buy potions
						else if(operationSelect.equals("3")) {
							System.out.println("\nPotions in Stock: ");
							gameUI.DisplayPotions(PotionsPool);
							int goods = userInput.goodSelect(PotionsPool, team, heroIndex);
							team.getHero(heroIndex).addEquipment(PotionsPool.get(goods-1));
						}
						//buy three types of spells
						else if(operationSelect.equals("4")) {
							
							boolean Flag_buySpells = true;
							while(Flag_buySpells) {
								String spellSelect = userInput.spellSelect();
								if(spellSelect.equalsIgnoreCase("b")) {
									Flag_buySpells = false;
								}
								else {
									//player select ice spell
									if(spellSelect.equals("1")) {
										System.out.println("\nIce Spells in Stock: ");
										gameUI.DisplaySpell(SpellsPool.get(0));
										int goods = userInput.goodSelect(SpellsPool.get(0), team, heroIndex);
										team.getHero(heroIndex).addEquipment(SpellsPool.get(0).get(goods-1));
									}
									//player select fire spell
									else if(spellSelect.equals("2")) {
										System.out.println("\nFire Spells in Stock: ");
										gameUI.DisplaySpell(SpellsPool.get(1));
										int goods = userInput.goodSelect(SpellsPool.get(1), team, heroIndex);
										team.getHero(heroIndex).addEquipment(SpellsPool.get(1).get(goods-1));
									}
									//player select lightning spell
									else if(spellSelect.equals("3")) {
										System.out.println("\nLightning Spells in Stock: ");
										gameUI.DisplaySpell(SpellsPool.get(2));
										int goods = userInput.goodSelect(SpellsPool.get(2), team, heroIndex);
										team.getHero(heroIndex).addEquipment(SpellsPool.get(2).get(goods-1));
									}
								}
							}
						}
						//sell weapons
						else if(operationSelect.equals("5")) {
							System.out.println("\nWeapon the hero " + team.getHero(heroIndex).getName() + " has:");
							gameUI.DisplayWeapon(team.getHero(heroIndex).getweapons());
							if(team.getHero(heroIndex).getweapons().size() > 0) {
								int itemIndex = userInput.inventorySelect(team.getHero(heroIndex).getweapons().size(), sellMessage) - 1;
								team.getHero(heroIndex).sellWeapon(itemIndex);
							}
							else {
								System.out.println("\nSorry the hero has no Weapons in the inventory. ");
							}
						}
						//sell Armory
						else if(operationSelect.equals("6")) {
							System.out.println("\nArmors the hero " + team.getHero(heroIndex).getName() + " has:");
							gameUI.DisplayArmory(team.getHero(heroIndex).getarmory());
							if(team.getHero(heroIndex).getarmory().size() > 0) {
								int itemIndex = userInput.inventorySelect(team.getHero(heroIndex).getarmory().size(), sellMessage) - 1;
								team.getHero(heroIndex).sellArmory(itemIndex);
							}
							else {
								System.out.println("\nSorry the hero has no Armory in the inventory. ");
							}
						}
						//sell potions
						else if(operationSelect.equals("7")) {
							System.out.println("\nPotions the hero " + team.getHero(heroIndex).getName() + " has:");
							gameUI.DisplayPotions(team.getHero(heroIndex).getpotions());
							if(team.getHero(heroIndex).getpotions().size() > 0) {
								int itemIndex = userInput.inventorySelect(team.getHero(heroIndex).getpotions().size(), sellMessage) - 1;
								team.getHero(heroIndex).sellPotion(itemIndex);
							}
							else {
								System.out.println("\nSorry the hero has no potions in the inventory. ");
							}
						}
						//sell Spells
						else if(operationSelect.equals("8")) {
							System.out.println("\nSpells the hero " + team.getHero(heroIndex).getName() + " has:");
							gameUI.DisplaySpell(team.getHero(heroIndex).getspells());
							if(team.getHero(heroIndex).getspells().size() > 0) {
								int itemIndex = userInput.inventorySelect(team.getHero(heroIndex).getspells().size(), sellMessage) - 1;
								team.getHero(heroIndex).sellSpell(itemIndex);
							}
							else {
								System.out.println("\nSorry the hero has no spells in the inventory. ");
							}
						}
					}
				}
				
			}
		}
	}
}
