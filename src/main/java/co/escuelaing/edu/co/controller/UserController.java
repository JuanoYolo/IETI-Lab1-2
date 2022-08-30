package co.escuelaing.edu.co.controller;

import co.escuelaing.edu.co.dto.UserDto;
import co.escuelaing.edu.co.entities.User;
import co.escuelaing.edu.co.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public ResponseEntity<List<UserDto>> getAll() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(userService.all());
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable String id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(userService.findById(id));
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


    @PostMapping
    public ResponseEntity<User> create(@RequestBody UserDto userDto) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(userService.create(new ModelMapper().map(userDto, User.class)));
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@RequestBody UserDto user, @PathVariable String id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(userService.update(new ModelMapper().map(user, User.class), id));
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable String id) {
        try {
            userService.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(true);
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
        }
    }


}
