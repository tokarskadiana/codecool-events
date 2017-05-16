package model;


import java.util.Calendar;
import java.util.Date;

public class Event {
    private Integer id;
    private String name;
    private String description;
    private String category;
    private Date date;

    public Event(String name, String description,
                 String category, Date date){
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

    public Date getDate() {
        return date;
    }
    public void setId(Integer id) {
        this.id = id;
    }

}
