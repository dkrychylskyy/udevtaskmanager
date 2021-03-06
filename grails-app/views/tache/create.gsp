<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'tache.label', default: 'Tache')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#create-tache" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/tache/index')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
    <g:if test="${session.user}">
        <div class="nav" role="navigation">
            <ul>

                <li>Login as : ${session.user.prenom} | <g:link controller="connexion" action="logout">Logout</g:link></li>
            </ul>
        </div>
    </g:if>
        <div id="create-tache" class="content scaffold-create" role="main">
            <h1><g:message code="default.create.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${this.tache}">
            <ul class="errors" role="alert">
                <g:eachError bean="${this.tache}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                </g:eachError>
            </ul>
            </g:hasErrors>
            <g:form resource="${this.tache}" method="POST">
                <fieldset class="form">
                    <f:field property="titre" bean="tache"/>
                    <div id="dateDebut">
                        <f:field property="dateDebut" bean="tache"/>
                    </div>
                    <div id="dateFin">
                        <f:field property="dateFin" bean="tache"/>
                    </div>
                    <f:field property="duree" bean="tache" value="" required="false" label="Duree jour(s)"/>
                    <p class="bg-danger" hidden id="errorDuree"><g:message code="error.duree"/></p>

                    <f:field property="desc" bean="tache" required="false"/>
                </fieldset>
                <fieldset class="buttons">
                    <g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
