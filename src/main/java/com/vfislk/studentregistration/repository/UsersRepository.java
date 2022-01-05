package com.vfislk.studentregistration.repository;

import com.vfislk.studentregistration.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users,String> {
   public Users findByUsername(String username);
}
