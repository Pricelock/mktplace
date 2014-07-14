<%@ include file="/WEB-INF/jsp/include.jsp" %>

<html>
  <head><title><fmt:message key="title"/></title></head>
  <body>
    <h1><fmt:message key="heading"/></h1>
    <p><fmt:message key="greeting"/> <c:out value="${model.now}"/></p>
    <h3>Users</h3>
    <c:forEach items="${model.users}" var="user">
      <c:out value="${user.firstName} ${user.lastName}"/> <i>Age : <c:out value="${user.age}"/></i><br><br>
    </c:forEach>
  </body>
</html>