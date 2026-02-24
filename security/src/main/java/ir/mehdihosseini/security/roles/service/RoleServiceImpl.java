package ir.mehdihosseini.security.roles.service;

import ir.mehdihosseini.security.core.service.AbstractEntityService;
import ir.mehdihosseini.security.roles.RoleEntity;
import ir.mehdihosseini.security.roles.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends AbstractEntityService<RoleEntity,String, RoleRepository> implements CrudRoleService {

    protected RoleServiceImpl(RoleRepository repository) {
        super(repository);
    }


}
