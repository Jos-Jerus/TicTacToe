
import java.util.Scanner;

public class Player {

    private int row, col;

    public Player() {
        
    }
    
    public void playTurn(Board board, Mark mark) {
        Scanner scan = new Scanner(System.in);
        while(true) {
            System.out.println("Please give me the num of the row..");
            row = scan.nextInt();
            System.out.println("Please give me the num of the column..");
            col = scan.nextInt();
            if(board.putMark(mark, row, col)) {
                board.putMark(mark, row, col);
                break;
            }
            else {
                if (board.getMark(row, col) != Mark.BLANK) {
                    System.out.println("!!\nchoose other cell. the cell is already full\n!!");
                }
                else {
                    System.out.printf("!!%nYou need to choose the num of the row and the column between 0 to %d%n!!%n", board.SIZE-1);
                }
            }
        } 
    }
}

