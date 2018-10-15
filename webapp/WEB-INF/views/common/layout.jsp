<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title><tiles:getAsString name="title" /></title>
	<link href="<c:url value="/static/css/bootstrap.min.css" />" rel="stylesheet">
	<script src="<c:url value="/static/js/bootstrap.min.js" />"></script>
</head>

<body>
		<header id="header">
            <tiles:insertAttribute name="header" />
        </header>
        
        <section id="site-content">
            <tiles:insertAttribute name="body" />
        </section>
         
        <footer id="footer">
            <tiles:insertAttribute name="footer" />
        </footer>
</body>
</html>