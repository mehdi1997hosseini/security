package ir.mehdihosseini.security.userDetail.service;

import ir.mehdihosseini.security.userDetail.UserDetailEntity;
import ir.mehdihosseini.security.userDetail.repository.UserDetailRepository;
import org.hibernate.query.IllegalSelectQueryException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private final UserDetailRepository repository;

    public UserDetailServiceImpl(UserDetailRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetailEntity userDetail = repository.findByUsername(username);
        if (userDetail == null)
            throw new IllegalSelectQueryException("user not found ...");
        return userDetail;
    }
}
