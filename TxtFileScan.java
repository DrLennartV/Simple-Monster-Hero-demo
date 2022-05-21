
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * this class is designed to scan all text files in a folder
 * attributes:
 * 		br -- a bufferedreader
 * 		filefoldpath -- a path to the folder that consists of all
 * 			necessary text files
 * @author zhaoyuyin
 */
public class TxtFileScan {

	public BufferedReader br;
	public final String filefoldpath = System.getProperty("user.dir") + "/ConfigFiles/";

	public void scanTxtFiles(List<Monster> monsterPool, List<ArrayList<? extends Hero>> heroPool, Market market) throws IOException {
		scanMonsters(monsterPool);
		scanHeroes(heroPool);
		scanWeapon(market.getWeaponPool());
		scanArmory(market.getArmoryPool());
		scanSpell(market.getSpellsPool());
		scanPotion(market.getPotionsPool());
		br.close();
	}

	/**
	 * scan three types of monsters
	 * @param monsterPool
	 */
	public void scanMonsters(List<Monster> monsterPool) {
		try {
			String filepath = filefoldpath + "Dragons.txt";
			InputStreamReader reader = new InputStreamReader(new FileInputStream(new File(filepath)));
			br = new BufferedReader(reader);
			String line = br.readLine();
			while ((line = br.readLine()) != null) {
				String[] eachObject = line.split("\\s+");
				if(eachObject.length == 5) {
					Dragon dragon = new Dragon(eachObject[0], Integer.parseInt(eachObject[1]), Integer.parseInt(eachObject[2]),
							Integer.parseInt(eachObject[3]), Integer.parseInt(eachObject[4]));
					monsterPool.add(dragon);
				}
			}
		}catch(Exception e) {
			System.out.println("Fail to import dragon txt file" + e);
		}


		try {
			String filepath = filefoldpath + "Exoskeletons.txt";
			InputStreamReader reader = new InputStreamReader(new FileInputStream(new File(filepath)));
			br = new BufferedReader(reader);
			String line = br.readLine();
			while ((line = br.readLine()) != null) {
				String[] eachObject = line.split("\\s+");
				if(eachObject.length == 5) {
					Exoskeleton exoskeleton = new Exoskeleton(eachObject[0], Integer.parseInt(eachObject[1]), Integer.parseInt(eachObject[2]),
							Integer.parseInt(eachObject[3]), Integer.parseInt(eachObject[4]));
					monsterPool.add(exoskeleton);
				}
			}
		}catch(Exception e) {
			System.out.println("Fail to import exoskeletons txt file" + e);
		}

		try {
			String filepath = filefoldpath + "Spirits.txt";
			InputStreamReader reader = new InputStreamReader(new FileInputStream(new File(filepath)));
			br = new BufferedReader(reader);
			String line = br.readLine();
			while ((line = br.readLine()) != null) {
				String[] eachObject = line.split("\\s+");
				if(eachObject.length == 5) {
					Spirit spirit = new Spirit(eachObject[0], Integer.parseInt(eachObject[1]), Integer.parseInt(eachObject[2]),
							Integer.parseInt(eachObject[3]), Integer.parseInt(eachObject[4]));
					monsterPool.add(spirit);
				}
			}
		}catch(Exception e) {
			System.out.println("Fail to import spirit txt file" + e);
		}

	}

