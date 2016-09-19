<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>todoList</title>
</head>
<body>

<form method="post" action="todoList">
    <table border="1">
        <tr bgcolor="#5f9ea0">
            <th width="200px">Task Name</th>
            <th width="400px">Task Description</th>
            <th>Task Executed</th>
            <th>Task Delete</th>
        </tr>

        <c:forEach items="${taskList}" var="task">
            <tr>
                <td>${task.taskName}</td>
                <td>${task.description}</td>
                <td><input type="checkbox" name="complete" value="${task.taskName}" <c:if test="${task.complete == true}"> checked="checked" </c:if></td>
                <td><button role="button" name="delete" value="${task.taskName}">Delete</button></td>
            </tr>
        </c:forEach>

    </table>

    <br/>
    <input type="submit" value="Update task list" name="update">
    <hr/><br/>

    <label for="taskName">Task Name</label>
    <input type="text" name="taskName" id="taskName">

    <label for="taskDescription">Task Description</label>
    <input type="text" name="taskDescription" id="taskDescription">

    <input type="submit" value="Submit" name="submit">

</form>
</body>
</html>
