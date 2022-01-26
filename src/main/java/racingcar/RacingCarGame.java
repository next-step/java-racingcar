package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RacingCarGame {

    private final static Random RANDOM = new Random();
    private final List<Car> cars = new ArrayList<>();
    private final List<String> carNames;
    private List<String> winners;
    private int tryCount;
    private final int MIN_MOVE = 0;
    private final int MAX_MOVE = 9;

    public RacingCarGame(int tryCount, List<String> carNames) {
        this.tryCount = tryCount;
        this.carNames = carNames;
        initializeCar();
    }

    private void initializeCar() {
        for (String carName : carNames) {
            Car car = new Car(carName);
            cars.add(car);
        }
    }

    public void play() {
        System.out.println("실행 결과");

        do {
            loadGame();

            tryCount--;

        } while (tryCount > 0);

        judgeWinner();
        printGameResult();
    }

    private int getRandomMove() {
        return MIN_MOVE + RANDOM.nextInt(MAX_MOVE - MIN_MOVE + 1);
    }

    private void loadGame() {
        for (Car car : cars) {
            int randomMove = getRandomMove();
            car.move(randomMove);

            String carName = car.getName();
            int totalMovingDistance = car.getPosition();
            printGameStatus(carName, totalMovingDistance);
        }
    }

    private int getMaxMovingDistance() {
        int maxMovingDistance = 0;

        for (Car car : cars) {
            int movingDistance = car.getPosition();
            if (maxMovingDistance < movingDistance) {
                maxMovingDistance = movingDistance;
            }
        }
        return maxMovingDistance;
    }

    private void judgeWinner() {
        int maxMovingDistance = getMaxMovingDistance();

        winners = cars.stream()
            .filter(car -> car.getPosition() == maxMovingDistance).map(Car::getName)
            .collect(Collectors.toList());
    }

    private String getDashByMove(int move) {
        StringBuilder dash = new StringBuilder();

        for (int i = 0; i < move; i++) {
            dash.append("-");
        }
        return dash.toString();
    }

    private void printGameStatus(String name, int move) {
        String dashes = getDashByMove(move);
        System.out.println(name + ":" + dashes);
    }

    private void printGameResult() {
        System.out.println("최종 우승자: " + String.join(", ", winners));
    }
}
