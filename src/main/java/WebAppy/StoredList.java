package WebAppy;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class StoredList {
    
    private final File file;
    
    public StoredList(String path) {
        this.file = new File(path);
    }
    
    public void readFile(List<String> list) throws FileNotFoundException {
        if (list.isEmpty()) {
            Scanner s = new Scanner(file);
            while (s.hasNext()) {
                list.add(s.next());
            }
            s.close();
        }
    }
    
    public void writeFile(String list) throws IOException {
        FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(list+"\n");
        bw.close();
    }

}
