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

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/plantes")
public class PlanteController {

    private final PlanteRepository planteService;

    @Autowired
    public PlanteController(PlanteRepository planteService) {
        this.planteService = planteService;
    }

    // Endpoint pour obtenir toutes les plantes nécessitant des conseils (isNeedingTips = true)
    @GetMapping("/tips")
    public ResponseEntity<List<Plante>> getPlantesNeedingTips() {
        List<Plante> plantesNeedingTips = planteService.findAll().stream()
                .filter(Plante::isNeedingTips)
                .collect(Collectors.toList());

        if (plantesNeedingTips.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(plantesNeedingTips, HttpStatus.OK);
    }

    // Endpoint pour obtenir toutes les plantes nécessitant des soins (isNeedingCare = true)
    @GetMapping("/care")
    public ResponseEntity<List<Plante>> getPlantesNeedingCare() {
        List<Plante> plantesNeedingCare = planteService.findAll().stream()
                .filter(Plante::isNeedingCare)
                .collect(Collectors.toList());

        if (plantesNeedingCare.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(plantesNeedingCare, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Plante> getPlanteById(@PathVariable Long id) {
        Optional<Plante> planteOptional = planteService.findById(id);
        return planteOptional.map(plante -> new ResponseEntity<>(plante, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
