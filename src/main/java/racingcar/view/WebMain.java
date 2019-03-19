package racingcar.view;

import static spark.Spark.get;
import static spark.Spark.staticFiles;

public class WebMain {
    public static void main(String[] args) {
        staticFiles.location("/templates");
        get("/", (req, res) -> "Hello World");
    }
}
