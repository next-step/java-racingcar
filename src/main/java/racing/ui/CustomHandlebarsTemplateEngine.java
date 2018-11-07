package racing.ui;

import com.github.jknack.handlebars.Helper;
import com.github.jknack.handlebars.Options;
import com.github.jknack.handlebars.helper.StringHelpers;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.io.IOException;

public class CustomHandlebarsTemplateEngine extends HandlebarsTemplateEngine implements Helper<Integer> {

    public CustomHandlebarsTemplateEngine() {
        super();
        handlebars.registerHelper("times", this);
        handlebars.registerHelper("join", StringHelpers.join);
    }

    @Override
    public Object apply(Integer time, Options options) throws IOException {
        Options.Buffer buffer = options.buffer();
        for (int idx = 0; idx < time; idx++) {
            buffer.append(options.apply(options.fn));
        }

        return buffer;
    }
}