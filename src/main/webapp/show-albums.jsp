<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<html>
<body>
<h2>Список альбомов:</h2><br>
<table border="1" style="border-collapse: collapse;">
    <tr>
        <td>ID</td>
        <td>Название</td>
        <td>Жанр</td>
    </tr>
    <c:forEach items="${albums}" var="album">
        <tr>
            <td>${album.getId()}</td>
            <td>${album.getName()}</td>
            <td>${album.getGenre()}</td>
        </tr>
    </c:forEach>
</table>
<br>
</body>
</html>
