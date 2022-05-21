
/**
 * Representative of a Exoskeleton class that extends Monster
 * construct
 * 		no argument: construct a Exoskeleton object with name
 * 			empty Exoskeleton
 * 		with arguments: super the monster class
 * @author zhaoyuyin
 *
 */
public class Exoskeleton extends Monster{
	
	public Exoskeleton(String name, int level, int damage, int defense, int dodgechance) {
		super(name, level, damage, defense, dodgechance);
	}
	
	public Exoskeleton() {
		super("empty exoskeleton", 0, 0, 0, 0);
	}

}
