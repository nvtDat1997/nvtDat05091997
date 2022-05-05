const t = new XMLHttpRequest();                                     
        t.open("GET", "https://gnews.io/api/v4/top-headlines?token=47b8f9dc53569b36401ff695c63ea0dc&lang=en");
        t.send();
        t.onload = function(){
            let data = JSON.parse(this.responseText);
            let news = data.articles;
            let output = "";
            for (var i in news){
                output += `<div class = 'chiacot'>
                    <div class = 'cot1'>
                    <img src = "${news[i].image}" />
                    </div>

                    <div class = 'cot2'>
                    <h5><a href = "${news[i].url}" target = "_blank"> ${news[i].title}</a></h5>                    
                    <h6><i>${news[i].publishedAt}</i></h6>
                    <p>${news[i].description}</p>
                    </div>
                    </div>                    
                    `
            }
            document.getElementById('infomation').innerHTML = output;
        }

document.addEventListener("DOMContentLoaded", function(){
    var nut = document.getElementById('click');
    var them = document.getElementsByClassName('keywords');
    var them01 = document.getElementsByClassName('row');
    nut.onclick = function(){        
        them[0].classList.add('hienthi');
        them01[0].classList.add('an');
    }
},false)

document.addEventListener("DOMContentLoaded", function(){
    var nutx = document.getElementsByClassName('iconx');
    var them = document.getElementsByClassName('keywords');
    var them01 = document.getElementsByClassName('row');
    nutx[0].onclick = function(){        
        them[0].classList.remove('hienthi');
        them01[0].classList.remove('an');
    }
},false)

    const searchForm = document.querySelector('.searchform');
	const input = document.querySelector('#input');
	const newList = document.querySelector('#infomation');	
	searchForm.addEventListener('submit', retrieve)

	function retrieve(e){
        var them = document.getElementsByClassName('keywords');
        var them01 = document.getElementsByClassName('row');
        var them001 = document.getElementsByClassName('infomation');

            them[0].classList.remove('hienthi');
            them01[0].classList.remove('an');	
            them001[0].classList.add('tintuc');
            
		if(input.value == ''){
            them[0].classList.remove('hienthi');
            them01[0].classList.remove('an');
            
			alert('Nhập dữ liệu bạn muốn tìm kiếm')
			return 
		}

		newList.innerHTML = '';
		
		e.preventDefault()
		let topic = input.value;
		let url = "https://gnews.io/api/v4/search?q="+topic+"&token=47b8f9dc53569b36401ff695c63ea0dc&lang=en"
		fetch(url).then((response)=>{
            
			return response.json();
			}).then((data)=>{			
				data.articles.forEach(article =>{								
				let img = document.createElement('img');
				let divcha = document.createElement('div');
				let div = document.createElement('div');
                let h5 = document.createElement('h5');
				let a = document.createElement('a');
				let h6 = document.createElement('h6');
				let p = document.createElement('p');
				
				img.src = article.image;
				a.setAttribute('href', article.url );
				a.setAttribute('target', '_blank' );
				a.textContent = article.title;
				h6.textContent = article.publishedAt;
				p.textContent = article.description;
				divcha.appendChild(img);
				div.appendChild(h5);
				h5.appendChild(a);
				div.appendChild(h6);
				div.appendChild(p);				
				divcha.appendChild(div);				
				newList.appendChild(divcha);				
			});			
		});
	}

