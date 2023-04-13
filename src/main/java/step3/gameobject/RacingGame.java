package step3.gameobject;

import step3.gameobject.rule.RaceRule;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private final List<Car> carList = new ArrayList<>();

    public RacingGame(List<String> nameList, RaceRule raceRule) {
        for (String name : nameList) {
            carList.add(new Car(name, raceRule));
        }
    }

    public List<String> race() {
        List<String> resultList = new ArrayList<>();
        for (Car car : carList) {
            car.goOrStop();
            resultList.add(car.getNowRacingResult());
        }
        return resultList;
    }

    private int getMaxLength() {
        return carList
                .stream()
                .mapToInt(car -> car.getTrace().length())
                .max()
                .orElseThrow();
    }

    public List<String> getWinner() {
        return carList
                .stream()
                .filter(car -> car.getTrace().length() == getMaxLength())
                .map(Car::getName)
                .collect(Collectors.toList());
    }

}