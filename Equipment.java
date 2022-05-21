
/**representative all objects such as weapons, potions
 * armors and spells. 
 * It contains three same attributes
 * 		Name, Cost, Level -- required level to buy/use
 * Constructor
 * 		no arguments: create an equipment named empty
 * 		with arguments: create an equipment with three
 * 		specific attributes.
 * @author zhaoyuyin
 */
public class Equipment {
	
	private String Name;
	private int Cost;
	private int Level;
	
	public Equipment(String name, int cost, int level) {
		setName(name);
		setCost(cost);
		setLevel(level);
	}
	
	public Equipment() {
		this("Empty equipment", 0, 0);
	}
	
	/**
	 * setName is used to set the name
	 * @param name --  attribute name
	 */
	public void setName(String name) {
		this.Name = name;
	}
	
	/**
	 * setCost is used to set cost
	 * @param cost -- money cost
	 */
	public void setCost(int cost) {
		this.Cost = cost;
	}
	
	/**
	 * setLevel is used to set level
	 * @param level -- required level
	 */
	public void setLevel(int level) {
		this.Level = level;
	}
	
	/**
	 * getName is used to get the name
	 * @return -- return string name
	 */
	public String getName() {
		return this.Name;
	}
	
	/**
	 * getCost is used to get the cost
	 * @return -- return integer cost
	 */
	public int getCost() {
		return this.Cost;
	}
	
	/**
	 * getLevel is used to get the level
	 * @return -- return integer level
	 */
	public int getLevel() {
		return this.Level;
	}

}
