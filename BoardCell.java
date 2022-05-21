
/**
 * 	Representative of each cell in the world board
 * 		Icon -- marks the cell with a specific pattern
 * 		is_Inaccessible -- a boolean to define if the 
 * 			cell represents the inaccessible zones
 * 		is_Market -- a boolean to define the cell is a
 * 			market
 * 		is_Common_Space -- a boolean to define the cell
 * 			is an empty space where the battle may happen
 * 	Constructor:
 * 		No-arg constructor will generate a common space 
 * 			type cell
 * 		Standard constructor will generate a cell with a
 * 			specific cell
 */
public class BoardCell {
	
	private String Icon;
	private boolean is_Inaccessible = false;
	private boolean is_Market = false;
	private boolean is_Common_Space = false;
	
	public BoardCell(int type) {
		if(type == 1) {
			setIsInaccessible(true);
			setIcon("X");
		}
		else if(type == 2) {
			setIsMarket(true);
			setIcon("M");
		}
		else if(type == 3) {
			setIsCommon(true);
			setIcon(" ");
		}
		else {
			System.out.println("/nFail to initial the cell/n");
		}
	}
	
	public BoardCell() {
		this(3);
	}
	
	/**
	 * setIcon is designed to set the specific pattern
	 * @param icon -- represents the pattern
	 */
	public void setIcon(String icon) {
		this.Icon = icon;
	}
	
	/**
	 * getIcon is designed to get the icon
	 */
	public String getIcon() {
		return this.Icon;
	}
	
	/**
	 * setIsInaccessible is designed to set the cell type
	 * to inaccessible
	 * @param Inaccessible -- a boolean to define if the 
	 * 	cell represents the inaccessible zones
	 */
	public void setIsInaccessible(boolean Inaccessible) {
		this.is_Inaccessible = Inaccessible;
	}
	
	/**
	 * getIsInaccessible is designed to get the boolean
	 * to determine the type of this cell
	 */
	public boolean getIsInaccessible() {
		return this.is_Inaccessible;
	}
	
	/**
	 * setIsMarket is designed to set the cell type to market
	 * @param market is a boolean that determines the cell
	 * is a market
	 */
	public void setIsMarket(boolean market) {
		this.is_Market = market;
	}
	
	/**
	 * getIsMarket is designed to get a boolean to 
	 * determine if the cell is a market
	 */
	public boolean getIsMarket() {
		return this.is_Market;
	}
	
	/**
	 * setIsCommon is designed to set the cell type to common
	 * @param common is aboolean that determines the cell
	 * is a common
	 */
	public void setIsCommon(boolean common) {
		this.is_Common_Space = common;
	}
	
	/**
	 * @return boolean that determines if the cell is
	 * a common type
	 */
	public boolean getIsCommon() {
		return this.is_Common_Space;
	}
	
	
}
