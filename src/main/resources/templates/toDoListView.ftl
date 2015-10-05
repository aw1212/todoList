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
            <div class="header">
                <h1><span class="glyphicon glyphicon-piggy-bank reverse"></span>
                <font class="name"> TO DO LIST </font>
                <span class="glyphicon glyphicon-piggy-bank"></span></h1>
            </div>
            <form action="/addItem" method="POST">
                <div class="form-group error">
                    <#if errorMessage??>
                        ${errorMessage}
                    </#if>
                </div>
                <div class="form-group add-item">
                    <font>Item:</font>
                    <textarea name="item" class="form-control"></textarea>
                </div>
                <div class="form-group add-date">
                    <font>Due Date:</font>
                    <textarea name="date" placeholder="DD/MM/YYYY" class="form-control"></textarea>
                </div>
                <div class="form-group add-priority">
                    <font>Priority:</font>
                    <select name="priority" class="form-control">
                        <option value="HIGH">high</option>
                        <option value="MEDIUM">medium</option>
                        <option value="LOW">low</option>
                    </select> 
                </div>
                <div class="form-group enter-button">
                    <input type="submit" value="Enter" class="btn btn-primary btn-block">
                </div>
            </form>
            <form action="/remove" method="POST">
                <div class="form-group list">
                    <font>My List:</font>
                    <#if !listy?has_content>
                        <font id="no-tasks">You have no tasks to do!</font>
                    <#else>
                        <ul>
                            <table class="table table-bordered">
                                <thead>
                                    <tr> <th></th>
                                    <th>Item</th>
                                    <th>Due date</th>
                                    <th>Priority</th></tr>
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
                                                <td class="desc">${description}<td class="date">${date}<td class="prio"><span class="glyphicon glyphicon-asterisk red"></span>
                                            <#elseif priority == "MEDIUM">
                                                <td class="desc">${description}<td width="date">${date}<td class="prio"><span class="glyphicon glyphicon-asterisk orange"></span>
                                            <#elseif priority == "LOW">
                                                <td class="desc">${description}<td width="date">${date}<td class="prio"><span class="glyphicon glyphicon-asterisk blue"></span>
                                            </#if>
                                        </tbody>
                                    </#if> 
                                </#list>
                            </table>
                        </ul>
                        <div class="done">
                            <font>Done:</font>
                            <ul>
                                <#list listy?keys as key>
                                    <#if listy?values[key_index].done>
                                        <input type="checkbox" name="listItem" value="${key}">
                                        <del>${listy?values[key_index].description}</del> <span class="glyphicon glyphicon-ok"></span>
                                        </br>
                                    </#if> 
                                </#list>
                            </ul>
                        </div>
                    </#if>
                </div>
                <div class="form-group remove-button">
                    <input type="submit" value="Remove" class="btn btn-block remove">
                </div>
                <div class="form-group done-button">
                    <input type="submit" formaction="/done" method="POST" value="Done" class="btn btn-block done">
                </div>
                <div class="form-group clear-button">
                    <input type="submit" formaction="/clear" method="POST" value="Clear" class="btn btn-block clear">
                </div>
            </form>
        </div>
    </body>
</html>