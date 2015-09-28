<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/main.css"></link>
        <title>Alex's To Do List</title>
    </head>
<body bgcolor="#E6E6FA">
<form action="/addItem" method="POST">
<span id="title"><center><b><font size=6>TO DO LIST</font></b></center></span> <br/> <br/>
    <#if errorMessage??> </br>
        <font color="red"><i>${errorMessage}</i></font> </br>
    </#if>
Item:
<textarea rows="1" cols="30" name="item"></textarea> <br/>
Due Date:
<textarea rows="1" cols="15" name="date" placeholder="DD/MM/YYYY"></textarea> <br/>
Priority:
<select name="priority">
  <option value="HIGH">high</option>
  <option value="MEDIUM">medium</option>
  <option value="LOW">low</option>
</select> <br/> </br>
<input type="submit" value="Enter" />
</form>
<form action="/refresh" method="POST">
<input type="submit" value="Clear" style="background-color:#FF6666; color:"black";"/>
</form> <br/>
My List: <br/>
<form action="/remove" method="POST">
<#if !listy?has_content> </br>
<font color=#000066>You have no tasks to do!</font>
</#if>
<#if listy??>
    <ul>
        <#list listy?keys as key>
            <#if !listy?values[key_index].done>
                <input type="checkbox" name="listItem" value="${key}">
                <#assign date = listy?values[key_index].dueDate?date>
                <#if listy?values[key_index].priority == "HIGH">
                    ${listy?values[key_index].description} (${date} <font color="red">${listy?values[key_index].priority}</font> <img src="reddot.png" alt="red">) </br>
                <#elseif listy?values[key_index].priority == "MEDIUM">
                    ${listy?values[key_index].description} (${date} <font color="orange">${listy?values[key_index].priority}</font>) </br>
                <#elseif listy?values[key_index].priority == "LOW">
                    ${listy?values[key_index].description} (${date} <font color="blue">${listy?values[key_index].priority}</font>) </br>
                </#if>
            </#if> 
        </#list> </br>
Done: </br>
        <#list listy?keys as key>
            <#if listy?values[key_index].done>
                <input type="checkbox" name="listItem" value="${key}">
                <del>${listy?values[key_index].description}<del> </br>
            </#if> 
        </#list>
    </ul>
</#if>
<input type="submit" value="Remove">
<input type="submit" formaction="/done" method="POST" value="Done">
</form>
</body>
</html>