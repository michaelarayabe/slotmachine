package slotmachinegame.data;

import java.util.*;

public class PasswordRepository {
    //SINGLETON DESIGN PATTERN
    private static PasswordRepository passwordRepository = new PasswordRepository();


    private PasswordRepository(){

        this.passwords = new HashMap<>();
    }

    public static PasswordRepository getPasswordRepository(){
        return passwordRepository;
    }

    //END SINGLETON PART


    //Key: username. Value: password
    private Map<String,String> passwords;


    public void addPassword(String username, String password) {

        passwords.put(username,password);
    }

    public String getPassword(String username){
        return passwords.get(username);
    }

    public void replacePassword(String username, String oldPassword, String newPassword){
        passwords.replace(username, oldPassword, newPassword);
    }

    public void removePassword(String username){
        passwords.remove(username);
    }

    public void removePassword(String username, String password){
        passwords.remove(username, password);

    }

    public boolean checkValidUserPassword(String username, String password){
        return getPassword(username).equals(password);

    }

    public boolean checkIfUserNameExists(String username){
        return passwords.containsKey(username);
    }

    //Just for practice not really handy method
    public boolean checkIfPasswordAlreadyExists(String password){
        return passwords.containsValue(password);
    }

    public Set<String> getAllUsernames(){
        return passwords.keySet();
    }

    public Collection<String> getAllPasswords(){
        return passwords.values();
    }

    public Set<Map.Entry<String,String>> getAllUsernameAndPasswordCombinations(){
        return passwords.entrySet();
    }

    public void addDefaultPasswordIfNoPasswordIsPresent(String username){
        passwords.computeIfAbsent(username, e->username + new Random().nextInt(1000));
    }

    public void printMap(){
        passwords.forEach((username, password) -> System.out.println(username + " " + password));
        passwords.entrySet().forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));
    }
}
