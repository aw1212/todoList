package WebAppy;

import java.io.FileNotFoundException;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
    
    private final String path = "/Users/techsupport/Downloads/ToDoList/src/main/java/WebAppy/listHistory.txt";
    private final StoredList sl = new StoredList(path);

    @RequestMapping("/TextBox")
    public String index(ModelMap model) throws FileNotFoundException {
        List<String> todo = ItemList.getList();
        sl.readFile(todo);
        model.addAttribute("listy", todo);
        return "allInOne";
    }

}