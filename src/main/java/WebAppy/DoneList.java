package WebAppy;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class DoneList {
    
    private final String path = "/Users/techsupport/Downloads/ToDoList/src/main/java/WebAppy/DoneList.txt";
    private File file = new File(path);
    private List<String> list = new ArrayList<>();
    
    public void addItemToDoneListAndFile(String item) throws IOException {
        list.add(item);
        writeItemsToFile(item);
    }
    
    public void writeItemsToFile(String item) throws IOException {
        updateFile(true,item+"\n");
        list.add(item);
    }
    
    private void updateFile(boolean append, String content) throws IOException {
        FileWriter fw = new FileWriter(file.getAbsoluteFile(),append);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(content);
        bw.close();    
    }
        
    public List<String> getList() {
        return list;
    }
}
