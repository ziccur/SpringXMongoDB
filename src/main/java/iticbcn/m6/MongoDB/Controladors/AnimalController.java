package iticbcn.m6.MongoDB.Controladors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import iticbcn.m6.MongoDB.DTO.AnimalDTO;
import iticbcn.m6.MongoDB.Model.Animal;
import iticbcn.m6.MongoDB.Serveis.AnimalService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/animals")
public class AnimalController {

    private final AnimalService animalService;

    @Autowired
    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @PostMapping("/save")
    public Mono<Animal> saveAnimal(@RequestBody AnimalDTO animalDTO) {
        return animalService.save(animalDTO);
    }

    @GetMapping("/{id}")
    public Mono<Animal> getAnimalById(@PathVariable String id) {
        return animalService.findById(id);
    }

    @GetMapping("/all")
    public Flux<Animal> getAllAnimals() {
        return animalService.findAll();
    }

    @PutMapping("/update")
    public Mono<Animal> updateAnimal(@RequestBody AnimalDTO animalDTO) {
        return animalService.update(animalDTO);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteAnimal(@PathVariable String id) {
        return animalService.delete(id);
    }

    @GetMapping("/search")
    public Flux<Animal> searchAnimalsByName(@RequestParam String regex) {
        return animalService.findByNomRegex(regex);
    }
}