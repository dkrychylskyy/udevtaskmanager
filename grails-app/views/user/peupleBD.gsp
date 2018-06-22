<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main" />
    <g:set var="entityName" value="${message(code: 'user.label', default: 'User')}" />
    <title><g:message code="default.create.label" args="[entityName]" /></title>
</head>
<body>
<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
    </ul>
</div>
    <p>On a ajouté dans BD le <span class="badge" style="background-color: #5bc0de"> ${count }</span> utilisateurs</p>
    <table class="table table-bordered">
        <tr>
            <th>Nom</th>
            <th>Prenom</th>
            <th>Email</th>
            <th>Mot de passe provisoir</th>
        </tr>
        <g:each in="${userList}">
            <tr>
                <td>${it.nom}</td>
                <td>${it.prenom}</td>
                <td>${it.email}</td>
                <td>1111</td>
            </tr>
        </g:each>
    </table>

</body>