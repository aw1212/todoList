package WebAppy;

import java.io.FileNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
    
    @Autowired
    private ToDoList toDoList;
    
    @Autowired
    private DoneList doneList;

    @RequestMapping("/TextBox")
    public String index(ModelMap model) throws FileNotFoundException {
        model.addAttribute("listy", toDoList.getList());
        return "allInOne";
    }

}