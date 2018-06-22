<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Form</title>
</head>
<body>

<g:form controller="connexion" action="login">
    <label>Email: </label>
    <g:textField name="email"/><br/>
    <label>mdp: </label>
    <g:textField name="mdp"/><br/>
    <g:actionSubmit value="login"/>

</g:form>
${flash.message}

<g:form controller="user" action="creerUtilisateurs">
    <g:actionSubmit value="creerUtilisateurs"/>
</g:form>

<a class="home" href="${createLink(uri: '/user/create')}"><g:message code="default.create.label"/></a>
</body>
</html>