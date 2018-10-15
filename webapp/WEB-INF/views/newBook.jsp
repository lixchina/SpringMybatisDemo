<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

 
<title>newBook</title>
</head>
<body>
    <spring:message code="bookName" var="varBookName"/>
    <spring:message code="price" var="varPrice"/>
    <spring:message code="cover" var="varCover"/>
    
    <div class="container-fluid">
    <form:form
        action="${pageContext.request.contextPath}/book/create"
        method="post" modelAttribute="bookForm" class="well" enctype="multipart/form-data">
        <div class="form-group">
            <form:label path="bookName" class="control-label">${varBookName}</form:label>
            <form:input path="bookName" class="form-control"/>
            <p class="help-block"><font color="red"><form:errors path="bookName" /></font></p>
        </div>
        <div class="form-group">
            <form:label path="price" class="control-label">${varPrice}</form:label>
            <form:input path="price" class="form-control"/>
            <p class="help-block"><font color="red"><form:errors path="price" /></font></p>
        </div>
        <div class="form-group">
            <label for="uploadFile" class="control-label">${varCover}</label>
            <input name="uploadFile" type="file" class="form-control"/>
        </div>
        <div class="form-group">
            <input type="submit" value="Create" class="btn btn-primary"/>
        </div>
    </form:form>
    </div>
</body>
</html>