package racing.controller;

import racing.dto.User;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.*;
import java.util.stream.Stream;

public class NameController {
    private static final String TEMPLATE_NAME = "/game.html";

    public static String post(Request req, Response res) {
        List<User> users = new ArrayList<>();
        Stream<String> stream = Arrays.stream(req.queryParams("names").split(" "));
        stream.forEach(name -> users.add(new User(name)));

        Map<String, Object> model = new HashMap<>();
        model.put("users", users);

        return new HandlebarsTemplateEngine().render(new ModelAndView(model, TEMPLATE_NAME));
    }
}
