<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <body>
    <h1>Comments</h1>
        <table>
            <thead>
                <tr>
                    <th>Id</th>
                    <th>PostId</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Body</th>
                    
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${comments}" var="comment">
                    <tr>
                        <td>${comment.id}</td>
                        <td>${comment.postId}</td>
                        <td>${comment.name}</td>
                        <td>${comment.email}</td>
                        <td>${comment.body}</td>
                        
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <h3><a href="/posts">Go back to Posts</a></h3>
    </body>
</html>