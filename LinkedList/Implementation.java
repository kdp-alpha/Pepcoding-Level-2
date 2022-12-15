public class MyClass {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            next = null;
        }
    }
    
    public static void insert(int data,Node head){
        Node new_node = new Node(data);
       
       if(head.next==null){
           head.next = new_node;
       }
       else{
           Node last = head;
           while(last.next!=null){
               last = last.next;
           }
           last.next = new_node;
       }
    }
    public static void print(Node head){
        Node temp = head.next;
        while(temp !=null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
    
    public static void insertMidlle(int data,Node head){
        Node new_Node = new Node(data);
        Node temp = head;
        while(temp.data != 4){
            temp = temp.next;
        }
        Node temp2 = temp.next;
        temp.next = new_Node;
        new_Node.next = temp2;
    }
    
    
    public static void main(String args[]) {
        Node head = new Node(-1);
       insert(3,head);
       insert(4,head);
       insert(5,head);
       insert(6,head);
       
       insertMidlle(17,head);
       print(head);
    }
}
