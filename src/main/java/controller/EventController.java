package controller;

import dao.EventDao;
import model.Event;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventController {
    public static ModelAndView renderProducts(Request req, Response res) {
        EventDao eventDao = new EventDao();
        Map params = new HashMap<>();
        params.put("eventContainer", eventDao.getAll());
        return new ModelAndView(params, "product/index");
    }
}
