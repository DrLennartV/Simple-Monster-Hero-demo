
/**
 * Paladin is a representative of a class Paladin
 * that extends from hero
 * Constructor
 * 		with arguments: super a hero
 * 		no arguments: create a paladin with empty name
 * @author zhaoyuyin
 */
public class Paladin extends Hero{

	public Paladin(String name, int mana, int strength, int agility, int dexterity, int money, int expLevel) {
		super(name, mana, strength, agility, dexterity, money, expLevel);
		// TODO Auto-generated constructor stub
	}
	
	public Paladin() {
		super("empty padadin", 0, 0, 0, 0, 0, 0);
	}

	/**
	 * override LevelUp method 
	 * paladin has its own level up way
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
		
		//increase 10% strength and dexterity
		super.setStrength((int) 1.1*super.getStrength());
		super.setDexterity((int) 1.1*super.getDexterity());
		
		//increase 5% agility
		super.setAgility((int) 1.05*super.getAgility());
		
	}

}
