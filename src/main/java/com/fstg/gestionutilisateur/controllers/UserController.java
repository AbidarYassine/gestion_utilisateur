package com.fstg.gestionutilisateur.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.fstg.gestionutilisateur.exception.UserException;
import com.fstg.gestionutilisateur.requests.UserRequest;
import com.fstg.gestionutilisateur.response.UserResponse;
import com.fstg.gestionutilisateur.response.exeption.UserError;
import com.fstg.gestionutilisateur.services.UserServices;
import com.fstg.gestionutilisateur.shared.dto.UserDto;


@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserServices userService;

    // production de donne ==== serialization
    @GetMapping(path = "/{id}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserResponse> index(@PathVariable String id) {
        UserDto userDto = userService.findByUserId(id);
//		if(userDto==null) throw new RuntimeException("User Not Foun");
        UserResponse userResponse = new UserResponse();
        BeanUtils.copyProperties(userDto, userResponse);
        return new ResponseEntity<UserResponse>(userResponse, HttpStatus.OK);
    }

    //	@GetMapping(path="/{ahmed}")
//	public String index(@PathVariable("ahmed") String id) {
//		return "yassine" +id;
//	}
    @PostMapping(consumes = {
            MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserResponse> createUser(@Valid @RequestBody UserRequest userRequest) throws Exception {
        if (userRequest.getFistName().isEmpty())
            throw new UserException(UserError.MISSING_REQUIRED_FIELD.getErrorMessage());
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userRequest, userDto);

        UserDto createUser = userService.create(userDto);

        UserResponse userResponse = new UserResponse();
        BeanUtils.copyProperties(createUser, userResponse);

        return new ResponseEntity<UserResponse>(userResponse, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}", consumes = {
            MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserResponse> updateUser(@PathVariable String id, @RequestBody UserRequest userRequest) {
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userRequest, userDto);

        UserDto updateUser = userService.updateUser(userDto, id);

        UserResponse userResponse = new UserResponse();
        BeanUtils.copyProperties(updateUser, userResponse);

//		return userResponse;
        return new ResponseEntity<UserResponse>(userResponse, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(path = "", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> getAllUsers(@RequestParam(value = "page", defaultValue = "1") int page, @RequestParam(value = "limit", defaultValue = "5") int limit) {
        List<UserDto> result = userService.findAll(page, limit);
        List<UserResponse> userResponses = new ArrayList<>();
        for (UserDto userDto : result) {
            UserResponse userResponse1 = new UserResponse();
            BeanUtils.copyProperties(userDto, userResponse1);
            userResponses.add(userResponse1);
        }
        return new ResponseEntity<>(userResponses, HttpStatus.OK);
    }
}
