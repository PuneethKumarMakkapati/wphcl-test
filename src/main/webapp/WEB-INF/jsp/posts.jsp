<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <body>
    <h1>Posts</h1>
        <table>
            <thead>
                <tr>
                    <th>Id</th>
                    <th>UserId</th>
                    <th>Title</th>
                    <th>Comments</th>
                    <th>Body</th>
                    
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${posts}" var="post">
                    <tr>
                        <td>${post.id}</td>
                        <td>${post.userId}</td>
                        <td>${post.title}</td>
                        <td><a href="/comments?postId=${post.id}">Click here</a></td>
                        <td>${post.body}</td>
                        
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>