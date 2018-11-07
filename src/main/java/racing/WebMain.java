package racing;

import racing.config.CustomHandlebarsTemplateEngineConfiguration;
import racing.domain.Car;
import racing.rule.Forward;
import racing.utils.CarRacingUtils;
import racing.utils.StringUtils;
import spark.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static spark.Spark.*;

public class WebMain {

    public static void main(String[] args) {

        port(8080);

        get("/", (request, response1) -> {
            final Map<String, Object> model = new HashMap<>();
            return render(model, "/index.html");
        });

        post("/name", (request, response) -> {

            final String[] splitNames = StringUtils.split(request.queryParams("names"), " ");

            final Map<String, Object> model = new HashMap<>();
            model.put("names", splitNames);

            return render(model, "/game.html");
        });

        post("/result", (request, response) -> {

            final String turn = request.queryParams("turn");
            final String[] names = request.queryParamsValues("names");

            final Game racing = new Racing(String.join(",", names), Integer.valueOf(turn), new Forward());
            while (racing.hasTryCount()) {
                racing.start();
            }

            final List<Car> cars = racing.getCars();

            final Map<String, Object> model = new HashMap<>();
            model.put("cars", cars);
            model.put(
                    "winner",
                    CarRacingUtils.findWinnders(cars)
                            .stream()
                            .map(Car::getName)
                            .collect(Collectors.joining(", "))
            );

            return render(model, "/result.html");
        });
    }

    public static String render(final Map<String, Object> model, final String templatePath) {
        return new CustomHandlebarsTemplateEngineConfiguration().render(new ModelAndView(model, templatePath));
    }

}
