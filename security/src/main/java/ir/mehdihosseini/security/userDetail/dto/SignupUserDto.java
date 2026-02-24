package ir.mehdihosseini.security.userDetail.dto;

import ir.mehdihosseini.security.roles.RoleEntity;

import java.io.Serializable;
import java.util.Set;

public record SignupUserDto(String username, String password, Set<RoleEntity> roles) implements Serializable {

}
