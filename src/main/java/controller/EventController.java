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

    public static boolean createEvent (Request req, Response res){
        Date date = null;
        try {
            date = new SimpleDateFormat("dd/mm/YYYY").parse(req.queryParams("date"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Event event = new Event(req.queryParams("name"),
                req.queryParams("description"),
                req.queryParams("category"),
                date);
        eventDao.add(event);
        res.redirect("/");
        return true;
    }
}
