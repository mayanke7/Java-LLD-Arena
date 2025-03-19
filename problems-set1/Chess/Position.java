public class Position{
    private final int x;
    private final int y;
    public Position(int x, int y){
        this.x=x;
        this.y=y;
    }

    public Position(Position position){
        this.x=position.x;
        this.y=position.y;
    }

    public int getX(){ return this.x;}

    public int getY(){ return this.y;}

    @Override
    public boolean equals(Object p1){
        if(p1 == this) return true;

        if (p1 instanceof Position p  ){            
            return p.x== this.x && p.y==this.y;
        }
        return false;
    }

    public boolean isValidOnBoard(){
        return this.x>=0 && x<8 && this.y>=0  && this.y<8;
    }
}