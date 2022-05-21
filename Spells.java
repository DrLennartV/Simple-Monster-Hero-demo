
/**
 * representative of a spell class that extends equipment
 * distinct attributes:
 * 		damage -- a spell can result
 * 		manacost -- a spell will cost
 * Constructor:
 * 		with arguments: super equipment
 * 		no arguments: create a spell with empty name
 * @author zhaoyuyin
 */
public abstract class Spells extends Equipment{
	
	protected int Damage;
	protected int ManaCost;
	
	public Spells(String name, int cost, int level, int damage, int manacost) {
		super(name, cost, level);
		setDamage(damage);
		setManaCost(manacost);
	}
	
	public Spells() {
		this("empty spells", 0, 0, 0, 0);
	}
	
	/**
	 * set spell's damage
	 * @param damage
	 */
	public void setDamage(int damage) {
		this.Damage = damage;
	}
	
	/**
	 * set spell's mana cost
	 * @param manacost
	 */
	public void setManaCost(int manacost) {
		this.ManaCost = manacost;
	}
	
	/**
	 * get the spell's damage
	 * @return
	 */
	public int getDamage() {
		return this.Damage;
	}
	
	/**
	 * get the spell's manacost
	 * @return
	 */
	public int getManaCost() {
		return this.ManaCost;
	}
	
	/**
	 * heroused method that needs overriding
	 * @param hero
	 * @param monster
	 */
	public abstract void heroUsed(Hero hero, Monster monster);

}
