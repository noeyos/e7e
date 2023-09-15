<%--
  Created by IntelliJ IDEA.
  User: soyeonlee
  Date: 2023/08/30
  Time: 8:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
    <div class="col-6">
        <label><b>채팅방</b></label>
    </div>
    <div>
        <div id="msgArea" class="col"></div>
        <div class="col-6">
            <div class="input-group mb-3">
                <input type="text" id="msg" class="form-control" aria-label="Recipient's username"
                       aria-describedby="button-addon2">
                <div class="input-group-append">
                    <button class="btn btn-outline-secondary" type="button" id="button-send">전송</button>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    const websocket = new WebSocket("ws://localhost:8080/ws/chat");

    websocket.onmessage = onMessage;

    function send(){

        let msg = document.getElementById("msg");

        console.log(username + ":" + msg.value);
        websocket.send(username + ":" + msg.value);
        msg.value = '';
    }

    function onMessage(msg) {
        var data = msg.data;
        var sessionId = null;
        //데이터를 보낸 사람
        var message = null;
        var arr = data.split(":");

        for (var i = 0; i < arr.length; i++) {
            console.log('arr[' + i + ']: ' + arr[i]);
        }
    }

    var cur_session = username;

    //현재 세션에 로그인 한 사람
    console.log("cur_session : " + cur_session);
    sessionId = arr[0];
    message = arr[1];

    console.log("sessionID : " + sessionId);
    console.log("cur_session : " + cur_session);

    //로그인 한 클라이언트와 타 클라이언트를 분류하기 위함
    if(sessionId == cur_session){
        var str = "<div class='col-6'>";
        str += "<div class='alert alert-secondary'>";
        str += "<b>" + sessionId + " : " + message + "</b>";
        str += "</div></div>";
        $("#msgArea").append(str);
    }
    else{
        var str = "<div class='col-6'>";
        str += "<div class='alert alert-warning'>";
        str += "<b>" + sessionId + " : " + message + "</b>";
        str += "</div></div>";
        $("#msgArea").append(str);
    }


</script>
</body>
</html>
