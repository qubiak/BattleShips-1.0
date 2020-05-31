package battleships;

public class PrintMap {

    static void seeTheMap(String[][] board) {

        System.out.print("  ");
        for (int i = 0; i < Battleships.numCols; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == null) {
                    board[i][j] = " ";
                }
                if (j == 0) {
                    System.out.print(i + "| " + board[i][j]);
                } else if (j == board[i].length - 1) {
                    System.out.print(board[i][j] + " |" + i);
                } else {
                    System.out.print(board[i][j] + " ");
                }
            }
            System.out.println();
        }

        System.out.print("  ");
        for (int i = 0; i < Battleships.numCols; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

    }

}
