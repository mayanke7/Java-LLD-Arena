
public class Player {

    private String name;
    private boolean optedBlack;
    IMove moveHandler;

    public Player(String name) {
        this.name = name;
        this.moveHandler = null;
    }

    public boolean getOptedBlack() {
        return this.optedBlack;
    }

    public boolean joinGame(IMove move, boolean optedBlack) {
        if (moveHandler == null) {
            this.moveHandler = move;
            this.optedBlack = optedBlack;
        } else {
            return false;
        }

        return true;
    }

    public void leaveGame() {
        this.moveHandler = null;
    }

    public boolean move(Position initialPos, Position finalPosition) {
        if(moveHandler ==null) return false;

        return moveHandler.move(this, initialPos, finalPosition);
    }
}
