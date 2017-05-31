import controller.EventController;
import dao.SqliteJDSCConnector;
import spark.Request;
import spark.Response;
import spark.template.thymeleaf.ThymeleafTemplateEngine;

import java.sql.SQLException;

import  static spark.Spark.*;
import static spark.debug.DebugScreen.enableDebugScreen;


public class Main {

    public static void main(String[] args) {
        exception(Exception.class, (e, req, res) -> e.printStackTrace());
        staticFileLocation("/public");
        port(8888);
        enableDebugScreen();
        try {
            SqliteJDSCConnector.createTables();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Always start with more specific routes
        get("/hello", (req, res) -> "Hello World");

        // Always add generic routes to the end
        get("/", EventController::renderEvents, new ThymeleafTemplateEngine());

        get("/add", EventController::addEvent, new ThymeleafTemplateEngine());
        post("/add", EventController::createEvent, new ThymeleafTemplateEngine());

        get("/edit/:id", EventController::editEvent, new ThymeleafTemplateEngine());
        post("/edit/:id", EventController::updateEvent, new ThymeleafTemplateEngine());

        get("/delete/:id", EventController::deleteEvent);

    }


}