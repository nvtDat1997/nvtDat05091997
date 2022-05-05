package asm2;

public class Product{
//khai báo thuộc tính cho đối tượng Product
private String code;    //mã sản phẩm
private String name;    //tên
private Integer quantity;   //số lượng
private Double price;   //đơn giá

//constructor
public Product(String code, String name, Integer quantity, Double price) {
        this.code = code;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        }

public String getCode() {
        return code;
        }

public void setCode(String code) {
        this.code = code;
        }

public String getName() {
        return name;
        }

public void setName(String name) {
        this.name = name;
        }

public Integer getQuantity() {
        return quantity;
        }

public void setQuantity(Integer quantity) {
        this.quantity = quantity;
        }

public Double getPrice() {
        return price;
        }

public void setPrice(Double price) {
        this.price = price;
        }

@Override
public String toString() {  //trả về chuỗi đại diện cho đối tượng
        return  String.format("%-30s",getCode()) +
        String.format("%-30s",getName()) +
        String.format("%-20d",getQuantity()) +
        String.format("%-20.2f",getPrice());
        }
        }

