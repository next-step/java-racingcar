package study.racing4;

import java.util.ArrayList;
import java.util.List;

public class CarRacing {

    private final List<Car> cars;
    private final int lastRound;
    private final MovingStrategy moveable;

    private int currentRound = 0;

    public CarRacing(RacingInput racingInput, MovingStrategy moveable) {
        this.cars = initRacingRecords(racingInput.getCars());
        this.lastRound = racingInput.getCountOfRound();
        this.moveable = moveable;
    }

    private List<Car> initRacingRecords(String[] carNames) {

        List<Car> cars = new ArrayList<>();

        for (String name : carNames) {
            cars.add(new Car(name));
        }

        return cars;
    }

    public boolean isProcessAbleRound() {
        return (currentRound < lastRound);
    }

    public void processRound() {

        if (!isProcessAbleRound()) {
            throw new RuntimeException("더 이상 라운드를 진행 할 수 없습니다.");
        }

        for (Car car : cars) {
            carMoving(car);
        }
        currentRound++;
    }

    private void carMoving(Car car) {
        if (moveable.moveable()) {
            car.move();
        }
    }

    public List<Car> getCars() {
        return cars;

    }

}
