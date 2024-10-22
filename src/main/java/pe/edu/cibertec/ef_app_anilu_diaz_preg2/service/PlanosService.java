package pe.edu.cibertec.ef_app_anilu_diaz_preg2.service;

import org.springframework.stereotype.Service;

@Service
public class PlanosService {

   public String generarPlano(String ciudad) {

       if (Math.random() > 0.5) {
           throw new RuntimeException("Error al generar el plano para la ciudad: " + ciudad);
       }

       return "Plano generado con éxito para la ciudad: " + ciudad;
   }
}
