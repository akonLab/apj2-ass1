<%--
  Created by IntelliJ IDEA.
  User: adaada
  Date: 12/27/20
  Time: 20:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="lib/header.jsp"%>

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
            <li>Name</li>
            <li>Name</li>
            <li>Name</li>
            <li>Name</li>
            <li>Name</li>
        </ul>

        <a class="btn mx-auto">
            run
        </a>
    </div>

    <div id="task2">
        <div class="mx-auto mb-3">

            <form action="" method="GET">

                <div class="user-box mx-auto d-flex justify-content-center">
                    <input placeholder="Books" type="text" name="book" required="">
                    <a onclick="searchUser()">
                        <i class='fas fa-search'></i>
                    </a>
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
            <c:if test="${all!=null}">
                <c:forEach items="${all}" var="book">
                    <tr>
                        <td>
                            file name
                        </td>
                        <td>
                            count
                        </td>
                    </tr>
                    <tr>
                        <td>
                            file name
                        </td>
                        <td>
                            count
                        </td>
                    </tr>
                    <tr>
                        <td>
                            file name
                        </td>
                        <td>
                            count
                        </td>
                    </tr>
                </c:forEach>
            </c:if>
            </tbody>

        </table>
    </div>

</div>
<%@include file="lib/footer.jsp"%>