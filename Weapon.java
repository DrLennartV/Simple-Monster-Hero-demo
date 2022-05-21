
/**
 * representative of a weapon class that extends Equipment
 * distinct attributes:
 * 		damage: weapon's damage
 * 		capacity: how many hands a weapon take
 * Constructor:
 * 		with arguments: super an equipment
 * 		no arguments: create a weapon named empty
 * @author zhaoyuyin
 */
public class Weapon extends Equipment{
	
	private int Damage;
	private int Capacity;
	
	public Weapon(String name, int cost, int level, int damage, int capacity) {
		super(name, cost, level);
		setDamage(damage);
		setCapacity(capacity);
	}
	
	public Weapon() {
		this("empty weapon", 0, 0, 0, 0);
	}
	
	/**
	 * set weapon's damage
	 * @param damage
	 */
	public void setDamage(int damage) {
		this.Damage = damage;
	}
	
	/**
	 * set weapon's capacity cost
	 * @param capacity
	 */
	public void setCapacity(int capacity) {
		this.Capacity = capacity;
	}
	
	/**
	 * get weapon's damage
	 * @return
	 */
	public int getDamage() {
		return this.Damage;
	}
	
	/**
	 * get weapon's capacity cost
	 * @return
	 */
	public int getCapacity() {
		return this.Capacity;
	}

}
