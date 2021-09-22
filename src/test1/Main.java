/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test1;

import java.io.IOException;

/**
 *
 * @author TuanAnh
 */
public class Main {
    public static void main(String[] args) throws IOException {
        MyList t = new MyList();
        String fname = "product.txt";
        String fnameRep = "output.txt";
        System.out.println("");
        
        t.readFromFile(fname);
        t.traverse();
        
        System.out.println("");
        
        t.sortName();
        t.removeDuplicate();
        t.traverse();
        
        System.out.println("");
        t.saveToFile(fnameRep);
        System.out.println("");
        System.out.println(t.head);
    }
}
