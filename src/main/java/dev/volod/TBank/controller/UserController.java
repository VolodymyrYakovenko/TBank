package dev.volod.TBank.controller;

import dev.volod.TBank.dto.request.UserRequestDTO;
import dev.volod.TBank.dto.response.UserResponseDTO;
import dev.volod.TBank.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    UserService service;

    public UserController(UserService service) {
        this.service = service;
    }


    @GetMapping("")
    public ResponseEntity<List<UserResponseDTO>> getAll(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getById(@PathVariable String id){
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<UserResponseDTO> create(@Valid @RequestBody UserRequestDTO user){
        return new ResponseEntity<>(service.save(user), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> update(@PathVariable String id, @Valid  @RequestBody UserRequestDTO userDTO){
        return new ResponseEntity<>(service.update(id, userDTO), HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable String id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
