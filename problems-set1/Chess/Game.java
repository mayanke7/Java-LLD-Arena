
import java.util.Optional;

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
    public boolean move(Player player, Position initialPos, Position finalPos) {
        boolean playerOptedBlack= player.getOptedBlack();
        if(gameOver  || playerOptedBlack!= blacksTurn) return false;

        Optional<IPiece> curPiece= chessboard.getPieceFromPosition(initialPos);

        if(curPiece.isEmpty()  || curPiece.get().isBlack()!= playerOptedBlack) return false;
        
        boolean madeMove= chessboard.moveOnBoard(initialPos, finalPos);

        if(madeMove  && isGameOver()) gameOver= true;
        if(madeMove) blacksTurn = !playerOptedBlack;
        
        return madeMove;

    }


    
}