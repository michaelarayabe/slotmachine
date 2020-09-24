package slotmachinegame.view;

import slotmachinegame.config.SessionsSetting;
import slotmachinegame.data.PasswordRepository;
import slotmachinegame.data.UserRepository;
import slotmachinegame.model.User;

import java.util.Scanner;

public class Identifier {

    private static Scanner scanner = new Scanner(System.in);
    private static PasswordRepository passwordRepository = PasswordRepository.getPasswordRepository();
    private static UserRepository userRepository = UserRepository.getUserRepository();


    public static void identifyUser(){
        User user;
        while(true) {
            System.out.println("Do you want to login or sign up? [Login/Sign Up]");
            String userResponse = scanner.nextLine();

            if (userResponse.equalsIgnoreCase("Login")) {
                user = login();
                break;
            } else if (userResponse.equalsIgnoreCase("Register")) {
                user = register();
                break;
            } else {
                System.out.println("Please use valid response!");
            }
        }
        SessionsSetting.currentUser = user;

    }

    public static User register(){
        while(true) {
            System.out.println("What is your User Name?");
            String username = scanner.nextLine();

            System.out.println("What is your password?");
            String password = scanner.nextLine();

            System.out.println("Please confirm password");
            String confirmedPassword = scanner.nextLine();

            if (password.equalsIgnoreCase(confirmedPassword)) {
                boolean alreadyExists = passwordRepository.checkIfUserNameExists(username);
                if(alreadyExists){
                    System.out.println("User name already exists");
                }else{
                    userRepository.addUser(username);
                    passwordRepository.addPassword(username, password);
                    return userRepository.getUser(username);
                }
            } else {
                System.out.println("Password is not the same as confirmed password");
            }
        }

    }

    public static User login(){
        while(true) {
            System.out.println("What is your User Name?");
            String username = scanner.nextLine();

            System.out.println("What is your password?");
            String password = scanner.nextLine();

            boolean isValid = passwordRepository.checkValidUserPassword(username, password);

            if (isValid) {
                return userRepository.getUser(username);
            } else {
                System.out.println("user and pass combo don't exist");
            }
        }
    }
}
