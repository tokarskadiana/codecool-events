import controller.EventController;
import spark.template.thymeleaf.ThymeleafTemplateEngine;

import  static spark.Spark.*;


public class Main {

    public static void main(String[] args) {
        exception(Exception.class, (e, req, res) -> e.printStackTrace());
        staticFileLocation("/public");
        port(8888);

        // Always start with more specific routes
        get("/hello", (req, res) -> "Hello World");

        // Always add generic routes to the end
        get("/", EventController::renderProducts, new ThymeleafTemplateEngine());
    }


}