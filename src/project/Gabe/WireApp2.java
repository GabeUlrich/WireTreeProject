
package project.Gabe;

/**
 *
 * @author Gabriel Ulrich
 */
public class WireApp2 {
    public static void main(String[] args) {
        WireList data = new WireList();
        data.create(new Wire(1, "aluminum", "Pliers", 15, 4));
        data.create(new Wire(2, "galvanized steel", "cutters", 10, 7));
        data.create(new Wire(3, "colored aluminum", "clamp", 15, 3));
        data.create(new Wire(4, "aluminum", "clamp", 20, 6));
        data.create(new Wire(5, "colored aluminum", "pliers", 13, 2));
        System.out.println(data);
        
//        System.out.println(data.retrieve(2));
//        System.out.println(data.retrieve(-1));
//        
//        Wire w1 = new Wire(2, "aluminum", "cutters", 12, 9);
//        data.update(w1);
//        System.out.println(data.retrieve(2));
//        data.delete(3);
//        System.out.println(data);
    }
}
