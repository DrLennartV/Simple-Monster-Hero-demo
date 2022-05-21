
/**
 * Representative of a lightningspell extends spells
 * construct
 * 		no argument: construct a lightningspell object with name
 * 			empty lightningspell
 * 		with arguments: super the spell class
 * @author zhaoyuyin
 */
public class LightningSpells extends Spells{
	
	public LightningSpells(String name, int cost, int level, int damage, int manacost) {
		super(name, cost, level, damage, manacost);
	}
	
	public LightningSpells() {
		super("empty lightningspells", 0, 0, 0, 0);
	}
	
	/**
	 * heroUsed is designed to simulate the process that a hero
	 * cast a spell attack to a monster
	 */
	@Override
	public void heroUsed(Hero hero, Monster monster) {
		// TODO Auto-generated method stub
		int baseDamage = this.getDamage();
		double dexterityInfu = 0.0001 * hero.getDexterity();
		int spellDamage = (int) (0.2 * (baseDamage + dexterityInfu * baseDamage));
		System.out.println("\nHero " + hero.getName() + " takes " + 
				String.valueOf(spellDamage) + " magic damage on " + monster.getName());
		hero.setMana(hero.getMana() - this.getManaCost());
		monster.subtractHealth(spellDamage);
		
		monster.subtractDodgeChance();
	
		hero.deleteSpell(this);
	}

}
