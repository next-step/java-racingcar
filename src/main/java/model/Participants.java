package model;

import java.util.List;
import java.util.stream.Collectors;

public class Participants {
    private final List<Car> carList;

    public Participants(List<Car> carList) {
        this.carList = carList;
    }


    public List<Car> getWinner() {
        int maxPosition = carList.stream()
            .mapToInt(Car::getCurrentPosition)
            .max()
            .orElse(0);

        return carList.stream()
            .filter(car -> car.getCurrentPosition() >= maxPosition)
            .collect(Collectors.toList());
    }

    public void moveAll() {
        for (Car car : this.carList) {
            car.tryMove();
        }
    }

    public List<Car> getParticipantList() {
        return this.carList;
    }
}
