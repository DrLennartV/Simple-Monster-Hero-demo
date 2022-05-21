
/**
 * 	Representative of an Armory extends Equipment
 * 	distinct attribute:
 * 		damReduction -- reduce the percentage of 
 * 		damage from monsters
 * 	Constructor:
 * 		No-arg constructor will generate an armor with
 * 			empty name
 * 		Standard constructor will generate a single
 * 			armor scanned from text file
 */

public class Armory extends Equipment{
	
	
	private int damReduction;
	
	public Armory(String name, int cost, int level, int reduction) {
		super(name, cost, level);
		setDamReduction(reduction);
	}
	
	public Armory() {
		this("empty armory", 0, 0, 0);
	}
	
	/**
	 * set the attribute value
	 * @param reduction value
	 */
	public void setDamReduction(int reduction) {
		this.damReduction = reduction;
	}
	
	/**
	 * get the damage attribute value
	 */
	public int getDamReduction() {
		return this.damReduction;
	}

}
