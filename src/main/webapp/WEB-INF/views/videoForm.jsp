<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New/Edit Video</title>
</head>
<body>
    <div align="center">
        <h1>New/Edit Video</h1>
        <form:form action="saveVideo" method="post" modelAttribute="video">
        <table>
            <form:hidden path="id"/>
            <tr>
                <td>Movie Name:</td>
                <td><form:input path="name" /></td>
            </tr>
           
             <tr>
                <td>Movie Length:</td>
                <td><form:input path="minutes" /></td>
            </tr>
            <tr>
                <td>Actors:</td>
                <td><form:input path="actors" /></td>
            </tr>
            <tr>
             <form:select path="genreId">
   			 <option value="NONE"  label="Select a genre"></option>
   			 	 <c:if test="${genreId > 0}">
   						<option value="selected"  itemValue="genreId" ></option>
				</c:if>
   				 <form:options items="${genres}" itemValue="id" itemLabel="description" />
   				
			 </form:select> 
           </tr>
            
            <tr>
                <td>Release Date:</td>
                <td><form:input path="releaseDate" /></td>
            </tr>
                       
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Save"></td>
            </tr>
        </table>
        </form:form>
    </div>
</body>
</html>