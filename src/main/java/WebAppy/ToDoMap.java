package WebAppy;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class ToDoMap {
    
    private Map<Integer,ToDoItem> toDoMap = new LinkedHashMap<>();
    private int counter;
        
    public void addItemToMap(String item, Date date, Enum priority) {
        ToDoItem toDoItem = new ToDoItem();
        toDoItem.setDescription(item);
        toDoItem.setDueDate(date);
        toDoItem.setPriority(priority);
        toDoMap.put(counter, toDoItem);
        counter++;
    }
        
    public Map<Integer, ToDoItem> getMap() {
        return toDoMap;
    }
    
    public void clearMap() {
        toDoMap.clear();
    }
    
    public void removeItemFromMap(int index) {
        toDoMap.remove(index);
    }
    
    public void markItemAsDone(int index) {
        toDoMap.get(index).setDone(true);
    }
    
}
