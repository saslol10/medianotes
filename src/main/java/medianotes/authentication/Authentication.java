package medianotes.authentication;

import medianotes.context.UserContext;

import java.util.Scanner;

/**
 * javadoc
 */

//Класс аутентификации

public class Authentication {

    private static final String LOGIN = "saslol"; // констата заглавными буквами
    private static final String PASSWORD = "1234";

    // Метод возвращающий число "0" - успешно или "-1" - не успешно
    public void authenticate(){
        Scanner s = new Scanner(System.in);
        // int maxCount = 3; // количество попыток
        boolean isLoginSuccess = false; // успешно(true) или нет(false)

        //while(условия){...} //можно заменить на for
        //for(инициализация; условия; итерация){...}
        for(int maxCount = 3; maxCount>0 && !isLoginSuccess; maxCount--) {

            String login;
            String password;

            System.out.print("Login: ");
            login = s.nextLine();

            System.out.print("Password: ");
            password = s.nextLine();

            if (validate(login, password)) {
                isLoginSuccess = true;

                UserContext.setUserLogin(login);

            } else {
                System.out.println("Password is incorrect. Please try again. ");
            }
        }
            if(!isLoginSuccess){
                throw new RuntimeException("Login failed");
            }

     }
    public boolean validate(String login, String password) {

        return login.equals(LOGIN) && password.equals(PASSWORD);
    }

}
