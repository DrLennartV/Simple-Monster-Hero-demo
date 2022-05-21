
/**
 * Warrior is a representative of a class warrior
 * that extends from hero
 * Constructor
 * 		with arguments: super a hero
 * 		no arguments: create a warrior with empty name
 * @author zhaoyuyin
 */
public class Warrior extends Hero{

	public Warrior(String name, int mana, int strength, int agility, int dexterity, int money, int expLevel) {
		super(name, mana, strength, agility, dexterity, money, expLevel);
		// TODO Auto-generated constructor stub
	}
	
	public Warrior() {
		super("empty warrior", 0, 0, 0, 0, 0, 0);
	}

	/**
	 * override LevelUp method 
	 * warrior has its own level up way
	 */
	@Override
	public void LevelUp() {
		// TODO Auto-generated method stub
		
		//increase level
		super.setLevel(super.getLevel() + 1);
		
		//reset HP
		super.InitialHealth();
		
		//increase Mana
		super.setMana((int) 1.1*super.getMana());
		
		//increase 10% Strength and Agility
		super.setStrength((int) 1.1*super.getStrength());
		super.setAgility((int) 1.1*super.getAgility());
		
		//increase 5% Dexterity
		super.setDexterity((int) 1.05*super.getDexterity());
		
	}

}
