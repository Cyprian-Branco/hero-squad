import models.Hero;
import models.Squad;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;


public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());


        get("/squad/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "squad-form.hbs");
        }, new HandlebarsTemplateEngine());


        post("/squad/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String name = request.queryParams("name");
            String cause = request.queryParams("cause");
            int max_size = Integer.parseInt(request.queryParams("max_size"));
            Squad squad =  new Squad(name, cause, max_size);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        //view all the squads
        get("/squads", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Squad> squads = Squad.getInstances();
            ArrayList<Hero> heroes = Hero.getInstances();
            model.put("squads", squads);
            model.put("heroes", heroes);
            return new ModelAndView(model, "view-squad.hbs");
        }, new HandlebarsTemplateEngine());
    }
}

