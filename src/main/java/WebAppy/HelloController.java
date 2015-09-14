package WebAppy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
        
    @Autowired
    private ToDoMap toDoMap;
     
    @RequestMapping("/TextBox")
    public String index(ModelMap model) {
        model.addAttribute("listy",toDoMap.getMap());
        return "toDoListView";
    }
    
}
    
    
    /*
    <#if listy??>
<#assign m = listy>
<#assign values = m?values>      
<#assign keys = m?keys>
<ul>
    <#list values as ToDoItem>
    <#list keys as key>
    <input type="checkbox" name="listItem" value="${key}"> ${key} = ${ToDoItem.description} <font color="blue">${ToDoItem.priority}</font>
    </br>
    </#list>
    </#list>
</ul>
</#if> */
    

   /* <#if listy??>
    <#list listy?keys as key> 
    <input type="checkbox" name="listItem" value="${key}">${key} = ${listy[key]}</br>
    </#list>
    </#if> 
    
    <#if listy??>
    <#list listy?keys as key> 
    ${key} = ${listy[key].description}
    </#list>
    </#if> */
    
    //<#if listy??>
    //<#list listy as item> 
    //<input type="checkbox" name="listItem" value="${item}">${item.description} <font color="blue">${item.priority}</font>
    //</br>
    //</#list>
    //</#if>

    
    /*@RequestMapping("/TextBox")
    public String index(ModelMap model) throws FileNotFoundException {
        model.addAttribute("listy", toDoList.getList());
        return "allInOne";
    }*/
    
    //for (todolist[0] -> todolist.length()-1) 
    //map key = ith index
