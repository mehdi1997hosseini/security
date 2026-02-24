package ir.mehdihosseini.security.seed;

import ir.mehdihosseini.security.roles.RoleEntity;
import ir.mehdihosseini.security.roles.repository.RoleRepository;
import ir.mehdihosseini.security.urlApp.UrlAppEntity;
import ir.mehdihosseini.security.urlApp.repository.UrlAppRepository;
import ir.mehdihosseini.security.userDetail.UserDetailEntity;
import ir.mehdihosseini.security.userDetail.repository.UserDetailRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@Order(value = 0)
public class SeedData implements CommandLineRunner {

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

    @Override
    public void run(String... args) throws Exception {

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
        urlApp1.setPath("**");
        urlApp1.setPermitAll(true);
        UrlAppEntity saveUrlApp1 = urlAppRepository.save(urlApp1);


    }

}
