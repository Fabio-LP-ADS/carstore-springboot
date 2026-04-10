package br.com.carstore.controller;

import br.com.carstore.dto.CarDTO;
import br.com.carstore.dto.CarResponseBody;
import br.com.carstore.service.CarService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestController {

    private final CarService carService;

    @Autowired
    public RestController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/api/cars")
    public ResponseEntity<CarResponseBody> home() {
        return ResponseEntity.ok(new CarResponseBody(carService.findAll()));
    }

    @PostMapping("/api/cars")
    public ResponseEntity<Void> createCar(@RequestBody @Valid CarDTO car) {
        carService.save(car);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/api/cars/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable String id) {
        carService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/api/cars/{id}")
    public ResponseEntity<CarDTO> updateCar(@PathVariable String id,
                                           @RequestBody @Valid CarDTO carDTO) {
        carService.update(id, carDTO);
        return ResponseEntity.ok(carDTO);
    }
}
