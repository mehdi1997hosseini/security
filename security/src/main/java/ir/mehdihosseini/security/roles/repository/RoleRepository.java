package ir.mehdihosseini.security.roles.repository;

import ir.mehdihosseini.security.core.repository.BasicRepository;
import ir.mehdihosseini.security.roles.RoleEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends BasicRepository<RoleEntity, String> {
}
