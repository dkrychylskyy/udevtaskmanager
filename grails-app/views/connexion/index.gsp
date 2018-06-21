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

</body>
</html>