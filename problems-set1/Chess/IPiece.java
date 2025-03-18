public interface IPiece{
    public abstract boolean isValidMove(int initialX, int initialY, int finalX, int finalY);

    public abstract boolean isBlack();
}