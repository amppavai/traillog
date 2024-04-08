package hh.sof3.traillog.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.sof3.traillog.domain.AninUser;
import hh.sof3.traillog.domain.AninUserRepository;

@Controller
public class UserController {

    private AninUserRepository aninUserRepository;

    // uuden käyttäjän rekisteröityminen
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String addUser(Model model) {
        model.addAttribute("user", new AninUser(null, null, null, null));
        return "register"; // register.html
    }

    // käyttäjän tallentaminen
    @RequestMapping(value = "/saveuser", method = RequestMethod.POST)
    public String saveUser(AninUser user) {
        aninUserRepository.save(user);
        return "redirect:../index"; // index.html
        // plus window alert: "Käyttäjä lisätty"
    }

    // käyttäjän muokkaus
    @RequestMapping(value = "/edituser", method = RequestMethod.GET)
    public String editUser(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", aninUserRepository.findById(id));
        return "edituser"; // edituser.html
    }

    // käyttäjän poisto
    @RequestMapping(value = "/deleteuser", method = RequestMethod.GET)
    public String deleteUser(@PathVariable("id") Long id, Model model) {
        aninUserRepository.deleteById(id);
        return "redirect:../index"; // index.html
        // plus window alert: "Käyttäjä poistettu"
    }

}
