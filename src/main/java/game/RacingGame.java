package game;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    public final Integer POINT_FORWARD = POINT;

    public final static Integer POINT = 4;

    /**
     * 4단계 - 자동차 경주
     * @param cars
     * @param numberOfAttempts
     */
    public void racingGameStart(List<Car> cars, int numberOfAttempts) {
        int tryCount = 0;

        for (int i = 0; i < numberOfAttempts; i++) {
            racing(cars, numberOfAttempts, tryCount);
            tryCount++;
        }

        ResultRacingPlayer.create().racingResultWithPlayer(cars,numberOfAttempts);

        ResultRacingPlayer.create().printWinner(findWinner(cars));
    }

    /**
     * 자동차 경주
     * @param cars
     * @param numberOfAttempts
     * @param tryCount
     */
    private void racing(List<Car> cars, int numberOfAttempts, int tryCount) {

        int movePosition = 0;

        for (Car car : cars) {
            movePosition = RandomNumberStrategy.create().move(numberOfAttempts);
            car.setMaxPosition(movePosition);
            Position position = Position.create(tryCount, movePosition);
            car.addPosition(position);
        }

    }

    /**
     * 자동차 경주 우승자
     * @return
     */
    public List<Car> findWinner(List<Car> cars) {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Integer.max(maxPosition, car.getMaxPosition());
        }

        int finalMaxPosition = maxPosition;

        List<Car> winner = cars.stream()
                .filter(car -> car.getMaxPosition() == finalMaxPosition)
                .collect(Collectors.toList());

        return winner;
    }

    public static RacingGame create() {
        return new RacingGame();
    }
}
