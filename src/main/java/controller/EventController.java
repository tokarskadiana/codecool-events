package controller;

import dao.EventDao;
import model.Event;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventController {
    static EventDao eventDao = new EventDao();

    public static ModelAndView renderEvents(Request req, Response res) {
        Map params = new HashMap<>();
        params.put("eventContainer", eventDao.getAll());
        return new ModelAndView(params, "product/index");
    }

    public static ModelAndView addEvent(Request req, Response res){
        Map params = new HashMap<>();
        return new ModelAndView(params, "product/add");
    }

    public static ModelAndView createEvent (Request req, Response res){
        Date date = null;
        for (String dateFormat : new String[]{"yyyy-MM-dd'T'HH:mm",
                "yyyy-MM-dd HH:mm"}){
            if(date==null) {
                try {
                    date = new SimpleDateFormat(dateFormat).parse(req.queryParams("date"));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }
        Event event = new Event(req.queryParams("name"),
                req.queryParams("description"),
                req.queryParams("category"),
                date);
        eventDao.add(event);
        res.redirect("/");
        return null;
    }

    public static ModelAndView editEvent(Request req, Response res){
        Map params = new HashMap<>();
        Event event = eventDao.getById(Integer.parseInt(req.params(":id")));

        params.put("event", event);
        return new ModelAndView(params, "product/edit");
    }

    public static ModelAndView updateEvent (Request req, Response res){
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(req.queryParams("date"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Event event = new Event(req.queryParams("name"),
                req.queryParams("description"),
                req.queryParams("category"),
                date);
        event.setId(Integer.parseInt(req.params(":id")));
        eventDao.update(event);
        res.redirect("/");
        return null;
    }

    public static ModelAndView deleteEvent(Request req, Response res){
        Event event = eventDao.getById(Integer.parseInt(req.params(":id")));
        eventDao.delete(event);
        res.redirect("/");
        return null;
    }

    public static ModelAndView showEvent(Request req, Response res){
        Map params = new HashMap<>();
        Event event = eventDao.getById(Integer.parseInt(req.params(":id")));

        params.put("event", event);
        return new ModelAndView(params, "product/show");
    }
}
