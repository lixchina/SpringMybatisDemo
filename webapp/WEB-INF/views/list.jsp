<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>


    <c:forEach items="${list}" var="book">
        ${book.bookId }
      
        ----->${book.name }   
        ----->${book.price }  
        ----->
        <img src="data:image/jpeg;base64,${book.coverBase64}"/>  
        </br>
    </c:forEach>
    <a href=${pageContext.request.contextPath}/book>create new book</a>
</body>
</html>