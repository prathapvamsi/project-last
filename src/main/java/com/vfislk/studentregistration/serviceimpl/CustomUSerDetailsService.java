package com.vfislk.studentregistration.serviceimpl;

import com.vfislk.studentregistration.entity.CustomUserDetails;
import com.vfislk.studentregistration.entity.Users;
import com.vfislk.studentregistration.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUSerDetailsService implements UserDetailsService {
    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = this.usersRepository.findByUsername(username);
        if (users == null) {
           throw new UsernameNotFoundException("NOT FOUND");
        }
        return new CustomUserDetails(users);
    }

}


