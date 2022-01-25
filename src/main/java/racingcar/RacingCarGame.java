package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RacingCarGame {

    private final static Random RANDOM = new Random();
    private final List<Car> cars = new ArrayList<>();
    private final List<String> carNames;
    private final List<Integer> racingResults = new ArrayList<>();
    private List<String> winners;
    private int tryCount;

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
            moveCars();

            tryCount--;

        } while (tryCount > 0);

        judgeWinner();
        printGameResult();
    }

    private int getRandomMove() {
        final int MIN_MOVE = 0;
        final int MAX_MOVE = 9;
        return MIN_MOVE + RANDOM.nextInt(MAX_MOVE - MIN_MOVE + 1);
    }

    private void moveCars() {
        for (Car car : cars) {
            int distance = getRandomMove();
            String carName = car.getName();

            car.move(distance);

            int totalMovingDistance = car.getMovingDistance();

            printGameStatus(carName, totalMovingDistance);
        }
    }

    private int getMaxMovingDistance() {
        int maxMovingDistance = 0;

        for (Car car : cars) {
            int movingDistance = car.getMovingDistance();
            if (maxMovingDistance < movingDistance) {
                maxMovingDistance = movingDistance;
            }
        }
        return maxMovingDistance;
    }

    private void judgeWinner() {
        int maxMovingDistance = getMaxMovingDistance();

        winners = cars.stream()
            .filter(car -> car.getMovingDistance() == maxMovingDistance).map(Car::getName)
            .collect(Collectors.toList());
    }

    private boolean checkMovable(int move) {
        final int MOVABLE = 4;
        return MOVABLE <= move;
    }

    private void printGameStatus(String name, int move) {
        System.out.println(name + ":" + move);
    }

    private void printGameResult() {
        System.out.println("최종 우승자: " + String.join(", ", winners));
    }
}
