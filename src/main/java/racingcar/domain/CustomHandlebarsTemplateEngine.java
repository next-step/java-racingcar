package racingcar.domain;

import racingcar.helper.ForHelper;
import spark.template.handlebars.HandlebarsTemplateEngine;

public class CustomHandlebarsTemplateEngine extends HandlebarsTemplateEngine {
    public CustomHandlebarsTemplateEngine() {
        super();
        this.handlebars.registerHelper(ForHelper.HELPER_NAME, new ForHelper());
    }
}
