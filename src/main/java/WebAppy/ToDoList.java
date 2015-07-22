package WebAppy;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class ToDoList {
    
    private final String path = "/Users/techsupport/Downloads/ToDoList/src/main/java/WebAppy/listHistory.txt";
    private File file = new File(path);
    private List<String> list = new ArrayList<>();
    
    @PostConstruct
    private void readFileAtStartUp() throws FileNotFoundException {
        Scanner s = new Scanner(file);
        while (s.hasNext()) {
            list.add(s.nextLine());
        }
        s.close();
    }
    
    private void updateFile(boolean append, String content) throws IOException {
        FileWriter fw = new FileWriter(file.getAbsoluteFile(),append);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(content);
        bw.close();    
    }
    
    public void writeItemsToFile(String item) throws IOException {
        updateFile(true,item+"\n");
        list.add(item);
    }
    
    public void deleteItemsFromFileAndList() throws IOException {
        updateFile(false,"");
        list.clear();
    }
    
    public List<String> getList() throws FileNotFoundException {
        return list;
    }

}
