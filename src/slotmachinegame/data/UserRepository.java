package slotmachinegame.data;

import slotmachinegame.model.User;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class UserRepository {

    //START SINGLETON
    private static UserRepository userRepository = new UserRepository();

    private UserRepository(){
        users = new ArrayList<>();
    }

    public static UserRepository getUserRepository(){
        return userRepository;
    }

    //END SINGLETON

    private List<User> users;

    public void addUser(String username){
        User user = new User(username);
        users.add(user);
    }

    public User getUser(String username){

        for(User u : users){
            if(u.getUserName().equalsIgnoreCase(username)){
                return u;
            }
        }
        return null;
    }

    public User getUser(int index){
        return users.get(index);
    }

    public void removeUser(String username){
        User user = getUser(username);
        removeUser(user);
    }
    public void removeUser(User user){
        users.remove(user);
    }
    public void removeUser(int index){
        users.remove(index);
    }

    public void addUsers(List<User> usersToAdd){
        users.addAll(usersToAdd);
    }

    public boolean containsUser(String username){
        if(getUser(username) == null){
            return false;
        } else{
            return true;
        }
    }

    public boolean containsUser(User user){
        return users.contains(user);
    }

    public boolean isEmpty(){
        //return users.size() == 0;
        return users.isEmpty();
    }

    public int getAmountOfUsers(){
        return users.size();
    }

    public List<User> getFirstTenUsers(){
        return users.subList(0,10);
    }

    public int getIndexOfUser(User user){
        return users.indexOf(user);
    }

    public int getIndexOfUser(String username){
        return users.indexOf(getUser(username));
    }

    public void emptyList(){
        users.clear();
    }

    public void sortUsersByName(){
        users.sort(Comparator.comparing(User::getUserName));
        users.forEach(user -> System.out.println(user.getUserName()));

        users = users.stream().sorted(Comparator.comparing(User::getUserName)).collect(Collectors.toList());

    }
}
