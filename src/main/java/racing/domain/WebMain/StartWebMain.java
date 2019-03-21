package racing.domain.WebMain;

import static spark.Spark.*;
import static spark.Spark.get;
import static spark.Spark.post;

import racing.controller.NameController;
import racing.controller.ResultController;

public class StartWebMain {

    public static void main(String[] args) {
        port(8080);
        staticFileLocation("/templates");
        router();
    }

    public static void router() {
        post("/name", NameController::post);
        get("/result", ResultController::get);
    }

}

