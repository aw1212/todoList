<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Alex's To Do List</title>
        <meta charset="utf-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
        <link rel="stylesheet" type="text/css" href="css/main.css"></link>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <h1><span class="glyphicon glyphicon-piggy-bank reverse"></span> TO DO LIST <span class="glyphicon glyphicon-piggy-bank"></span></h1>
            </div>
            <form action="/addItem" method="POST">
                <div class="form-group error">
                    <#if errorMessage??>
                        ${errorMessage}
                    </#if>
                </div>
                <div class="form-group">
                    <label>Item:</label>
                    <textarea name="item" class="form-control"></textarea>
                </div>
                <div class="form-group">
                    <label>Due Date:</label>
                    <textarea name="date" placeholder="DD/MM/YYYY" class="form-control"></textarea>
                </div>
                <div class="form-group">
                    <label>Priority:</label>
                    <select name="priority" class="form-control">
                        <option value="HIGH">high</option>
                        <option value="MEDIUM">medium</option>
                        <option value="LOW">low</option>
                    </select> 
                </div>
                <div class="form-group">
                    <input type="submit" value="Enter" class="btn btn-primary btn-block">
                </div>
            </form>
            <form action="/remove" method="POST">
                <label>My List:</label>
                <#if !listy?has_content>
                    <font color=#000066>You have no tasks to do!</font>
                <#else>
                    <ul>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th></th>
                                <th>Item</th>
                                <th>Due date</th>
                                <th>Priority</th>
                            </tr>
                        </thead>
                        <#list listy?keys as key>
                            <#if !listy?values[key_index].done>
                                    <tbody>
                                        <tr><td id="checkbox_column" width="40">
                                            <input type="checkbox" name="listItem" value="${key}">
                                        <#assign date = listy?values[key_index].dueDate?date>
                                        <#assign description = listy?values[key_index].description> 
                                        <#assign priority = listy?values[key_index].priority>
                                        <#if priority == "HIGH">
                                            <td width="150">${description} <td width="80">${date} <td width="50"><span class="glyphicon glyphicon-asterisk red"></span>
                                        <#elseif priority == "MEDIUM">
                                            <td width="150">${description} <td width="80">${date} <td width="50"><span class="glyphicon glyphicon-asterisk orange"></span>
                                        <#elseif priority == "LOW">
                                            <td width="150">${description} <td width="80">${date} <td width="50"><span class="glyphicon glyphicon-asterisk blue"></span>
                                        </#if>
                                    </tbody>
                            </#if> 
                        </#list>
                    </table>
                    </ul>
                    <label>Done:</label>
                    <ul>
                        <#list listy?keys as key>
                            <#if listy?values[key_index].done>
                                <input type="checkbox" name="listItem" value="${key}">
                                <del>${listy?values[key_index].description}</del> <span class="glyphicon glyphicon-ok"></span>
                                </br>
                            </#if> 
                        </#list>
                    </ul>
                </#if>
                <div class="form-group">
                    <input type="submit" value="Remove" class="btn btn-block">
                </div>
                <div class="form-group">
                    <input type="submit" formaction="/done" method="POST" value="Done" class="btn btn-block">
                </div>
                <div class="form-group">
                    <input type="submit" formaction="/refresh" method="POST" value="Clear" class="btn btn-block">
                </div>
            </form>
        </div>
    </body>
</html>