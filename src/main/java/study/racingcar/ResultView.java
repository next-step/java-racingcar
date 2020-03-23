package study.racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final String CAR_DISPLAY = "-";
    private static final String START_GAME_DISPLAY = "실행 결과";
    private static final String WINNER_DISPLAY = "%s가 최종 우승했습니다.";
    private RacingGame racingGame;

    public ResultView(RacingGameData racingGameData) {
        this.racingGame = new RacingGame(racingGameData, new RandomMovableDistance());
    }

    public void printResult() {
        List<Car> carPositions;
        System.out.println(START_GAME_DISPLAY);
        while (racingGame.isMovable()) {
            carPositions = racingGame.move();
            print(carPositions);
        }
        String winners = racingGame.getWinner().stream()
                .map(Car::getName)
                .collect(Collectors.joining(","));
        System.out.println(String.format(WINNER_DISPLAY, winners));
    }

    private void print(List<Car> carPositions) {
        String displayCar;
        for (Car car : carPositions) {
            displayCar = new String(new char[car.getPosition()])
                    .replace("\0", CAR_DISPLAY);
            System.out.println(car.getName() + ":" + displayCar);
        }

        System.out.println();
    }
}
