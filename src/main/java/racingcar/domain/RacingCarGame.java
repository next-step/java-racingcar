package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import racingcar.view.ResultView;

public class RacingCarGame {

    private final static int MIN_MOVE = 0;
    private final static int MAX_MOVE = 9;
    private final static Random RANDOM = new Random();
    private final List<Car> cars;
    private final List<String> carNames;
    private int tryCount;

    public RacingCarGame(List<String> carNames, int tryCount) {
        this.carNames = carNames;
        this.tryCount = tryCount;
        cars = makeCarsByCarNames();
    }

    public void play() {
        System.out.println("실행 결과");

        do {
            loadGame();

            tryCount--;

        } while (tryCount > 0);
    }

    public List<Car> getCars() {
        return cars;
    }

    private List<Car> makeCarsByCarNames() {
        List<Car> cars = new ArrayList<>();

        for (String carName : carNames) {
            Car car = new Car(carName);
            cars.add(car);
        }
        return cars;
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
            ResultView.printGameStatus(carName, totalMovingDistance);
        }

        System.out.println();
    }
}
