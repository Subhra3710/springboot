package com.subhra.intro_to_web;

import java.io.PrintWriter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller // StereotypeAnnotation
/*
 * //Marks the class as a controller classs, which means that class is
 * responsible to handle http request
 */
public class HelloController {

    @RequestMapping("/home")
    /*
     * This annotation handles a custom path inside a controller class
     */
    public void sayHello(PrintWriter writer) {
        System.out.println("Hello Web");
        writer.println("<h1>Hello Spring Web</h1> <p>Welcome Home</P>");
    }

    /* PrintWriter- */
    @RequestMapping("/")
    public void landingPage(PrintWriter printWriter) {
        System.out.println("landingPage");
        printWriter.println("Our first landing page");
    }

    @RequestMapping("/contact")
    public String contact(PrintWriter printWriter) {
        return "contact-page";
    }

//     @RequestMapping("/submit-details")
    // public String submitDetails(HttpServletRequest request, Model model) {
//         System.out.println("Submit details handled");
//         String name = request.getParameter("name");
//         String phone = request.getParameter("phone");
//         //System.out.println("name is:" + name);
//         //System.out.println("phone is:" + phone);

//         model.addAttribute("name", name);
//         model.addAttribute("phone", phone);



//         return "details-page";
//     }

// }

// @RequestMapping(value="/submit-details", method= RequestMethod.POST ) 
// public String submitDetails(@RequestParam(value="name1", required= false, defaultValue="SpringBoot") String name12, @RequestParam String phone,  Model model){
 
//     model.addAttribute("name1", name12);
//     model.addAttribute("phone", phone);

//       return "details-page";

//     }
// }

@RequestMapping(value="/submit-details", method= RequestMethod.POST ) 
public String submitDetails(@ModelAttribute Person person, Model model){
 
    model.addAttribute("name1", person.getName1());
    model.addAttribute("phone", person.getPhone());

      return "details-page";

    }
}