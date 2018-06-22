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
<p>On a ajouté dans BD le <span class="badge"> ${count }</span> utilisateurs</p>
<ul>
    <g:each in="${userList}">
        <li><samp>${it.nom} |</samp><samp>${it.prenom} |</samp><samp>${it.email} </samp></li>
    </g:each>
</ul>

</body>