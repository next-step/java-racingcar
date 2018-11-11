package racingcar.view;

import spark.template.handlebars.HandlebarsTemplateEngine;

public class CustomHandlebarsTemplate extends HandlebarsTemplateEngine {
    private static final String CAR_ROUTE_HTML = "&nbsp;";
    private static final String CAR_FINAL_HTML = "&#128652;";

    public CustomHandlebarsTemplate() {
        super();
        handlebars.registerHelpers(this);
    }

    public String MoveStatus(int position) {
        String str = "";
        for(int i = 0; i < position; i++){
            str += CAR_ROUTE_HTML;
        }

        return str + CAR_FINAL_HTML;
    }

}
