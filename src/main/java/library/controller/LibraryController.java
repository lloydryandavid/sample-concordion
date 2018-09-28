package library.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class LibraryController {


    @RequestMapping("/greeting")
    public String index() {
        return "Hello World!";
    }

}
