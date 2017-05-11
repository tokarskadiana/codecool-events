package model;


import java.util.Calendar;

public class Event {
    private Integer id;
    private String name;
    private String description;
    private String category;
    private Calendar date;

    public Event(Integer id, String name, String description,
                 String category, Calendar date){
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public Calendar getDate() {
        return date;
    }

}
