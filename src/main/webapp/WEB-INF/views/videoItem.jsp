<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Video Maintenance Page</title>
    </head>
    <body>
        <div align="center">
            <h1>Video Items List</h1>
            <h3><a href="newVideoItem">New Video Item</a></h3>
            <table border="1">
                <th>ID</th>
                <th>Serial Number</th>
                <th>Video</th>
                <th>Customer</th>
                <th>Create Date</th>
                                            
                <c:forEach var="videoitem" items="${listVideoItems}" varStatus="status">
                <tr>
                    <td>${videoitem.id}</td>
                    <td>${videoitem.serialNumber}</td>
                    <td>${videoitem.videoId}</td>
                    <td>${videoitem.customerId}</td>
                    <td>${videoitem.createDate}</td>
                    
                    <td>
                        <a href="editVideoItem?id=${videoitem.id}">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="deleteVideoItem?id=${videoitem.id}">Delete</a>
                         <a href="editVideoItem?id=${videoitem.id}">Check out video Item</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="editVideoItem?id=${videoitem.id}">Check in Video Item</a>
                    </td>
                             
                </tr>
                </c:forEach>             
            </table>
        </div>
    </body>
</html>