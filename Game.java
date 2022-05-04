public class Game {

    public static void main(String[] args) {
        run();
        
    }
    private static void run() {
        Board board = new Board();
        Renderer renderer = new Renderer();
        Player player = new Player();

        System.out.printf("\nYou choose %s X %s board !!\n\n", board.SIZE, board.SIZE);

        while (!board.isGameEnded()) {
            player.playTurn(board, Mark.X);
            renderer.renderBoard(board);
            player.playTurn(board, Mark.O);
            renderer.renderBoard(board);
        }
    }
}
