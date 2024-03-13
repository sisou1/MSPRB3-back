package fr.epsi.msprb3bootjpamaven.controller;

import fr.epsi.msprb3bootjpamaven.bo.Plante;
import fr.epsi.msprb3bootjpamaven.repository.PlanteRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PlanteControllerTest {

    @Mock
    private PlanteRepository planteRepository;

    @InjectMocks
    private PlanteController planteController;

    @Test
    public void testGetPlanteById() {
        Long planteId = 1L;
        Plante mockPlante = new Plante();
        mockPlante.setId(planteId);
        mockPlante.setDescription("Description de la plante");
        mockPlante.setNeedingCare(true);
        mockPlante.setNeedingTips(false);
        when(planteRepository.findById(planteId)).thenReturn(Optional.of(mockPlante));

        ResponseEntity<Plante> responseEntity = planteController.getPlanteById(planteId);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(mockPlante, responseEntity.getBody());
    }

    @Test
    public void testGetPlantesNeedingTips() {
        Plante plante1 = new Plante();
        plante1.setId(1L);
        plante1.setDescription("Plante 1");
        plante1.setNeedingCare(false);
        plante1.setNeedingTips(true);

        Plante plante2 = new Plante();
        plante2.setId(2L);
        plante2.setDescription("Plante 2");
        plante2.setNeedingCare(true);
        plante2.setNeedingTips(false);

        List<Plante> plantes = Arrays.asList(plante1, plante2);

        when(planteRepository.findAll()).thenReturn(plantes);

        ResponseEntity<List<Plante>> responseEntity = planteController.getPlantesNeedingTips();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(1, responseEntity.getBody().size());
        assertEquals(plante1, responseEntity.getBody().get(0));
    }

    @Test
    public void testGetPlantesNeedingCare() {
        Plante plante1 = new Plante();
        plante1.setId(1L);
        plante1.setDescription("Plante 1");
        plante1.setNeedingCare(true);
        plante1.setNeedingTips(false);

        Plante plante2 = new Plante();
        plante2.setId(2L);
        plante2.setDescription("Plante 2");
        plante2.setNeedingCare(true);
        plante2.setNeedingTips(true);

        List<Plante> plantes = Arrays.asList(plante1, plante2);

        when(planteRepository.findAll()).thenReturn(plantes);

        ResponseEntity<List<Plante>> responseEntity = planteController.getPlantesNeedingCare();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(2, responseEntity.getBody().size());
        assertEquals(plantes, responseEntity.getBody());
    }
}

