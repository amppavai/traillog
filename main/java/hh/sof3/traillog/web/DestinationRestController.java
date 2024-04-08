package hh.sof3.traillog.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import hh.sof3.traillog.domain.Destination;
import hh.sof3.traillog.domain.DestinationRepository;

@CrossOrigin
@RestController
public class DestinationRestController {

    @Autowired
    private DestinationRepository destinationRepository;
    
    // RESTful kohteiden haku GET
    @GetMapping(value = "/destinations")
    public @ResponseBody List<Destination> getAllDestinations() {
        return (List<Destination>) destinationRepository.findAll();
    }

    // RESTful kohteen haku id:n perusteella GET
    @GetMapping(value = "/destinations/{id}")
    public Destination getDestinationById(@PathVariable Long dest_id) {
        return destinationRepository.findById(dest_id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Destination not found"));
    }

    // RESTful kohteen lisäys POST
    @PostMapping(value = "/destinations")
    public @ResponseBody Destination addDestination(Destination destination) {
        if (destination != null) {
            return destinationRepository.save(destination);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Destination cannot be null");
        }
    }


}
