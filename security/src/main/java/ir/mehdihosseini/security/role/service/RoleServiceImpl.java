package ir.mehdihosseini.security.role.service;

import ir.mehdihosseini.security.core.service.AbstractEntityService;
import ir.mehdihosseini.security.role.RoleEntity;
import ir.mehdihosseini.security.role.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends AbstractEntityService<RoleEntity,String, RoleRepository> implements CrudRoleService {

    protected RoleServiceImpl(RoleRepository repository) {
        super(repository);
    }


}
