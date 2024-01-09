package petclinic.repository;

import petclinic.domain.PetType;

import java.util.List;

public interface PetTypeRepositoryOverride {

    List<PetType> query();
}
