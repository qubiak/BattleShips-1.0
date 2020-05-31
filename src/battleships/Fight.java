package battleships;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Fight {

    static void battle() {
        playerTurn();
        computerTurn();

        Comments.playerMap();
        PrintMap.seeTheMap(Battleships.playerboard);
        Comments.computerMap();
        PrintMap.seeTheMap(Battleships.computerboard);

        System.out.println();
        System.out.println("Player Ships: " + Battleships.playerShips);
        System.out.println("Computer Ships: " + Battleships.computerShips);
        System.out.println();
    }

    static void playerTurn() {

        int x = -1, y = -1;

        do {
            try {
                Scanner input = new Scanner(System.in);

                System.out.println();
                System.out.println("Now is PLAYER turn");
                System.out.println();
                System.out.println("Enter X coordination: ");
                x = input.nextInt();
                System.out.println("Enter Y coordination: ");
                y = input.nextInt();

                if ((x >= 0 || x <= Battleships.numCols) || (y >= 0 || y <= Battleships.numRows)) {
                    if (Battleships.computerboard[y][x] == "X") {
                        System.out.println("HIT!! Computer is bleeding");
                        Battleships.computerboard[y][x] = "!";
                        Battleships.computerShips--;
                        if (Battleships.computerShips > 0) {
                            Fight.playerTurn();
                        }
                    } else if (Battleships.computerboard[y][x] == " ") {
                        System.out.println("Ohh YOU missed");
                        Battleships.computerboard[y][x] = "-";
                    } else if (Battleships.computerboard[y][x] == "!" | Battleships.computerboard[y][x] == "-") {
                        System.out.println("You have already checke these coordinate, try again");
                        Fight.playerTurn();
                    }

                }
            } catch (ArrayIndexOutOfBoundsException obj) {
                System.out.println(
                        String.format("You can't put ships outside the %s by %s board. Try again", Battleships.numRows, Battleships.numCols));
                   Fight.playerTurn();
            } catch (InputMismatchException obj) {
                System.out.println("You entered the text instead of the number, try again, try again");
                Fight.playerTurn();
            }

        } while ((x < 0 || x >= Battleships.numRows) || (y < 0 || y >= Battleships.numCols));

    }

    static void computerTurn() {

        int x = -1, y = -1;

        do {
            System.out.println();
            System.out.println("Now is COMPUTER tunr");

            x = (int) (Math.random() * 10);
            y = (int) (Math.random() * 10);

            if ((x >= 0 || x <= Battleships.numCols) || (y >= 0 || y <= Battleships.numRows)) {
                if (Battleships.playerboard[y][x] == "X") {
                    System.out.println("HIT!! Player is bleeding");
                    Battleships.playerboard[y][x] = "!";
                    Battleships.playerShips--;
                } else if (Battleships.playerboard[y][x] == " ") {
                    System.out.println("Ohh Computer missed");
                    Battleships.playerboard[y][x] = "-";
                } else if (Battleships.playerboard[y][x] == "!" | Battleships.playerboard[y][x] == "-") {
                    System.out.println("You have already checke these coordinate");

                }

            } else {
                System.out.println(
                        String.format("You can't put ships outside the %s by %s board. Try again", Battleships.numRows, Battleships.numCols));
   

            }

        } while ((x < 0 || x >= Battleships.numRows) || (y < 0 || y >= Battleships.numCols)); 

    }

    static void gameOver() {
        if (Battleships.playerShips > 0 || Battleships.computerShips <= 0) {
            System.out.println("JUPI You WON!!!!");
        } else {
            System.out.println("SORRY you lose :( ");
        }
    }
}
