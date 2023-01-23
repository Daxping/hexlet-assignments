<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- BEGIN -->
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Users</title>
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
                    rel="stylesheet"
                    integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
                    crossorigin="anonymous">
    </head>
    <body>
    <table>
            <tr>
            <td>${user.get("id")} ${user.get("firstName")} ${user.get("lastName")} ${user.get("email")}</td>
            </tr>
    </table>
    <form action="/users/delete?" method="get">

            <button type="submit" name="id" id="id" value="${user.get("id")}" class="btn btn-danger">Удалить</button>
        </form>
    </body>
</html>
<!-- END -->