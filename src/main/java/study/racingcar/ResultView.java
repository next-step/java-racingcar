package study.racingcar;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class ResultView {
    private static final int BOUND = 10;
    private static final int BASE_POINT = 4;
    private static final String CAR_DISPLAY = "-";
    private RacingGame racingGame;

    public ResultView(RacingGameData racingGameData) {
        this.racingGame = new RacingGame(racingGameData, getMovableDistance());
    }

    public void printResult() {
        List<Car> carPositions;
        System.out.println("실행 결과");
        while (racingGame.isMovable()) {
            carPositions = racingGame.move();
            print(carPositions);
        }
        String winners = racingGame.getWinner().stream()
                .map(car -> car.getName())
                .collect(Collectors.joining(","));
        System.out.println(winners + "가 최종 우승했습니다.");
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

    private MovableDistance getMovableDistance() {
        return () -> {
            int random = (new Random()).nextInt(BOUND);
            return (random >= BASE_POINT) ? 1 : 0;
        };
    }
}
