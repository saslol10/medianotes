package src;

import java.util.Scanner;

public class Main {

   public static void main (String[] args){
       //    src.Note note1 = new src.Note("name1","text1");
       //    note1.setText("text6");

       //аутентификация
       //авторизация

       /*
       System.out.println("Hello, World!");
       Scanner s = new Scanner(System.in);

       var str = s.nextLine();
       */
        int code = Authentication.authenticate();
        if(code == 0){
            System.out.print("Login success");
        }else
        {
            System.out.print("Login failed");
        }

   }
}
