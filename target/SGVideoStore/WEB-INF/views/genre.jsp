<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Genre Maitenance Page</title>
    </head>
    <body>
        <div align="center">
            <h1>Genre List</h1>
            <h3><a href="newGenre">New Genre</a></h3>
            <table border="1">
                <th>ID</th>
                <th>Description</th>
                <th>Date Created</th>
                              
                <c:forEach var="genre" items="${listgenre}" varStatus="status">
                <tr>
                    <td>${genre.id}</td>
                    <td>${genre.description}</td>
                    <td>${genre.createDate}</td>
                    <td>
                        <a href="editGenre?id=${genre.id}">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="deleteGenre?id=${genre.id}">Delete</a>
                    </td>
                             
                </tr>
                </c:forEach>             
            </table>
        </div>
    </body>
</html>