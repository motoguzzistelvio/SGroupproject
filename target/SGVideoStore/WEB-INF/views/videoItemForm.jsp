<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New/Edit Video Item</title>
</head>
<body>
    <div align="center">
        <h1>New/Edit Video Item</h1>
        <form:form action="saveVideoItem" method="post" modelAttribute="videoitem">
        <table>
            <form:hidden path="id"/>
            <tr>
                <td>Serial Number:</td>
                <td><form:input path="serialNumber" /></td>
            </tr>
           
            <tr>
             <form:select path="videoId">
   			 <option value="NONE"  label="Select a video name"></option>
   			 	 <c:if test="${videoId > 0}">
   						<option value="selected"  itemValue="videoId" ></option>
				</c:if>
   				 <form:options items="${listvideo}" itemValue="id" itemLabel="name" />
   				
			 </form:select> 
           </tr>
           <tr>
             <form:select path="customerId">
   			 <option value="NONE"  label="Select a customer"></option>
   			 	 <c:if test="${customerId > 0}">
   						<option value="selected"  itemValue="customerId" ></option>
				</c:if>
   				 <form:options items="${listcustomer}" itemValue="id" itemLabel="surname" />
   				
			 </form:select> 
           </tr>
           <tr>
                <td colspan="2" align="center"><input type="submit" value="Save"></td>
            </tr>
        </table>
        </form:form>
    </div>
</body>
</html>