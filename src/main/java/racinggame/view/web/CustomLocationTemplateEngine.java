package racinggame.view.web;

import spark.template.handlebars.HandlebarsTemplateEngine;

public class CustomLocationTemplateEngine extends HandlebarsTemplateEngine {
    public CustomLocationTemplateEngine() {
        super();
        handlebars.registerHelper("locations", new LocationHelper());
    }
}
