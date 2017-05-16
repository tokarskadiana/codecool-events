package dao;

import model.Event;
import org.thymeleaf.util.DateUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;


public class EventDao {

    public List<Event> getAll() {
        List<Event> events = new ArrayList<>();
        try {
            Statement statement = SqliteJDSCConnector.makeConnection().createStatement();
            ResultSet rs = statement.executeQuery("SELECT * from events");
            while(rs.next()){
                Event event = new Event(
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getString("category"),
                        rs.getDate("date"));
                event.setId(rs.getInt("id"));
                events.add(event);
            }
        } catch (SQLException e) {
            System.out.println("Connection failed");
            e.printStackTrace();
        }
        return events;

    }

    public void add(Event event){
        //add to data base
    }
}
