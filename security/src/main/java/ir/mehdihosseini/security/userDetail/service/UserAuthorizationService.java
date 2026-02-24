package ir.mehdihosseini.security.userDetail.service;

import ir.mehdihosseini.security.userDetail.dto.LoginUserDto;

public interface UserAuthorizationService {

    String login(LoginUserDto login);

}
