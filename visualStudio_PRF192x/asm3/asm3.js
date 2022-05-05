$(document).ready(function(){
    var i = 1;  //biến chạy stt
    
    $('#nhap').on('click', function () {  //hàm nhập họ tên, điểm học sinh

        if ($("#name").val().trim().length === 0) {  //điều kiện nhằm khai báo cho người dùng biết lỗi khi nhập
            alert("Vui lòng nhập tên học sinh");
        }
        else if ($("#math").val() < 0 || $("#math").val()>10 || $("#math").val().trim().length === 0 || 
            $("#physical").val().trim().length === 0 || $("#physical").val() < 0 || $("#physical").val()>10 || 
            $("#chemistry").val() < 0 || $("#chemistry").val()>10 || $("#chemistry").val().trim().length === 0) {

                alert("Điểm số không hợp lệ vui lòng nhập điểm trong khoảng 0 đến 10");
        }
        else{//chèn dòng và các ô vào bảng đồng thời gán giá trị trong các ô input vào bảng
            $("#table").append('<tr><td>'+ i +'</td><td>'+$("#name").val()+'</td><td>'+$("#math").val()+'</td><td>' 
                                +$("#physical").val()+'</td><td>'+$("#chemistry").val()+'</td><td>?</td></tr>'); 
            
            $("#name").val("");   //xóa dữ liệu trong ô input
            $("#math").val("");
            $("#physical").val("");
            $("#chemistry").val("");
            i=i + 1; 
        }
    });

    $('#diemtb').on('click', function () {   //hàm tính điểm trung bình
            $('tr').each(function(){    //vòng lặp each cho phép lặp từ đầu đến cuối các hàng trong bảng
            
                var math= $(this).find("td").eq(2).html();  //khai báo các biến giá trị, cho các biến nhận giá trị của ô được chỉ định trong hàng
                var physical= $(this).find("td").eq(3).html();  
                var chemistry= $(this).find("td").eq(4).html();  
                var tb= ((parseFloat(math) + parseFloat(physical) + parseFloat(chemistry))/3).toFixed(1);   //biến giá trị điểm trung bình
                $(this).find("td").eq(5).html(tb);  //gán giá trị điểm trung bình tính được ở mỗi dòng vào ô số 5 (tính từ 0) của mỗi dòng
                    
            });                        
    });            
            
    $('#hsgioi').on('click', function () {    //hàm hiển thị học sinh giỏi
        $('tr').each(function(){
            var gioi = $(this).find("td").eq(5).html();
            if (gioi>=8) {
                    this.style.backgroundColor= 'red';    //định dạng background-color cho các dòng 
            }                         //có giá trị gioi>=8, ở đây "this" nghĩa dòng hiện tại mà vòng lặp đang xét
        });
    });
        
    $('#huy').on('click', function () {    //hàm hủy định dạng background-color cho các hàng có hsgioi đã được xét ở trên
            $('tr').each(function(){
                this.style.backgroundColor= '#f0f0f0';
            });
    });
        
    $('#delete').on('click', function () {   //hàm xóa 1 hàng được chỉ định ở trong ô input
            $('tr').each(function(){                  
                if ($('#hang').val() == $(this).find("td").eq(0).html()) {
                        $('tr').closest(this).remove();   //xóa hàng
                        $('#hang').val("");   //xóa dữ liệu trong ô input
                        i--; 
                }
                
                if ($('#hang').val() != $(this).find("td").eq(0).html()) {  
                    //vòng lặp đặt lại số thứ tự cho các hàng sau khi có 1 hàng bị xóa
                    var z=-1;
                    $('tr').each(function(){
                        z=z+1;
                        $(this).find("td").eq(0).html(z);
                    });
                }
            });
    });          
});