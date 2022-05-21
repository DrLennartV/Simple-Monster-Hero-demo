
import java.util.ArrayList;
import java.util.List;

/**
 * representative a hero
 * attributes:
 * 		Name -- a hero's name
 * 		health -- a hero's health
 * 		Mana, Strength, Agility etc.
 * 		equipWeapons -- an arraylist that
 * 			contains all equipped weapons
 * 		equipArmor -- the equipped armor
 * 		inventory -- similiar to a bag
 * Constructor:
 * 		with arguments: records all necessary information
 * 		no arguments: creat a hero named empty
 * @author zhaoyuyin
 *
 */
public abstract class Hero {
	
	protected String Name;
	protected int Health;
	protected int Mana;
	protected int Strength;
	protected int Agility;
	protected int Dexterity;
	protected int Money;
	protected int Exp;
	protected int Level;
	
	protected ArrayList<Weapon> equipWeapons = new ArrayList<Weapon>();
	protected Armory equipArmor;
	
	protected Inventory inventory = new Inventory();
	
	public Hero(String name, int mana, int strength, int agility, int dexterity, int money, int expLevel) {
		setLevel(1);
		setName(name);
		setMana(mana);
		setStrength(strength);
		setAgility(agility);
		setDexterity(dexterity);
		setMoney(money);
		setExp(expLevel);
		InitialHealth();
	}
	
	public Hero() {
		this("empty hero", 0, 0, 0, 0, 0, 0);
	}
	
	/**
	 * set hero's name
	 * @param name
	 */
	public void setName(String name) {
		this.Name = name;
	}
	
	/**
	 * initial a hero's health
	 */
	public void InitialHealth() {
		this.Health = 100*this.Level;
	}
	
	/**
	 * set a hero's level
	 * @param level
	 */
	public void setLevel(int level) {
		this.Level = level;
	}
	
	/**
	 * get a hero's level
	 * @return int
	 */
	public int getLevel() {
		return this.Level;
	}
	
	/**
	 * add values to health attributes
	 * @param addition
	 */
	public void addHealth(int addition) {
		this.Health += addition;
	}
	
	/**
	 * reduce some health
	 * @param subtraction
	 */
	public void subtractHealth(int subtraction) {
		if(this.getHealth() > subtraction) {
			this.Health -= subtraction;
		}
		else {
			this.Health = 0;
			System.out.println("\nThe Hero " + this.getName() + " has run out of his HP");
		}
	}
	
	/**
	 * set the mana
	 * @param mana
	 */
	public void setMana(int mana) {
		this.Mana = mana;
	}
	
	/**
	 * set the strength
	 * @param strength
	 */
	public void setStrength(int strength) {
		this.Strength = strength;
	}
	
	/**
	 * set the agility
	 * @param agility
	 */
	public void setAgility(int agility) {
		this.Agility = agility;
	}
	
	/**
	 * set the dexterity
	 * @param dexterity
	 */
	public void setDexterity(int dexterity) {
		this.Dexterity = dexterity;
	}
	
	/**
	 * set the money
	 * @param money
	 */
	public void setMoney(int money) {
		this.Money = money;
	}
	
	/**
	 * set the initial exp
	 * @param exp
	 */
	public void setExp(int exp) {
		this.Exp = exp;
	}
	
	/**
	 * get the name
	 * @return
	 */
	public String getName() {
		return this.Name;
	}
	
	/**
	 * get the health
	 * @return
	 */
	public int getHealth() {
		return this.Health;
	}
	
	/**
	 * get the mana
	 * @return
	 */
	public int getMana() {
		return this.Mana;
	}
	
	/**
	 * get the strength
	 * @return
	 */
	public int getStrength() {
		return this.Strength;
	}
	
	/**
	 * get the agility
	 * @return
	 */
	public int getAgility() {
		return this.Agility;
	}
	
	/**
	 * get the dexterity
	 * @return
	 */
	public int getDexterity() {
		return this.Dexterity;
	}
	
	/**
	 * get the money
	 * @return
	 */
	public int getMoney() {
		return this.Money;
	}
	
	/**
	 * get the exp
	 * @return
	 */
	public int getExp() {
		return this.Exp;
	}
	
	public void deletePotion(Potions potion) {
		inventory.getpotions().remove(potion);
	}
	
	public void deleteSpell(Spells spell) {
		inventory.getspells().remove(spell);
	}
	
	/**
	 * return all weapons in the inventory
	 * @return
	 */
	public ArrayList<Weapon> getweapons(){
		return this.inventory.getweapons();
	}
	
	/**
	 * return all potions in the inventory
	 * @return
	 */
	public ArrayList<Potions> getpotions(){
		return this.inventory.getpotions();
	}
	
	/**
	 * return all spells in the inventory
	 * @return
	 */
	public List<Spells> getspells(){
		return this.inventory.getspells();
	}
	
	/**
	 * return all armors in the inventory
	 * @return
	 */
	public ArrayList<Armory> getarmory(){
		return this.inventory.getarmory();
	}
	
