package hh.sof3.traillog.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.sof3.traillog.domain.Destination;
import hh.sof3.traillog.domain.DestinationRepository;
import hh.sof3.traillog.domain.Favorite;
import hh.sof3.traillog.domain.Rating;

public class DestinationController {

    @Autowired
    private DestinationRepository destinationRepository;

    // kohteen lisäys ja mahdollisuus lisätä suosikki ja arvostelu
    @RequestMapping(value = "/adddestination", method = RequestMethod.GET)
    public String addDestination(Model model) {
        model.addAttribute("destination", new Destination());
        model.addAttribute("favorites", new Favorite());
        model.addAttribute("ratings", new Rating());
        return "adddestination"; // adddestination.html
    }

    // kohteen tallentaminen
    @SuppressWarnings("null")
    @RequestMapping(value = "/adddestination", method = RequestMethod.POST)
    public String saveDestination(@ModelAttribute Destination destination) {
        destinationRepository.save(destination);
        return "redirect:../destinations"; // vai /profile-page?
    }

    // kohteen muokkaus
    @RequestMapping(value = "/editdestination({id})", method = RequestMethod.GET)
    public String editDestination(@PathVariable("id") Long id, Model model) {
        model.addAttribute("destination", destinationRepository.findById(id).orElse(null));
        return "editdestination"; // editdestination.html
    }

    // Poista kohde
    @RequestMapping(value = "/deletedestination/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deleteDestination(@PathVariable Long id) {
        destinationRepository.deleteById(id);
        return "redirect:../destinations";
    }
}
