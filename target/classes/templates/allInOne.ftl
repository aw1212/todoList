<!DOCTYPE html>
<html>
<head>
<title>Alex's To Do List</title>
</head>
<#if errorMessage??>
</br>
<font color="red" size="10">${errorMessage}</font>
</br>
</#if>
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
<form action="/remove" method="POST">
<#if listy??>
<#list listy as item>
<input type="checkbox" name="listItem" value="${item}">${item}</br>
</#list>
</#if>
<input type="submit" value="Remove">
<input type="submit" formaction="/done" method="POST" value="Done">
<#if doneList??>
<#list doneList as doneItem>
<del>${doneItem}</del>
</#list>
</#if>
</form>
</body>
</html>