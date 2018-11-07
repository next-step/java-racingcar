package racing.config;

import spark.template.handlebars.HandlebarsTemplateEngine;

public class CustomHandlebarsTemplateEngineConfiguration extends HandlebarsTemplateEngine {
    public CustomHandlebarsTemplateEngineConfiguration() {
        super();
        this.handlebars.registerHelper("repeat", new RepeatHelper());
    }
}