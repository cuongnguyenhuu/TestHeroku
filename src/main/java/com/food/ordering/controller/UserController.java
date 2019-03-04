package com.food.ordering.controller;

import java.net.URI;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.food.ordering.entity.Food;
import com.food.ordering.entity.Role;
import com.food.ordering.entity.User;
import com.food.ordering.exception.AppException;
import com.food.ordering.payload.ApiResponse;
import com.food.ordering.payload.JwtAuthenticationResponse;
import com.food.ordering.payload.LoginRequest;
import com.food.ordering.payload.SignUpRequest;
import com.food.ordering.repository.RoleRepository;
import com.food.ordering.repository.UserRepository;
import com.food.ordering.security.JwtTokenProvider;
import com.food.ordering.service.UserService;

@RestController
@RequestMapping("/account")
public class UserController {
	
	@Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;
    
    @Autowired
    UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtTokenProvider tokenProvider;
    
    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsernameOrEmail(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
    }
    
    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
        if(userRepository.existsByUsername(signUpRequest.getUsername())) {
            return new ResponseEntity(new ApiResponse(false, "Username is already taken!"),
                    HttpStatus.BAD_REQUEST);
        }


        // Creating user's account
        User user = new User( signUpRequest.getUsername(),
                signUpRequest.getPassword(),true);

        user.setPassword_encode(passwordEncoder.encode(user.getPassword_encode()));

        Role userRole = roleRepository.findByRoleName("user")
                .orElseThrow(() -> new AppException("User Role not set."));

        user.setRole(userRole);

        User result = userRepository.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/api/users/{username}")
                .buildAndExpand(result.getUsername()).toUri();

        return ResponseEntity.created(location).body(new ApiResponse(true, "User registered successfully"));
    }
    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
       // System.out.println(tokenProvider.));
        if (auth != null){    
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "success";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
    }
    
    
    @GetMapping("/users")
	public ResponseEntity<User> getAll(){
		return new ResponseEntity(userService.getAllUser(),HttpStatus.OK);
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id")Integer id){
		if(userService.findUserById(id)==null) {
			return new ResponseEntity("Item not found",HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(userService.findUserById(id),HttpStatus.OK);
	}
	
	@PostMapping("users/addUser")
	public ResponseEntity<User> addUser(@RequestBody User user){
		return new ResponseEntity(userService.createUser(user),HttpStatus.OK);
	}
	
	@PutMapping("users/{id}/update")
	public ResponseEntity<User> update(@PathVariable("id")Integer id,@RequestBody User user){
		if(userService.findUserById(id)==null) {
			return new ResponseEntity("Item not found",HttpStatus.NOT_FOUND);
		}
		else return new ResponseEntity(userService.createUser(user),HttpStatus.OK);
	}

	@DeleteMapping("user/{id}")
	public ResponseEntity<User> delete(@PathVariable("id")Integer id){
		if(userService.deleteUser(id)) {
			return new ResponseEntity("Delete "+id+" success",HttpStatus.OK);
		}
		else
			return new ResponseEntity("Delete "+id+" false",HttpStatus.BAD_REQUEST);
	}
}
