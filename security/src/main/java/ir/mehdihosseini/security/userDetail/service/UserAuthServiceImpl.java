package ir.mehdihosseini.security.userDetail.service;

import ir.mehdihosseini.security.core.service.AbstractAuditingService;
import ir.mehdihosseini.security.core.service.entity.BasicEntityService;
import ir.mehdihosseini.security.userDetail.UserDetailEntity;
import ir.mehdihosseini.security.userDetail.dto.LoginUserDto;
import ir.mehdihosseini.security.userDetail.dto.RemoveUserDto;
import ir.mehdihosseini.security.userDetail.dto.SignupUserDto;
import ir.mehdihosseini.security.userDetail.dto.UserSystemDto;
import ir.mehdihosseini.security.userDetail.repository.UserDetailRepository;
import org.hibernate.query.IllegalSelectQueryException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAuthServiceImpl extends AbstractAuditingService<UserDetailEntity, String, UserDetailRepository>
        implements BasicEntityService<UserDetailEntity, String>, AdminAuthOperationService, UserAuthorizationService {

    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    protected UserAuthServiceImpl(UserDetailRepository repository
            , PasswordEncoder passwordEncoder
            , AuthenticationManager authenticationManager) {
        super(repository);
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }


    @Override
    public String signup(SignupUserDto signup) {
        if (repository.existsByUsername(signup.username())) {
            throw new IllegalSelectQueryException("user by user name is exist .... ");
        }

        UserDetailEntity userDetail = new UserDetailEntity();
        userDetail.setUsername(signup.username());
        userDetail.setPassword(passwordEncoder.encode(signup.password()));
        userDetail.setRoles(signup.roles());

        repository.save(userDetail);

        return "successFull";
    }

    @Override
    public List<UserSystemDto> findAllUserSystem() {
        return repository.findAll().stream().filter(x -> x.isEnabled()
                && x.isAccountNonExpired()
                && !x.getIsDelete())
                .map(e -> new UserSystemDto(e.getUsername(),e.getPassword())).toList();
    }

    @Override
    public String login(LoginUserDto login) {
        Authentication authenticate = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(login.username(), login.password()));

        if (!authenticate.isAuthenticated()) {
            throw new AuthenticationServiceException("username or password is not correct");
        }

        // generate token
        String token = "is success full";

        return token;
    }

    @Override
    public String remove(RemoveUserDto remove) {
        UserDetailEntity userDetail = repository.findByUsername(remove.username());
        if (userDetail == null)
            throw new IllegalSelectQueryException("user not found");
        super.softDeleteById(userDetail);
        return "user deleted";
    }

}
