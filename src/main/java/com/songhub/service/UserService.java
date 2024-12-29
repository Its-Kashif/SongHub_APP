package com.songhub.service;

import com.songhub.entity.User;

public interface UserService {
	public void saveUser(User user);

	public boolean validateCredential(String email, String password);

	public Object getRole(String email);

	public boolean isPremium(String email);

	public User getUser(String mail);

	public void updateUser(User user);

}
