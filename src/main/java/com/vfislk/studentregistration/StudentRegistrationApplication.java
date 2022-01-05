package com.vfislk.studentregistration;

import com.vfislk.studentregistration.entity.Users;
import com.vfislk.studentregistration.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class StudentRegistrationApplication implements CommandLineRunner{
	@Autowired
	private UsersRepository usersRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(StudentRegistrationApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		Users users1=new Users();
		users1.setUsername("prathap");
		users1.setPassword(this.bCryptPasswordEncoder.encode("prathap"));
		users1.setRole("ROLE_NORMAL");

		Users users2=new Users();
		users2.setUsername("vamsi");
		users2.setPassword(this.bCryptPasswordEncoder.encode("vamsi"));
		users2.setRole("ROLE_ADMIN");
		usersRepository.save(users1);
		usersRepository.save(users2);
	}
}
