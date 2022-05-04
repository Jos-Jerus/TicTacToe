
enum Mark { X, O, BLANK}
enum Winner {X_WIN, O_WIN, DRAW}

public class Board {

    public static final int SIZE = 3;
    public static final int WIN_STREAK = 3;

    private Mark[][] boardMarks = new Mark[SIZE][SIZE];

    public Board() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                this.boardMarks[row][col] = Mark.BLANK;
            }
        }
    }

    public boolean isGameEnded() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (boardMarks[row][col] == Mark.BLANK) {
                    return false;
                }
            }
        }
        return true;
    }

    private Winner whoTheWinner(Mark mark, int row, int col) {
        int counter = 0;
        for(int i = 0; i < SIZE; i++){
            if(boardMarks[row][i] == mark) {
                counter++;
            }
            else {
                counter = 0;
            }
        }
        if(counter >= WIN_STREAK) {
            if(mark == Mark.O) {
                return Winner.O_WIN;
            }
            else if(mark == Mark.X) {
                return Winner.X_WIN;
            }
        }
        
        counter = 0;
        //check row
        for(int i = 0; i < SIZE; i++){
            if(boardMarks[i][col] == mark) {
                counter++;
            }
            else {
                counter = 0;
            }
        }
        if(counter >= WIN_STREAK) {
            if(mark == Mark.O) {
                return Winner.O_WIN;
            }
            else if(mark == Mark.X) {
                return Winner.X_WIN;
            }
        }

        counter = 0;
        for(int i = 0; i < SIZE; i++){
            if(boardMarks[i][i] == mark) {
                counter++;
            }
            else {
                counter = 0;
            }
        }
        if(counter >= WIN_STREAK) {
            if(mark == Mark.O) {
                return Winner.O_WIN;
            }
            else if(mark == Mark.X) {
                return Winner.X_WIN;
            }
        }

        counter = 0;
        for(int i = 0; i < SIZE; i++){
            if(boardMarks[i][(SIZE-1)-i] == mark) {
                counter++;
            }
            else {
                counter = 0;
            }
        }
        if(counter >= WIN_STREAK) {
            if(mark == Mark.O) {
                return Winner.O_WIN;
            }
            else if(mark == Mark.X) {
                return Winner.X_WIN;
            }
        }
        return Winner.DRAW;
    }
        

    


    public boolean putMark(Mark mark, int row, int col) {
        if (row < 0 || row >= SIZE || col < 0 || col >= SIZE) {
            return false;
        }
        else if (boardMarks[row][col] != Mark.BLANK) {
            return false;
        }
        else {
            boardMarks[row][col] = mark;

            if (whoTheWinner(mark, row, col) == Winner.O_WIN) {
                System.out.println("Congratulation :) .. O win the game %&*");
            }
            else if (whoTheWinner(mark, row, col) == Winner.X_WIN) {
                System.out.println("Congratulation :) .. X win the game %&*");
            }
            else {
                if (isGameEnded()) {
                    System.out.println("The game end with the draw #@");
                }
            }
            return true;
        }
    }
    

    public Mark getMark(int row, int col) {
        if (row < 0 || row >= SIZE || col < 0 || col >= SIZE) {
            return Mark.BLANK;
        }
        else {
            return boardMarks[row][col];
        }
        
    }
    
}
