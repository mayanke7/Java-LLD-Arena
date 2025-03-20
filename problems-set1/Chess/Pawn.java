
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pawn extends  IPiece{

    private boolean isFirstMove= false;

    List<List<Integer>> movesWhite = Arrays.asList(
        Arrays.asList(0, 1),
        Arrays.asList(0, 2),
        Arrays.asList(1, 1),
        Arrays.asList(-1, 1));
    
    List<List<Integer>> movesBlack = Arrays.asList(
        Arrays.asList(0, -1),
        Arrays.asList(0, -2),
        Arrays.asList(1, -1),
        Arrays.asList(-1, -1));

    List<List<Integer>> moves;

    
    @Override
    public String toString(){
        String color= this.isBlack()?"Black":"White";
        return "Pawn with color: "+ color;
    }

    public Pawn(boolean isBlack){
        super(isBlack);
        this.isFirstMove= true;
        moves= isBlack? movesBlack: movesWhite;
    }

    @Override
    public boolean isValidMove(Position start, Position end) {
        if(!super.notMoving(start, end)  || !super.isValidMove(start, end)) return false;

        if(Math.abs(start.getY()- end.getY()) == 2){
            if(!this.isFirstMove) return false;
            this.isFirstMove= true;
        }
        return true;
    }

    @Override
    public List<Position> getAllPossiblePositions(Position position) {
        return super.getAllNonContinuousPostions(moves, position);
    }

    @Override
    public List<Position> getAllPossiblePositionsInPath(Position start, Position end) {
        if(!this.isValidMove(start, end)  && Math.abs(start.getY()- end.getY()) != 2)
            return new ArrayList<>();
        
        return Arrays.asList(new Position(start.getX(), Math.min(start.getY(), end.getY())+1));
    }
}