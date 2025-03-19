import java.util.ArrayList;
import java.util.List;
public abstract class IPiece{

    private boolean isBlack;
    public IPiece(boolean isBlack){
        this.isBlack= isBlack;
    }

    public boolean isBlack(){
        return this.isBlack;
    }

    public abstract List<Position> getAllPossiblePositions(Position position);
    public abstract List<Position> getAllPossiblePositionsInPath(Position start, Position end);

    public boolean notMoving(Position start, Position end){
        return start.equals(end);
    }

    public boolean isValidMove(Position start, Position end) {
        return !notMoving(start, end) && getAllPossiblePositions(start).contains(end);
    }

    protected List<Position> getAllContinuousPostions(List<List<Integer>> moves, Position position) {
        List<Position> allPossiblePositions= new ArrayList<>();
        
        for(List<Integer> curMove: moves){
            Position curPosition= new Position(position);
            while (true) {
                curPosition = new Position(curPosition.getX() + curMove.get(0), curPosition.getY() + curMove.get(1));

                if (!curPosition.isValidOnBoard()) break;
                allPossiblePositions.add(curPosition);
            }
        }
        return allPossiblePositions;
    }

    protected List<Position> getAllNonContinuousPostions(List<List<Integer>> moves, Position position) {
        List<Position> allPossiblePositions= new ArrayList<>();
        
        for(List<Integer> curMove: moves){
            Position curPosition= new Position(position.getX()+ curMove.get(0), position.getY()+ curMove.get(1));
            if(curPosition.isValidOnBoard()) allPossiblePositions.add(curPosition);
        }
        return allPossiblePositions;
    }

    protected  List<Position> getAllPossibleContinuousPositionsInPath(List<List<Integer>> moves, Position start, Position end) {        
        for(List<Integer> curMove: moves){
            Position curPosition= new Position(start);
            List<Position> allPossiblePositions= new ArrayList<>();
            while(true){
                curPosition= new Position(curPosition.getX()+ curMove.get(0), curPosition.getY()+ curMove.get(1));
                if(!curPosition.isValidOnBoard())  break;  
                if(curPosition.equals(end)) {
                    return allPossiblePositions;
                }
                allPossiblePositions.add(curPosition);
            }
        }
        return new ArrayList<>();
    }

}