	/**
	 * scan three types of heroes
	 * @param heroPool
	 */
	public void scanHeroes(List<ArrayList<? extends Hero>> heroPool) {
		ArrayList<Warrior> warriors = new ArrayList<Warrior>();
		ArrayList<Sorcerer> sorcerers = new ArrayList<Sorcerer>();
		ArrayList<Paladin> paladins = new ArrayList<Paladin>();
		try {
			String filepath =  filefoldpath + "Warriors.txt";
			InputStreamReader reader = new InputStreamReader(new FileInputStream(new File(filepath)));
			br = new BufferedReader(reader);
			String line = br.readLine();
			while ((line = br.readLine()) != null) {
				String[] eachObject = line.split("\\s+");
				if(eachObject.length == 7) {
					Warrior warrior = new Warrior(eachObject[0], Integer.parseInt(eachObject[1]), Integer.parseInt(eachObject[2]),
							Integer.parseInt(eachObject[3]), Integer.parseInt(eachObject[4]), Integer.parseInt(eachObject[5]), Integer.parseInt(eachObject[6]));
					warriors.add(warrior);
				}
			}
		}catch(Exception e) {
			System.out.println("Fail to import warrior txt file" + e);
		}


		try {
			String filepath = filefoldpath + "Sorcerers.txt";
			InputStreamReader reader = new InputStreamReader(new FileInputStream(new File(filepath)));
			br = new BufferedReader(reader);
			String line = br.readLine();
			while ((line = br.readLine()) != null) {
				String[] eachObject = line.split("\\s+");
				if(eachObject.length == 7) {
					Sorcerer sorcerer = new Sorcerer(eachObject[0], Integer.parseInt(eachObject[1]), Integer.parseInt(eachObject[2]),
							Integer.parseInt(eachObject[3]), Integer.parseInt(eachObject[4]), Integer.parseInt(eachObject[5]), Integer.parseInt(eachObject[6]));
					sorcerers.add(sorcerer);
				}
			}
		}catch(Exception e) {
			System.out.println("Fail to import sorcerer txt file" + e);
		}

		try {
			String filepath = filefoldpath + "Paladins.txt";
			InputStreamReader reader = new InputStreamReader(new FileInputStream(new File(filepath)));
			br = new BufferedReader(reader);
			String line = br.readLine();
			while ((line = br.readLine()) != null) {
				String[] eachObject = line.split("\\s+");
				if(eachObject.length == 7) {
					Paladin paladin = new Paladin(eachObject[0], Integer.parseInt(eachObject[1]), Integer.parseInt(eachObject[2]),
							Integer.parseInt(eachObject[3]), Integer.parseInt(eachObject[4]), Integer.parseInt(eachObject[5]), Integer.parseInt(eachObject[6]));
					paladins.add(paladin);
				}
			}
		}catch(Exception e) {
			System.out.println("Fail to import Paladin txt file" + e);
		}
		heroPool.add(warriors);
		heroPool.add(sorcerers);
		heroPool.add(paladins);

	}

	/**
	 * scan all weapons
	 * @param weaponPool
	 */
	public void scanWeapon(ArrayList<Weapon> weaponPool) {
		try {
			String filepath = filefoldpath + "Weaponry.txt";
			InputStreamReader reader = new InputStreamReader(new FileInputStream(new File(filepath)));
			br = new BufferedReader(reader);
			String line = br.readLine();
			while ((line = br.readLine()) != null) {
				String[] eachObject = line.split("\\s+");
				if(eachObject.length == 5) {
					Weapon weapon = new Weapon(eachObject[0], Integer.parseInt(eachObject[1]), Integer.parseInt(eachObject[2]),
							Integer.parseInt(eachObject[3]), Integer.parseInt(eachObject[4]));
					weaponPool.add(weapon);
				}
			}
		}catch(Exception e) {
			System.out.println("Fail to import weapon txt file" + e);
		}
	}

	/**
	 * scan all armors
	 * @param armoryPool
	 */
	public void scanArmory(ArrayList<Armory> armoryPool) {
		try {
			String filepath = filefoldpath + "Armory.txt";
			InputStreamReader reader = new InputStreamReader(new FileInputStream(new File(filepath)));
			br = new BufferedReader(reader);
			String line = br.readLine();
			while ((line = br.readLine()) != null) {
				String[] eachObject = line.split("\\s+");
				if(eachObject.length == 4) {
					Armory armory = new Armory(eachObject[0], Integer.parseInt(eachObject[1]), Integer.parseInt(eachObject[2]),
							Integer.parseInt(eachObject[3]));
					armoryPool.add(armory);
				}
			}
		}catch(Exception e) {
			System.out.println("Fail to import armory txt file" + e);
		}
	}

