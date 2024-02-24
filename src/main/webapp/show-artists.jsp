<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<html>
<body>
<h2>Список артистов:</h2><br>
<table border="1" style="border-collapse: collapse;">
    <tr>
        <td>ID</td>
        <td>Имя</td>
        <td>Фамилия</td>
    </tr>
    <c:forEach items="${artists}" var="artist">
        <tr>
            <td>${artist.getId()}</td>
            <td>${artist.getName()}</td>
            <td>${artist.getSurname()}</td>
        </tr>
    </c:forEach>
</table>
<br>
</body>
</html>
