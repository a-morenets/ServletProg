<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title></title>
</head>
<body>
    <h3>Users.jsp</h3>

    <table>
        <tr>
            <th>Фамилия<th>
            <th>Имя<th>
            <th>Зарплата<th>
        </tr>
        <c:forEach items="${users}" var="current">
            <tr>
                <td><c:out value="${current.secondName}"/><td>
                <td><c:out value="${current.firstName}"/><td>
                <td><c:out value="${current.salary}"/><td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
