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
