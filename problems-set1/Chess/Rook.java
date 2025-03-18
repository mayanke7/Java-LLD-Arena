public class Rook implements  IPiece{

    private boolean isBlack;

    public Rook(boolean isBlack){
        this.isBlack= isBlack;
    }

    @Override
    public boolean isBlack() {
        return this.isBlack;
    }

   @Override
    public boolean isValidMove(int initialX, int initialY, int finalX, int finalY) {
        return ((initialX == finalX) || (initialY == finalY)
                && (!((initialX == finalX) && (initialY == finalY))));
    }

    @Override
    public String toString(){
        String color= this.isBlack?"Black":"White";
        return "Rook with color: "+ color;
    }

}