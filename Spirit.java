
/**
 * Representative of a Spirit class that extends Monster
 * construct
 * 		no argument: construct a Spirit object with name
 * 			empty Spirit
 * 		with arguments: super the monster class
 * @author zhaoyuyin
 *
 */
public class Spirit extends Monster{
	
	public Spirit(String name, int level, int damage, int defense, int dodgechance) {
		super(name, level, damage, defense, dodgechance);
	}
	
	public Spirit() {
		super("empty spirit", 0, 0, 0, 0);
	}

}
