package asm2;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class MyQueue {
    //khai báo thuộc tính
    private Node headNode;  //đầu Queue
    private Node tailNode;  //đuôi Queue (cuối)

    //constructor
    public MyQueue(){
        headNode = tailNode = null;
    }

    //hàm thêm phần tử vào Queue
    public boolean push(Product product) {
        Node newnode = new Node(product);
        if(isEmpty()){
            headNode = tailNode = newnode;
        }
        else {
            newnode.setNext(headNode);
            headNode = newnode;
        }
        return true;
    }

    //hàm lấy ra phần tử ở đầu Queue
    public Product pop() {
        if(isEmpty()) {     //nếu Queue rỗng trả về null
            return null;
        }
        else {
            Product product = headNode.getData();
            if (headNode == tailNode) {     //trường hợp Queue chỉ có 1 phần tử
                headNode = tailNode = null;
            }
            else {
                headNode = headNode.getNext();  //lấy ra phần tử đầu tiên, gán headNode cho phần tử kế tiếp
            }
            return product;
        }
    }

    public boolean isFull() {   //hàm kiểm tra xem Queue đã đầy hay chưa nếu đầy trả về false
        return false;
    }

    public boolean isEmpty() {  //hàm kiểm tra Queue có rỗng hay không thông qua điều kiện ở trong ngoặc đơn
        return (headNode == null && tailNode == null);
    }

    public void clearData(){    //hàm lấy ra toàn bộ các phần tử trong Queue
        while (!isEmpty()) {
            pop();
        }
    }

    //hàm duyệt và hiển thị các phần tử trong Queue
    public void show(OutputStreamWriter out) throws IOException {
        if(isEmpty()){
            System.out.println("Queue is empty!");
            out.write("\nQueue is empty!\n");
        }
        else {
            ArrayList<Product> list = new ArrayList<>();    //khai báo thêm danh sách để lưu dữ liệu trong Queue
            Node temp = headNode;
            while (temp != null){
                list.add(temp.getData());
                temp = temp.getNext();
            }
            for (int i = list.size()-1; i >= 0; i--){ //duyệt phần tử trong danh sách và in ra theo thứ tự của yêu cầu bài toán
                System.out.println(list.get(i));
                out.write(String.valueOf(list.get(i)));     //ghi output vào file
                out.write("\n");
            }
        }
    }

    @Override
    public String toString() {
        return "" + headNode.getData() + tailNode.getData();
    }
}

