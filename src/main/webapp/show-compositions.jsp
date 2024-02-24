<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<html>
<body>
<h2>Список композиций:</h2><br>
<table border="1" style="border-collapse: collapse;">
    <tr>
        <td>ID</td>
        <td>Название</td>
        <td>Жанр</td>
    </tr>
    <c:forEach items="${compositions}" var="composition">
        <tr>
            <td>${composition.getId()}</td>
            <td>${composition.getName()}</td>
            <td>${composition.getDuration()}</td>
        </tr>
    </c:forEach>
</table>
<br>
</body>
</html>