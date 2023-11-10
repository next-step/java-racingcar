package racingcar.domain;

import racingcar.service.ValidationCheck;

import java.util.*;

public class Cars {

    private static final List<Car> cars = new ArrayList<>();
    private static final List<String> winners = new ArrayList<>();

    private int maxScore = 0;

    public Cars(String input) {
        addCar(input);
    }

    public static List<Car> getCarList() {
        return Collections.unmodifiableList(cars);
    }

    public String getWinners() {
        for(Car car : cars) {
            addWinner(car);
        }
        return String.join(", ", winners);
    }

    private void addCar(String input) {
        String[] names = input.split(",");

        for (int i = 0; i < names.length; i++) {
            ValidationCheck.checkInputCarName(names[i]);
            cars.add(new Car(names[i]));
        }
    }
    private void addWinner(Car input) {
        getMaxScore(cars);

        if(maxScore == input.position()) {
            winners.add(input.name());
        }
    }

    private void getMaxScore(List<Car> input) {
        for(Car car : input) {
            maxScore = Math.max(maxScore, car.position());
        }
    }
}