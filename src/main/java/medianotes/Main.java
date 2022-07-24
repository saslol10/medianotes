package medianotes;

import medianotes.authentication.Authentication;
import medianotes.command.CommandReader;

/**
 * javadoc
 */

//Класс Main - содержит точку входа программы


// ctrl+b - описание класса/метода - документация
// ctrl+shift+r - replace code
public class Main {

    public static void main (String[] args){

        System.out.println("Hello, World!");
        authenticate();
        CommandReader.startReading();
    }
    private  static void authenticate(){
        Authentication authentication = new Authentication();
        authentication.authenticate();
    }
}


