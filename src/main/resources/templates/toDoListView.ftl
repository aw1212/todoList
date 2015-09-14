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
<textarea rows="1" cols="30" name="item"> </textarea>
<textarea rows="1" cols="10" name="date"> </textarea>
<select name="priority">
  <option value="HIGH">high</option>
  <option value="MEDIUM">medium</option>
  <option value="LOW">low</option>
</select>
<br/>
<input type="submit" value="Enter" />
</form>
<form action="/refresh" method="POST">
<input type="submit" value="Clear" />
</form>
<br/>
My List :  <br/>
<form action="/remove" method="POST">
<#if listy??>
<ul>
    <#list listy?keys as key>
    <input type="checkbox" name="listItem" value="${key}"> ${key}=${listy?values[key_index].description} <font color="blue">${listy?values[key_index].priority}</font>
    </br>
    </#list>
</ul>
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