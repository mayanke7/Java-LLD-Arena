
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
        if(!super.notMoving(start, end)) return false;
        
        if(!super.isValidMove(start, end)) return false;


        // needs to have logic for +2 move here
        return true;

    }

    @Override
    public List<Position> getAllPossiblePositions(Position position) {
        return super.getAllNonContinuousPostions(moves, position);
    }

    @Override
    public List<Position> getAllPossiblePositionsInPath(Position start, Position end) {
        // needs to be checked for +2 move

        return new ArrayList<>();
    }
}