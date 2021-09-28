<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>

<% String logged = (String)session.getAttribute("logged"); %>

<% if (logged == null || "".equals(logged)) { %>
<form action="${pageContext.request.contextPath}/login" method="post" align="center">
    <h1 style="font-family: Bahnschrift,sans-serif">Enter login:</h1>
    <input type="text" name="login"><br>
    <h1 style="font-family: Bahnschrift,sans-serif">Enter password: </h1>
    <input type="password" name="password"><br><br>
    <input type="submit" value="LOGIN" style="font-family: 'Bahnschrift', serif; color: indianred">
</form>
<% } else if (logged.equals("true")){ %>
<form action="${pageContext.request.contextPath}/send" method="post" align="center">
    <h1>Fill the form:</h1>
    <p><b>What is your age?</b></p>
    <p><input name="age" type="radio" value="<20"> <20</p>
    <p><input name="age" type="radio" value="20-30"> 20-30</p>
    <p><input name="age" type="radio" value=">30"> >30</p>

    <p><b>What is your coding experience?</b></p>
    <p><input name="position" type="radio" value="Junior"> Junior</p>
    <p><input name="position" type="radio" value="Middle"> Middle</p>
    <p><input name="position" type="radio" value="Senior"> Senior</p>

    <p><b>Which language do you prefer to code in?</b></p>
    <p><input name="language" type="radio" value="C++"> C++</p>
    <p><input name="language" type="radio" value="Python"> Python</p>
    <p><input name="language" type="radio" value="Java"> Java</p>
    <input type="submit" value="send">
</form>
<br><br><br>
<form action="${pageContext.request.contextPath}/login" method="get" align="center">
    <input type="submit" value="EXIT">
</form>
<% } else { %>
<h1 style="color: red">TRY ONE MORE TIME!</h1>
<form action="${pageContext.request.contextPath}/login" method="post" align="center">
    <h1>Enter login:</h1>
    <input type="text" name="login"><br>
    <h1>Enter password: </h1>
    <input type="password" name="password"><br><br>
    <input type="submit" value="LOGIN">
</form>
<br><br><br>
<form action="${pageContext.request.contextPath}/login" method="get" align="center">
    <input type="submit" value="EXIT">
</form>
<% } %>

</body>
</html>