<%@ page import="java.util.stream.IntStream" %>
<%@page contentType="text/html" pageEncoding="UTF-8" session="false" %>
<!doctype html>
<html lang="en">
<head>
    <title>Piranha Nano - Servlet test</title>
</head>

<body>
<h1>Hello, Piranha!</h1>
<h2><%= request.getRequestURI() %>
</h2>
<%
    var foo = 10;
    var bar = 5;
    var textBlock =
            """
            Text blocks in JSP!
            """;
%>
<p><%=foo%> + <%=bar%> == <%= IntStream.of(foo, bar).sum() %>
</p>
<p><%=textBlock%>
</p>
</body>
</html>
