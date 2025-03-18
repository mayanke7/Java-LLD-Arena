public class Inventorybox {
    int length;
    String type;
    int breadth;


    public Inventorybox(int length, String type, int breadth) {
        this.length = length;
        this.type = type;
        this.breadth = breadth;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getLength() {
        return this.length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getBreadth() {
        return this.breadth;
    }

    public void setBreadth(int breadth) {
        this.breadth = breadth;
    }

}