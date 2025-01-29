<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Editer Partie</title>
</head>
<body>
<h1>Editer Partie</h1>
<form action="/partie/save" method="post">
    <input type="hidden" name="pno" value="${partie.pno}" />

    <label>Joueur 1</label>
    <input type="text" name="jno1" value="${partie.jno1}" /><br/>

    <label>Joueur 2</label>
    <input type="text" name="jno2" value="${partie.jno2}" /><br/>

    <label>Date</label>
    <input type="date" name="date" value="${partie.date}" /><br/>

    <label>Statut</label>
    <select name="statut">
        <option value="1" ${partie.statut == 1 ? 'selected' : ''}>Non commencée</option>
        <option value="2" ${partie.statut == 2 ? 'selected' : ''}>En cours</option>
        <option value="3" ${partie.statut == 3 ? 'selected' : ''}>Terminée</option>
    </select><br/>

    <label>Temps</label>
    <input type="number" name="temps" value="${partie.temps}" /><br/>

    <label>Gagnant</label>
    <input type="text" name="gagnant" value="${partie.gagnant}" /><br/>

    <button type="submit">Enregistrer</button>
</form>
</body>
</html>
