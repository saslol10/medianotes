package src;

import java.time.Instant;

/**
 * javadoc
 */

// Класс "Заметки"

// ctrl+b - описание класса/метода - документация

public class Note {

    // иммутабельный(неизменяемый) класс/переменная
    // final - никогда не изменится значение

    // модификаторы доступа определяют из какого участка программы доступен или недоступен
    // тот или иной параметр класса

    // private - доступен только в классе

    private final String name; // название
    private String text; // содержание
    private final String author; // автор
    //Instant - тип данных для хранения дат и времени
    private final Instant creationDate; // дата создания
    private Instant updateDate; // дата изменений



    //конструкторы
    /*
    public src.Note(String text){} // конструктор по умолчанию
    */

     public Note(String name, String text){
         //name = namePar;
         //this - ключевое слово, использование переменной определенной в классе
         this.name = name; //присваивается ссылка на область памяти
         this.text = text;

         author = null; // нет ссылки

         creationDate = Instant.now();//.now() метод текущее время/дата
     }

     //Существуют getter и setter - для получения значения или установки значение
     //Не все поля имеют setter благодаря final

     public String getName() {
        return name;
    }

     public String getText() {
        return text;
    }

     public void setText(String text) {
         this.text = text;
         this.updateDate = Instant.now();
     }

     public String getAuthor() {
        return author;
    }

     public Instant getCreationDate() {
        return creationDate;
    }
}
