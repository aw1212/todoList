package WebAppy;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ToDoMap implements Serializable {
    
    @Autowired
    private ToDoItem toDoItem;
    
    private Map<Integer,ToDoItem> toDoMap = new LinkedHashMap<>();
    private int counter;
    
    @PostConstruct
    public void makeMap() {
        try {
            FileInputStream fileIn = new FileInputStream("/home/alessandra/NetBeansProjects/todoList/mappy.ser");
            //FileInputStream fileIn = new FileInputStream("/C:/Users/Alessandra/git/todoList/mappy.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            toDoMap = (Map) in.readObject();
            in.close();
            fileIn.close();
            getHighestIndex();
        }
        catch(IOException i) {
            System.out.println(i);
        }
        catch(ClassNotFoundException c) {
            System.out.println("ToDoMap class not found");
        }
    }
    
    private void getHighestIndex() {
        int highest = -1;
        for ( int key : toDoMap.keySet()) {
            if (key > highest) {
                highest = key;
            }
        }
        counter = ++highest;
        System.out.println("counter: " +counter);
    }
        
    public void addItemToMap(String item, Date date, Enum priority) {
        toDoItem = new ToDoItem();
        toDoItem.setDescription(item);
        toDoItem.setDueDate(date);
        toDoItem.setPriority(priority);
        toDoMap.put(counter, toDoItem);
        System.out.println(counter);
        counter++;
        saveState();
    }
    
    public void clearMap() {
        toDoMap.clear();
        saveState();
    }
    
    public void removeItemFromMap(int index) {
        toDoMap.remove(index);
        saveState();
    }
    
    public void markItemAsDone(int index) {
        toDoMap.get(index).setDone(true);
        saveState();
    }
    
    private void saveState() {
        try {
            FileOutputStream fileOut = new FileOutputStream("/home/alessandra/NetBeansProjects/todoList/mappy.ser");
            //FileOutputStream fileOut = new FileOutputStream("/C:/Users/Alessandra/git/todoList/mappy.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(toDoMap);
            out.close();
            fileOut.close();
        }
        catch(IOException i)
        {
            System.out.println(i);
        }
    }
    
    public Map<Integer, ToDoItem> getMap() {
        return toDoMap;
    }
    
    public int getCounter() {
        return counter;
    }
      
}
