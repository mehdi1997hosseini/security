package ir.mehdihosseini.security.userDetail.repository;

import ir.mehdihosseini.security.core.repository.BasicRepository;
import ir.mehdihosseini.security.userDetail.UserDetailEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailRepository extends BasicRepository<UserDetailEntity, String> {

    UserDetailEntity findByUsername(String username);

    boolean existsByUsername(String username);

}
