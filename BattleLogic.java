
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 	Representative of a battle logic in this game
 * 	method run controls all procedures in a battle
 */
public class BattleLogic {

	public void run(Team team, List<Monster> MonsterPool, UI gameUI, InputCheck userInput) {
		gameUI.BattleStart();
		List<Monster> randMonster = randomMonsterTeam(team, MonsterPool);
		//rounds in battle
		while(this.teamAlive(team) && this.monstersAlive(randMonster)) {
			gameUI.DisplayBattleTeam(team);
			gameUI.DisplayBattleMonster(randMonster);

			//heroes' turns
			for(int i = 0; (i < team.getTeamSize()) && (this.monstersAlive(randMonster)); i++) {
				if(team.getHero(i).getHealth() > 0) {

					boolean checkInfo = true;
					while(checkInfo) {
						System.out.println("\nHero " + team.getHero(i).getName() + " takes the turn ");
						String heroAction = userInput.battleSelect();

						//check information
						if(heroAction.equalsIgnoreCase("i")) {
							this.battleInfoShow(team, randMonster, gameUI);
							checkInfo = true;
						}
						//regular attack
						else if(heroAction.equals("1")) {
							if(this.monstersAlive(randMonster) == true) {
								int targetIndex = selectMonsterTarget(i, randMonster);
								double monsterDodgeProb = (double) (0.01*randMonster.get(targetIndex).getDodgeChance());
								double randomNumber = Math.random();
								if(randomNumber >= 0 && randomNumber <= monsterDodgeProb) {
									System.out.println("\nThe Hero " + team.getHero(i).getName() + "'s attack MISS! ");
								}
								else {
									this.regularAttack(team.getHero(i), randMonster.get(targetIndex));
								}
							}
							checkInfo = false;
						}
						//cast a spell
						else if(heroAction.equals("2")) {
							if(this.monstersAlive(randMonster) == true) {
								int targetIndex = selectMonsterTarget(i, randMonster);
								double monsterDodgeProb = (double) (0.01*randMonster.get(targetIndex).getDodgeChance());
								double randomNumber = Math.random();
								if(randomNumber >= 0 && randomNumber <= monsterDodgeProb) {
									System.out.println("\nThe Hero " + team.getHero(i).getName() + "'s attack MISS! ");
								}
								else {
									if(team.getHero(i).getspells().size() > 0) {
										System.out.println("\nSpells the hero " + team.getHero(i).getName() + " has:");
										gameUI.DisplaySpell(team.getHero(i).getspells());
										String chooseMessage = "Enter # to choose: ";
										int itemIndex = userInput.inventorySelect(team.getHero(i).getspells().size(), chooseMessage) - 1;

										if(team.getHero(i).getSpell(itemIndex).getManaCost() <= team.getHero(i).getMana()) {
											team.getHero(i).getSpell(itemIndex).heroUsed(team.getHero(i), randMonster.get(targetIndex));
										}
										else {
											System.out.println("The hero has insufficient Mana. Use regular attack instead");
											this.regularAttack(team.getHero(i), randMonster.get(targetIndex));
										}
									}
									else {
										System.out.println("\nSorry the hero has no spells. Use regular attack instead");
										this.regularAttack(team.getHero(i), randMonster.get(targetIndex));
									}
								}
							}
							checkInfo = false;
						}
						//use a potion
						else if(heroAction.equals("3")) {
							team.getHero(i).usePotion(gameUI, userInput);
							checkInfo = false;
						}
						//change the weapon
						else if(heroAction.equals("4")) {
							team.getHero(i).changeWeapon(gameUI, userInput);
							checkInfo = false;
						}
					}
				}
			}
			//monsters' turns
			for(int i = 0; (i < randMonster.size()) && (this.teamAlive(team)); i++) {
				//check if the monster is alive
				if(randMonster.get(i).getHealth() > 0) {
					//if the hero team is stil alive
					if(this.teamAlive(team) == true) {
						int targetIndex;
						if(team.getHero(i).getHealth() > 0) {
							targetIndex = i;
						}
						else {
							int firstAliveHero = 0;
							for(int j = 0; j < team.getTeamSize(); j++) {
								if(team.getHero(j).getHealth() > 0) {
									firstAliveHero = j;
									break;
								}
							}
							targetIndex = firstAliveHero;
						}
						double heroDodgeProb = (0.0002 * team.getHero(targetIndex).getAgility());
						double randomNumber = Math.random();
						if(randomNumber >= 0 && randomNumber <= heroDodgeProb) {
							System.out.println("The monster " + randMonster.get(i).getName() + "'s attack MISS! ");
						}
						else {
							int damage = (int) (0.1*randMonster.get(i).getDamage());
							int finalDamage;
							if(team.getHero(targetIndex).getEquipArmor() != null) {
								int armorReduction = (int) (0.01*team.getHero(targetIndex).getEquipArmor().getDamReduction());
								finalDamage = damage - armorReduction;
							}
							else {
								finalDamage = damage;
							}
							System.out.println("\nMonster " + randMonster.get(i).getName() + " takes " +
												String.valueOf(finalDamage) + " damage on " + team.getHero(targetIndex).getName());

							team.getHero(targetIndex).subtractHealth(finalDamage);
						}
					}
					else {
						break;
					}
				}
			}

			//for each alive hero regain 10% hp and mana
			this.heroRegain(team);
		}

		//battle ends
		gameUI.BattleEnd();
		//team wins
		if(this.teamAlive(team)) {
			this.teamWin(team, randMonster);
		}
		//team loses
		else {
			this.teamLose(team);
		}
	}


