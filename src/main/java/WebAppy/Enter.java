package WebAppy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

@Controller
public class Enter {
    
    private static final List<String> todo = new ArrayList<>(); 
    private File file = new File("/Users/techsupport/Downloads/demo 2/src/main/java/WebAppy/listHistory.txt");

    @RequestMapping(value = "/TextBox", method = RequestMethod.POST)
    public String getList(@RequestParam String list, ModelMap model) throws IOException { //if param name same as html name dont need value
        if (todo.isEmpty()) {
            Scanner s = new Scanner(file);
            while (s.hasNext()) {
                todo.add(s.next());
            }
            s.close();
        }
        todo.add(list);
        FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
        BufferedWriter bw = new BufferedWriter(fw);
	bw.write(list+"\n");
	bw.close();
        model.addAttribute("listy", todo);
        return "allInOne";
    }
}
