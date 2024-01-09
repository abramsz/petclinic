package petclinic.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import petclinic.domain.PetType;
import petclinic.rest.dto.PetTypeDto;
import petclinic.rest.dto.PetTypeFieldsDto;

import java.util.Collection;
import java.util.List;

/**
 * Map PetType & PetTypeDto using mapstruct
 */
@Mapper
public interface PetTypeMapper {

    PetTypeMapper INSTANCE = Mappers.getMapper(PetTypeMapper.class);

    PetType toPetType(PetTypeDto petTypeDto);

    PetType toPetType(PetTypeFieldsDto petTypeFieldsDto);

    PetTypeDto toPetTypeDto(PetType petType);

    List<PetTypeDto> toPetTypeDtos(Collection<PetType> petTypes);
}
