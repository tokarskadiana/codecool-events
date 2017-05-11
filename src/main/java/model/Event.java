package model;


import java.util.Date;

public class Event {
    private Integer id;
    private String name;
    private String description;
    private String category;
    private Date date;

    Event(Integer id, String name, String description,
          String category, Date date){
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

    public Date getDate() {
        return date;
    }

}
