<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Voir Partie</title>
</head>
<body>
<h1>Voir Partie</h1>
<c:if test="${not empty partie}">
    <p>Numéro: ${partie.pno}</p>
    <p>Joueur 1: ${partie.jno1}</p>
    <p>Joueur 2: ${partie.jno2}</p>
    <p>Date: ${partie.date}</p>
    <p>Statut: ${partie.statut}</p>
    <p>Temps: ${partie.temps}</p>
    <p>Gagnant: ${partie.gagnant}</p>
</c:if>
<a href="/partie?action=list">Retour liste</a>
</body>
</html>
