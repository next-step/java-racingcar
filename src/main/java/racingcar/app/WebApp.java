package racingcar.app;

import racingcar.controller.Controller;
import racingcar.dao.CarDao;
import racingcar.view.dto.NamesRequestDto;

import static java.lang.Integer.parseInt;
import static spark.Spark.*;

public class WebApp {
    public static CarDao carDao;

    public static void main(String[] args) {
        carDao = new CarDao();

        port(8080);

        // routes
        get("/", (req, res) -> Controller.serveIndexPage());

        post("/name", (req, res) -> {
            NamesRequestDto namesRequestDto = new NamesRequestDto(req.queryParams("names"));
            return Controller.serveGamePage(namesRequestDto);
        });

        get("/result", (req, res) -> {
            Integer times = parseInt(req.queryParams("turn"));
            return Controller.serveResultPage(times);
        });
    }
}
