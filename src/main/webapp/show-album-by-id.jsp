<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<html>
<head>
    <h3>Альбом:</h3>
</head>
<body>
<table border="1" style="border-collapse: collapse;">
    <tr>
        <td>ID</td>
        <td>Название</td>
        <td>Жанр</td>
    </tr>
    <tr>
        <td>${id}</td>
        <td>${name}</td>
        <td>${genre}</td>
    </tr>
</table>
</body>