package ir.mehdihosseini.security.core.service;

import ir.mehdihosseini.security.core.entity.audit.BasicAuditEntity;
import ir.mehdihosseini.security.core.repository.BasicRepository;
import ir.mehdihosseini.security.core.utils.SecurityUtils;
import jakarta.transaction.Transactional;

import java.util.Date;

public abstract class AbstractAuditingService<ENTITY extends BasicAuditEntity<ID>, ID, REPO extends BasicRepository<ENTITY, ID>>
        extends AbstractEntityService<ENTITY, ID, REPO> {

    protected AbstractAuditingService(REPO repository) {
        super(repository);
    }

    @Override
    @Transactional
    public Boolean softDeleteById(ENTITY entity) {
        entity.setIsDelete(true);
        entity.setDeletedAt(new Date());
        entity.setDeletedBy(SecurityUtils.currentUsername());
        return save(entity) != null;
    }


}
