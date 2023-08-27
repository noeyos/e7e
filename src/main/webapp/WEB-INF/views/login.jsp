<%--
  Created by IntelliJ IDEA.
  User: soyeonlee
  Date: 2023/08/21
  Time: 4:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<style>
    .container {
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
        height: 100vh;
        border: 1px solid black;
    }

    .container > * {
        border: 1px solid black;
    }

    .logo-img {
        width: 213px;
        height: 60px;
        border: 1px solid black;
    }

    .login-div {
        display: flex;
        flex-direction: column;
        align-items: center;
        margin-top: 64px;
    }

    form {
        display: flex;
        flex-direction: column;
        align-items: center;
    }

    input[type="text"], input[type="submit"] {
        width: 516px;
        height: 64px;
        padding: 10px;
        border: 1px solid black;
    }

    .userId {
        margin-bottom: 24px;
    }

    .find-id-pw {
        text-align: right;
        font-size: 14px;
        width: 100%;
        padding: 20px 0px 65px 20px;
        box-sizing: border-box; /* Include padding in width calculation */
    }
</style>
<body>
<div class="container">
    <div class="logo-img"></div>
    <div class="login-div">
        <form action="#" method="post">
            <input type="text" class="userId" placeholder="ID" />
            <input type="text" class="userPw"placeholder="PASSWORD" />
            <div class="find-id-pw"><a href="#">아이디</a> | <a href="#">비밀번호 찾기</a></div>
            <input type="submit" value="로그인">
        </form>
    </div>
</div>
</body>
</html>
