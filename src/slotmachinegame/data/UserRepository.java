package slotmachinegame.data;

import slotmachinegame.model.User;

import java.util.List;

public class UserRepository {

    //START SINGLETON
    private static UserRepository userRepository = new UserRepository();

    private UserRepository(){

    }

    public static UserRepository getUserRepository(){
        return userRepository;
    }

    //END SINGLETON

    List<User> users;

    public void addUser(String username){

    }

    public User getUser(String username){

        return null;
    }

    public void removeUser(){

    }
}
