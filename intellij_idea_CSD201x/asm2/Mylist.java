package asm2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Mylist {
    //khai báo thuộc tính Node khởi đầu và kết thúc cho danh sách
    private Node head;
    private Node tail;

    //constructor
    public Mylist(){
        this.head = this.tail = null;
    }

    //Thêm Node vào cuối danh sách móc nối
    public void addLast(Product data){
        Node newnode = new Node(data);  //khai báo node mới thông qua dữ liệu truyền vào
        if(this.head == null){      //xét điều kiện ban đầu lúc danh sách trống
            head = tail = newnode;  //gán head và tail vào node mới
        }
        else {
            tail.setNext(newnode);      //set giá trị cho node tail.next = newnode
            tail = newnode;     //gán tail vào newnode;
        }
    }

    //Duyệt từng phần tử và in ra danh sách các Node (thông tin sản phẩm)
    public Integer length(OutputStreamWriter out) throws IOException{
        Integer length = 0; //khai báo giá trị chiều dài ban đầu của danh sách móc nối là 0
        Node temp = this.head;  //Tạo node temp nhằm hứng giá trị node đầu tiên của danh sách
        while (temp != null){
            System.out.println(temp);
            out.write(String.valueOf(temp));    //ghi file
            out.write("\n");
            length++;
            temp = temp.getNext();  //temp tiếp tục hứng giá trị của node kế tiếp để tiếp tục xét cho các điều kiện
        }
        return length;
    }

    //lưu dữ liệu của danh sách móc nối vào tệp
    public void saveInFile() throws IOException {
        File file = new File("data111.txt");  //khởi tạo file
        if(!file.exists()){     //nếu file chưa tồn tại thì tạo mới
            file.createNewFile();
        }

        FileOutputStream stream = new FileOutputStream(file);           //Tạo đối tượng luồng và liên kết
        OutputStreamWriter out = new OutputStreamWriter(stream, "UTF-8");   //với nguồn dữ liệu

        Node temp = this.head;
        while (temp != null) {
            out.write(String.valueOf(temp.getData()));
            out.write("\n");
            temp = temp.getNext();
        }
        out.close();    //đóng luồng
    }

    //Tìm kiếm thông tin sản phẩm theo Mã sp
    public Product FindID(OutputStreamWriter out, String code) throws IOException{

        int count = 0;  //biến đếm để xác định có tìm thấy sản phẩm hay không
        Node current = this.head;
        Product product = null;     //tạo thêm 1 đối tượng để hứng giá trị trả về
        while (current != null){
            //so sánh mã trong dữ liệu của node current với mã tham số truyền vào
            if(( current.getData()).getCode().equalsIgnoreCase(code)){
                System.out.println(current.getData());
                out.write(String.valueOf(current.getData()));
                out.write("\n");
                count++;
                product = current.getData();
            }
            current = current.getNext();    //tiếp tục xét với node kế tiếp
        }
        if(count == 0) {
            System.out.println("Mã không tồn tại!");
            out.write("\nMã không tồn tại!\n");
        }
        return product;
    }

    //Xóa sản phẩm trong danh sách theo mã sản phẩm
    public Product DeleteID(OutputStreamWriter out, String code) throws IOException{
        Product product = null;     //tạo thêm đối tượng để hứng giá trị trả về
        int count = 0;          //biến đếm để xác định đã xóa được sản phẩm hay chưa
        Node temp = this.head;  //tạo node temp để nhận giá trị node ban đầu
        Node before = null;     //node before để nhận giá trị node vừa được xét trước khi temp chuyển đến node kế tiếp
        while (temp != null){
            //so sánh mã trong dữ liệu của node temp với mã tham số truyền vào
            if(temp.getData().getCode().equalsIgnoreCase(code)){
                if (temp == this.head){
                    head = temp.getNext();
                }
                else {
                    before.setNext(temp.getNext()); //loại bỏ node temp khỏi danh sách
                }
                product = temp.getData();   //product nhận giá trị trả về
                count++;
            }
            before = temp;  //before nhận giá trị node hiện tại đang xét
            temp = temp.getNext();  //chuyển đến node kế tiếp
        }
        if (count == 0){
            System.out.println("Mã không tồn tại!");
            out.write("\nMã không tồn tại!\n");
        }
        else {
            System.out.println("Đã xóa sp khỏi danh sách!");
            out.write("\nĐã xóa sp khỏi danh sách!\n");
        }
        return product;
    }

    //Hàm lấy giá trị số lượng của sản phẩm đầu tiên trong danh sách
    public Integer Quantity(){
        Integer x = null;   //biến x hứng giá trị trả về
        Node temp = this.head;
        while (temp != null){
            if(temp.getData() instanceof Product){   //kiểm tra dữ liệu của temp có là 1 thể hiện của đối tượng product hay không
                x = temp.getData().getQuantity();    //biến x nhận giá trị trả về Quantity của dữ liệu node temp
            }
            break; //thoát vòng lặp
        }
        return x;
    }

    //Hàm sắp xếp danh sách theo mã với thứ tự theo trong từ điển
    public void InsertionSort(OutputStreamWriter out, ArrayList<Product> listProduct) throws IOException{
        if (this.head == null){     //trường hợp danh sách trống
            System.out.println("Danh sách trống!");
            out.write("Danh sách trống!");
        }
        else if(this.head == this.tail){        //trường hợp danh sách chỉ có 1 phần tử
            System.out.println("Danh sách chỉ có một phần tử! Thỏa mãn!");
            out.write("Danh sách chỉ có một phần tử! Thỏa mãn!");
        }
        else {  //trường hợp từ 2 phần tử trở lên
            Node current = this.head;
            Product product = null;     //đối tượng product hứng giá trị node trong quá trình sắp xếp chuyển đổi
            while (current != null && current.getNext() != null) {  //điều kiện xét khi danh sách có ít nhất 2 nút trở lên
                if (current.getData().getCode().compareToIgnoreCase(current.getNext().getData().getCode()) > 0) {
                    product = current.getData();
                    current.setData(current.getNext().getData());
                    current.getNext().setData(product);
                }
                current = current.getNext();    //chuyển đến node kế tiếp
            }
            listProduct.add(deleteLastNode().getData());    //thêm giá trị node vừa xóa vào danh sách đối tượng được truyền vào

            if (this.head.getNext() == null) {      //điều kiện xét khi danh sách móc nối được xóa chỉ còn lại 1 phần tử
                for (int i = listProduct.size() - 1; i >= 0; i--) { //vòng lặp duyệt qua các phần tử của danh sách đối tượng truyền vào
                    addLast(listProduct.get(i));    //thêm phần tử từ danh sách đối tượng vào cuối danh sách móc nối
                }
            } else {
                InsertionSort(out,listProduct);     //(đệ quy) gọi lại hàm sau mỗi bước sắp xếp
            }
        }
    }

    //hàm xóa và trả về giá trị phần tử cuối danh sách
    public Node deleteLastNode(){
        if (this.head == null){ //trường hợp danh sách trống
            return null;
        }
        Node prevNode = null;   //node prevNode để hứng giá trị node trước lastNode
        Node lastNode = this.head;      //node lastNode để xác định ra node cuối cùng trong danh sách
        while (lastNode.getNext() != null) {    //vòng lặp để duyệt các phần tử trong mảng nhằm xác định lastNode cần tìm
            prevNode = lastNode;
            lastNode = lastNode.getNext();
        }
        if (prevNode == null){  //trường hợp danh sách chỉ còn lại 1 node
            this.tail = lastNode;   //gán tail cho node còn lại
            return lastNode;
        }
        else {      //trường hợp khác
            this.tail = prevNode;       //gán tail cho node trước lastNode là prevNode
            prevNode.setNext(lastNode.getNext());   //xóa node lasrNode
            return lastNode;
        }
    }
}

