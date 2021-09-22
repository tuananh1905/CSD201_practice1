/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.EmptyStackException;

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
            addLast(new Person(sub[0].trim(), sub[1].trim(), Integer.parseInt(sub[2].trim())));
        }
        fr.close();
        br.close();
    }
    
    void saveToFile(String fname) throws IOException{
        FileWriter fw = new FileWriter(fname);
        PrintWriter pw = new PrintWriter(fw);
        Node p = head;
        while(p!=null){
            pw.printf("%10s | %20s | %4d\r\n", p.infor.id, p.infor.name, p.infor.age);
            pw.write(p.infor.id+" | "+p.infor.name+" | "+p.infor.age+"\r\n");
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
//q4
    public void traverse(){
        Node p = head;
        while(p!=null){
            System.out.println(p.infor);
            p=p.next;
        }
    }
//q1
    public void addFirst(Person x){
        Node p =new Node(x);
        if(isEmpty()) head=tail=p;
        else {
            p.next=head;
            head=p;
        }
    }
//q5
    public Person delFirst(){
        Node p = head;
        if(isEmpty()) throw new EmptyStackException();
        else head=head.next;
        return p.infor;
    }
//q2
    public void addLast(Person x){
        Node p = new Node(x);
        if(isEmpty()) tail=head=p;    
        else{
            tail.next=p;
            tail=p;
        }
    }
//q6
    public Person delLast(){
        Node t = tail;
        if(isEmpty()) throw new EmptyStackException();
        else{
            Node p =head;
            while(p.next!=tail){
                p=p.next;
            }
            tail=p;
            tail.next=null;
        }
        return t.infor;
    }
//q10
    public int count(){
        if(isEmpty()) return 0;
        else{
            Node p = head;
            int count=0;
            while(p.next!=null) {
                count++;
                p=p.next;
            }
            return count;
        }
    }
//q9
    public Node search(String x){
        Node p =head;
        while(!p.infor.name.equalsIgnoreCase(x)) p=p.next;
        return p;
    }
//q16
    public void addBefore(Node p, Person x){
        if(isEmpty()) return;
        Node c = head;
        Node b = null;
        while(c!=p){
            b=c;
            c=c.next;
        }
        if(p==head){
            addFirst(x);
        } else{
            Node temp = new Node(x, c);
            b.next = temp;
        }
    }
//q3
    public void addAfter(Node p, Person x){
        if(isEmpty()) return;
        Node c = head;
        Node b = null;
        while(c!=p){
            b=c;
            c=c.next;
        }
        if(p==tail){
            addLast(x);
        } else{
            Node temp = new Node(x, c.next);
            c.next = temp;
        }
    }
//q11
    public void deleteAnINode(int x){
        if(count()<x || isEmpty()) return;
        int index=1;
        Node p = head;
        while(index!=x){
            p=p.next;
            index++;
        }
        delete(p);
    }
//q7
    public Person delAfter(Node p){
        Node point = p.next.next;
        Node ret = p.next;
        p.next = point;
        return ret.infor;
    }
//q8
    public void delete (String s){
        Node p = head;
        while(p.infor.name.equalsIgnoreCase(s)){
            p=p.next;
        }
        delete(p);
    }
//q13
    public void delete(Node p){
        Node c = head;
        Node b = null;
        if(head==null) return;
        while(c!=p){
            b=c;
            c=c.next;
        }
        c = c.next;
        b.next = c;
    }
//q12
//    public void sort(){
//        Node c = head;
//        Node a = null;
//        int temp=0;
//        if(head==null) return;
//        while(c!=null){
//            a=c.next;
//            while(a!=null){
//                if(c.infor>a.infor){
//                    temp = c.infor;
//                    c.infor = a.infor;
//                    a.infor = temp;
//                }
//                a = a.next;
//            }
//            c = c.next;
//        }
//    }
////q14
//    public int[] toArray(){
//        int[] array = new int[count()+1];
//        Node p =head;
//        for (int i = 0; i < array.length; i++) {
//            array[i] = p.infor;
//            p=p.next;
//        }
//        return array;
//    }
////q15
//    public MyList merge(MyList list1, MyList list2){
//        if(list1.isEmpty() && list2.isEmpty()) return null;
//        MyList merge = new MyList();
//        while(list1.head!=null || list2.head!=null){
//            if(list1.isEmpty()) {
//                merge.tail.next = list2.head;
//                return merge;
//            }
//            if(list2.isEmpty()) {
//                merge.tail.next = list1.head;
//                return merge;
//            }
//            suppostMerge(list1, list2, merge);
//        }
//        return merge;
//    }
//    public void delHead(){
//        head=head.next;
//    }
//    public void suppostMerge(MyList list1, MyList list2, MyList merge){
//       if(list1.head.infor==list2.head.infor){
//           merge.addLast(list1.head.infor);
//           list1.delHead();
//           list2.delHead();
//           return;
//       }
//       if(list1.head.infor<list2.head.infor) {
//           merge.addLast(list1.head.infor);
//           list1.delHead();
//           return;
//       }
//       if(list1.head.infor>list2.head.infor){
//           merge.addLast(list2.head.infor);
//           list2.delHead();
//           return;
//       }
//    }
////q17
//    public void attachListToList(MyList list1, MyList list2){
//        list1.tail.next = list2.head;
//        list1.tail = list2.tail;
//    }
////q18
//    public int max(){
//        if(isEmpty()) return head.infor;
//        int max = head.infor;
//        Node p = head;
//        while(p!=null) {
//            if(max<p.infor) max = p.infor;
//            p=p.next;
//        }
//        return max;
//    }
////q19
//    public int min(){
//        if(isEmpty()) return head.infor;
//        int min = head.infor;
//        Node p = head;
//        while(p!=null) {
//            if(min>p.infor) min = p.infor;
//            p=p.next;
//        }
//        return min;
//    }
////q20
//    public int sum(){
//        if(isEmpty()) return head.infor;
//        int sum = 0;
//        Node p = head;
//        while(p!=null) {
//            sum+=p.infor;
//            p=p.next;
//        }
//        return sum;
//    }
////q21
//    public int avg(){
//        if(isEmpty()) return head.infor;
//        int sum = 0;
//        Node p = head;
//        while(p!=null) {
//            sum+=p.infor;
//            p=p.next;
//        }
//        return sum/count();
//    }
////q22
//    public boolean sorted(){
//        if(isEmpty()) return false;
//        Node p = head;
//        while(p.next!=null){
//            if(p.infor>p.next.infor) return false;
//            p=p.next;
//        }
//        return true;
//    }
//q23
//    public void insert(int x){
//        if(isEmpty()) return;
//        addLast(x);
//        sort();
//    }
//q24
    public void reverseLinked(){
        Node prev = null;
        Node c = head;
        Node n = null;
        while(c!=null){
            n = c.next;
            c.next=prev;
            if(c.next==null) tail=c;
            prev=c;
            c=n;
        }
        head=prev;
    }
//q25
    public boolean checkSameContents(MyList l1, MyList l2){
        if(l1.count()!=l2.count()) return false;
        Node p1 = l1.head;
        Node p2 = l2.head;
        while(p1!=null){
            if(p1.infor!=p2.infor) return false;
            p1=p1.next;
            p2=p2.next;
        }
        return true;
    }

}
