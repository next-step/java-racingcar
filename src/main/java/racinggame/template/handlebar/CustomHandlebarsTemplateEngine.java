package racinggame.template.handlebar;

import racinggame.template.handlebar.helper.RepeatHelper;
import spark.template.handlebars.HandlebarsTemplateEngine;

public class CustomHandlebarsTemplateEngine extends HandlebarsTemplateEngine {
    public CustomHandlebarsTemplateEngine() {
        super();
        this.handlebars.registerHelper("repeat", new RepeatHelper());
    }
}