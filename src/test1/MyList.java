/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author TuanAnh
 */
public class MyList {
    Node head, tail;
    void readFromFile(String fname) throws IOException{
        FileReader fr = new FileReader(fname);
        BufferedReader br = new BufferedReader(fr);
        String s;
        String[] sub;
        String id, name;
        int age;
        while(true){
            s = br.readLine();
            if(s==null||s.trim().length()<3) break;
            sub = s.split("[|]");
            addLast(new Product(sub[0].trim(), Double.parseDouble(sub[1].trim()), Integer.parseInt(sub[2].trim())));
        }
        fr.close();
        br.close();
    }
    
    void saveToFile(String fname) throws IOException{
        FileWriter fw = new FileWriter(fname);
        PrintWriter pw = new PrintWriter(fw);
        Node p = head;
        while(p!=null){
            pw.printf("%10s | %10f | %4d\r\n", p.infor.name, p.infor.price, p.infor.quantity);
//            pw.write(p.infor.id+" | "+p.infor.name+" | "+p.infor.age+"\r\n");
            p = p.next;
        }
        pw.close();
        fw.close();
    }
    
    public void clear(){
        head=tail=null;
    }
    
    public boolean isEmpty(){
        return head==null;
    } 
    
    public void addLast(Product x){
        Node p = new Node(x);
        if(isEmpty()) tail=head=p;    
        else{
            tail.next=p;
            tail=p;
        }
    }
    
    public void traverse(){
        if(isEmpty()){
            System.out.println("List is empty");
            return;
        }
        Node p = head;
        while(p!=null){
            System.out.println(p.infor);
            p=p.next;
        }
    }
    
    public void sortName(){
        if(isEmpty()){
            System.out.println("List is empty");
            return;
        }
        Node c = head;
        Node a = null;
        Product temp=null;
        if(head==null) return;
        while(c!=null){
            a=c.next;
            while(a!=null){
                if(c.infor.name.compareTo(a.infor.name)>0){
                    temp = c.infor;
                    c.infor = a.infor;
                    a.infor = temp;
                }
                a = a.next;
            }
            c = c.next;
        }
    }
    
    public void addRightIndex(Product p){
        addLast(p);
        sortName();
    }
   
    public void removeDuplicate(){
        if(isEmpty()){
            System.out.println("List is empty");
            return;
        }
        Node c = head;
        Node a = null;
        Product temp=null;
        if(head==null) return;
        while(c!=null){
            a=c.next;
            while(a!=null){
                if(c.infor.name.compareTo(a.infor.name)==0){
                    double capC = c.infor.price * c.infor.quantity;
                    double capA = a.infor.price * a.infor.quantity;
                    if(capC<=capA){
                        temp = c.infor;
                        c.infor = a.infor;
                        a.infor = temp;
                    }
                }
                a = a.next;
            }
            c = c.next;
        }
        
        c = head;
        Node nextNode = null;
        while (c.next != null) {
            if (c.infor.name.equals(c.next.infor.name)) {
                nextNode = c.next.next;
                c.next = null;
                c.next = nextNode;
            } else {
                c = c.next;
            }
        }
    }

}
