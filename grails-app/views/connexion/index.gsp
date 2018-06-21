<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Form</title>
</head>
<body>
<g:if test="${session.user}">
    <br>
    Login as : ${session.user.prenom} | <g:link action="logout">Logout</g:link>

</g:if>
<g:else>
<g:form controller="connexion" action="login">
    <label>Email: </label>
    <g:textField name="email"/><br/>
    <label>mdp: </label>
    <g:textField name="mdp"/><br/>
    <g:actionSubmit value="login"/>

</g:form>
</g:else>
${flash.message}

</body>
</html>