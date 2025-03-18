
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Building{
    List<Shelf> shelves;

    public Building() {
        this.shelves = new ArrayList<>();
    }

    public void addShelf(int length, int breadth, int address){
        shelves.add(new Shelf(address, length, breadth));
    }

    public boolean addInventory(Inventorybox inventorybox){
        if (inventorybox == null) return false;
        int bestShelfIndex=-1;
        int minSpacesLeft=Integer.MAX_VALUE;
        int totalInventoryArea= inventorybox.getBreadth() * inventorybox.getLength();
        Optional<Shelf.Position> position = Optional.empty();
        
        for(int i=0;i<shelves.size();i++){
            
            Shelf curShelf= shelves.get(i);
            
            int curShelfArea= curShelf.getLength() * curShelf.getBreadth();
            boolean inventoryTypeMatches= Objects.equals(inventorybox.getType(), curShelf.getInventoryType());  
            if(curShelf.getInventoryType().isEmpty()  || inventoryTypeMatches){

                int availableAreaAfterwards= curShelfArea- (curShelf.getTotalAreaFilled() +  totalInventoryArea);

                if(availableAreaAfterwards >=0 && availableAreaAfterwards<minSpacesLeft){
                    Optional<Shelf.Position> curPosition= shelves.get(i).findBestPosition(inventorybox);
                    if(curPosition.isPresent()){
                        bestShelfIndex= i;
                        minSpacesLeft = availableAreaAfterwards;
                        position= curPosition;
                        if (minSpacesLeft == 0) break;
                    }
                }
            }
        }

        if(bestShelfIndex == -1) 
            return false;

        return shelves.get(bestShelfIndex).placeBox(inventorybox,position);
    }

}