<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Liste</title>
</head>
<body>
<h1>Liste de tous les objets</h1>
<ul>
    <c:forEach var="obj" items="${objects}">
        <li>${obj}</li>
    </c:forEach>
</ul>
<a href="/myObject?action=vignette&n=0">Aller à la vignette 0</a>
</body>
</html>
