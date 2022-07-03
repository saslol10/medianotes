package src;

import src.command.CommandReader;
import src.repository.NoteRepository;
import src.repository.impl.NoteRepositoryImpl;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * javadoc
 */

//Класс Main - содержит точку входа программы

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
