package WebAppy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @RequestMapping("/TextBox")
    public String index() {
        return "allInOne";
    }

}