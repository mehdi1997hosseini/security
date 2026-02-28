package ir.mehdihosseini.security.userDetail.controller;

import ir.mehdihosseini.security.url.dto.AddUrlDto;
import ir.mehdihosseini.security.url.service.CrudUrlsService;
import ir.mehdihosseini.security.userDetail.dto.RemoveUserDto;
import ir.mehdihosseini.security.userDetail.dto.SignupUserDto;
import ir.mehdihosseini.security.userDetail.service.AdminAuthOperationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/")
public class AdminControllerImpl implements AdminController {

    private final AdminAuthOperationService service;
    private final CrudUrlsService urlsService;

    public AdminControllerImpl(AdminAuthOperationService service, CrudUrlsService urlsService) {
        this.service = service;
        this.urlsService = urlsService;
    }

    @Override
    public ResponseEntity<?> signup(@RequestBody SignupUserDto signup) {
        return new ResponseEntity<>(service.signup(signup), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> removeUser(@RequestBody RemoveUserDto remove) {
        return new ResponseEntity<>(service.remove(remove), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> addUrl(@RequestBody AddUrlDto dto) {
        return new ResponseEntity<>(urlsService.addUrl(dto), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> findAllUserSystem() {
        return new ResponseEntity<>(service.findAllUserSystem(), HttpStatus.OK);
    }


}
