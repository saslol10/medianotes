package src;

import java.util.Scanner;

public class Authentication {

    private  static final  String LOGIN = "saslol";
    private  static final  String PASSWORD = "1234";

    public static int authenticate(){
        Scanner s = new Scanner(System.in);
//      int maxCount = 3;
        boolean isLoginSuccess = false;


        for(int maxCount = 3; maxCount>0 && !isLoginSuccess; maxCount--)
        {
            System.out.print("Login: ");
            var login = s.nextLine();

            System.out.print("Password: ");
            var password = s.nextLine();

            if(login.equals(LOGIN) && password.equals(PASSWORD)){
                isLoginSuccess = true;
            }
        }
        return isLoginSuccess ? 0 : -1; //тернарный оператор??? сокращение кода

      }
}
