
/**
 * Representative of a dragon class that extends Monster
 * construct
 * 		no argument: construct a dragon object with name
 * 			empty dragon
 * 		with arguments: super the monster class
 * @author zhaoyuyin
 *
 */
public class Dragon extends Monster{
	
	public Dragon(String name, int level, int damage, int defense, int dodgechance) {
		super(name, level, damage, defense, dodgechance);
	}
	
	public Dragon() {
		super("empty dragon", 0, 0, 0, 0);
	}

}
