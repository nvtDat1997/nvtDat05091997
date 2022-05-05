package asm2;

public class Node{
    //khai báo thuộc tính cho Node
    private Product data;   //dữ liệu
    private Node next;      //thành phần vector

    //constructor
    public Node(Product data){
        this.data = data;
    }

    public Product getData() {
        return data;
    }

    public void setData(Product data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "" + data;
    }
}
