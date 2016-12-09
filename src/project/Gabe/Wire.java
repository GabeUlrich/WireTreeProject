package project.Gabe;

/**
 *  This is the data fields of everything having to do with wire tree making.
 * 
 * 
 * @author Gabriel Ulrich
 */
public class Wire {
    private int id;
    private String wireTypes;
    private String toolTypes;
    double price;
    private double timeWorked; 

    public Wire() {
    }

    public Wire(int id, String wireTypes, String toolTypes, double price, double timeWorked) {
        this.id = id;
        this.wireTypes = wireTypes;
        this.toolTypes = toolTypes;
        this.price = price;
        this.timeWorked = timeWorked;
    }

    public double getTimeWorked() {
        return timeWorked;
    }

    public void setTimeWorked(double timeWorked) {
        this.timeWorked = timeWorked;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWireTypes() {
        return wireTypes;
    }

    public void setWireTypes(String wireTypes) {
        this.wireTypes = wireTypes;
    }

    public String getToolTypes() {
        return toolTypes;
    }

    public void setToolTypes(String toolTypes) {
        this.toolTypes = toolTypes;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
//        return "Wire{" + "id=" + id + ", wireTypes=" + wireTypes + ", toolTypes=" + toolTypes + ", price=" + price + ", timeWorked=" + timeWorked + '}';
            return String.format("id= %-1d | wireTypes= %-18s | toolTypes= %-8s | price= %-5.2f | timeWorked= %-1.1f", id, wireTypes, toolTypes, price, timeWorked);
    }
}
//%5d %20s %8.2f
//%20s is right justify, to make left put - right after %
//8.2 the .2 is the two numbers after the decimal
//d for integers
//s for string
//# is how wide column is
//f floating point number