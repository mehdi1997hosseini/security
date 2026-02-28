package ir.mehdihosseini.security.role.repository;

import ir.mehdihosseini.security.core.repository.BasicRepository;
import ir.mehdihosseini.security.role.RoleEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends BasicRepository<RoleEntity, String> {
}
