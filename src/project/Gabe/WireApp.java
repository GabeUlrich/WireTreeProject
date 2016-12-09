/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.Gabe;

/**
 *
 * @author 55ulrichgw06
 */
public class WireApp {

    public static void main(String[] args) {

        Wire w1 = new Wire(1, "aluminum", "Pliers", 15, 4);
        Wire w2 = new Wire(2, "galvanized steel", "cutters", 10, 7);
        Wire w3 = new Wire(3, "colored aluminum", "clamp", 15, 3);
        Wire w4 = new Wire(4, "aluminum", "clamp", 20, 6);
        Wire w5 = new Wire(5, "colored aluminum", "pliers", 13, 2);

        System.out.println(w1);
        System.out.println(w2);
        System.out.println(w3);
        System.out.println(w4);
        System.out.println(w5);
    }
}
