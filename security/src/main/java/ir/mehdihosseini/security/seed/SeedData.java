package ir.mehdihosseini.security.seed;

import ir.mehdihosseini.security.roles.RoleEntity;
import ir.mehdihosseini.security.roles.repository.RoleRepository;
import ir.mehdihosseini.security.urlApp.UrlAppEntity;
import ir.mehdihosseini.security.urlApp.repository.UrlAppRepository;
import ir.mehdihosseini.security.userDetail.UserDetailEntity;
import ir.mehdihosseini.security.userDetail.repository.UserDetailRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class SeedData {

    private final RoleRepository roleRepository;
    private final UrlAppRepository urlAppRepository;
    private final UserDetailRepository userDetailRepository;
    private final PasswordEncoder passwordEncoder;


    public SeedData(RoleRepository roleRepository, UrlAppRepository urlAppRepository, UserDetailRepository userDetailRepository, PasswordEncoder passwordEncoder) {
        this.roleRepository = roleRepository;
        this.urlAppRepository = urlAppRepository;
        this.userDetailRepository = userDetailRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    void init() {
        RoleEntity roleEntity1 = new RoleEntity();
        roleEntity1.setTitle("manager");
        roleEntity1.setRoleName("SUPER_ADMIN");
        RoleEntity saveRole1 = roleRepository.save(roleEntity1);

        UserDetailEntity userDetail1 = new UserDetailEntity();
        userDetail1.setUsername("mehdi");
        userDetail1.setPassword(passwordEncoder.encode("mehdi"));
        userDetail1.setRoles(Set.of(saveRole1));
        UserDetailEntity saveUserDetail1 = userDetailRepository.save(userDetail1);


        UrlAppEntity urlApp1 = new UrlAppEntity();
        urlApp1.setTitle("swagger");
        urlApp1.setContextPath("/swagger/");
        urlApp1.setEndpoint("**");
        urlApp1.setPermitAll(true);
        UrlAppEntity saveUrlApp1 = urlAppRepository.save(urlApp1);

        UrlAppEntity urlApp2 = new UrlAppEntity();
        urlApp2.setTitle("h2-db");
        urlApp2.setContextPath("/h2/");
        urlApp2.setEndpoint("**");
        urlApp2.setPermitAll(true);
        UrlAppEntity saveUrlApp2 = urlAppRepository.save(urlApp2);
    }

}
