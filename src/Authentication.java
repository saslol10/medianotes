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
    public static int authenticate(){
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
            if(login.equals(LOGIN) && password.equals(PASSWORD)){
                isLoginSuccess = true;
            }
        }

        //if(isLoginSuccess){return 0;}else{return -1;} //сокращается до =>
        return isLoginSuccess ? 0 : -1; //тернарный оператор - сокращение кода

      }
}
