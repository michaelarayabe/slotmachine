package slotmachinegame.data;

import java.util.Map;

public class PasswordRepository {
    //SINGLETON DESIGN PATTERN
    private static PasswordRepository passwordRepository = new PasswordRepository();


    private PasswordRepository(){

    }

    public static PasswordRepository getPasswordRepository(){
        return passwordRepository;
    }

    //END SINGLETON PART


    //Key: username. Value: password
    private Map<String,String> passwords;


    public void getPassword(){

    }

    public void replacePassword(){

    }

    public void removePassword(){}

    public boolean checkValidUserPassword(String username, String password){

        return false;
    }

    public boolean checkIfUserNameExists(String username){
        return false;
    }

    public void addPassword(String username, String password) {
    }
}
