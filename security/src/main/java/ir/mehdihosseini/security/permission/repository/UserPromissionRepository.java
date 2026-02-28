package ir.mehdihosseini.security.permission.repository;

import ir.mehdihosseini.security.core.repository.BasicRepository;
import ir.mehdihosseini.security.permission.UserPromissionEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPromissionRepository extends BasicRepository<UserPromissionEntity, String> {

}
