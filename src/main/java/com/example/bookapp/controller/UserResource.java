package com.example.bookapp.controller;

import com.example.bookapp.domain.User;
import com.example.bookapp.dto.UserDTO;
import com.example.bookapp.error.EntityMustHaveIDException;
import com.example.bookapp.error.NewEntityCannotHaveIDException;
import com.example.bookapp.filter.UserFilter;
import com.example.bookapp.mapper.UserMapper;
import com.example.bookapp.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "Users REST controller", tags = "user-resource")
@RequestMapping("/api")
public class UserResource {

    private final Logger log = LoggerFactory.getLogger(UserResource.class);
    private static final String ENTITY_NAME = "User";

    private final UserService userService;

    private UserMapper userMapper;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @ApiOperation(httpMethod = "POST", response = UserDTO.class, value = "/api/author", nickname = "createAuthor")
    @PostMapping(value = "/author")
    public ResponseEntity<UserDTO> createAuthor(@RequestBody UserDTO userDTO) {
        log.debug("REST request create Author: {}", userDTO);
        if (userDTO.getId() != null) {
            throw new NewEntityCannotHaveIDException(ENTITY_NAME);
        }
        User user = userMapper.userDTOToUser(userDTO);
        UserDTO result = userMapper.userToUserDTO(userService.createOrUpdate(user));
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @ApiOperation(httpMethod = "PUT", response = UserDTO.class, value = "/api/author", nickname = "updateAuthor")
    @PutMapping(value = "/author")
    public ResponseEntity<UserDTO> updateAuthor(@RequestBody UserDTO userDTO) {
        log.debug("REST request update Author: {}", userDTO);
        if (userDTO.getId() == null) {
            throw new EntityMustHaveIDException(ENTITY_NAME);
        }
        User user = userMapper.userDTOToUser(userDTO);
        UserDTO result = userMapper.userToUserDTO(userService.createOrUpdate(user));
        return new ResponseEntity<>(result, HttpStatus.NO_CONTENT);
    }

    @ApiOperation(httpMethod = "GET", response = UserDTO.class, responseContainer = "Page",
            value = "/api/author/page", nickname = "getAllAuthors")
    @GetMapping(value = "/author/page")
    public ResponseEntity<Page<UserDTO>> getAllAuthors(
            @PageableDefault(size = Integer.MAX_VALUE) Pageable pageable,
            UserFilter criteria) {
        log.debug("REST request to get all Authors");
        Page<UserDTO> result = userService.findByCriteria(criteria, pageable)
                .map(userMapper::userToUserDTO);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
