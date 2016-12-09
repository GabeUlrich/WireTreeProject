package project.Gabe;

/**
 *
 * @author 55jphillip
 */
public class WireArray {
    private Wire[] wires;
    private int n;
    
    public WireArray() {
        wires = new Wire[100];
        n = 0;
    }
    
    // CRUD - create new wire, retrieve wires, update wire object, delete wire object
    public void create(Wire wire) {
        wires[n] = wire;
        n++;
    }
    
    @Override
    public String toString() {        
        StringBuilder sb = new StringBuilder("");
        for(int i=0; i<n; i++) {
            sb.append(wires[i]).append("\n");
        }
        return sb.toString();
    }
}