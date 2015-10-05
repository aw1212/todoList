package WebAppy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Controller
public class Action {

    @Autowired
    private ToDoMap toDoMap;
    
    private ErrorMessage errorMessage;
    
    @RequestMapping(value = "/addItem", method = RequestMethod.POST)
    public String getList(@RequestParam String item, @RequestParam String date, @RequestParam Priority priority) throws IOException, ParseException {
        if (!item.trim().isEmpty() && !date.isEmpty()) {
            DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            Date dueDate = format.parse(date);
            toDoMap.addItemToMap(item,dueDate,priority); 
            return "forward:/TextBox";
        }
        else if (item.isEmpty() && date.isEmpty()) {
            errorMessage = new ErrorMessage("Please enter a non-empty value into Item and Due Date");
            return "forward:/errorMessage";
        }
        else if (item.isEmpty()) {
            errorMessage = new ErrorMessage("Please enter a non-empty value into Item");
            return "forward:/errorMessage";
        }
        else {
            errorMessage = new ErrorMessage("Please enter a non-empty value into Due Date");
            return "forward:/errorMessage";
        }
    }
    
    @ExceptionHandler(ParseException.class)
    public String handleParseException(ParseException ex) {
        errorMessage = new ErrorMessage("Please enter date as DD/MM/YYYY");
        return "forward:/errorMessage";
    }
       
    @RequestMapping(value = "/errorMessage", method = RequestMethod.POST)
    public String displayErrorMessage(ModelMap model) {
        model.addAttribute("errorMessage", errorMessage.getMessage());
        return "forward:/TextBox";
    }
    
    @RequestMapping(value = "/clear", method = RequestMethod.POST)
    public String wipeListAndMap() {
        toDoMap.clearMap();
        return "forward:/TextBox";
    }
      
    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public String removeItem(@RequestParam("listItem") ArrayList<String> indexes) throws IOException {
        for (String index : indexes) {
            System.out.println(index);
            int num = Integer.parseInt(index);
            toDoMap.removeItemFromMap(num);

        }
        return "forward:/TextBox";
    } 
 
    @RequestMapping(value = "/done", method = RequestMethod.POST)
    public String markAsDone(@RequestParam("listItem") ArrayList<String> indexes) throws IOException {
        for (String index : indexes) {
            System.out.println(index);
            int num = Integer.parseInt(index);
            toDoMap.markItemAsDone(num);

        }
        return "forward:/TextBox";
    } 
    
}