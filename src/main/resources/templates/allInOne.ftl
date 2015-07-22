<!DOCTYPE html>
<html>
<head>
<title>Alex's To Do List</title>
</head>
<body bgcolor="#E6E6FA">
<form action="/addItem" method="POST">
List :  <br/>
<textarea rows="5" cols="50" name="item">
</textarea>
<br/>
<input type="submit" value="Enter" />
</form>
<form action="/refresh" method="POST">
<input type="submit" value="Clear" />
</form>
<br/>
<img src="http://pixdaus.com/files/items/pics/5/38/557538_db299ee391c3b36d727cc20acfe60ec1_large.jpg" style="float:right" alt="Chicken">
My List :  <br/>
<ul type="circle">
<#if listy??>
<#list listy as thing>
<li>${thing}</li>
</#list>
</#if>
</ul>
</body>
</html>