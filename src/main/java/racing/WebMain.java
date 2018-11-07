package racing;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jetty.util.UrlEncoded;

import racing.domain.RacingGame;
import racing.domain.RacingRanking;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

public class WebMain {

    public static void main(String[] args) {

        webServerConfigure();

        routes();
    }

    private static void routes() {
        get("/", (req, res) -> {
            res.removeCookie("cars");
            return render(null, "index.html");
        });

        post("/name", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            String names = req.queryParams("names");
            res.cookie("cars", UrlEncoded.encodeString(names));
            model.put("cars", names.split(" "));
            return render(model, "game.html");
        });

        get("/result", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            
            int times = Integer.parseInt(req.queryParams("turn"));
            String names = UrlEncoded.decodeString(req.cookie("cars"));

            RacingGame racingGame = new RacingGame(times, names.split(" "));
            
            while (!racingGame.isFinish()) {
                racingGame.move();
            }
            
            RacingRanking racingRanking = new RacingRanking(racingGame.getResultOfTheGame());
            
            model.put("gameResults", racingGame.getResultOfTheGame());
            model.put("winners", String.join(", ", racingRanking.getWinners()));
            return render(model, "result.html");
        });
    }

    private static void webServerConfigure() {
        port(8080);
    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
