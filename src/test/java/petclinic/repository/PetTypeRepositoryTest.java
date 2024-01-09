package petclinic.repository;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PetTypeRepositoryTest {

    @Resource
    PetTypeRepository petTypeRepository;

    @Test
    @Sql("classpath:db/schema/data-test.sql")
    void testQuery() {
        var types = petTypeRepository.query();
        assertEquals(7, types.size());
    }

    @Test
    void testQuery2() {
        var types = petTypeRepository.query();
        assertEquals(7, types.size());
    }
}
