package step4;

import java.util.*;
import java.util.stream.Collectors;

public class Racing {
    final Print print = new Print();
    private static final RacingRule racingRule = new RacingRule();

    public Racing(String[] carNames, int lapCount) {
        List<Car> cars = getCarReady(carNames);
        onRacing(cars, lapCount);
        print.winner(getWinnersName(cars));
    }

    private List<Car> getCarReady(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String s : carNames) {
            cars.add(new Car(s));
        }
        return cars;
    }

    private void onRacing(List<Car> cars, int lapCount) {
        print.startLap();
        racingRule.goCars(cars);
        print.racing(cars);
        lapCount--;
        if (lapCount > 0) {
            onRacing(cars, lapCount);
        }
    }

    private String getWinnersName(List<Car> cars) {
        int maxPosition = winnerPosition(cars);
        HashMap<String, Integer> carMap = (HashMap<String, Integer>) cars.stream()
                .filter(s -> s.getPosition() == maxPosition)
                .collect(Collectors.toMap(Car::getName, Car::getPosition)
                );

        Set<String> names = carMap.keySet();
        return names.stream().collect(Collectors.joining(", "));
    }

    private int winnerPosition(List<Car> cars) {
        Car macCar = cars.stream()
                .max(Comparator.comparingInt(Car::getPosition))
                .get();
        return macCar.getPosition();
    }

}
