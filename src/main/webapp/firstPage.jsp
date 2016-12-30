<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
     <h1>First JSP - Hello!</h1>

     <form action="/first" method="post">
         <input name="login" type="text" value="${login}"/>
         <input name="password" type="password" value="${password}"/>
         <input name="go" type="submit" value="Подключиться к БД /FIRST" />
     </form>

</body>
</html>
