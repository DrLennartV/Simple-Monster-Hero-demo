
/**
 * representative of a potion that extends Equipment
 * attributes:
 * 		health -- if the potion boosts health
 * 		Strength -- if the potion boots strength
 * 		Mana -- if the potion boots Mana
 * 		Dexterity -- if the potion boots Dexterity
 * 		Defense -- if the potion boots Defense
 * 		Agility -- if the potion boots Agility
 * Constructor:
 * 		with arguments: super several attributes in equipment
 * 			and set distinct attributes
 * 		no arguments: create a potion with empty name
 * @author zhaoyuyin
 *
 */
public class Potions extends Equipment{
	
	private int Boost;
	
	private boolean Health;
	private boolean Strength;
	private boolean Mana;
	private boolean Dexterity;
	private boolean Defense;
	private boolean Agility;
	
	public Potions(String name, int cost, int level, int boost, boolean health, boolean strength, boolean mana, 
			boolean dexterity, boolean defense, boolean agility) {
		super(name, cost, level);
		setBoost(boost);
		setHealth(health);
		setStrength(strength);
		setMana(mana);
		setDexterity(dexterity);
		setDefense(defense);
		setAgility(agility);
	}
	
	public Potions() {
		this("empty potion", 0, 0, 0, false, false, false, false, false, false);
	}
	
	/**
	 * boost the hero's corresponding attributes
	 * @param hero
	 */
	public void heroUsed(Hero hero) {
		if(Health) hero.addHealth(Boost);
		if(Strength) hero.setStrength(hero.getStrength() + Boost);
		if(Mana) hero.setMana(hero.getMana() + Boost);
		if(Dexterity) hero.setDexterity(hero.getDexterity() + Boost);
		if(Agility) hero.setAgility(hero.getAgility() + Boost);
		hero.deletePotion(this);
	}
	
	/**
	 * set the boost value
	 * @param boost
	 */
	public void setBoost(int boost) {
		this.Boost = boost;
	}
	
	/**
	 * set if boosts health
	 * @param health
	 */
	public void setHealth(boolean health) {
		this.Health = health;
	}
	
	/**
	 * set if boosts strength
	 * @param strength
	 */
	public void setStrength(boolean strength) {
		this.Strength = strength;
	}
	
	/**
	 * set if boosts mana
	 * @param mana
	 */
	public void setMana(boolean mana) {
		this.Mana = mana;
	}
	
	/**
	 * set if boosts dexterity
	 * @param dexterity
	 */
	public void setDexterity(boolean dexterity) {
		this.Dexterity = dexterity;
	}
	
	/**
	 * set if boosts defense
	 * @param defense
	 */
	public void setDefense(boolean defense) {
		this.Defense = defense;
	}
	
	/**
	 * set if boosts agility
	 * @param agility
	 */
	public void setAgility(boolean agility) {
		this.Agility = agility;
	}
	
	/**
	 * get the boost value
	 * @return
	 */
	public int getBoost() {
		return this.Boost;
	}
	
	/**
	 * get if boosts health
	 * @param health
	 */
	public boolean getHealth() {
		return this.Health;
	}
	
	/**
	 * get if boosts Strength
	 * @param Strength
	 */
	public boolean getStrength() {
		return this.Strength;
	}
	
	/**
	 * get if boosts Mana
	 * @param Mana
	 */
	public boolean getMana() {
		return this.Mana;
	}
	
	/**
	 * get if boosts Dexterity
	 * @param Dexterity
	 */
	public boolean getDexterity() {
		return this.Dexterity;
	}
	
	/**
	 * get if boosts Defense
	 * @param Defense
	 */
	public boolean getDefense() {
		return this.Defense;
	}
	
	/**
	 * get if boosts Agility
	 * @param Agility
	 */
	public boolean getAgility() {
		return this.Agility;
	}
	
	

}
