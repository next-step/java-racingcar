package racingcar.template;

import spark.ModelAndView;

import java.util.Map;

public class TemplateEngine {

    private TemplateEngine() {

    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new BasicHandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }

    public static String render(String templatePath) {
        return render(null, templatePath);
    }
}
