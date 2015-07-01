package WebAppy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class Enter {

    @Autowired
    private ToDoList toDoList;
    
    @RequestMapping(value = "/addItem", method = RequestMethod.POST)
    public String getList(@RequestParam String item) throws IOException { //if param name same as html name dont need value
        if (!item.trim().isEmpty() && !toDoList.getList().contains(item)) {
            toDoList.writeItemsToFile(item);
            return "forward:/TextBox";
        }
        else { 
            return "forward:/errorPage";
        }
    }
    
    @RequestMapping(value = "/errorPage", method = RequestMethod.GET)
    public String showError() {
        return "error";
    }
    
    @RequestMapping(value = "/refresh", method = RequestMethod.POST)
    public String wipeList() throws IOException {
        toDoList.deleteItemsFromFileAndList();
        return "forward:/TextBox";
    }

}
