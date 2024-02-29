package fr.epsi.msprb3bootjpamaven.controller;

import fr.epsi.msprb3bootjpamaven.bo.Plante;
import fr.epsi.msprb3bootjpamaven.dal.PlanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;

@RestController
@RequestMapping("/plantes")
public class PlanteController {

    private final PlanteRepository planteService;

    @Autowired
    public PlanteController(PlanteRepository planteService) {
        this.planteService = planteService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Plante> getPlanteById(@PathVariable Long id) {
        Optional<Plante> planteOptional = planteService.findById(id);
        return planteOptional.map(plante -> new ResponseEntity<>(plante, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
