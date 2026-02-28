package ir.mehdihosseini.security.jwt.dto;

import java.io.Serializable;

public record AcceptLoginDto(String token, String expireTime) implements Serializable {

}
