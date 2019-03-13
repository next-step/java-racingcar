package racing.view;

import racing.domain.Car;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WebView {
    public static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }

    public static String makeWinnerNameString(List<Car> winners) {
        String winnersName = "";
        for (Car car : winners) {
            winnersName += car.getName();
            winnersName += ",";
        }
        winnersName = winnersName.substring(0, winnersName.length() - 1);
        return winnersName;
    }

    public static void setView(Car car) {
        List<Integer> moves = new ArrayList<>();
        for (int i = 0; i < car.getTotalDistance(); i++) {
            moves.add(1);
        }
        car.setMoves(moves);
    }
}
