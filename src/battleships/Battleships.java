package battleships;

public class Battleships {

    public static int numRows = 10;
    public static int numCols = 10;
    public static String[][] playerboard = new String[numCols][numRows];
    public static String[][] computerboard = new String[numCols][numRows];
    public static int playerShips = 5;
    public static int computerShips = 5;

    public static void main(String[] args) {

        Comments.letsStart();

        PrintMap.seeTheMap(Battleships.playerboard);

        DeployShips.deployPlayerShips();

        DeployShips.deployComputerShips();

        do {
            Fight.battle();
        } while (Battleships.playerShips != 0 && Battleships.computerShips
                != 0);

        Fight.gameOver();
    }

}
