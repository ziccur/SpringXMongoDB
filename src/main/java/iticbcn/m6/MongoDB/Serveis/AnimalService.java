package iticbcn.m6.MongoDB.Serveis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iticbcn.m6.MongoDB.DTO.AnimalDTO;
import iticbcn.m6.MongoDB.Mappers.AnimalMapper;
import iticbcn.m6.MongoDB.Model.Animal;
import iticbcn.m6.MongoDB.Repositoris.AnimalRepo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AnimalService {

    private final AnimalRepo animalRepo;
    private final AnimalMapper animalMapper;

    @Autowired
    public AnimalService(AnimalRepo animalRepo, AnimalMapper animalMapper) {
        this.animalRepo = animalRepo;
        this.animalMapper = animalMapper;
    }

    public Mono<Animal> save(AnimalDTO animalDTO) {
        return animalRepo.save(animalMapper.animalDTOToAnimal(animalDTO));
    }

    public Mono<Animal> findById(String id) {
        return animalRepo.findById(id);
    }

    public Flux<Animal> findAll() {
        return animalRepo.findAll();
    }

    public Mono<Animal> update(AnimalDTO animalDTO) {
        return animalRepo.findById(animalDTO.id())
                .flatMap(existingAnimal -> {
                    Animal updatedAnimal = animalMapper.animalDTOToAnimal(animalDTO);
                    updatedAnimal.setId(existingAnimal.getId());
                    return animalRepo.save(updatedAnimal);
                });
    }

    public Mono<Void> delete(String id) {
        return animalRepo.deleteById(id);
    }
}