package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private List<Car> cars;
    private int moveCount;

    public RacingGame(InputReq inputReq) {
        this.moveCount = inputReq.getMoveCount();
        setupCar(inputReq.getCarNames());
    }

    private void setupCar(String carNames) {
        cars = new ArrayList<>();
        String[] names = carNames.split(",");
        for (String name : names) {
            cars.add(new Car(name.trim()));
        }
    }

    public void startRace() {
        for (int i = 0; i < moveCount; i++) {
            System.out.println((i + 1) + "번째횟수");
            run();
            printCarsDistance();
        }
    }

    public void run() {
        for (Car car : cars) {
            if (car.canMove()) {
                car.moveCar();
            }
        }
    }


    private void printCarsDistance() {
        for (Car car : cars) {
            printCarDistance(car);
        }
    }

    private void printCarDistance(Car car) {
        StringBuilder raceResult = new StringBuilder(car.getName() + " : ");
        for (int i = 0; i < car.getMovingDistance(); i++) {
            raceResult.append("-");
        }
        System.out.println(raceResult.toString());
    }

    public List<Car> getCars() {
        return cars;
    }

}


