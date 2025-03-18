
import java.util.Optional;



public class Shelf {
    int address;
    int length;
    int breadth;
    int [][] grid;
    int totalAreaFilled;
    String inventoryType;

    public int getAddress() {
        return this.address;
    }

    public int getTotalAreaFilled() {
        return this.totalAreaFilled;
    }

    public String getInventoryType() {
        return this.inventoryType;
    }

    public int getLength() {
        return this.length;
    }

    public int getBreadth() {
        return this.breadth;
    }
    
    public void setTotalAreaFilled(int totalAreaFilled) {
        this.totalAreaFilled = totalAreaFilled;
    }

    public Shelf(int address, int length, int breadth) {
        this.address = address;
        this.length = length;
        this.breadth = breadth;
        grid= new int[length][breadth];
        totalAreaFilled=0;
        inventoryType= "";
    }
    public static class Position {
        int row, col;
        Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public Optional<Position> findBestPosition(Inventorybox inventorybox){
        Position bestPositon= null;
        for(int row=0;row+inventorybox.getLength()<=length  && bestPositon ==null;row++){
            for(int col=0;col+inventorybox.getBreadth()<=breadth && bestPositon ==null;col++){
                Position curPosition= new Position(row, col);
                if(canFit(curPosition, inventorybox)){
                    bestPositon= curPosition;
                }
            }
        }
        return Optional.ofNullable(bestPositon);
    }


    public Boolean placeBox(Inventorybox inventorybox, Optional<Position> position){
        
        if(position.isEmpty()) return false;

        if(canFit(position.get(), inventorybox)){
            Position positionValue= position.get();
            markOccupied(positionValue.row,positionValue.col, inventorybox);
            inventoryType= inventorybox.getType();
            return true;
        }
        return false;
    }

    private boolean canFit(Position position, Inventorybox inventorybox) {
        //check for gravity
        if(position.row>0){
            int supportedCells=0;
            for(int p=position.col;p<position.col+inventorybox.getBreadth();p++){
                if(grid[position.row-1][p]!=0)
                    supportedCells++;
            }
            if (supportedCells < (inventorybox.getBreadth() + 1) / 2) 
                return false;
        }
        
        for(int i=0;i<inventorybox.getLength();i++){
            for(int j=0;j<inventorybox.getBreadth();j++){
                if(grid[position.row+i][position.col+j]!=0)
                    return false;
            }
        }
        return true;
    }

    private void markOccupied(int row, int col, Inventorybox inventorybox) {
        for(int i=row;i<row+inventorybox.getLength();i++){
            for(int j=col;j<col+inventorybox.getBreadth();j++){
                grid[i][j]= 1;
                totalAreaFilled++;
            }
        }
    }

    public void printGrid() {
        System.out.println("Current Shelf State:");
        for(int i=0;i<length;i++){
            for(int j=0;j<breadth;j++){
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("-------------------------");
    }
    
}
