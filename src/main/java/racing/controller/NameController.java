package racing.controller;

import racing.dto.User;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NameController {
    private static final String TEMPLATE_NAME = "/game.html";

    public static String get(Request req, Response res) {
        return null;
    }

    public static String post(Request req, Response res) {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < req.queryParams("names").split(" ").length; i++) {
            users.add(new User(req.queryParams("names").split(" ")[i]));
        }

        Map<String, Object> model = new HashMap<>();
        model.put("users", users);

        return new HandlebarsTemplateEngine().render(new ModelAndView(model, TEMPLATE_NAME));
    }
}