	/**
	 * scan three types of spells
	 * @param spellsPool
	 */
	public void scanSpell(List<ArrayList<? extends Spells>> spellsPool) {
		ArrayList<IceSpells> icespells = new ArrayList<IceSpells>();
		ArrayList<FireSpells> firespells = new ArrayList<FireSpells>();
		ArrayList<LightningSpells> lightningspells = new ArrayList<LightningSpells>();
		try {
			String filepath = filefoldpath + "IceSpells.txt";
			InputStreamReader reader = new InputStreamReader(new FileInputStream(new File(filepath)));
			br = new BufferedReader(reader);
			String line = br.readLine();
			while ((line = br.readLine()) != null) {
				String[] eachObject = line.split("\\s+");
				if(eachObject.length == 5) {
					IceSpells icespell = new IceSpells(eachObject[0], Integer.parseInt(eachObject[1]), Integer.parseInt(eachObject[2]),
							Integer.parseInt(eachObject[3]), Integer.parseInt(eachObject[4]));
					icespells.add(icespell);
				}
			}
		}catch(Exception e) {
			System.out.println("Fail to import icespells txt file" + e);
		}


		try {
			String filepath = filefoldpath + "FireSpells.txt";
			InputStreamReader reader = new InputStreamReader(new FileInputStream(new File(filepath)));
			br = new BufferedReader(reader);
			String line = br.readLine();
			while ((line = br.readLine()) != null) {
				String[] eachObject = line.split("\\s+");
				if(eachObject.length == 5) {
					FireSpells firespell = new FireSpells(eachObject[0], Integer.parseInt(eachObject[1]), Integer.parseInt(eachObject[2]),
							Integer.parseInt(eachObject[3]), Integer.parseInt(eachObject[4]));
					firespells.add(firespell);
				}
			}
		}catch(Exception e) {
			System.out.println("Fail to import firespells txt file" + e);
		}

		try {
			String filepath = filefoldpath + "LightningSpells.txt";
			InputStreamReader reader = new InputStreamReader(new FileInputStream(new File(filepath)));
			br = new BufferedReader(reader);
			String line = br.readLine();
			while ((line = br.readLine()) != null) {
				String[] eachObject = line.split("\\s+");
				if(eachObject.length == 5) {
					LightningSpells lightningspell = new LightningSpells(eachObject[0], Integer.parseInt(eachObject[1]), Integer.parseInt(eachObject[2]),
							Integer.parseInt(eachObject[3]), Integer.parseInt(eachObject[4]));
					lightningspells.add(lightningspell);
				}
			}
		}catch(Exception e) {
			System.out.println("Fail to import lightningspells txt file" + e);
		}
		spellsPool.add(icespells);
		spellsPool.add(firespells);
		spellsPool.add(lightningspells);
	}

	/**
	 * scan all potions
	 * @param potionsPool
	 */
	public void scanPotion(ArrayList<Potions> potionsPool) {
		try {
			String filepath = filefoldpath + "Potions.txt";
			InputStreamReader reader = new InputStreamReader(new FileInputStream(new File(filepath)));
			br = new BufferedReader(reader);
			String line = br.readLine();
			while ((line = br.readLine()) != null) {
				String[] eachObject = line.split("\\s+");
				String attributes = eachObject[eachObject.length - 1];
				boolean health = attributes.contains("Health");
				boolean mana = attributes.contains("Mana");
				boolean strength = attributes.contains("Strength");
				boolean dexterity = attributes.contains("Dexterity");
				boolean defense = attributes.contains("Defense");
				boolean agility = attributes.contains("Agility");
				Potions potion = new Potions(eachObject[0],Integer.parseInt(eachObject[1]), Integer.parseInt(eachObject[2]), Integer.parseInt(eachObject[3]),
						health, strength, mana, dexterity, defense, agility);
				potionsPool.add(potion);
			}
		}catch(Exception e) {
			System.out.println("Fail to import potions txt file" + e);
		}
	}
}
