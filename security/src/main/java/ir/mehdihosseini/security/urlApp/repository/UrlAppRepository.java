package ir.mehdihosseini.security.urlApp.repository;

import ir.mehdihosseini.security.core.repository.BasicRepository;
import ir.mehdihosseini.security.urlApp.UrlAppEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UrlAppRepository extends BasicRepository<UrlAppEntity, String> {

    List<UrlAppEntity> findAllByPermitAllAndIsDelete(boolean permitAll, Boolean isDelete);

}
