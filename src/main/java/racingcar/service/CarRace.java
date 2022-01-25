package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.RacingCar;

public class CarRace {

    private final List<RacingCar> racingCars;

    public CarRace(List<String> carName) {
        racingCars = getRacingCars(carName);
    }

    public List<RacingCar> getRacingCars(List<String> carName) {
        List<RacingCar> cars = new ArrayList<>();
        for (String name : carName) {
            cars.add(new RacingCar(name));
        }
        return cars;
    }

    public void moveForwardAll() {
        for (RacingCar car : racingCars) {
            car.moveForward();
        }
    }

    public void printRacing() {
        racingCars.forEach(System.out::println);
    }

    public void printWinner() {
        int maxPosition = maxPosition();
        List<String> winners = getWinners(maxPosition);
        System.out.print("최종 우승자: " + String.join(", ", winners));
    }

    private int maxPosition() {
        return racingCars.stream()
            .mapToInt(RacingCar::getPosition)
            .max().getAsInt();
    }

    private List<String> getWinners(int maxPosition) {
        return racingCars.stream()
            .filter(car -> car.getPosition() == maxPosition)
            .map(RacingCar::getName)
            .collect(Collectors.toList());
    }
}

