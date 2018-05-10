<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: norbiak
  Date: 10.05.18
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>
<%@include file="base/Header.jsp"%>


<div class="card mb-3">
    <div class="card-header">
        <i class="fa fa-table"></i> Data Table Example</div>
    <div class="card-body">
        <div class="table-responsive">
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                <thead>
                <tr>
                    <th>Title</th>
                    <th>Author(s)</th>
                    <th>Rating</th>
                    <th>Publisher</th>
                    <th>Description</th>
                    <th>Pages</th>
                </tr>
                </thead>
                <tfoot>
                <tr>
                    <th>Name</th>
                    <th>Author(s)</th>
                    <th>Rating</th>
                    <th>Publisher</th>
                    <th>Description</th>
                    <th>Pages</th>
                </tr>
                </tfoot>
                <tbody>
                    <c:forEach items="${books}" var="book">
                        <tr>
                            <td>${book.title}</td>
                            <td>
                                <c:forEach items="${book.authors}" var="author">
                                    <li>
                                        ${author.firstName} ${author.lastName}
                                    </li>
                                </c:forEach>
                            </td>
                            <td>${book.rating}</td>
                            <td>${book.publisher.name}</td>
                            <td>${book.description}</td>
                            <td>${book.pages}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
</div>


<%@include file="base/Footer.jsp"%>