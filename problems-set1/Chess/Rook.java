
import java.util.Arrays;
import java.util.List;

public class Rook extends  IPiece{

    List<List<Integer>> moves = Arrays.asList(
        Arrays.asList(1, 0),
        Arrays.asList(-1, 0),
        Arrays.asList(0, 1),
        Arrays.asList(0, -1));

    public Rook(boolean isBlack){
        super(isBlack);
    }

    @Override
    public String toString(){
        String color= this.isBlack()?"Black":"White";
        return "Rook with color: "+ color;
    }

    @Override
    public boolean isValidMove(Position start, Position end) {
        if(super.notMoving(start, end)) return false;
        return start.getX()== end.getX() || start.getY()== end.getY();
    }

    @Override
    public List<Position> getAllPossiblePositions(Position position) {
        return super.getAllContinuousPostions(moves, position);
    }

    @Override
    public List<Position> getAllPossiblePositionsInPath(Position start, Position end) {
        return super.getAllPossibleContinuousPositionsInPath(moves, start, end);
    }

}