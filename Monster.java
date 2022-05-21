
/**
 * Monster is a representative of a class monster
 * attributes:
 * 		Name -- monster's name
 * 		Health -- monster's health
 * 		Level -- monster's level
 * 		Damage -- monster's damage
 * 		dodgeChance -- monster's prob of dodge
 * Constructor:
 * 		with arguments: create a monster with all values
 * 		no arguments: create a monster with empty name
 * @author zhaoyuyin
 */
public abstract class Monster {
	
	protected String Name;
	protected int Health;
	protected int Level;
	protected int Damage;
	protected int Defense;
	protected int dodgeChance;
	
	public Monster(String name, int level, int damage, int defense, int dodgechance) {
		setName(name);
		setLevel(level);
		setDamage(damage);
		setDefense(defense);
		setDodgeChance(dodgechance);
		initialHealth();
	}
	
	public Monster() {
		this("empty monster", 0, 0, 0, 0);
	}
	
	/**
	 * initial monster health
	 */
	public void initialHealth() {
		this.Health = 100*this.Level;
	}
	
	/**
	 * set monster name
	 * @param name
	 */
	public void setName(String name) {
		this.Name = name;
	}
	
	/**
	 * set monster level
	 * @param level
	 */
	public void setLevel(int level) {
		this.Level = level;
	}
	
	/**
	 * set monster damage
	 * @param damage
	 */
	public void setDamage(int damage) {
		this.Damage = damage;
	}
	
	/**
	 * set monster defense
	 * @param defense
	 */
	public void setDefense(int defense) {
		this.Defense = defense;
	}
	
	/**
	 * set monster dodge chance
	 * @param dodgechance
	 */
	public void setDodgeChance(int dodgechance) {
		this.dodgeChance = dodgechance;
	}
	
	/**
	 * get monster name
	 * @return
	 */
	public String getName() {
		return this.Name;
	}
	
	/**
	 * get monster level
	 * @return
	 */
	public int getLevel() {
		return this.Level;
	}
	
	/**
	 * get monster damage
	 * @return
	 */
	public int getDamage() {
		return this.Damage;
	}
	
	/**
	 * get monster defense
	 * @return
	 */
	public int getDefense() {
		return this.Defense;
	}
	
	/**
	 * get monster dodge chance
	 * @return
	 */
	public int getDodgeChance() {
		return this.dodgeChance;
	}
	
	/**
	 * get monster health
	 * @return
	 */
	public int getHealth() {
		return this.Health;
	}
	
	/**
	 * subtract health if damaged
	 * @param finalDamage
	 */
	public void subtractHealth(int finalDamage) {
		if(this.getHealth() > finalDamage) {
			this.Health -= finalDamage;
		}
		else {
			this.Health = 0;
			System.out.println("\nThe Monster " + this.getName() + " has run out of its HP");
		}
	}
	
	/**
	 * reduce the  damage
	 */
	public void subtractDamage() {
		this.Damage *= 0.9;
	}
	
	/**
	 * reduce the defense
	 */
	public void subtractDefense() {
		this.Defense *= 0.9;
	}
	
	/**
	 * reduce the dodgechance
	 */
	public void subtractDodgeChance() {
		this.dodgeChance *= 0.9;
	}

}
