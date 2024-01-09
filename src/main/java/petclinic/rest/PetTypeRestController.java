package petclinic.rest;

import jakarta.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import petclinic.mapper.PetTypeMapper;
import petclinic.repository.PetTypeRepository;
import petclinic.rest.api.PettypesApi;
import petclinic.rest.dto.PetTypeDto;

import java.util.List;

@RestController
@RequestMapping("api")
public class PetTypeRestController implements PettypesApi {

    @Resource
    private PetTypeRepository petTypeRepository;

    @Override
    public ResponseEntity<List<PetTypeDto>> listPetTypes() {
        System.out.println("listPetTypes");
        var petTypes = petTypeRepository.query();

        return new ResponseEntity<>(PetTypeMapper.INSTANCE.toPetTypeDtos(petTypes), HttpStatus.OK);
    }
}