	/**
	 * get all equipped weapons
	 * @return
	 */
	public ArrayList<Weapon> getEquipWeapon(){
		return this.equipWeapons;
	}
	
	/**
	 * get a specific potion
	 * @param index
	 * @return potion
	 */
	public Potions getPotion(int index) {
		return inventory.getpotions().get(index);
	}
	
	/**
	 * delete a specific potion
	 * @param index
	 */
	public void deletePotion(int index) {
		inventory.getpotions().remove(index);
	}
	
	/**
	 * get a specific spell
	 * @param index
	 * @return spell
	 */
	public Spells getSpell(int index) {
		return inventory.getspells().get(index);
	}
	
	/**
	 * get the equipped armor
	 * @return armory
	 */
	public Armory getEquipArmor() {
		return this.equipArmor;
	}
	
	/**
	 * set equipped armor
	 * @param armor
	 */
	public void setEquipArmor(Armory armor) {
		this.equipArmor = armor;
	}
	
	/**
	 * delete a specific spell with index
	 * @param index
	 */
	public void deleteSpell(int index) {
		inventory.getspells().remove(index);
	}
	
	/**
	 * get the number of hands occupied
	 * @return
	 */
	public int getEquipWeaponCapacity() {
		int total = 0;
		for(Weapon weapon: equipWeapons) {
			total += weapon.getCapacity();
		}
		return total;
	}
	
	/**
	 * get the total damage from weapons in hands
	 * @return
	 */
	public int getWeaponsDamage() {
		int damage = 0;
		for(Weapon weapon : equipWeapons) {
			damage += weapon.getDamage();
		}
		return damage;
	}
	
	/**
	 * if all heroes lose, revive half HP
	 */
	public void hpRevive() {
		this.Health = (int) (0.5 * this.Level * 100);
	}
	
	/**
	 * buy items and add them to the inventory
	 * @param <T>
	 * @param equip
	 */
	public <T extends Equipment> void addEquipment(T equip) {
		
		if(this.getLevel() >= equip.getLevel()) {
			if(this.getMoney() > equip.getCost()) {
				if(equip instanceof Weapon) {
					this.setMoney(this.getMoney() - equip.getCost());
					inventory.getweapons().add((Weapon) equip);
					System.out.println("\nThe hero bought " + equip.getName() + " successfully.");
				}
				else if(equip instanceof Armory) {
					this.setMoney(this.getMoney() - equip.getCost());
					inventory.getarmory().add((Armory) equip);
					System.out.println("\nThe hero bought " + equip.getName() + " successfully.");
				}
				else if(equip instanceof Potions) {
					this.setMoney(this.getMoney() - equip.getCost());
					inventory.getpotions().add((Potions) equip);
					System.out.println("\nThe hero bought " + equip.getName() + " successfully.");
				}
				else if(equip instanceof Spells) {
					boolean hasExist = false;
					for(Spells spell: inventory.getspells()){
						if(spell.getName().equals(equip.getName())) {
							hasExist = true;
						}
					}
					if(hasExist == true) {
						System.out.println("\nSorry, the hero has already mastered Spell " + equip.getName());
					}
					else {
						this.setMoney(this.getMoney() - equip.getCost());
						inventory.getspells().add((Spells) equip);
						System.out.println("\nThe hero bought " + equip.getName() + " successfully.");
					}
				}
			}
			else {
				System.out.println("\nSorry, the hero has insufficient money. ");
			}
		}
		else {
			System.out.println("\nSorry, the hero has insufficient level. ");
		}
	}
	/**
	 * abstract level up needs overriding for different types of heroes
	 */
	public abstract void LevelUp();
	
	/**
	 * sell armor and get money
	 * @param index
	 */
	public void sellArmory(int index) {
		this.setMoney(this.getMoney() + (this.getarmory().get(index).getCost())/2);
		System.out.println("\nHero " + this.getName() + " sold the Armory " + this.getarmory().get(index).getName() + " successfully.");
		System.out.println("\nHero " + this.getName() + " now has Money: " + this.getMoney());
		inventory.getarmory().remove(index);
	}
	
	/**
	 * sell weapon and get half money
	 * @param index
	 */
	public void sellWeapon(int index) {
		this.setMoney(this.getMoney() + (this.getweapons().get(index).getCost())/2);
		System.out.println("\nHero " + this.getName() + " sold the Weapon " + this.getweapons().get(index).getName() + " successfully.");
		System.out.println("\nHero " + this.getName() + " now has Money: " + this.getMoney());
		inventory.getweapons().remove(index);
	}
	
	/**
	 * sell potion and get half money
	 * @param index
	 */
	public void sellPotion(int index) {
		this.setMoney(this.getMoney() + (this.getPotion(index).getCost())/2);
		System.out.println("\nHero " + this.getName() + " sold the Potion " + this.getPotion(index).getName() + " successfully.");
		System.out.println("\nHero " + this.getName() + " now has Money: " + this.getMoney());
		inventory.getpotions().remove(index);
	}
	
