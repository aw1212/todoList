package WebAppy;

import java.io.Serializable;
import java.util.Date;
import org.springframework.stereotype.Component;

@Component
public class ToDoItem implements Serializable {
    
    private String description;
    private boolean done;
    private Date dueDate;
    private Enum priority;
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public void setDone(boolean done) {
        this.done = done;
    }
    
    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
    
    public void setPriority(Enum priority) {
        this.priority = priority;
    }
    
    public String getDescription() {
        return description;
    }
    
    public boolean isDone() {
        return done;
    }
    
    public Date getDueDate() {
        return dueDate;
    }
    
    public Enum getPriority() {
        return priority;
    }
    
}
