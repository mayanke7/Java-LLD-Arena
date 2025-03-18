public class Pawn implements  IPiece{

    private boolean isFirstMove= false;
    private boolean isBlack= false;

    public Pawn(boolean isBlack){
        this.isFirstMove= true;
        this.isBlack= isBlack;
    }

    @Override
    public boolean isBlack() {
        return this.isBlack;
    }

    @Override
    public boolean isValidMove(int initialX, int initialY, int finalX, int finalY) {
        if(finalX != finalY) return false;
        if(isFirstMove){
            if(isBlack){
                return finalX - finalY ==1 || finalX - finalY ==2;
            }else{
                return finalY - finalX ==1 || finalY - finalX ==2;
            }
        }else{
            if(isBlack){
                return finalX - finalY ==1;
            }else{
                return finalY - finalX ==1;
            }
        }
    }

    @Override
    public String toString(){
        String color= this.isBlack?"Black":"White";
        return "Pawn with color: "+ color;
    }
}