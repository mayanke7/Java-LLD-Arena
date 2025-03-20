
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;


public class Chessboard {

    private IPiece[][] board;

    public Chessboard() {
        this.reset();
    }

    public void reset() {
        board = new IPiece[8][8];
        initializeRooks();
        initializeKnights();
        initializeBishops();
        initializeQueens();
        initializeKings();
        initializePawns();
    }

    private void initializeRooks() {
        IPiece rookWhite1 = new Rook(false);
        IPiece rookWhite2 = new Rook(false);
        IPiece rookBlack1 = new Rook(true);
        IPiece rookBlack2 = new Rook(true);

        this.board[0][0] = rookWhite1;
        this.board[7][0] = rookWhite2;

        this.board[0][7] = rookBlack1;
        this.board[7][7] = rookBlack2;
    }

    private void initializeKnights() {
        IPiece knightWhite1 = new Knight(false);
        IPiece knightWhite2 = new Knight(false);
        IPiece knightBlack1 = new Knight(true);
        IPiece knightBlack2 = new Knight(true);

        this.board[1][0] = knightWhite1;
        this.board[6][0] = knightWhite2;

        this.board[1][7] = knightBlack1;
        this.board[6][7] = knightBlack2;
    }

    private void initializeBishops() {
        IPiece bishopWhite1 = new Bishop(false);
        IPiece bishopWhite2 = new Bishop(false);
        IPiece bishopBlack1 = new Bishop(true);
        IPiece bishopBlack2 = new Bishop(true);
        
        this.board[2][0] = bishopWhite1;
        this.board[5][0] = bishopWhite2;

        this.board[2][7] = bishopBlack1;
        this.board[5][7] = bishopBlack2;
    }

    private void initializeQueens() {
        IPiece queenWhite1 = new Queen(false);
        IPiece queenBlack1 = new Queen(true);

        this.board[3][0] = queenWhite1;
        this.board[3][7] = queenBlack1;

    }

    private void initializeKings() {
        IPiece kingWhite1 = new King(false);
        IPiece kingBlack1 = new King(true);

        this.board[4][0] = kingWhite1;
        this.board[4][7] = kingBlack1;

    }

    private void initializePawns() {

        for (int i = 0; i < 8; i++) {
            IPiece newPawn = new Pawn(false);
            this.board[i][1] = newPawn;
        }

        for (int i = 0; i < 8; i++) {
            IPiece newPawn = new Pawn(true);
            this.board[i][6] = newPawn;
        }
    }

    public void printBoard() {
        for (int i = 0; i < 8; i++) {
            System.out.println();
            for (int j = 0; j < 8; j++) {
                if (this.board[i][j] == null) {
                    System.out.print("NONE\t");
                } else {
                    System.out.print(board[i][j].toString() + "\t");
                }
            }
        }
    }

    public static void main(String args[]) {
        Chessboard board = new Chessboard();
        board.printBoard();
    }

    public boolean isCurrentPieceBlackWhenExists(Position position) {
        if (!position.isValidOnBoard()) return false;
        
        IPiece curPiece = board[position.getX()][position.getY()];

        return curPiece.isBlack();
    }

    public Optional<IPiece> getPieceFromPosition(Position position) {
        if (!position.isValidOnBoard()) return Optional.empty();
        return Optional.ofNullable(board[position.getX()][position.getY()]);
    }


    public boolean validMoveOnBoard(Position initialPositon, Position finalPosition){
        if(!initialPositon.isValidOnBoard() || !finalPosition.isValidOnBoard()
        || getPieceFromPosition(initialPositon).isEmpty()) 
            return false;
        
        IPiece curPiece = board[initialPositon.getX()][initialPositon.getY()];
        IPiece capturedPiece= board[finalPosition.getX()][finalPosition.getY()];

        if(!curPiece.isValidMove(initialPositon, finalPosition)) return false;

            
        board[initialPositon.getX()][initialPositon.getY()] = null;
        board[finalPosition.getX()][finalPosition.getY()] = curPiece;
        boolean isKingInCheck= false;
        if(this.isKingInCheck(curPiece.isBlack())){
            isKingInCheck= true;
        }
        board[initialPositon.getX()][initialPositon.getY()] = curPiece;
        board[finalPosition.getX()][finalPosition.getY()] = capturedPiece;


        return !isKingInCheck;
        
    }

    public boolean moveOnBoard(Position initialPositon, Position finalPosition) {
        if(this.validMoveOnBoard(initialPositon, finalPosition)){
            IPiece curPiece= board[initialPositon.getX()][initialPositon.getY()];
            board[initialPositon.getX()][initialPositon.getY()] = null;
            board[finalPosition.getX()][finalPosition.getY()] = curPiece;
            return true;
        }
        return false;
    }

    private boolean isKingInCheck(boolean isBlack) {
        Position positionOfKing = null;
        Set<Position> allCheckedPositons= new HashSet<>();
        for (int i = 0; i < 8; i++) {
            for (int p = 0; p < 8; p++) {
                if (board[i][p] != null) {
                    IPiece piece = board[i][p];
                    if (piece instanceof King && piece.isBlack() == isBlack)
                        positionOfKing= new Position(i,p);
                    
                    if(piece.isBlack() != isBlack){
                        List<Position> checkedPostions= piece.getAllPossiblePositions(new Position(i,p));
                        allCheckedPositons.addAll(checkedPostions);
                    }
                }
            }
        }

        return allCheckedPositons.contains(positionOfKing);
    }

}
