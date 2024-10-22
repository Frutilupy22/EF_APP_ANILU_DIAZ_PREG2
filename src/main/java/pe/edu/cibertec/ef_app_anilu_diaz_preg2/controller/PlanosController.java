package pe.edu.cibertec.ef_app_anilu_diaz_preg2.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.ef_app_anilu_diaz_preg2.service.PlanosService;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/planos")
public class PlanosController {

   private final PlanosService planosService;

    @GetMapping("/{ciudad}")
    @CircuitBreaker(name="planoRed", fallbackMethod = "fallBackMethod")
    public String generarPlano(@PathVariable String ciudad) {
        return planosService.generarPlano(ciudad);
    }

    public String fallBackMethod(Throwable throwable) {
        return "Servicio no disponible. Inténtelo más tarde.";
    }
}
