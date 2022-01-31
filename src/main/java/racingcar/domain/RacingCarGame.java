package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import racingcar.view.ResultView;

public class RacingCarGame {

    private final static Random RANDOM = new Random();
    private final static ResultView resultView = new ResultView();
    private final static Referee referee = new Referee();
    private List<Car> cars;
    private final List<String> carNames;
    private int tryCount;
    private final int MIN_MOVE = 0;
    private final int MAX_MOVE = 9;

    public RacingCarGame(int tryCount, List<String> carNames) {
        this.tryCount = tryCount;
        this.carNames = carNames;
        cars = makeCarsByCarNames();
    }

    private List<Car> makeCarsByCarNames() {
        List<Car> cars = new ArrayList<>();

        for (String carName : carNames) {
            Car car = new Car(carName);
            cars.add(car);
        }
        return cars;
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

    private int getRandomMove() {
        return MIN_MOVE + RANDOM.nextInt(MAX_MOVE - MIN_MOVE + 1);
    }

    private void loadGame() {
        for (Car car : cars) {
            int randomMove = getRandomMove();
            car.move(randomMove);

            String carName = car.getName();
            int totalMovingDistance = car.getPosition();
            resultView.printGameStatus(carName, totalMovingDistance);
        }

        System.out.println();
    }

}
