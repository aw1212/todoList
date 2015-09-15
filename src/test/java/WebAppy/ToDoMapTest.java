package WebAppy;

import java.util.Date;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class ToDoMapTest {
    
    @Mock
    private ToDoItem toDoItem = new ToDoItem();
    
    @InjectMocks
    private ToDoMap toDoMap = new ToDoMap();
    
    @Test
    public void whenItemIsAddedToMap_givenCounterIsZero_thenCounterIsIncremented() {
        toDoMap.addItemToMap("test", new Date(01/01/2012), Priority.HIGH);
        assertEquals(1,toDoMap.getCounter());
    }
    
    @Test
    public void whenItemIsAddedToMap_givenEmptyMap_thenMapSizeIsOne() {
        toDoMap.addItemToMap("test", new Date(01/01/2012), Priority.HIGH);
        assertEquals(1,toDoMap.getMap().size());
    }
    
    @Test
    public void whenItemIsAddedToMap_givenEmptyMap_thenToDoItemDescriptionIsSet() {
        String desc = "test";
        toDoMap.addItemToMap(desc, new Date(01/01/2012), Priority.HIGH);
        assertEquals(desc,toDoMap.getMap().get(0).getDescription());
    }
    
    @Test
    public void whenItemIsAddedToMap_givenEmptyMap_thenToDoItemDueDateIsSet() {
        Date date = new Date(01/01/2012);
        toDoMap.addItemToMap("test", date, Priority.HIGH);
        assertEquals(date,toDoMap.getMap().get(0).getDueDate());
    }
    
    @Test
    public void whenItemIsAddedToMap_givenEmptyMap_thenToDoItemPriorityIsSet() {
        Enum priority = Priority.HIGH;
        toDoMap.addItemToMap("test", new Date(01/01/2012), priority);
        assertEquals(priority,toDoMap.getMap().get(0).getPriority());
    }
    
    @Test
    public void whenMapIsCleared_givenNonEmptyMap_thenMapSizeIsZero() {
        
        toDoMap.addItemToMap("test", new Date(01/01/2012), Priority.HIGH);
        int sizeBefore = toDoMap.getMap().size();
        toDoMap.clearMap();
        int sizeAfter = toDoMap.getMap().size();
        
        assertEquals(1,sizeBefore);
        assertEquals(0,sizeAfter);
    }
}