	/**
	 * randomMonsterTeam will generate a monster team with the same number
	 * as heroes randomly. All monster's levels are the same as the hero
	 * with highest level
	 * @param Team -- represents hero team
	 * @param monsterpool -- represents the whole pool with all monster kinds
	 */
	public List<Monster> randomMonsterTeam(Team team, List<Monster> monsterpool){
		int heroTeamSize = team.getTeamSize();
		int maxiHeroLevel = 0;
		//find the maximal hero level in hero team
		for(int i = 0; i < heroTeamSize; i++) {
			if(team.getHero(i).getLevel() > maxiHeroLevel) {
				maxiHeroLevel = team.getHero(i).getLevel();
			}
		}
		List<Monster> randomMonster = new ArrayList<>();
		int count = 1;
		while(count <= heroTeamSize) {
			Collections.shuffle(monsterpool);
			for(Monster monster : monsterpool) {
				if((monster.getLevel() == maxiHeroLevel) && (!randomMonster.contains(monster))) {
					randomMonster.add(monster);
					count++;
					break;
				}
			}
		}
		return randomMonster;
	}

	/**
	 * teamAlive is designed to check if there remains any hero that has HP
	 * @param Team -- represents hero team
	 */
	public boolean teamAlive(Team team) {
		boolean areAlive = false;
		for(int i = 0; i < team.getTeamSize(); i++) {
			if(team.getHero(i).getHealth() > 0) {
				areAlive = true;
				break;
			}
		}
		return areAlive;
	}

	/**
	 * monsterAlive is designed to check if there remains any monster that has HP
	 * @param monsters -- represents the generated random monster team
	 */
	public boolean monstersAlive(List<Monster> monsters) {
		boolean areAlive = false;
		for(int i = 0; i < monsters.size(); i++) {
			if(monsters.get(i).getHealth() > 0) {
				areAlive = true;
				break;
			}
		}
		return areAlive;
	}

	/**
	 * teamWin is designed to revive and bonus the heroes after battle
	 * @param Team -- represents hero team
	 * @param monsters -- represents the generated random monster team
	 */
	public void teamWin(Team team, List<Monster> monsters) {
		int monsterLevel = monsters.get(0).getLevel();
		for(int i = 0; i < team.getTeamSize(); i++) {
			if(team.getHero(i).getHealth() > 0) {
				team.getHero(i).setMoney(team.getHero(i).getMoney() + 100*monsterLevel);
				team.getHero(i).setExp(team.getHero(i).getExp() + 2);
				//hero levels up
				if(team.getHero(i).getExp() > (10*team.getHero(i).getLevel())) {
					team.getHero(i).LevelUp();
				}
			}
			else {
				System.out.println("The Hero " + team.getHero(i).getName() + " is revived by teammates and get half HP");
			}
		}
		team.teamMemberDisplay();
	}

