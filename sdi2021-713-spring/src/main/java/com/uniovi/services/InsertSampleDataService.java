package com.uniovi.services;

import java.util.HashSet;
import java.util.Set;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.uniovi.entities.Mark;
import com.uniovi.entities.Teacher;
import com.uniovi.entities.User;

@Service
public class InsertSampleDataService {
    @Autowired
    private UsersService usersService;
    
    @Autowired
    private RolesService rolesService;
    
    @Autowired
    private TeachersService teachersService;
    
    @PostConstruct
    public void init() {
	User user1 = new User("99999990A", "Pedro", "Pérez");
	user1.setPassword("123456");
	user1.setRole(rolesService.getRoles()[0]);
	User user2 = new User("99999991B", "PEDRITO", "SANTOS");
	user2.setPassword("123456");
	user2.setRole(rolesService.getRoles()[0]);
	User user3 = new User("99999992C", "Cristina", "Pedroche");
	user3.setPassword("123456");
	user3.setRole(rolesService.getRoles()[0]);
	User user4 = new User("99999993D", "Marta", "Almonte");
	user4.setPassword("123456");
	user4.setRole(rolesService.getRoles()[1]);
	User user5 = new User("99999977E", "Pelayo", "Valdes");
	user5.setPassword("123456");
	user5.setRole(rolesService.getRoles()[1]);
	User user6 = new User("99999988F", "Edward", "Núñez");
	user6.setPassword("123456");
	user6.setRole(rolesService.getRoles()[2]);

	User user7 = new User("11111111A", "María", "González");
	user7.setPassword("123456");
	user7.setRole(rolesService.getRoles()[0]);
	User user8 = new User("22222222B", "Sandra", "Fernández");
	user8.setPassword("123456");
	user8.setRole(rolesService.getRoles()[0]);
	User user9 = new User("33333333C", "Pablo", "Miranda");
	user9.setPassword("123456");
	user9.setRole(rolesService.getRoles()[0]);
	User user10 = new User("44444444D", "Carlos", "Gómez");
	user10.setPassword("123456");
	user10.setRole(rolesService.getRoles()[0]);
	User user11 = new User("55555555E", "Lucía", "Gutiérrez");
	user11.setPassword("123456");
	user11.setRole(rolesService.getRoles()[0]);
	
	Teacher teacher1 = new Teacher(1L, "12345678z", "John", "Doe", "Inglés");
	teacher1.setRole(rolesService.getRoles()[1]);
	Teacher teacher2 = new Teacher(2L, "87654321a", "Jane", "Doe", "Español");
	teacher2.setRole(rolesService.getRoles()[1]);
	Teacher teacher3 = new Teacher(2L, "12345671a", "Sarah", "Smith", "Ciencias");
	teacher3.setRole(rolesService.getRoles()[1]);
	Teacher teacher4 = new Teacher(2L, "12345672b", "Dylan", "Lee", "Educación física");
	teacher4.setRole(rolesService.getRoles()[1]);
	Teacher teacher5 = new Teacher(2L, "12345673c", "Marco", "Johnson", "Filosofía");
	teacher5.setRole(rolesService.getRoles()[1]);
	Teacher teacher6 = new Teacher(2L, "12345674d", "Cynthia", "Dixon", "Física");
	teacher6.setRole(rolesService.getRoles()[1]);
	Teacher teacher7 = new Teacher(2L, "12345675e", "Samara", "Hilton", "Química");
	teacher7.setRole(rolesService.getRoles()[1]);
	
	
	@SuppressWarnings("serial")
	Set<Mark> user1Marks = new HashSet<Mark>() {
	    {
		add(new Mark("Nota A1", 10.0, user1));
		add(new Mark("Nota A2", 9.0, user1));
		add(new Mark("Nota A3", 7.0, user1));
		add(new Mark("Nota A4", 6.5, user1));
	    }
	};
	user1.setMarks(user1Marks);
	@SuppressWarnings("serial")
	Set<Mark> user2Marks = new HashSet<Mark>() {
	    {
		add(new Mark("Nota B1", 5.0, user2));
		add(new Mark("Nota B2", 4.3, user2));
		add(new Mark("Nota B3", 8.0, user2));
		add(new Mark("Nota B4", 3.5, user2));
	    }
	};
	user2.setMarks(user2Marks);
	@SuppressWarnings("serial")
	Set<Mark> user3Marks = new HashSet<Mark>() {
	    {
		;
		add(new Mark("Nota C1", 5.5, user3));
		add(new Mark("Nota C2", 6.6, user3));
		add(new Mark("Nota C3", 7.0, user3));
	    }
	};
	user3.setMarks(user3Marks);
	@SuppressWarnings("serial")
	Set<Mark> user4Marks = new HashSet<Mark>() {
	    {
		add(new Mark("Nota D1", 10.0, user4));
		add(new Mark("Nota D2", 8.0, user4));
		add(new Mark("Nota D3", 9.0, user4));
	    }
	};
	
	user4.setMarks(user4Marks);
	usersService.addUser(user1);
	usersService.addUser(user2);
	usersService.addUser(user3);
	usersService.addUser(user4);
	usersService.addUser(user5);
	usersService.addUser(user6);
	usersService.addUser(user7);
	usersService.addUser(user8);
	usersService.addUser(user9);
	usersService.addUser(user10);
	usersService.addUser(user11);
	
	teachersService.addTeacher(teacher1);
	teachersService.addTeacher(teacher2);
	teachersService.addTeacher(teacher3);
	teachersService.addTeacher(teacher4);
	teachersService.addTeacher(teacher5);
	teachersService.addTeacher(teacher6);
	teachersService.addTeacher(teacher7);
    }
}
