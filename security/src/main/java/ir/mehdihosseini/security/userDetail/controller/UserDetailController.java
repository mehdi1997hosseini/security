package ir.mehdihosseini.security.userDetail.controller;

import ir.mehdihosseini.security.userDetail.dto.LoginUserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserDetailController {

    @PostMapping("login")
    public ResponseEntity<?> login(@RequestBody LoginUserDto login);

}
