package src;

import java.util.Scanner;

/**
 * javadoc
 */

//Класс Main - содержит точку входа программы

public class Main {

    // public - общедоступный

    // static - можно использовать метод не создавая экземпляр класса
    // без static
    // Main main = new Main();
    // main.main();
    //
    // static int a = 5;
    // static означает переменная или метод доступен через Main.a Main.main()

    // void - ничего не возвращает

    // String[] - массив строк
    // String a = "hello";
    // String b = "hello";
    // String c = "hello";
    // String[] srv = new String[] {a, b, c}

    //Принципы SOLID - разобрать(?) рекомендации о работе с ООП языками

    public static void main (String[] args){

        // Note note1 = new Note(); // вызов конструктора
        // Конструктор - метод для создания объекта
        // Note note1 = new Note("name1", "text2"); // передаем параметры в конструктор

        // note1.text = "text";
        // note1.setText("text6");

        // аутентификация - вводим логин пароль
        // авторизация - (уже ввели логин пароль) - уровень доступа/проверка прав admin/user/moder


        // System.out.println("Hello, World!");
        // System.in - доступ к консоли
        // Scanner  - позволяет взаимодействовать с потоком данных
        // В данном случае поток данных из консоли
        // Scanner s = new Scanner(System.in);// параметр ссылка на ресурс консоли

        // тип var - автоматическое опредление типа переменной
        // var str = s.nextLine(); //.nextLine() - метод возвращает строку, которую мы введем в консоль


        int code = Authentication.authenticate();
        if(code == 0){
            System.out.print("Login success");// успешно
        }else
        {
            System.out.print("Login failed");// неуспешно
        }
    }
}
