<!DOCTYPE html>
<html>
<head>
<title>Text Input Control</title>
</head>
<body>
<form action="TextBox" method="POST">
List :  <br/>
<textarea rows="5" cols="50" name="list">
</textarea>
<br/>
<input type="submit" value="Enter" />
</form>
<br/>
<img src="http://www.cacklehatchery.com/images/white_silkie_hen2.jpg" style="float:right" alt="Mountain View">
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