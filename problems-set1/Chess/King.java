
import java.util.Arrays;
import java.util.List;

public class King implements  IPiece{

    List<List<Integer>> moves;
    private boolean isBlack;

   
    public King(boolean isBlack) {
        moves = Arrays.asList(
                    Arrays.asList(1, 0),
                    Arrays.asList(1, 1),
                    Arrays.asList(1, -1),
                    Arrays.asList(-1, 0),
                    Arrays.asList(-1, 1),
                    Arrays.asList(-1, -1)
                );
        this.isBlack= isBlack;

    }


    @Override
    public boolean isBlack() {
        return this.isBlack;
    }

    @Override
    public boolean isValidMove(int initialX, int initialY, int finalX, int finalY) {
        for(List<Integer> curMove: moves){
            if(initialX+ curMove.get(0) == finalX  && initialY+ curMove.get(1)== finalY)
                return true;
        }
        return false;
    }

    @Override
    public String toString(){
        String color= this.isBlack()?"Black":"White";
        return "King with color: "+ color;
    }
    

}