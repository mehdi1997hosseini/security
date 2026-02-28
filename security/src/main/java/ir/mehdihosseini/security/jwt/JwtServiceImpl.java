package ir.mehdihosseini.security.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import ir.mehdihosseini.security.jwt.dto.AcceptLoginDto;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtServiceImpl implements JwtService {

    @Override
    public AcceptLoginDto generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("roles", userDetails.getAuthorities());
        long currentTimeMillis = System.currentTimeMillis();
        Date expirationTime = new Date(currentTimeMillis + 1000 * 60 * 15);
        String token = Jwts.builder().
                claims(claims)
                .subject(userDetails.getUsername())
                .issuedAt(new Date(currentTimeMillis))
                .expiration(expirationTime)
                .signWith(generateKey())
                .compact();

        return new AcceptLoginDto(token , expirationTime.toString());
    }

    private SecretKey generateKey() {
        byte[] decode = Decoders.BASE64.decode("");
        return Keys.hmacShaKeyFor(decode);
    }

}
