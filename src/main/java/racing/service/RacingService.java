package racing.service;

import racing.domain.Car;
import racing.domain.Cars;
import racing.domain.Movable;
import racing.view.ResultView;

import java.util.Random;

public class RacingService {
    private static final int RANDOM_VALUE_MAX = 10;
    private static final int MOVE_CONDITION = 4;
    private static final String CARS_NAME_DELIMITER = ",";

    public void playGame(String carNames, int tryCnt) {
        Cars cars = new Cars(carNames.split(CARS_NAME_DELIMITER));
        StringBuilder stringBuilder = ResultView.getResultViewBuilder();

        stringBuilder.append(positionsToString(cars));
        for (int i = 0; i < tryCnt; i++) {
            cars.playRound(getMovable());
            stringBuilder.append(positionsToString(cars));
        }
        stringBuilder.append(ResultView.getRacingWinnersFormat(cars.getWinnersName(CARS_NAME_DELIMITER)));

        ResultView.printRacingResult(stringBuilder.toString());
    }

    private String positionsToString(Cars cars) {
        StringBuilder stringBuilder = new StringBuilder();

        for (Car car : cars.getList()) {
            stringBuilder.append(ResultView.positionToString(car));
        }
        stringBuilder.append("\n");

        return stringBuilder.toString();
    }

    private Movable getMovable() {
        return new Movable() {
            @Override
            public boolean isMovable() {
                return new Random().nextInt(RANDOM_VALUE_MAX) >= MOVE_CONDITION;
            }
        };
    }
}
