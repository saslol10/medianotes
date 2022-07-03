package src.model;

import java.time.Instant;
import java.util.Objects;

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

    private  Folder parentFolder;
    private final String name; // название
    private String text; // содержание
    private final String author; // автор
    //Instant - тип данных для хранения дат и времени
    private final Instant creationDate; // дата создания
    private Instant updateDate; // дата изменений

//конструкторы
    /*
    public src.model.Note(String text){} // конструктор по умолчанию
    */

     public Note(String name, String text,  Folder parentFolder){
         //name = namePar;
         //this - ключевое слово, использование переменной определенной в классе
         this.parentFolder = parentFolder;

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

    public Instant getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Instant updateDate) {
        this.updateDate = updateDate;
    }

    public Folder getParentFolder() {
        return parentFolder;
    }

    public void setParentFolder(Folder parentFolder) {
        this.parentFolder = parentFolder;
    }

    //equals и hashcode всегда определяются в паре
    //метод сравнения
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;//если ссылка равна объекту о они равны
        if (o == null || getClass() != o.getClass()) return false;
        //если ссылка равна нулю - ссылка пустая или если имена классов не совпадают они не равны
        Note note = (Note) o;
        //если все параметры равны, то объекты равны
        //в данном случае достаточно только название(name)
        return Objects.equals(name, note.name);
     }

    //генерирует число хеш
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
