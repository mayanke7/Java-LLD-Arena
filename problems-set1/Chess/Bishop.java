
public class Bishop implements IPiece {

    private boolean isBlack;

    public Bishop(boolean isBlack){
        this.isBlack= isBlack;
    }

    @Override
    public boolean isBlack() {
        return this.isBlack;
    }

    @Override
    public boolean isValidMove(int initialX, int initialY, int finalX, int finalY) {
        return ((Math.abs((initialX - finalX)) == Math.abs((initialY - finalY)))
                && (!((initialX == finalX) && (initialY == finalY))));
    }

    @Override
    public String toString(){
        String color= this.isBlack()?"Black":"White";
        return "Bishop with color: "+ color;
    }


}
