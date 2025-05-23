package iticbcn.m6.MongoDB.Mappers;

import org.mapstruct.Mapper;

import iticbcn.m6.MongoDB.DTO.AnimalDTO;
import iticbcn.m6.MongoDB.Model.Animal;

@Mapper(componentModel = "spring")
public interface AnimalMapper {
    Animal animalDTOToAnimal(AnimalDTO dto);
    AnimalDTO animalToAnimalDTO(Animal entity);
}