<%--
  Created by IntelliJ IDEA.
  User: soyeonlee
  Date: 2023/09/01
  Time: 10:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ftpClient test</title>
</head>
<body>
<form action="/ftp/uploadTest" method="post" enctype="multipart/form-data">
    <input type="file" name="myFile" value="">
    <button>전송</button>
</form>
</body>
</html>
