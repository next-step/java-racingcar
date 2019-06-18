package step2.domain;

import step2.utils.MoveIndicator;
import step2.utils.RandomNumberGenerator;
import step2.view.OutputView;

import java.util.List;

public class RaceExecutor {

    private List<Car> cars;
    private RandomNumberGenerator randomNumberGenerator;
    private MoveIndicator moveIndicator;

    public RaceExecutor(List<Car> cars) {
        this.cars = cars;
        this.randomNumberGenerator = new RandomNumberGenerator();
        this.moveIndicator = new MoveIndicator();
    }

    public void executeTrials(int numberOfTrials) {
        for (int i = 0; i < numberOfTrials; i++) {
            moveCars();
        }
    }

    private void moveCars() {
        for (Car car : this.cars) {
            moveIfPossible(car);
        }
        new OutputView(this.cars); // TODO: 결과화면을 여기서 생성하는 것이 어색한데 문제 없을지 궁금합니다.
    }

    private void moveIfPossible(Car car) {
        if (moveIndicator.canMove(randomNumberGenerator)) {
            car.move();
        }
    }
}
