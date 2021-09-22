/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test1;

/**
 *
 * @author TuanAnh
 */
public class Node {
    Product infor;
    Node next;
    Node(Product x, Node p) {
        infor = new Product(x.name, x.price, x.quantity);
        next = p;
    }
    
    Node(Product x){
        infor = x;
        next = null;
    }

    @Override
    public String toString() {
        return "Node{" + "infor=" + infor + ", next=" + next + '}';
    }

}