	/**
	 * sell spell and get half money
	 * @param index
	 */
	public void sellSpell(int index) {
		this.setMoney(this.getMoney() + (this.getSpell(index).getCost())/2);
		System.out.println("\nHero " + this.getName() + " sold the Spell " + this.getSpell(index).getName() + " successfully.");
		System.out.println("\nHero " + this.getName() + " now has Money: " + this.getMoney());
		inventory.getspells().remove(index);
	}
	
	/**
	 * allow a hero to change his weapon
	 * @param gameUI
	 * @param userInput
	 */
	public void changeWeapon(UI gameUI, InputCheck userInput) {
		String equipSelect = userInput.equipSelect();
		//unequip weapon
		if(equipSelect.equals("1")) {
			//if the hero is not equipped with weapon
			if(this.getEquipWeapon().size() == 0) {
				System.out.println("\nThe hero has no weapon. Cannot take off the weapon");
			}
			//if the hero has only one weapon
			else if(this.getEquipWeapon().size() == 1) {
				this.getweapons().add(this.getEquipWeapon().get(0));
				System.out.println("\nThe weapon " + this.getEquipWeapon().get(0).getName() + " has been unequipped successfully");
				this.getEquipWeapon().remove(0);
			}
			//if the hero takes two weapons
			else {
				System.out.println("\nDisplay Hero " + this.getName() + "'s Equipped Weapons");
				gameUI.DisplayWeapon(this.getEquipWeapon());
				String weaponMessage = "Choose weapon #: ";
				int weaponIndex = userInput.inventorySelect(this.getEquipWeapon().size(), weaponMessage) - 1;
				this.getweapons().add(this.getEquipWeapon().get(weaponIndex));
				System.out.println("\nThe weapon " + this.getEquipWeapon().get(weaponIndex).getName() + " has been UNEQUIPPED successfully");
				this.getEquipWeapon().remove(weaponIndex);
			}
		}
		//equip weapon
		else if(equipSelect.equals("2")) {
			if(this.getweapons().size() != 0) {
				System.out.println("\nDisplay Hero " + this.getName() + "'s weapons in Inventory");
				gameUI.DisplayWeapon(this.getweapons());
				String weaponMessage = "Choose armor #: ";
				int weaponIndex = userInput.inventorySelect(this.getweapons().size(), weaponMessage) - 1;
				
				if(this.getEquipWeaponCapacity() + this.getweapons().get(weaponIndex).getCapacity() <= 2) {
					this.getEquipWeapon().add(this.getweapons().get(weaponIndex));
					System.out.println("\nThe weapon " + this.getweapons().get(weaponIndex).getName() + " has been EQUIPPED successfully");
					this.getweapons().remove(weaponIndex);
				}
				else {
					System.out.println("\nThe hero has insufficient hand space");
				}
			}
			else {
				System.out.println("\nThere is no Weapon in the inventory");
			}
			
		}
		//unequip armor
		else if(equipSelect.equals("3")) {
			if(this.getEquipArmor() != null) {
				this.getarmory().add(this.getEquipArmor());
				System.out.println("\nThe armor " + this.getEquipArmor().getName() + " has been UNEQUIPPED successfully");
				this.setEquipArmor(null);
			}
			else {
				System.out.println("\nThe hero has no Armor. Cannot take off the Armor");
			}
		}
		//equip armor
		else if(equipSelect.equals("4")) {
			if(this.getarmory().size() != 0) {
				System.out.println("\nDisplay Hero " + this.getName() + "'s armors in Inventory");
				gameUI.DisplayArmory(this.getarmory());
				String armorMessage = "Choose armor #: ";
				int armorIndex = userInput.inventorySelect(this.getarmory().size(), armorMessage) - 1;
				if(this.getEquipArmor() == null) {
					this.setEquipArmor(this.getarmory().get(armorIndex));
					System.out.println("\nThe armor " + this.getarmory().get(armorIndex).getName() + " has been EQUIPPED successfully");
					this.getarmory().remove(armorIndex);
				}
				else {
					System.out.println("\nThe hero is already equipped with the armor. Please unequip first");
				}
			}
			else {
				System.out.println("\nThere is no Armor in the inventory");
			}
		}
	}
	
	/**
	 * allow a hero to use his potion
	 * @param gameUI
	 * @param userInput
	 */
	public void usePotion(UI gameUI, InputCheck userInput) {
		if(this.getpotions().size() > 0) {
			System.out.println("\nHero "+ this.getName() + " has the following Potions: ");
			gameUI.DisplayPotions(this.getpotions());
			String potionMessage = "Choose potion #: ";
			int potionIndex = userInput.inventorySelect(this.getpotions().size(), potionMessage) - 1;
			this.getPotion(potionIndex).heroUsed(this);
		}
		else {
			System.out.println("\nSorry the hero has no potions. ");
		}
	}

}
