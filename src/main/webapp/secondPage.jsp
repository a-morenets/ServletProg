<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>
    <h2>Second JSP - Hello!</h2>

    <h3>Параметры подключения к БД</h3>
    <p>Login: ${login}</p>
    <p>Connection opened: ${isOpened}</p>

    <form action="./second" method="post">
        <p><select size="10" name="address_id">
            <option value="${address_id}" selected>${address_id} Выберите адрес...</option>
            <c:forEach items="${addresses}" var="address">
                <option value="${address.address_id}">${address.address_id} ${address.city} ${address.street} ${address.building}</option>
            </c:forEach>
        </select></p>
        <p><input name="go" type="submit" value="Список прописанных по этому адресу /SECOND" /></p>
    </form>

    <table>
        <tr>
            <th>Фамилия<th>
            <th>Имя<th>
            <th>Зарплата<th>
            <th>user_address_id<th>
        </tr>
        <c:forEach items="${users}" var="user">
            <tr>
                <td><c:out value="${user.secondName}"/><td>
                <td><c:out value="${user.firstName}"/><td>
                <td><c:out value="${user.salary}"/><td>
                <td><c:out value="${user.user_address_id}"/><td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>
