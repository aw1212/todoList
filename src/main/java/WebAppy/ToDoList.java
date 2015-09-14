package WebAppy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ToDoList {
    
    private List<ToDoItem> toDoList = new ArrayList<>();
    
    public void addItemToList(String item, Date date, Enum priority) {
        ToDoItem toDoItem = new ToDoItem();
        toDoItem.setDescription(item);
        toDoItem.setDueDate(date);
        toDoItem.setPriority(priority);
        toDoList.add(toDoItem);
    }
    
    public void clearList() {
        toDoList.clear();
    }
    
    public List<ToDoItem> getToDoList() {
        return toDoList;
    }
    
    public void removeItemFromList(int index) {
        toDoList.remove(index);
    }
    
    public void removeItemFromList(ToDoItem hashcode) {
        toDoList.remove(hashcode);
    }
    
    /*private final String path = "/Users/techsupport/Downloads/ToDoList/src/main/java/WebAppy/listHistory.txt";
    private File file = new File(path);
    private List<String> list = new ArrayList<>();
    
    @PostConstruct
    private void readFileAtStartUp() throws IOException {
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while((line = br.readLine()) != null) 
                list.add(line);
        }
        catch (FileNotFoundException fnfe) {
            System.out.println(file + " not found");
        }
    }
            
    public void writeItemsToFile(String item) throws IOException {
        updateFile(true,item+"\n");
        list.add(item);
    }
    
    public void deleteItemsFromFileAndList() throws IOException {
        updateFile(false,"");
        list.clear();
    }
    
    private void updateFile(boolean append, String content) throws IOException {
        FileWriter fw = new FileWriter(file.getAbsoluteFile(),append);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(content);
        bw.close();    
    }
    
    public void deleteSingleItemFromFileAndList(String item) throws IOException {
        list.remove(item);
        removeItemFromFile(item);
    }
    
    private void removeItemFromFile(String item) throws IOException {
        File temp = File.createTempFile("fileT", ".txt", file.getParentFile());
        String delete = item;
        FileReader fr = new FileReader(file); 
        BufferedReader reader = new BufferedReader(fr);
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(temp)));
        for (String line; (line = reader.readLine()) != null;) {
            line = line.replace(delete, "");
            writer.println(line);
        }
        reader.close();
        writer.close();
        file.delete();
        temp.renameTo(file);
        updateFile(false,"");
        for (String li : list) {
            updateFile(true,li+"\n");
        }
    }
    
    public List<String> getList() throws FileNotFoundException {
        return list;
    }*/
    
    public List<ToDoItem> getList() {
        return toDoList;
    }

}
