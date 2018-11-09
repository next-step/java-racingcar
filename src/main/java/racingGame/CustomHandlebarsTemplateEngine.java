package racingGame;

import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CustomHandlebarsTemplateEngine extends HandlebarsTemplateEngine {
    private static final String SYMBOL_POSITION = "&#128652;";
    private static final String SYMBOL_LEAVED_POSITION = "&nbsp;";

    public CustomHandlebarsTemplateEngine() {
        super();
        handlebars.registerHelpers(this);
    }

    public String trace(int position) {
        String leavedTrace = IntStream.range(1, position).mapToObj(i -> SYMBOL_LEAVED_POSITION).collect(Collectors.joining());
        return leavedTrace + SYMBOL_POSITION;
    }

    public String join(List<String> values) {
        return String.join(",", values);
    }
}
