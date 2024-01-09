package petclinic.repository;

import jakarta.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import petclinic.domain.PetType;

import java.util.List;

public class PetTypeRepositoryOverrideImpl implements PetTypeRepositoryOverride {
    @Resource
    JdbcTemplate jdbcTemplate;

    @Override
    public List<PetType> query() {
        return jdbcTemplate.query("select * from types", (rs, rowNum) -> {
            var type = new PetType();
            type.setId(rs.getInt("id"));
            type.setName(rs.getString("name"));
            return type;
        });
    }
}
