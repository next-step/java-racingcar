package step5.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    List<RacingCar> carList = new ArrayList<>();

    public RacingGame() {}

    public List<RacingCar> getCarList() {
        return carList;
    }

    public void addRacingCar(RacingCar car) {
        carList.add(car);
    }

    public int getMaxPosition() {
        return carList
                .stream()
                .max(Comparator.comparing(RacingCar::getPosition))
                .get().getPosition();
    }

    public String getWinner() {
        int maxPosition = getMaxPosition();

        List<String> winners = carList.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList())
                .stream()
                .map(RacingCar::getCarName)
                .collect(Collectors.toList());

        return String.join(", ", winners);
    }
}
