package iticbcn.m6.MongoDB.Repositoris;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.stereotype.Repository;

import iticbcn.m6.MongoDB.Model.Animal;

@Repository
@EnableReactiveMongoRepositories
public interface AnimalRepo extends ReactiveMongoRepository<Animal, String> {
    
}