package ir.mehdihosseini.security.userDetail.controller;

import ir.mehdihosseini.security.urlApp.dto.AddUrlDto;
import ir.mehdihosseini.security.userDetail.dto.RemoveUserDto;
import ir.mehdihosseini.security.userDetail.dto.SignupUserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface AdminController {
    @PostMapping("user/sign-up")
    public ResponseEntity<?> signup(@RequestBody SignupUserDto signup);

    @PostMapping("user/remove")
    public ResponseEntity<?> removeUser(@RequestBody RemoveUserDto remove);

    @PostMapping("url/add")
    public ResponseEntity<?> addUrl(@RequestBody AddUrlDto dto);

    @PostMapping("user/find-all-user-system")
    public ResponseEntity<?> findAllUserSystem();

}
