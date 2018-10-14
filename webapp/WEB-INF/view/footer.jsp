<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<link href="<c:url value="/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<c:url value="/css/bootstrap-theme.min.css" />" rel="stylesheet">
<script src="<c:url value="/js/bootstrap.min.js" />"></script>
<title>footer</title>
</head>
<body>
    <spring:url value="/book" var="varHomeUrl"/>

    <div class="container-fluid">
    <div class="col-sm-3 text-left">
        <a href="${varHomeUrl}?lang=en"><u>English</u></a>
        <a href="${varHomeUrl}?lang=ja"><u>Japanese</u></a>
    </div>
    <div align="center">@Copyright bookmount8</div>
    </div>
</body>
</html>