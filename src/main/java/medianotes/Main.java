package medianotes;

import medianotes.command.CommandReader;
import medianotes.repository.NoteRepository;
import medianotes.repository.impl.NoteRepositoryImpl;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

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
