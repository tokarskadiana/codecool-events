package dao;

import model.Event;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;


public class EventDao {

    public List<Event> getAll() {
        List<Event> events = new ArrayList<>();
        events.add(new Event(1, "Codecool cinema",
                "Cinema evening",
                "Culture",
                new GregorianCalendar(2017, 6, 15)));
        events.add(new Event(2, "Codecool hakaton",
                "24 hours of codding",
                "Android developing",
                new GregorianCalendar(2017, 6, 1)));
        return events;
    }
}
