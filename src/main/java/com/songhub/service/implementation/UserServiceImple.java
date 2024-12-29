package com.songhub.service.implementation;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.songhub.entity.User;
import com.songhub.repository.UserRepository;
import com.songhub.service.UserService;
import com.songhub.entity.User;

@Service
public class UserServiceImple implements UserService {
	
	@Autowired
	UserRepository userRepo;




	@Override
	public void saveUser(User user) {
		User existingUser=userRepo.findByEmail(user.getEmail());
		if(existingUser!=null) {
			System.out.println("Duplicate Entry");
			
		}
		else {
			userRepo.save(user);
		}
		
	}




	@Override
	public boolean validateCredential(String email, String password) {
		User user=userRepo.findByEmail(email);
		if(user!=null) {
			
			if(user.getPassword().equals(password)) {
				return true;
			}	
		}
		return false;	
	}




	@Override
	public Object getRole(String email) {
		User user = userRepo.findByEmail(email);
		return user.getRole();
		
	}
	
	@Override
	public boolean isPremium(String email) {
		User user=userRepo.findByEmail(email);
		if(user!=null) {
			return user.isPremium();
		}
		return false;
	}



	//Implementation of the user that called from payment controller 
	@Override
	public User getUser(String mail) {
		User user=userRepo.findByEmail(mail);
		return user;
	}




	//Implementation of the user that called from payment controller 
		@Override
		public void updateUser(User user) {
			userRepo.save(user);
			
		}

}
