package WebAppy;

import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import org.springframework.stereotype.Component;

@Component
public class ToDoMap {
    
    private Map<Integer,ToDoItem> toDoMap = new LinkedHashMap<>();
    private Set<Integer> generated = new HashSet<>();
        
    public void addItemToMap(String item, Date date, Enum priority) {
        ToDoItem toDoItem = new ToDoItem();
        toDoItem.setDescription(item);
        toDoItem.setDueDate(date);
        toDoItem.setPriority(priority);
        toDoMap.put(generateRandomNumber(), toDoItem);
    }
    
    private int generateRandomNumber() {
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(5);
        System.out.println(randomInt);
        if (generated.contains(randomInt)) {
            generateRandomNumber();
        }
        generated.add(randomInt);
        return randomInt;
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
    
}
