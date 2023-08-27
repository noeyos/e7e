<%--
  Created by IntelliJ IDEA.
  User: soyeonlee
  Date: 2023/08/23
  Time: 9:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>hamham restful 클라이언트</title>
</head>
<body>
    <div id="disp"></div>
    <form>
        타이틀 <input type="text" name="title" id="title"><br>
        이름 <input type="text" name="sname" id="sname"><br>
        내용 <textarea name="scont" id="scont"></textarea><br>
        <!-- 버튼태그는 form안에 들어가면 자동으로 type=submit이 됨 -->
        <button type="button" onclick="fSearch()">조회</button>
        <button type="button" onclick="fModify()">수정</button>
        <button type="button" onclick="fDel()">삭제</button>
        <button type="button" onclick="fInsert()">입력</button>
    </form>
    <hr>
<script>
    const myList = document.querySelector("#disp");
    const myTitle = document.querySelector("#title");
    const myName = document.querySelector("#sname");
    const myCont = document.querySelector("#scont");

    // TR 마우스 오버
    function fmover(pthis) {
        pthis.style.backgroundColor="black";
        pthis.style.color="yellow";
    }

    function fclick(pthis) {
        myTitle.value = pthis.children[0].innerHTML;
        myName.value = pthis.children[1].innerHTML;
        myCont.value = pthis.children[2].innerHTML;
    }

    function fModify() {
        let hamhamVO = {
            title : myTitle.value,
            sname : myName.value,
            scont : myCont.value
        }

        let xhr = new XMLHttpRequest();
        xhr.open("put", "/rest/ham", true);
        xhr.setRequestHeader("Content-Type", "application/json;charset=utf-8"); // json타입의 문자열을 보낸다는 걸 알려줌
        xhr.onreadystatechange = function () {
            if(xhr.readyState == 4 && xhr.status == 200) {
                console.log("체크: ",xhr.responseText);
                getList();
            }
        }
        xhr.send(JSON.stringify(hamhamVO));
        // java는 스크립트 형태를 인식 못하므로 문자열(json형식의 문자열)로 보내야 함
    }

    function fDel() {
        let xhr = new XMLHttpRequest();
        let delURL = `/rest/ham/\${myTitle.value}`
        xhr.open("delete", delURL, true);
        xhr.onreadystatechange = function () {
            if(xhr.readyState == 4 && xhr.status == 200) {
                console.log("체크: ",xhr.responseText);
                getList();
            }
        }
        xhr.send();
        // java는 스크립트 형태를 인식 못하므로 문자열(json형식의 문자열)로 보내야 함
    }

    function fSearch() {
        let xhr = new XMLHttpRequest();
        let schURL = `/rest/ham/\${myTitle.value}`
        xhr.open("get", schURL, true);
        xhr.onreadystatechange = function () {
            if(xhr.readyState == 4 && xhr.status == 200) {
                console.log("체크: ",xhr.responseText);
                let hamhamVO = xhr.responseText;
                if(hamhamVO) {
                    hamhamVO = JSON.parse(hamhamVO); // json문자열을 json객체로
                    myName.value = hamhamVO.sname;
                    myCont.value = hamhamVO.scont;
                } else {
                    myName.value = null;
                    myCont.value = null;
                    alert("찾는 타이틀이 존재하지 않습니다.");
                }
            }
        }
        xhr.send();
        // java는 스크립트 형태를 인식 못하므로 문자열(json형식의 문자열)로 보내야 함
    }

    function fInsert() {
        let hamhamVO = {
            title : myTitle.value,
            sname : myName.value,
            scont : myCont.value
        }

        let xhr = new XMLHttpRequest();
        xhr.open("post", "/rest/ham", true);
        xhr.setRequestHeader("Content-Type", "application/json;charset=utf-8"); // json타입의 문자열을 보낸다는 걸 알려줌
        xhr.onreadystatechange = function () {
            if(xhr.readyState == 4 && xhr.status == 200) {
                console.log("체크: ",xhr.responseText);
                getList();
            }
        }
        xhr.send(JSON.stringify(hamhamVO));
        // java는 스크립트 형태를 인식 못하므로 문자열(json형식의 문자열)로 보내야 함
    }

    // TR 마우스 아웃
    function fmout(pthis) {
        pthis.style.backgroundColor="white";
        pthis.style.color="black";
    }

    // 리스트 가져다 뿌리기
    const getList = () => {
        let xhr = new XMLHttpRequest();
        xhr.open("get", "/rest/hams", true);
        xhr.onreadystatechange = () => {
            if(xhr.readyState == 4 && xhr.status == 200) {
                console.log(xhr.responseText);
                //xhr.responseText 값 => json 타입의 문자열
                console.log(JSON.parse(xhr.responseText)); // 리스트 타입

                //json문자열을 json객체로 바꿔야 편하게 쓸 수 있음!
                let rslt = JSON.parse(xhr.responseText);

                let tblStr = "<table border=1>";
                tblStr += "<tr><th>타이블</th><th>이름</th><th>내용</th></tr>";
                for(let i=0; i<rslt.length; i++) {
                    tblStr += `<tr onmouseover = fmover(this) onmouseout=fmout(this) onclick=fclick(this)>`;
                    tblStr += `<td>\${rslt[i].title}</td>`;
                    tblStr += `<td>\${rslt[i].sname}</td>`;
                    tblStr += `<td>\${rslt[i].scont}</td>`;
                    // 달러{} <== 자바 스프링 el 이랑 같은 형색이라 자바가 먼저 해석해버림
                    // 그렇기 때문에 앞에 \을 붙여서 jsp가 해석할 수 있도록 해줘야 함.
                    tblStr += "</tr>";

                }

                tblStr += "</table>";
                myList.innerHTML = tblStr;

            }
        }
        xhr.send();
    }
    getList();
</script>
</body>
</html>
