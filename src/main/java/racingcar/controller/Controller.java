package racingcar.controller;

import racingcar.service.Service;
import racingcar.view.dto.NamesRequestDto;
import racingcar.view.dto.ResultResponseDto;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

public class Controller {
    private static Service service = new Service();

    public static String serveIndexPage() {
        return render(null, "index.html");
    }

    public static String serveGamePage(NamesRequestDto namesRequestDto) {
        Map<String, Object> model = new HashMap<>();
        model.put("cars", service.createCars(namesRequestDto));
        return render(model, "game.html");
    }

    public static String serveResultPage(Integer times) {
        Map<String, Object> model = new HashMap<>();
        model.put("cars", service.playRacingGame(times));
        model.put("namesOfWinners", new ResultResponseDto(service.produceResult()));
        return render(model, "result.html");
    }

    private static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
