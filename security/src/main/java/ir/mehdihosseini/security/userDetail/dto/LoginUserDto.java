package ir.mehdihosseini.security.userDetail.dto;

import java.io.Serializable;

public record LoginUserDto(String username, String password) implements Serializable {
}
