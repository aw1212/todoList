package WebAppy;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.io.IOException;

@Controller
public class Enter {
    
    //private static final List<String> todo = new ArrayList<>(); 
    private final String path = "/Users/techsupport/Downloads/ToDoList/src/main/java/WebAppy/listHistory.txt";
    private final StoredList sl = new StoredList(path);
    
    @RequestMapping(value = "/TextBox", method = RequestMethod.POST)
    public String getList(@RequestParam String item, ModelMap model) throws IOException { //if param name same as html name dont need value
        List<String> todo = ItemList.getList();
        sl.readFile(todo);
        todo.add(item);
        sl.writeFile(item);
        model.addAttribute("listy", todo);
        return "allInOne";
    }
}
