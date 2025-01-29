<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Liste des parties</title>
</head>
<body>
<h1>Liste des parties</h1>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Joueur1</th>
        <th>Joueur2</th>
        <th>Date</th>
        <th>Statut</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="p" items="${parties}">
        <tr>
            <td>${p.pno}</td>
            <td>${p.jno1}</td>
            <td>${p.jno2}</td>
            <td>${p.date}</td>
            <td>${p.statut}</td>
            <td>
                <a href="/partie?action=voir&id=${p.pno}">Voir</a> |
                <a href="/partie?action=modifier&id=${p.pno}">Modifier</a> |
                <a href="/partie?action=delete&id=${p.pno}"
                   onclick="return confirm('Supprimer la partie ?');">Supprimer</a>
            </td>
        </tr>
    </c:forEach>
</table>
<br/>
<a href="/partie?action=modifier">Créer une nouvelle partie</a>
</body>
</html>
