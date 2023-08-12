<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>AJAX File Upload</h1>
	<form>
		<input type="text" name="goodWords" value="good"><br>
		<input type="text" name="badWords" value="bad"><br>
		<input type="file" name="file" value="" onchange="fChg(this)">
	</form>
	<div id="disp"></div>
	<script>
		const myDisp = document.querySelector("#disp");
		const myForm = document.forms[0];

		function fChg(pThis) {

			let formData = new FormData(myForm);
			console.log("로그", pThis.files[0]);
			/*
				FormData를 생성 해서 append()로 추가하는 방법이 있고, 생성 때 주는 방법이 있음
				사용자 입력이 많을 땐 new FormData(myForm)처럼 form을 넘기는 방법을 쓴다
			*/

			
			/*
				// 아작스로 파일보내기를 하려면 꼭 FormData를 써야 함!
				// 무조건 자동으로 multipart/form-data로 전송됨
				let formData = new FormData();
				// formData.append("이름","값")
				console.log("로그", pThis.files[0]);
				formData.append("file", pThis.files[0])
				// 여기 "이름" 이랑 이 파일 받는 컨트롤러 MultipartFile 매개변수명이랑 일치해야 함 
			*/

			let xhr = new XMLHttpRequest();
			xhr.open("post", "/mFile", true);
			xhr.onreadystatechange = function() {
				if (xhr.readyState == 4 && xhr.status == 200) {
					console.log(xhr.responseText);
					let myImg = document.createElement("img"); // 이미지 태크 만들기
					myImg.src = xhr.responseText; // 이미지 경로 세팅
					myImg.width = 100;
					myImg.height = 100;
					myDisp.appendChild(myImg);
				}
			}

			// get방식 이외에는 보내는 데이터를 send()안에 매개변수로 보내야 함
			xhr.send(formData); // 반드시 문자열로
		}
	</script>
</body>
</html>