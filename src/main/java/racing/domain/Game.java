package racing.domain;

import racing.view.Output;

import java.util.*;
import java.util.stream.Collectors;

public class Game {
    private final List<Car> attendedCars;
    private final RandomGenerator randomGenerator;

    public Game() {
        this(new ArrayList<>());
    }

    public Game(List<Car> attendedCars) {
        this.attendedCars = attendedCars;
        this.randomGenerator = new RandomGenerator();
    }

    public List<Car> getAttendedCars() {
        return attendedCars;
    }

    public void createAttendedCarsWithName(String nameOfCar) {
        String[] splittedName = nameOfCar.split(",");

        for (String name: splittedName) {
            attendedCars.add(new Car(name));
        }
    }

    public void playGame(int numberOfAttempts) {
        if (numberOfAttempts < 0) {
            throw new IllegalArgumentException("시도할 횟수는 음수가 될 수 없습니다.");
        }

        System.out.println("실행 결과");
        for (int i = 0; i < numberOfAttempts; i++) {
            this.playSession();
            Output.showSessionStatus(this);
        }
    }

    public List<Car> getWinners() {
        int maxNum = this.getWinnerLocation();

        return this.attendedCars.stream()
                .filter(car -> car.isSameLocation(maxNum))
                .collect(Collectors.toList());
    }

    private int getWinnerLocation() {
        return attendedCars.stream()
                .mapToInt(Car::getCurrentLocation)
                .max().orElse(-1);
    }

    private void playSession() {
        for (Car car : attendedCars) {
            car.move(randomGenerator.getRandomMovePoint());
        }
    }
}
