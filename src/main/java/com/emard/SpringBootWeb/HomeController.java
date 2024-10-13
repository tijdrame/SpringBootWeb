package com.emard.SpringBootWeb;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home() {
        return "index";
    }

    @RequestMapping(path = "add", method = RequestMethod.GET)
    // public String add(HttpServletRequest request, HttpSession session) {
    // public String add(@RequestParam("num1") int num, int num2, Model model) {
    public ModelAndView add(@RequestParam("num1") int num, int num2, ModelAndView model) {
        // var num1 = Integer.parseInt(request.getParameter("num1"));
        // var num2 = Integer.parseInt(request.getParameter("num2"));
        var result = num + num2;
        // session.setAttribute("result", result);
        // model.addAttribute("result", result);
        model.addObject("result", result);
        model.setViewName("result");
        return model;
    }

    @RequestMapping(path = "addAlien", method = RequestMethod.GET)
    // public ModelAndView addAlien(@RequestParam("aid") int aid, String aname,
    // ModelAndView model) {
    // ModelAttribute est optionnnel si on a le meme nom de var ici et sur la page
    // jsp
    public ModelAndView addAlien(@ModelAttribute Alien alien, ModelAndView model) {
        /*
         * Alien alien = new Alien();
         * alien.setAid(aid);
         * alien.setAname(aname);
         */
        model.addObject("alien", alien);
        model.setViewName("result");
        return model;
    }

    @ModelAttribute("course")
    public String coursename() {
        return "Java";
    }
}
