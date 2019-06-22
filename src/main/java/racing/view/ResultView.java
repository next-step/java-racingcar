package racing.view;

import racing.common.Script;
import racing.domain.Cars;
import racing.domain.MovingHistory;
import racing.domain.RacingResult;

import java.util.stream.IntStream;

public class ResultView {
    private final static String CAR_STATUS_SEPARATOR = " : ";
    private final static String CAR_MOVING_SIGN = "-";
    private final static int MOVING_START_COUNT = 0;
    
    public void printResult(RacingResult racingResult) {
        printMovingStatus(racingResult.getMovingHistory());
        printWinners(racingResult.getWinnerNames());
    }
    
    private void printMovingStatus(MovingHistory movingHistory) {
        movingHistory.getMovingHistory().forEach(this::printMovingStatus);
    }
    
    private void printMovingStatus(Cars cars) {
        cars.getCars().forEach(car -> {
            System.out.print(car.getName() + CAR_STATUS_SEPARATOR);
            IntStream.range(MOVING_START_COUNT, car.getPosition())
                .forEach(i -> System.out.print(CAR_MOVING_SIGN));
            System.out.println();
        });
    }
    
    private void printWinners(String winnerNames) {
        System.out.println(winnerNames + Script.WINNER_PRINT_SCRIPT.getMessage());
    }
}
