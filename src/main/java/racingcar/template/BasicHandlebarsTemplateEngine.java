package racingcar.template;

import com.github.jknack.handlebars.Helper;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.Objects;

public class BasicHandlebarsTemplateEngine extends HandlebarsTemplateEngine {
    public BasicHandlebarsTemplateEngine() {
        super();
        this.handlebars.registerHelper("repeat", (Helper<Integer>) (context, options) -> {
            if(Objects.isNull(context)){
                return "";
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < context; i++) {
                sb.append(options.fn(i + 1));
            }
            return sb.toString();
        });
    }
}
