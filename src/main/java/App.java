import models.Hero;
import models.Squad;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import sun.nio.cs.HistoricallyNamedCharset;

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

        //view individual squad details
        get("/squads/:id", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int squadId = Integer.parseInt(request.params(":id"));
            Squad eachSquad = Squad.findById(squadId);
            model.put("squad", eachSquad);
            return new ModelAndView(model, "viewSquadDetails.hbs");
        }, new HandlebarsTemplateEngine());

        get("/squads/:id/update", ((request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int squadIdToEdit = Integer.parseInt(request.params("id"));
            Squad updateSquad = Squad.findById(squadIdToEdit);
            model.put("updateSquad", updateSquad);
            return new ModelAndView(model, "squad-form.hbs");
        }), new HandlebarsTemplateEngine());

        //fetch heroes details from form
        get("/squads/:id/heroes/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int squadId = Integer.parseInt(request.params(":id"));
            Squad eachSquad = Squad.findById(squadId);
            model.put("squad", eachSquad);
            return new ModelAndView(model, "heroes.hbs");
        }, new HandlebarsTemplateEngine());


        //update heroes properties
        post("/squads/:id/heroes/new", (request, response) -> {
            Map<Object, String>model = new HashMap<>();
            String name = request.queryParams("name");
            int age = Integer.parseInt(request.queryParams("age"));
            String specialPower = request.queryParams("specialPower");
            String weakness = request.queryParams("weakness");
            int squadId = Integer.parseInt(request.queryParams(":id"));
            Hero newHero = new Hero(name, age, specialPower, weakness, squadId);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        //display all the heroes
        get("/squads/:id/heroes", (request, response) -> {
            Map<Object, String> model = new HashMap<>();
            int squadId = Integer.parseInt(request.params(":id"));
            Squad eachSquad = Squad.findById(squadId);
            model.put("heroes", eachSquad.getSquadMembers());
            return new ModelAndView(model, "view-heroes.hbs");
        }, new HandlebarsTemplateEngine());
    }
}

