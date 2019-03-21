package racingcar.util;

import spark.template.handlebars.HandlebarsTemplateEngine;

public class CustomTemplateEngine extends HandlebarsTemplateEngine {
    public CustomTemplateEngine() {
        super();
        handlebars.registerHelper("repeat", (context, options) -> {
            String result = "";
            for (int i = 0; i < Integer.parseInt(context.toString()); i++) {
                result += options.fn();
            }
            return result;
        });
    }
}
