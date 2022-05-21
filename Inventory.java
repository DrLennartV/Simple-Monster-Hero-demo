
import java.util.ArrayList;
import java.util.List;
/**
 * representative of an inventory that stores armors,
 * weapons, potions and spells owned by a hero
 * attributes:
 * 		armory -- arraylist that stores the armor
 * 		weapons -- arraylist that stores the weapon
 * 		potions -- arraylist that stores potions
 * 		spells -- arraylist that stores spells
 * Constructor:
 * 		no arguments: generate a specific inventory
 * @author zhaoyuyin
 */
public class Inventory {
	
	protected ArrayList<Armory> armory;
	protected ArrayList<Weapon> weapons;
	protected ArrayList<Potions> potions;
	protected List<Spells> spells;
	
	public Inventory() {
		armory = new ArrayList<Armory>();
		weapons = new ArrayList<Weapon>();
		potions = new ArrayList<Potions>();
		spells = new ArrayList<>();
	}
	
	/**
	 * get all the armors
	 * @return an arraylist
	 */
	public ArrayList<Armory> getarmory(){
		return this.armory;
	}
	
	/**
	 * get all the weapons
	 * @return an arraylist
	 */
	public ArrayList<Weapon> getweapons(){
		return this.weapons;
	}
	
	/**
	 * get all potions
	 * @return an arraylist
	 */
	public ArrayList<Potions> getpotions(){
		return this.potions;
	}
	
	/**
	 * get all spells
	 * @return a list
	 */
	public List<Spells> getspells(){
		return this.spells;
	}

}
