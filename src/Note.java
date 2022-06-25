package src;

import java.time.Instant;

/**
 * javadoc
 */
public class Note {

    private final String name;
    private String text;
    private final String author;
    private final Instant creationDate;//Instant - тип данных для хранения дат и времени
    private Instant updateDate;
    //конструкторы
   /*
   public src.Note(String text){
   }//конструктор по умолчанию
   */

    public Note(String name, String text){
        this.name = name;
        this.text = text;
        author = null;
        creationDate = Instant.now();//.now() метод текущее время/дата
    }

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
