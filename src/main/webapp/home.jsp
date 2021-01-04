<%@ page import="java.io.File" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="lib/header.jsp" %>

<div class="box mx-auto my-5">
    <h3 class="text-center">Happy New Year</h3>

    <div class="col d-flex mb-5">
        <a class="btn mx-auto" onclick="btn(task1)">
            Task 1
        </a><br>
        <a class="btn mx-auto" onclick="btn(task2)">
            Task 2
        </a>
    </div>

    <div id="task1">

        <h4 class="text-center">Folder File List:</h4>
        <ul class="mx-auto">

            <c:forEach items="${folder1}" var="file">
                <li>${file}</li>
                <li><c:out value="${file}"/></li>
            </c:forEach>
            <>
            <li>AKon</li>
            <li>aray</li>
            <li>n</li>
            <%
                String str="";
                File folder2 = new File("src/main/filesForTask2");
                for (File file : folder2.listFiles()) {
            %>
            <%str=file.getName();%>
            <%=str%>
            <%
                }
            %>

            <li>Name</li>
            <li><%="file.getName()"%>
            </li>

        </ul>

        <a class="btn mx-auto">
            run
        </a>
    </div>

    <div id="task2">
        <div class="mx-auto mb-3">

            <form action="${pageContext.request.contextPath}/serv1?action=search" method="GET">

                <div class="user-box mx-auto d-flex justify-content-center">
                    <input type="text" name="input">
                    <input type="submit">
                </div>

            </form>

        </div>

        <h4 class="text-center">Folder File List:</h4>
        <table class="mx-auto">
            <thead>
            <tr>
                <th style="width: 95%;">Name</th>
                <th style="width: 5%;">Count</th>
            </tr>
            </thead>

            <tbody>
            <c:forEach items="${folder2}" var="file">
                <tr>
                    <td>
                            ${file}
                    </td>
                    <td>
                        count
                    </td>
                </tr>
            </c:forEach>
            <c:forEach items="${folder2}" var="file">
                <tr>
                    <td>
                            ${file}
                    </td>
                    <td>
                        count
                    </td>
                </tr>
            </c:forEach>
            </tbody>

        </table>
    </div>

</div>
<%@include file="lib/footer.jsp" %>