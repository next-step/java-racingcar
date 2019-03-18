package racinggame.view;

import racinggame.dto.WebGameDto;
import racinggame.domain.Car;

import static racinggame.view.PrintRacing.makeCarMovementForPrint;

public class WebRacing {

    public static WebGameDto printWebRacing(Car car) {
        return new WebGameDto(car, makeCarMovementForPrint(car));
    }
}
