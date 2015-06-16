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
            <h1>Video List</h1>
            <h3><a href="newVideo">New Video</a></h3>
            <table border="1">
                <th>ID</th>
                <th>Movie Name</th>
                <th>Genre Id</th>
                <th>Movie Length</th>
                <th>Actors</th>
                <th>Release Date</th>
                                            
                <c:forEach var="video" items="${listvideo}" varStatus="status">
                <tr>
                    <td>${video.id}</td>
                    <td>${video.name}</td>
                    <td>${video.genreId}</td>
                    <td>${video.minutes}</td>
                    <td>${video.actors}</td>
                    <td>${video.releaseDate}</td>
                    <td>
                        <a href="editVideo?id=${video.id}">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="deleteVideo?id=${video.id}">Delete</a>
                    </td>
                             
                </tr>
                </c:forEach>             
            </table>
        </div>
    </body>
</html>