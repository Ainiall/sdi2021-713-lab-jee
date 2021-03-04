package com.uniovi.services;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.uniovi.entities.User;
import com.uniovi.repositories.UsersRepository;

@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public List<User> getUsers() {
	List<User> users = new ArrayList<User>();
	usersRepository.findAll().forEach(users::add);
	return users;
    }

    public User getUser(Long id) {
	return usersRepository.findById(id).get();
    }

    public void addUser(User user) {
	// no se debe actualizar la contraseña de usuario
	if (user.getId() == 0) {
	    user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
	}
	usersRepository.save(user);
    }

    public User getUserByDni(String dni) {
	return usersRepository.findByDni(dni);
    }

    public void deleteUser(Long id) {
	usersRepository.deleteById(id);
    }

    public List<User> searchByNameAndLastname(String searchText) {
	List<User> users = new ArrayList<User>();
	searchText = "%" + searchText + "%";
	users = usersRepository.searchByNameAndLastname(searchText);
	return users;
    }

}