	/**
	 * teamLose is designed to revive 50% HP to all heroes
	 * @param Team -- represents hero team
	 */
	public void teamLose(Team team) {
		System.out.println("\nAll heroes lose half of their money");
		System.out.println("\nAll heroes revive 50 HP");
		for(int i = 0; i < team.getTeamSize(); i++) {
			team.getHero(i).setMoney(team.getHero(i).getMoney()/2);
			team.getHero(i).addHealth(50);
		}
	}

	/**
	 * heroRegain is designed to regain 10% HP and Mana after each round
	 * during the entire battle
	 * @param Team -- represents hero team
	 */
	public void heroRegain(Team team) {
		System.out.println("\nAll alive heroes regain 10% HP and Mana ");
		for(int i = 0; i < team.getTeamSize(); i++) {
			if(team.getHero(i).getHealth() > 0) {
				team.getHero(i).addHealth((int) (0.1* team.getHero(i).getHealth()));
				team.getHero(i).setMana((int) (1.1*team.getHero(i).getMana()));
			}
		}
	}

	/**
	 * battleInfoShow is designed to show both heroes and monsters' information
	 * if the player enters i
	 * @param Team -- represents hero team
	 * @param monsters -- represents the generated random monster team
	 * @param gameUI -- the class that controls all context show
	 */
	public void battleInfoShow(Team team, List<Monster> monsters, UI gameUI) {
		System.out.println("\nHeroes in team: ");
		for(int i = 0; i < team.getTeamSize(); i++) {
			System.out.println("\n# Name       Level/  HP/  Mana");
			System.out.println(String.valueOf(i+1) + " " +
								team.getHero(i).getName() + "     " +
								team.getHero(i).getLevel() + "    " +
								team.getHero(i).getHealth() + "    " +
								team.getHero(i).getMana());
			System.out.println("\nWeapons:");
			gameUI.DisplayWeapon(team.getHero(i).getEquipWeapon());
			System.out.println("\nArmor:");
			gameUI.DisplayEquipArmor(team.getHero(i).getEquipArmor());
		}
		System.out.println("\n----------------------------------------------------------: ");
		System.out.println("Monsters: \n");
		gameUI.DisplayBattleMonster(monsters);
	}

	/**
	 * regularAttack is designed implement regular attack from a hero
	 * to a specific monster
	 * @param Team -- represents hero team
	 * @param monsters -- represents the generated random monster team
	 */
	public void regularAttack(Hero hero, Monster monster) {
		int damage = (int) (0.05* (hero.getStrength() + hero.getWeaponsDamage()));
		int monsterDefense = (int) (0.1 * monster.getDefense());
		int finalDamage = damage - monsterDefense;
		if(finalDamage < 0) finalDamage = 0;
		System.out.println("\nHero " + hero.getName() + " takes " +
				String.valueOf(finalDamage) + " damage on " + monster.getName());
		monster.subtractHealth(finalDamage);
	}

	/**
	 * battleInfoShow is designed to select the first alive monster target
	 * if the corresponding target is down, find the new monster
	 * @param Team -- represents hero team
	 * @param monsters -- represents the generated random monster team
	 */
	public int selectMonsterTarget(int heroIndex, List<Monster> monsters) {
		int targetIndex;
		if(monsters.get(heroIndex).getHealth() > 0) {
			targetIndex = heroIndex;
		}
		else {
			int firstAliveMonster = 0;
			for(int j = 0; j < monsters.size(); j++) {
				if(monsters.get(j).getHealth() > 0) {
					firstAliveMonster = j;
					break;
				}
			}
			targetIndex = firstAliveMonster;
		}
		return targetIndex;
	}


}
