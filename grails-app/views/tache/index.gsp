<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'tache.label', default: 'Tache')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>

        <a href="#list-tache" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/tache/index')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>

            </ul>
        </div>
    <g:if test="${session.user}">
    <div class="nav" role="navigation">
        <ul>

                <li>Login as : ${session.user.prenom} | <g:link controller="connexion" action="logout">Logout</g:link></li>
        </ul>
    </div>
    </g:if>

        <div id="list-tache" class="content scaffold-list" role="main">

            <h1><g:message code="default.list.label" args="[entityName]" /></h1>

            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>



            <table class="table">

                <thead>

                <tr>
                    <th scope="col">LABEL</th>
                    <th scope="col">TITRE</th>
                    <th scope="col">DESC</th>
                    <th scope="col">CREATION</th>
                    <th scope="col">DEBUT</th>
                    <th scope="col">FIN</th>
                    <th scope="col">STATUT</th>
                    <th scope="col">EDIT</th>
                </tr>

                </thead>
                <%--<g:if test="${flash.listDeTache}">--%>

                    <tbody>
                        <g:render template="tacheListeTemplate" collection="${flash.listDeTache}"/>
                    </tbody>
                <%--</g:if>--%>
            </table>

            <br>
            <br>
            <p>-------------------------------------------------------------------------------</p>
            <br>
            <br>
            <div style="display: inline-block; margin: 5px; padding: 5px; width: 100%">
            <g:render template="taskListTemplate" collection="${flash.listDeTache}"/>
            </div>
            <div class="pagination">
                <g:paginate total="${tacheCount ?: 0}" />
            </div>
        </div>
    </body>
</html>