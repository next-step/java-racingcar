package racingcar;

import static spark.Spark.*;

public class WebMain {
    public static void main(String[] args) {
        port(8080);

        get("/helloworld", (req, res) -> {
            return "Hello World";
        });
    }
}
