package racinggame.controller;

import racinggame.domain.WebRacing;

import static spark.Spark.port;

public class RacingWebGame {

    public static void main(String[] args) {
        WebRacing webRacing = new WebRacing();
        port(8080);

        webRacing.inputNameByGet();
        webRacing.inputTryGameByPost();
        webRacing.playGameByGet();
    }
}
