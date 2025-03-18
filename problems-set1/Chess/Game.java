public class Game implements IMove{

    private final Chessboard chessboard;
    private boolean gameOver;
    private boolean blacksTurn;
    private Player whitePlayer;
    private Player blackPlayer;

    private Game() {  
        this.chessboard = new Chessboard();
        this.gameOver = false;
        this.blacksTurn = false;
    }

    public void setWhitePlayer(Player whitePlayer){
        this.whitePlayer= whitePlayer;
    }
    public void setBlackPlayer(Player blackPlayer){
        this.blackPlayer= blackPlayer;
    }

    public static Game createGame(Player whitePlayer, Player blackPlayer) {
        Game game = new Game();
        game.setWhitePlayer(whitePlayer);
        game.setBlackPlayer(blackPlayer);
        whitePlayer.joinGame(game, false);
        blackPlayer.joinGame(game, true);
        return game;
    }


    public boolean isGameOver(){
        // to be implemented
         return false;
    }

    @Override
    public boolean move(Player player, int initialX, int initialY, int finalX, int finalY) {
        if(gameOver) return false;
        if(!chessboard.pieceExistsInCurrentPosition(initialX, initialY)) return false;

        boolean playerOptedBlack= player.getOptedBlack();

        boolean currentPieceIsBlack= chessboard.isCurrentPieceBlackWhenExists(initialX, initialY);

        if(playerOptedBlack!= currentPieceIsBlack) return false;
        
        var currentPlayer= blacksTurn ? this.blackPlayer: this.whitePlayer;
        if(!currentPlayer.equals(player)) return false;

        boolean madeMove= chessboard.moveOnBoard(initialX, initialY, finalX, finalY);

        if(madeMove  && isGameOver()) gameOver= true;
        if(madeMove) blacksTurn = !playerOptedBlack;
        
        return madeMove;

    }


    
}