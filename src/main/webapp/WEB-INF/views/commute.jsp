<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>commute</title>
</head>
<style>
    .container {
        display: flex;
        flex-direction: column;
        width: 1476px;
    }

    .head-title, .middle-div, .small-title, .month {
        border: 1px solid black;
    <%-- padding: 20px; --%>
        margin-bottom: 10px;

    }

    .head-title {
        display: flex;
    }

    .title {
        width: 50%;
    }

    .common {
        width : 50%;
    }

    .month-grid {
        display: grid;
        grid-template-columns: repeat(4, 351px);
        grid-template-rows: repeat(3, 98px);
        gap: 24px 24px;
    }

    .month {
        width: 100%;
    }

    .middle-div {
        display : flex;
    }

    .img {
        width: 367px;
        height: 256px;
        border: 1px solid black;
        margin-right: 30px;
    }

    .commute-time-and-bar {
        display: flex;
        flex-direction: column;
        height: 256px;
        border: 1px solid black;
        text-align: center;
    }

    .commute-time {
        display: grid;
        grid-template-areas: repeat(2, 60px);
        grid-template-columns: repeat(2, 189px);
        border: 1px solid black;
    }

    .commute-bar {
        display: flex;
        flex-direction: column;
    }

    .bar {
        width: 397px;
        height: 35px;
        border: 1px solid black;
    }


</style>
<body>
<div class="container">
    <div class="head-title">
        <div class="title"><p>출·퇴근 현황</p></div>
        <div class="common"></div>
    </div>

    <div class="middle-div">
        <div class="img"></div>
        <div class="commute-time-and-bar">
            <div class="commute-time">
                <div class="attendence-time">
                    <p>출근 08:54</p>
                </div>
                <div class="left-time">
                    <p>퇴근 18:00</p>
                </div>
                <div class="total-time-today">
                    <p>오늘 근무 시간</p>
                    <p>05시간 30분</p>
                </div>
                <div class="total-time-week">
                    <p>이번주 총 근무 시간</p>
                    <p>34시간 30분</p>
                </div>
            </div>
            <div class="commute-bar">
                <div class="bar-text">
                    <span>0h</span>
                    <span>72h</span>
                </div>
                <div class="bar"></div>
            </div>
        </div>
        <div class="commute-table"></div>
    </div>

    <div class="small-title">

    </div>
    <div class="month-grid">
        <c:forEach var="eachMonth" begin="1" end="12">
            <input type="button" class="month" value="<c:out value="${eachMonth}" />">
        </c:forEach>
    </div>
</div>
</body>
</html>
