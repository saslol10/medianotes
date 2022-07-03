package src;

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
        for(int maxCount = 3; maxCount>0 && !isLoginSuccess; maxCount--)
        {
            System.out.print("Login: ");
            var login = s.nextLine();

            System.out.print("Password: ");
            var password = s.nextLine();

            // if(условия){...}else{...}
            // .equals() - для сравнения значений строк
            // &, && - и
            // |, || - или
            if (validate(login, password)) {
                isLoginSuccess = true;
            } else {
                System.out.println("Password is incorrect. Please try again. ");
            }
        }

      }
    public boolean validate(String login, String password) {
//        Можно так:
//        if (login.equals(LOGIN) && password.equals(PASSWORD)) {
//            return true;
//        } else {
//            return false;
//        }

//        А можно так:
//        return login.equals(LOGIN) && password.equals(PASSWORD) ? true : false;

//        Но еще можно так:
        return login.equals(LOGIN) && password.equals(PASSWORD);
    }

}
