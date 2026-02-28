package ir.mehdihosseini.security.jwt;

import ir.mehdihosseini.security.jwt.dto.AcceptLoginDto;
import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {

    AcceptLoginDto generateToken(UserDetails userDetails);



}
