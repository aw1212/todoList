<!DOCTYPE html>
<html>
<span id="color_strip_horizontal"></span>
<span id="color_strip_vertical"></span>
    <head>
        <link rel="stylesheet" type="text/css" href="css/main.css"></link>
        <title>Alex's To Do List</title>
    </head>
<body bgcolor="#E6E6FA">
    <h1>TO DO LIST</h1> <br/> <br/>
    <form action="/addItem" method="POST">
        <#if errorMessage??> </br>
            <font color="red" id="error_text"><i>${errorMessage}</i></font> </br>
        </#if>
<div id="colorstrip">
<div id="item_text">Item:</div>
    <textarea id="item_box" name="item"></textarea> <br/>
<div id="date_text">Due Date:</div>
    <textarea id="date_box" name="date" placeholder="DD/MM/YYYY"></textarea> <br/>
<div id ="priority_text">Priority:</div>
    <select id="priority_box" name="priority">
        <option value="HIGH">high</option>
        <option value="MEDIUM">medium</option>
        <option value="LOW">low</option>
    </select> <br/> </br>
<input type="submit" value="Enter" id="enter_button">
</form>
<form action="/refresh" method="POST">
<input type="submit" value="Clear" id="clear_button">
</form> <br/><br/><br/>
<form action="/remove" method="POST" id="list_items">
<h3>My List:</h3>
<#if !listy?has_content> 
<font color=#000066>You have no tasks to do!</font>
</#if>
<#if listy??>
    <ul>
        <#list listy?keys as key>
            <#if !listy?values[key_index].done>
                <input type="checkbox" name="listItem" value="${key}">
                <#assign date = listy?values[key_index].dueDate?date>
                <#if listy?values[key_index].priority == "HIGH">
                    ${listy?values[key_index].description} (${date} <font color="red">${listy?values[key_index].priority}</font>) </br>
                <#elseif listy?values[key_index].priority == "MEDIUM">
                    ${listy?values[key_index].description} (${date} <font color="orange">${listy?values[key_index].priority}</font>) </br>
                <#elseif listy?values[key_index].priority == "LOW">
                    ${listy?values[key_index].description} (${date} <font color="blue">${listy?values[key_index].priority}</font>) </br>
                </#if>
            </#if> 
        </#list>
    </ul>
<h4>Done:</h4>
    <ul>
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
</div>
</html>