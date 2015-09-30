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
    <body bgcolor="#E6E6FA">
        <div class="container">
            <div class="row">
                <h1 align="center"><span class="glyphicon glyphicon-piggy-bank reverse" style="font-size:1.5em;color:pink"></span> TO DO LIST <span class="glyphicon glyphicon-piggy-bank" style="font-size:1.5em;color:pink"></span></h1>
            </div>
            <form action="/addItem" method="POST">
                <div class="form-group">
                    <#if errorMessage??>
                        <font color="red" id="error_text"><i>${errorMessage}</i></font>
                    </#if>
                </div>
                <div class="form-group">
                    <label>Item:</label>
                    <textarea id="item_box" name="item" class="form-control"></textarea>
                </div>
                <div class="form-group">
                    <label>Due Date:</label>
                    <textarea id="date_box" name="date" placeholder="DD/MM/YYYY" class="form-control"></textarea>
                </div>
                <div class="form-group">
                    <label>Priority:</label>
                    <select id="priority_box" name="priority" class="form-control">
                        <option value="HIGH">high</option>
                        <option value="MEDIUM">medium</option>
                        <option value="LOW">low</option>
                    </select> 
                </div>
                <div class="form-group">
                    <input type="submit" value="Enter" id="enter_button" class="btn btn-primary btn-block">
                </div>
            </form>
            <form action="/remove" method="POST" id="list_items">
                <div class="form-group">
                    <label>My List:</label>
                    <#if !listy?has_content>
                        <font color=#000066>You have no tasks to do!</font>
                    </#if>
                    <#if listy??>
                        <ul>
                            <#list listy?keys as key>
                                <#if !listy?values[key_index].done>
                                     <table class="table table-bordered" width="100%">
                                        <thead>
                                            <tr>
                                                <th></th>
                                                <th>Item</th>
                                                <th>Due date</th>
                                                <th>Priority</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td id="checkbox_column" width="40">
                                                    <input type="checkbox" name="listItem" value="${key}">
                                                </td>
                                                <#assign date = listy?values[key_index].dueDate?date>
                                                <#if listy?values[key_index].priority == "HIGH">
                                                    <td id="item_column" width="150">${listy?values[key_index].description}</td> <td id="date_column" width="80">${date}</td> <td id="priority_column" width="50"><span class="glyphicon glyphicon-asterisk" style="color:red"></span></td>
                                                <#elseif listy?values[key_index].priority == "MEDIUM">
                                                    <td id="item_column" width="150">${listy?values[key_index].description}</td> <td id="date_column" width="80">${date}</td> <td id="priority_column" width="50"><span class="glyphicon glyphicon-asterisk" style="color:orange"></span></td>
                                                <#elseif listy?values[key_index].priority == "LOW">
                                                    <td id="item_column" width="150">${listy?values[key_index].description}</td> <td id="date_column" width="80">${date}</td> <td id="priority_column" width="50"><span class="glyphicon glyphicon-asterisk" style="color:blue"></span></td>
                                                </#if>
                                            </tr>
                                        </tbody>
                                    </table>
                                </#if> 
                            </#list>
                        </ul>
                        <label>Done:</label>
                        <ul>
                            <#list listy?keys as key>
                                <#if listy?values[key_index].done>
                                    <input type="checkbox" name="listItem" value="${key}">
                                    <del>${listy?values[key_index].description}<del> </br>
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
                        <input type="submit" formaction="/refresh" method="POST" value="Clear" id="clear_button" class="btn btn-block">
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>