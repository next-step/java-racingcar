package racing.view;

import static racing.common.RacingSettings.*;

import racing.common.Script;
import racing.vo.Cars;

import java.util.stream.IntStream;

public class ResultView {
    public void printMovingStatus(Cars cars) {
        cars.getCars().forEach(car -> {
            System.out.print(car.getName() + CAR_STATUS_SEPARATOR.getValue());
            IntStream.range(MOVING_START_COUNT.getValue(), car.getPosition())
                .forEach(i -> System.out.print(CAR_MOVING_SIGN.getStr()));
            System.out.println();
        });
    }
    
    public void printWinners(String winnerNames) {
        System.out.println(winnerNames + Script.WINNER_PRINT_SCRIPT.getMessage());
    }
}
