package step5.domain;

import step5.view.Print;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Racing {
    final Print print = new Print();
    private static final RacingRule RACING_RULE = new RacingRule();

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
        RACING_RULE.goCars(cars);
        print.racing(cars);
        lapCount--;
        if (lapCount > 0) {
            onRacing(cars, lapCount);
        }
    }

    public static String getWinnersName(List<Car> cars) {
        int maxPosition = winnerPosition(cars);
        HashMap<String, Integer> carMap = (HashMap<String, Integer>) cars.stream()
                .filter(s -> s.getPosition() == maxPosition)
                .collect(Collectors.toMap(Car::getName, Car::getPosition)
                );

        Set<String> names = carMap.keySet();
        return String.join(", ", names);
    }

    private static int winnerPosition(List<Car> cars) {
        return cars.stream().mapToInt(Car::getPosition).max().orElse(0);
    }

}
