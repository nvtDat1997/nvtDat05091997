var testScore = { 
    name: [],
    math: [],
    physical: [],
    chemistry: []
};

var t = 0;        

function Name() {
    if(document.getElementById("name").value.trim().length === 0){
        alert('Vui lòng điền thông tin học sinh');
    }
    else if(document.getElementById("math").value.trim().length === 0 || document.getElementById("math").value < 0 ||
        document.getElementById("math").value > 10 || document.getElementById("physical").value.trim().length === 0 || 
        document.getElementById("physical").value < 0 || document.getElementById("physical").value > 10 || 
        document.getElementById("chemistry").value.trim().length === 0 || 
        document.getElementById("chemistry").value < 0 || document.getElementById("chemistry").value > 10){

            alert('Vui lòng điền điểm số học sinh nằm trong khoảng từ 0-10');
    }
    else{
        t = t + 1;
        console.log('test');
        testScore.name[t-1] = document.getElementById("name").value;
        testScore.math[t-1] = document.getElementById("math").value;
        testScore.physical[t-1] = document.getElementById("physical").value;
        testScore.chemistry[t-1] = document.getElementById("chemistry").value;
        
        var row = table.insertRow(t);
        var cell1 = row.insertCell(0);
        var cell2 = row.insertCell(1);
        var cell3 = row.insertCell(2);
        var cell4 = row.insertCell(3);
        var cell5 = row.insertCell(4);
        var cell6 = row.insertCell(5);
        
        cell1.innerHTML = t;
        cell2.innerHTML = testScore.name[t-1];
        cell3.innerHTML = testScore.math[t-1];
        cell4.innerHTML = testScore.physical[t-1];
        cell5.innerHTML = testScore.chemistry[t-1];
        cell6.innerHTML = "";
        
        document.getElementById("name").value = "";
        document.getElementById("math").value = "";
        document.getElementById("physical").value = "";
        document.getElementById("chemistry").value = "";
    }
    }

    function diemtb() {
    for (var i = 1, row; row = table.rows[i]; i++) {
    row.cells[5].innerHTML = ((parseFloat(row.cells[2].innerHTML) + parseFloat(row.cells[3].innerHTML) + 
                                parseFloat(row.cells[4].innerHTML))/3).toFixed(1);
    }  
    }

    function hsgioi() {
    for (var i = 1, row; row = table.rows[i]; i++) {
        if (row.cells[5].innerHTML >= 8) {
                row.style.backgroundColor = "red";
        }
    }
}

function huy() {           
        for (var i = 1, row; row = table.rows[i]; i++) {
            row.style.backgroundColor = "#f0f0f0";
        }                 
}

function sapxep() {
    var data = {
                    name:[],
                    math:[],
                    physical:[],
                    chemistry:[],
                    tb:[]
                };
    for (var i = 1, row1; row1 = table.rows[i]; i++) {
        for (var j = i+1, row2; row2 = table.rows[j]; j++) {
            if (parseFloat(parseFloat(row2.cells[2].innerHTML)+parseFloat(row2.cells[3].innerHTML)+parseFloat(row2.cells[4].innerHTML))
                    > parseFloat(parseFloat(row1.cells[2].innerHTML)+parseFloat(row1.cells[3].innerHTML)+parseFloat(row1.cells[4].innerHTML))) {
                    data.name[0] = row1.cells[1].innerHTML;
                    data.math[0] = row1.cells[2].innerHTML;
                    data.physical[0] = row1.cells[3].innerHTML;
                    data.chemistry[0] = row1.cells[4].innerHTML;
                    data.tb[0] = row1.cells[5].innerHTML;
                    
                    data.name[1] = row2.cells[1].innerHTML;
                    data.math[1] = row2.cells[2].innerHTML;
                    data.physical[1] = row2.cells[3].innerHTML;
                    data.chemistry[1] = row2.cells[4].innerHTML;
                    data.tb[1] = row2.cells[5].innerHTML;
                    
                    row1.cells[1].innerHTML = data.name[1];
                    row1.cells[2].innerHTML = data.math[1];
                    row1.cells[3].innerHTML = data.physical[1];
                    row1.cells[4].innerHTML = data.chemistry[1];
                    row1.cells[5].innerHTML = data.tb[1];
                    
                    row2.cells[1].innerHTML = data.name[0];
                    row2.cells[2].innerHTML = data.math[0];
                    row2.cells[3].innerHTML = data.physical[0];
                    row2.cells[4].innerHTML = data.chemistry[0];
                    row2.cells[5].innerHTML = data.tb[0];
            }
        }
    }
}

function xoa() {
    for (var i = 1, row; row = table.rows[i]; i++) {
        if (i==document.getElementById("hang").value) {
            table.deleteRow(i);
            t--;;
            for (var j = i, row; row = table.rows[j]; j++) {
                row.cells[0].innerHTML = j;
            }
        }
    }
    document.getElementById("hang").value = "";
}

//Hiệu ứng nhấp nháy tiêu đề
var h1Element = document.querySelector('.header');
h1Element.classList.add('twinkling');

setInterval(()=>{
    h1Element.classList.toggle('twinkling')
},2000);