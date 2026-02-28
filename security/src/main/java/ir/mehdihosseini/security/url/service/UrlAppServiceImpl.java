package ir.mehdihosseini.security.url.service;

import ir.mehdihosseini.security.core.service.AbstractEntityService;
import ir.mehdihosseini.security.core.service.entity.BasicEntityService;
import ir.mehdihosseini.security.url.UrlAppEntity;
import ir.mehdihosseini.security.url.dto.AddUrlDto;
import ir.mehdihosseini.security.url.repository.UrlAppRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UrlAppServiceImpl extends AbstractEntityService<UrlAppEntity, String, UrlAppRepository>
        implements BasicEntityService<UrlAppEntity, String>, CrudUrlsService, AccessibilityUrlService {

    protected UrlAppServiceImpl(UrlAppRepository repository) {
        super(repository);
    }

    @Override
    public List<UrlAppEntity> isPermitAll() {
        return repository.findAllByPermitAllAndIsDelete(true, false);
    }

    @Transactional
    public String addUrl(AddUrlDto add) {
        UrlAppEntity urlApp = new UrlAppEntity();
        urlApp.setPermitAll(add.permitAll());
        urlApp.setTitle(add.title());
        urlApp.setEndpoint(add.path());
        urlApp.setContextPath(add.contextPath());
        save(urlApp);

        return "new url added";
    }


}
