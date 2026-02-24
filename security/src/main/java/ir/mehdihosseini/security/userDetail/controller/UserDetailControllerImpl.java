package ir.mehdihosseini.security.userDetail.controller;

import ir.mehdihosseini.security.userDetail.dto.LoginUserDto;
import ir.mehdihosseini.security.userDetail.service.UserAuthorizationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/")
public class UserDetailControllerImpl implements UserDetailController {

    private final UserAuthorizationService service;

    public UserDetailControllerImpl(UserAuthorizationService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<?> login(@RequestBody LoginUserDto login) {
        return new ResponseEntity<>(service.login(login), HttpStatus.OK);
    }

}
