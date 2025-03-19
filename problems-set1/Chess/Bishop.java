
import java.util.Arrays;
import java.util.List;


public class Bishop extends IPiece {

    public Bishop(boolean isBlack){
        super(isBlack);
    }

    List<List<Integer>> moves = Arrays.asList(
        Arrays.asList(1, 1),
        Arrays.asList(-1, 1),
        Arrays.asList(-1, -1),
        Arrays.asList(1, -1));

    @Override
    public List<Position> getAllPossiblePositions(Position position) {
        return super.getAllContinuousPostions(moves, position);
    }

    @Override
    public String toString(){
        String color= this.isBlack()?"Black":"White";
        return "Bishop with color: "+ color;
    }

    @Override
    public List<Position> getAllPossiblePositionsInPath(Position start, Position end) {
        return super.getAllPossibleContinuousPositionsInPath(moves, start, end);
    }

    @Override
    public boolean isValidMove(Position start, Position end) {
        if(super.notMoving(start, end)) return false;
        return (Math.abs(start.getX() - end.getX()) == Math.abs(start.getY() - end.getY()));
    }


}
