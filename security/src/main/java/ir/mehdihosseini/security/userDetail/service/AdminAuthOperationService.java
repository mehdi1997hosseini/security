package ir.mehdihosseini.security.userDetail.service;

import ir.mehdihosseini.security.userDetail.dto.RemoveUserDto;
import ir.mehdihosseini.security.userDetail.dto.SignupUserDto;
import ir.mehdihosseini.security.userDetail.dto.UserSystemDto;

import java.util.List;

public interface AdminAuthOperationService {

    String remove(RemoveUserDto remove);

    String signup(SignupUserDto signup);

    List<UserSystemDto> findAllUserSystem();

}
