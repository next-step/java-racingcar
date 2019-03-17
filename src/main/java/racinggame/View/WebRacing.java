package racinggame.View;

import racinggame.DTO.WebGame;
import racinggame.domain.Car;

public class WebRacing {

    public static WebGame printWebRacing(Car car) {
        return new WebGame(car, makeRacingForWeb(car));
    }

    public static String makeRacingForWeb(Car car) {
        StringBuilder viewRacing = new StringBuilder();

        for (int i = 0; i < car.getCountMoving(); i++) {
            viewRacing.append("-");
        }

        return String.valueOf(viewRacing);
    }
}
