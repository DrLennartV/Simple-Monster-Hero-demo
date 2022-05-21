
/**
 * representative of a board that shows the map
 * attribute:
 * 		size -- set the board's width
 * 		2d array boardCell -- store each cell
 * 		Inaccess_Possibility -- set the probability
 * 			of generating an inaccess cell
 * 	Constructor:
 * 		no arguments: set the default size to 8
 * 		with arguments: set the size to a specific int
 * @author zhaoyuyin
 *
 */
public class WorldBoard {

	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";

	private int size;
	private BoardCell[][] board;
	private double Inaccess_Possibility = 0.2;
	private double Market_Possibility = 0.3;
	private double Common_Possibility = 0.5;

	public WorldBoard(int size) {
		setSize(size);
		this.board = new BoardCell[size][size];
	}

	public WorldBoard() {
		this(8);
	}

	/**
	 * get size
	 * @return int
	 */
	public int getSize() {
		return size;
	}

	/**
	 * set size
	 * @param newSize
	 */
	public void setSize(int newSize) {
		this.size = newSize;
	}

	/**
	 * random generate an integer that represents
	 * the type of a cell
	 * @return
	 */
	private int randomCellType() {
		double randomNumber;
		randomNumber = Math.random();
		if(randomNumber >= 0 && randomNumber <= Inaccess_Possibility) {
			return 1;
		}
		else if(randomNumber > Inaccess_Possibility && randomNumber <= Inaccess_Possibility + Market_Possibility) {
			return 2;
		}
		else if(randomNumber > Inaccess_Possibility + Market_Possibility && randomNumber <= Inaccess_Possibility + Market_Possibility+ Common_Possibility) {
			return 3;
		}
		return -1;
	}

	/**
	 * check if team's up is inaccessible
	 * @param team
	 * @return boolean
	 */
	public boolean upIsInaccess(Team team) {
		if(board[team.getRowPosition()-1][team.getColPosition()].getIsInaccessible()) {
			return true;
		}
		return false;
	}

	/**
	 * check if team's left is inaccessible
	 * @param team
	 * @return boolean
	 */
	public boolean leftIsInaccess(Team team) {
		if(board[team.getRowPosition()][team.getColPosition()-1].getIsInaccessible()) {
			return true;
		}
		return false;
	}

	/**
	 * check if team's down is inaccessible
	 * @param team
	 * @return boolean
	 */
	public boolean downIsInaccess(Team team) {
		if(board[team.getRowPosition()+1][team.getColPosition()].getIsInaccessible()) {
			return true;
		}
		return false;
	}

	/**
	 * check if team's right is inaccessible
	 * @param team
	 * @return boolean
	 */
	public boolean rightIsInaccess(Team team) {
		if(board[team.getRowPosition()][team.getColPosition()+1].getIsInaccessible()) {
			return true;
		}
		return false;
	}

	/**
	 * get a specific cell with x and y postion
	 * @param row
	 * @param col
	 * @return Cell
	 */
	public BoardCell getCell(int row, int col) {
		return board[row][col];
	}

	/**
	 * random generate a world with three kinds
	 * of cells
	 * @param team
	 */
	public void initialWorld(Team team) {
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				if(i == (size-1)/2) {
					if(j == ((size-1)/2)-1) {
						board[i][j] = new BoardCell(1);
					}
					else if(j == (size-1)/2) {
						board[i][j] = new BoardCell(3);
					}
					else if(j == ((size-1)/2)+1) {
						board[i][j] = new BoardCell(2);
					}
					else {
						int type = randomCellType();
						BoardCell cell = new BoardCell(type);
						board[i][j] = cell;
					}
				}
				else {
					int type = randomCellType();
					BoardCell cell = new BoardCell(type);
					board[i][j] = cell;
				}
			}
		}
		team.setRowPosition((size-1)/2);
		team.setColPosition((size-1)/2);
	}

	/**
	 * print the world and team's icon
	 * @param team
	 */
	public void showWorld(Team team) {

		System.out.println("");
		//print the line +--+--+--+--+ in board
		String style1 = "";
		for(int i = 0; i < size; i++) {
			style1 += "+--";
		}
		style1 += "+";

		//print the line |  |  |  |  | in board
		for(int j = 0; j < size; j++) {
			System.out.println(style1);
			for(int m = 0; m < size; m++) {
				System.out.print("|");
				if(j == team.getRowPosition() && m == team.getColPosition()) {
					System.out.print(ANSI_RED + team.getTeamName() + " " + ANSI_RESET);
				}
				else {
					if(board[j][m].getIsInaccessible()) {
						System.out.print(ANSI_YELLOW + board[j][m].getIcon() + " " + ANSI_RESET);
					}
					else if(board[j][m].getIsMarket()) {
						System.out.print(ANSI_GREEN + board[j][m].getIcon() + " " + ANSI_RESET);
					}
					else {
						System.out.print(board[j][m].getIcon() + " ");
					}
				}
			}
			System.out.println("|");

		}
		System.out.println(style1);
		System.out.println("\nX means forbidden zone. M means Market. ");
		System.out.println("");
	}

}
