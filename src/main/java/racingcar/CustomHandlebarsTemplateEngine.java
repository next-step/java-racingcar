package racingcar;

import spark.template.handlebars.HandlebarsTemplateEngine;

public class CustomHandlebarsTemplateEngine extends HandlebarsTemplateEngine {
    public CustomHandlebarsTemplateEngine() {
        super();
        this.handlebars.registerHelper(BlankHelper.NAME ,new BlankHelper());
    }
}
