package iticbcn.m6.MongoDB.Repositoris;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import iticbcn.m6.MongoDB.Model.Animal;
import reactor.core.publisher.Flux;

@Repository
public interface AnimalRepo extends ReactiveMongoRepository<Animal, String> {
    Flux<Animal> findByNomRegex(String regex);
}