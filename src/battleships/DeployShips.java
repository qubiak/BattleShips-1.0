package battleships;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DeployShips {

    static void deployPlayerShips() {
        Scanner input = new Scanner(System.in);

        System.out.println("\nDeploy your ships:");

        int shipsOnBoard = 1;
        do {
            try {

                System.out.print("Enter X coordinate for you " + shipsOnBoard + " ships: ");
                int x = input.nextInt();
                System.out.print("Enter Y coordinate for you " + shipsOnBoard + " ships: ");
                int y = input.nextInt();

                if ((x >= 0 && x < Battleships.numRows) && (y >= 0 && y < Battleships.numCols)) {
                    if (Battleships.playerboard[y][x] == " ") {
                        Battleships.playerboard[y][x] = "@";
                        shipsOnBoard++;
                    } else {
                        System.out.println("You can't place two ships on the same place");
                    }
                } else {
                    System.out.println(
                            String.format("You can't put ships outside the %s by %s board. Try again", Battleships.numRows, Battleships.numCols));
                    System.out.println();

                }

            } catch (InputMismatchException obj) {
                System.out.println("You entered the text instead of the number, try again");
                input.nextLine();
            }

        } while (shipsOnBoard <= Battleships.playerShips);

        Comments.playerMap();

        PrintMap.seeTheMap(Battleships.playerboard);

    }

    public static void deployComputerShips() {
        System.out.println("\nNow Computer is deploying ships");

        int i = 0;
        do {

            int a = (int) (Math.random() * 10);
            int b = (int) (Math.random() * 10);

            if ((a >= 0 && a < Battleships.numRows) && (b >= 0 && b < Battleships.numCols) && (Battleships.computerboard[a][b] == null)) {
                Battleships.computerboard[a][b] = "X";
                i++;
                System.out.println(i + ". Computer ship is ready ");

            }

        } while (i < Battleships.computerShips);

        Comments.computerMap();
        PrintMap.seeTheMap(Battleships.computerboard);
    }

}
