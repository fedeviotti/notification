package it.fedeviotti.rest.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import it.fedeviotti.rest.pojo.User;

public class UsersDB {
	
    private static UsersDB instance;

    private final ArrayList<User> USERS;

    //dammi oggetto singolo
    public static UsersDB getInstance() {
        
        if (instance == null) {
            
            instance = new UsersDB();
        }
        return instance;
    }
    
    private UsersDB() {
        USERS = new ArrayList<User>();
        User user = new User();
        user.setUsername("Federico");
        user.setCreationTime(new Date());
        user.setAccessToken("o.LCGcUVrNpgSKWNQ7MRrt6Ny1NGaKAtL9");
        USERS.add(user);
    }
    
    public User get(int index) {
        return USERS.get(index);
    }
    
    public ArrayList<User> getAll(){
    	return USERS;
    }
    
    public void add(User user) {
    	USERS.add(user);
    }
    
    public User get(String username){
    	
    	Iterator<?> iterator = USERS.iterator();
		
		while( iterator.hasNext() ) {
			
			User user = (User)iterator.next();
			if (user.getUsername().equals(username)) {
				return user;
			}
			
		}
		return null;

    }

}
