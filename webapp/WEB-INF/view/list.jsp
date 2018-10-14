<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


    <c:forEach items="${list}" var="book">
        ${book.bookId }
        <!-- 这里使用jstl取值，如果我们把User对象的字段，所对应的getter和setter方法去掉，页面会报错 -->
      
        ----->${book.name }        
        </br>
    </c:forEach>
    
</body>
</html>