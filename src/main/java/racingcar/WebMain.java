package racingcar;

import racingcar.view.WebController;

import static spark.Spark.*;

public class WebMain {
    private static String[] carNames;
    private static int tryNo;

    public static void main(String[] args) {
        port(8080);

        get("/", WebController.getIndexPage());
        post("/name", WebController.getNamePage());
        get("/result", WebController.getResultPage());
    }
}
