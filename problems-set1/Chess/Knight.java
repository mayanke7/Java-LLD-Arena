
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Knight extends IPiece {

    List<List<Integer>> moves = Arrays.asList(
            Arrays.asList(1, 2),
            Arrays.asList(1, -2),
            Arrays.asList(-1, 2),
            Arrays.asList(-1, -2),
            Arrays.asList(2, 1),
            Arrays.asList(-2, 1),
            Arrays.asList(2, -1),
            Arrays.asList(-2, -1)
    );

    public Knight(boolean isBlack) {
        super(isBlack);
    }

    @Override
    public String toString() {
        String color = this.isBlack() ? "Black" : "White";
        return "Knight with color: " + color;
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
