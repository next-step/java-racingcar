package step2;

import java.util.List;

public class RaceExecutor {
    private final static int MOVE_CRITERION = 4;

    private List<Car> cars;
    private RandomNumberGenerator randomNumberGenerator;

    public RaceExecutor(List<Car> cars) {
        this.cars = cars;
        this.randomNumberGenerator = new RandomNumberGenerator();
    }

    public void executeTrials(int numberOfTrials) {
        for (int i = 0; i < numberOfTrials; i++) {
            moveCars();
        }
    }

    private OutputView moveCars() {
        for (Car car : this.cars) {
            decideMoveOrNot(car);
        }
        return new OutputView(this.cars); // TODO: 결과화면을 여기서 반환하는 것이 어색한데 문제없을지 궁금합니다.
    }

    private void decideMoveOrNot(Car car) {
        if (canMove()) {
            car.move();
        }
    }

    private boolean canMove() {
        final int randomNumber = randomNumberGenerator.getRandomNumber();
        if (randomNumber >= MOVE_CRITERION) {
            return true;
        }
        return false;
    }
}
