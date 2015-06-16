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
            <h1>Available Videos currently in Store</h1>
             <table border="1">
                <th>Name</th>
                <th>Serial Number</th>
                <th>Genre</th>
                <th>Actors</th>
                <th>Release Date</th>
                                                           
                <c:forEach var="searchobject" items="${listSearch}" varStatus="status">
                <tr>
                    <td>${searchobject.name}</td>
                    <td>${searchobject.serialNumber}</td>
                    <td>${searchobject.genre}</td>
                    <td>${searchobject.actors}</td>
                    <td>${searchobject.releaseDate}</td>
                   
                </tr>
                </c:forEach>
                <tr>
                 <td>
                       <a href="welcome">Back to home page</a>
                   
                    </td>
                </tr>    
                                        
            </table>
        </div>
    </body>
</html>