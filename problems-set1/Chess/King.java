
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class King extends  IPiece{

    List<List<Integer>> moves= Arrays.asList(
        Arrays.asList(1, 0),
        Arrays.asList(1, 1),
        Arrays.asList(1, -1),
        Arrays.asList(-1, 0),
        Arrays.asList(-1, 1),
        Arrays.asList(-1, -1)
    );

   
    public King(boolean isBlack) {
        super(isBlack);
    }


    @Override
    public String toString(){
        String color= this.isBlack()?"Black":"White";
        return "King with color: "+ color;
    }

    @Override
    public List<Position> getAllPossiblePositions(Position position) {
        return super.getAllNonContinuousPostions(moves, position);
    }

    @Override
    public List<Position> getAllPossiblePositionsInPath(Position start, Position end) {
        return new ArrayList<>();
    }
    

}