package racinggame;

import racinggame.domain.RacingGame;
import racinggame.domain.RacingResult;
import racinggame.view.InputView;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import util.StringUtils;

import java.util.*;

import static racinggame.view.InputView.WEB_CARNAME_DELIMETER;
import static spark.Spark.*;

public class WebRacingGameLauncher {

    public static void main(String[] args) {

        port(8080);

        staticFiles.location("/templates");

        get("/", (req, res) -> {
            return renderIndex();
        });

        post( "/name", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<String> carNames = getCarNames(req.queryParams("names"));
            req.session().attribute(req.ip(), carNames);
            model.put("carNames", carNames);
            return render(model, "game.html");
        });

       get( "/result", (req, res) -> {
           List<String> carNames = req.session().attribute(req.ip());

           if( StringUtils.isEmpty(carNames) ) {
               return renderIndex();
           }

           int numberOfTries = Integer.parseInt(req.queryParams("numberOfTries"));

           RacingGame racingGame = new RacingGame(carNames, numberOfTries);

           RacingResult result = new RacingResult(racingGame.getCars());
           for( int i = 0; i < numberOfTries; ++i ) {
               racingGame.proceed(result);
           }

           Map<String, Object> model = new HashMap<>();
           model.put("result", result);

           req.session().removeAttribute(req.ip());
           return render(model, "result.html");
        });

    }

    private static Object renderIndex() {
        return render(null, "index.html");
    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }

    private static List<String> getCarNames(String names) {
        return Arrays.asList(InputView.getCarNames(names, WEB_CARNAME_DELIMETER));
    }
}