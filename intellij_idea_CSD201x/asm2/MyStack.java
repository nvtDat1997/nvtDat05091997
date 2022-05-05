package asm2;

import java.io.IOException;
import java.io.OutputStreamWriter;

public class MyStack {
    private Node topNode;   //khai báo thuộc tính

    //constructor
    public MyStack(){
        topNode = null;
    }

    //hàm thêm phần tử vào Stack
    public boolean push(Product product) {
        if (!isFull()){                 //nếu Stack chưa đầy
            Node newNode = new Node(product);   //khởi tạo Node mới với đối tượng tham số truyền vào
            if (isEmpty()){     //trường hợp Stack rỗng
                topNode = newNode;  //gán topNode cho node mới
            }
            else {
                newNode.setNext(topNode);
                topNode = newNode;
                return true;
            }
        }
        return false;
    }

    public Product pop() {  //Lấy ra từng phần tử trong Stack
        if(isEmpty()) {     //nếu Stack rỗng thì trả về null
            return null;
        }
        Product product = topNode.getData();
        topNode = topNode.getNext();
        return product;
    }

    public boolean isFull() {   //Hàm trả về cho biết Stack đã đầy hay chưa
        return false;
    }

    public boolean isEmpty() {  //hàm trả về cho biết Stack có rỗng hay không
        return topNode == null;
    }

    public void clearData(){       //Hàm thực thi reset lại dữ liệu ban đầu cho Stack
        while (!isEmpty()) {    //nếu Stack không trống thì tiếp tục rút dữ liệu ra bằng hàm pop()
            pop();
        }
    }

    //hàm duyệt và hiển thị các phần tử trong Stack
    public void show(OutputStreamWriter out) throws IOException {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            out.write("\nStack is empty!\n");
        }

        Node temp = topNode;
        while (temp != null){
            System.out.println(temp.getData());
            out.write(String.valueOf(temp.getData()));  //ghi output vào file
            out.write("\n");
            temp = temp.getNext();
        }
    }

    @Override
    public String toString() {
        return "" + topNode.getData();
    }
}

