<%@ page language="java" session="true" %>
<%@ page import="javax.portlet.*" %>

<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c'%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix='c'%>

<portlet:defineObjects/>

<portlet:actionURL var="newRolesAction"/>
<br/>
<div class='portlet-section-header'>Services Tutorial Portlet</div>

<form name="servicesTutorialForm" action="<c:out value="${newRolesAction}"/>" method="post">
<input type="submit" name='action' value="createRoles" class="portlet-form-button" />
<input type="submit" name='action' value="createGroups" class="portlet-form-button" />
<input type="submit" name='action' value="registerUsers" class="portlet-form-button" />
<input type="submit" name='action' value="modifyPages" class="portlet-form-button" />
<input type="submit" name='action' value="createSharedPages" class="portlet-form-button" />
</form>
<c:if test="${message != null}">
<div class='portlet-msg-info'><c:out value="${message}"/></div>
</c:if>
<c:if test="${errorMessage != null}">
<div class='portlet-msg-error'><c:out value="${errorMessage}"/></div>
</c:if>