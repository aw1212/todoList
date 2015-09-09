package WebAppy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.io.IOException;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;

@Controller
public class Enter {

    @Autowired
    private ToDoList toDoList;
    
    @Autowired
    private DoneList doneList;
    
    @RequestMapping(value = "/addItem", method = RequestMethod.POST)
    public String getList(@RequestParam String item) throws IOException {
        if (!item.trim().isEmpty() && !toDoList.getList().contains(item)) {
            toDoList.writeItemsToFile(item);
            return "forward:/TextBox";
        }
        else { 
            return "forward:/errorMessage";
        }
    }
    
    @RequestMapping(value = "/refresh", method = RequestMethod.POST)
    public String wipeList() throws IOException {
        toDoList.deleteItemsFromFileAndList();
        return "forward:/TextBox";
    }
    
    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public String removeItem(@RequestParam("listItem") ArrayList<String> listItems) throws IOException {
        for (String listItem : listItems) {
            toDoList.deleteSingleItemFromFileAndList(listItem);
        }
        return "forward:/TextBox";
    }
    
    @RequestMapping(value = "/errorMessage", method = RequestMethod.POST)
    public String displayErrorMessage(ModelMap model) {
        ErrorMessage e = new ErrorMessage("Please enter a unique, non-empty value");
        model.addAttribute("errorMessage", e.getMessage());
        return "forward:/TextBox";
    }

    @RequestMapping(value = "/done", method = RequestMethod.POST)
    public String markAsDone(@RequestParam("listItem") ArrayList<String> doneItems, ModelMap model) throws IOException {
        for (String doneItem : doneItems) {
            doneList.addItemToDoneListAndFile(doneItem);
            toDoList.deleteSingleItemFromFileAndList(doneItem);
            model.addAttribute("doneList", doneList.getList());
        }
        return "forward:/TextBox";
    }

}