package com.co.SpringSecurityDemo.service;

import com.co.SpringSecurityDemo.model.User;
import com.co.SpringSecurityDemo.model.UserPrincipal;
import com.co.SpringSecurityDemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if(user == null){
            System.out.println("User not found!");
            throw new UsernameNotFoundException("User not found");
        }
        return new UserPrincipal(user);
    }
}
