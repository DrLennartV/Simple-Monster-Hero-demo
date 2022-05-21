# CS611-Legends: Monsters and Heroes

Name
-------------------------------------------------------------------------------------------------
--Zhaoyu Yin--
--U26267142--


Files
-------------------------------------------------------------------------------------------------
<Main.java file> - <start the program
<UI.java file> - <print all introduction, context and information
<InputCheck.java file> - <provide the context for user to input and check the correctness
<TxtFileScan.java file> - <scan all the objects in the txt files

<initialGame.java file> - <initial the game with fundamental objects and controls user's movement
<Market.java file> - <represents the market object and logics for buying and selling
<BattleLogic.java file> - <contain all logics and the process in a battle

<WorldBoard.java file> - <represent the board map class that records and print the board
<BoardCell.java file> - <represent the type of each cell in the world board

<Equipment.java file> - <an abstract class that contain the necessary attributes
<Weapon.java file> - <extends Equipment and represents a weapon class
<Armory.java file> - <extends Equipment and represents an armor
<Potions.java file> - <extends Equipment and represents a potion
<Spells.java file> - <extends Equipment and represents the abstract spell class
<IceSpells.java file> - <extends Spells and represents an icespell
<FireSpells.java file> - <extends Spells and represents a firespell
<LightningSpells.java file> - <extends Spells and represents a lightningspell


<Monster.java file> - <an abstract class that contains all necessary attributes of a monster
<Dragon.java file> - <extends Monster and represents dragon
<Exoskeleton.java file> - <extends Monster and represents exoskeleton
<Spirit.java file> - <extends Monster and represents spirit

<Team.java file> - <a class that represents a team which contains several heroes

<Hero.java file> - <an abstract class that contains the necessary information of a hero
<Inventory.java file> - <a class that contains items in the inventory, each hero has his own inventory
<Warrior.java file> - <extends Hero and represents Warrior
<Sorcerer.java file> - <extends Hero and represents Sorcerer
<Paladin.java file> - <extends Hero and represents Paladin

Notes:
-------------------------------------------------------------------------------------------------
1. Files to be parsed should be stored in ConfigFiles, for parser class to read class

2. Bonus:
	The game can print colors on Mac Terminal. I also tried it on Eclipse but it failed.
	The program reserve the general constructor for multiple teams

How to run:
-------------------------------------------------------------------------------------------------
1. Navigate to the directory after downloading the project
2. Run the following instructions on command line:
	javac *.java
	java Main.java (java Main on Mac)
