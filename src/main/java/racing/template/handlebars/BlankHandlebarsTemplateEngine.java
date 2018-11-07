package racing.template.handlebars;

import spark.template.handlebars.HandlebarsTemplateEngine;

/**
 * 공백 만들어주는 기능 추가
 */
public class BlankHandlebarsTemplateEngine extends HandlebarsTemplateEngine {
    public BlankHandlebarsTemplateEngine() {
        super();
        this.handlebars.registerHelper("toBlank", new BlankHelper());
    }
}
