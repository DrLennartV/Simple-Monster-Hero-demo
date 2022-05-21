
/**
 * Sorcerer is a representative of a class sorcerer
 * that extends from hero
 * Constructor
 * 		with arguments: super a hero
 * 		no arguments: create a sorcerer with empty name
 * @author zhaoyuyin
 */
public class Sorcerer extends Hero{

	public Sorcerer(String name, int mana, int strength, int agility, int dexterity, int money, int expLevel) {
		super(name, mana, strength, agility, dexterity, money, expLevel);
		// TODO Auto-generated constructor stub
	}
	
	public Sorcerer() {
		super("empty sorcerer", 0, 0, 0, 0, 0, 0);
	}

	/**
	 * override LevelUp method 
	 * sorcerer has its own level up way
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
		
		//increase 10% dexterity and agility
		super.setDexterity((int) 1.1*super.getDexterity());
		super.setAgility((int) 1.1*super.getAgility());
		
		//increase 5% Strength
		super.setStrength((int) 1.05*super.getStrength());
		
	}

}
