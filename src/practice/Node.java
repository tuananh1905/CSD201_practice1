/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice;

/**
 *
 * @author TuanAnh
 */
public class Node {
    Person infor;
    Node next;
    
    Node(Person x, Node p) {
        infor = new Person(x.id, x.name, x.age);
        next = p;
    }
    
    Node(Person x){
        infor = x;
        next = null;
    }

    @Override
    public String toString() {
        return "Node{" + "info=" + infor + ", next=" + next + '}';
    }
    
}
