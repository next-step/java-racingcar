package racing.model;

import java.util.*;

public class Cars {

    private static final String COMMA_CHARACTER = ",";
    private static final String DUPLICATE_NAME_MESSAGE = "중복된 이름이 있습니다.";
    private final List<Car> racingCars = new ArrayList<>();

    public Cars createCars(String inputNameOfCar) {
        inputNameOfCar = inputNameOfCar.trim();
        Set<String> noDuplicateNames = isDuplication(inputNameOfCar);
        for (String name : noDuplicateNames) {
            Car car = new Car(name);
            racingCars.add(car);
        }
        return this;
    }

    public Set<String> isDuplication(String inputCarNames) {
        String[] carNames = inputCarNames.split(COMMA_CHARACTER);
        Set<String> noDuplicateNames = new HashSet<>();
        for (String carName : carNames) {
            noDuplicateNames.add(carName);
        }

        if (noDuplicateNames.size() != carNames.length) {
            throw new IllegalArgumentException(DUPLICATE_NAME_MESSAGE);
        }

        return noDuplicateNames;
    }

    public int countOfCars() {
        return racingCars.size();
    }

    public void race(List<Integer> randomValues) {
        int countOfCars = countOfCars();
        for (int i = 0; i < countOfCars; i++) {
            int randomValue =  randomValues.get(i);
            racingCars.get(i).move(randomValue);
        }
    }

    public Car getCar(int i) {
        return racingCars.get(i);
    }

    public String getWinners() {
        int countOfCars = countOfCars();
        int winnerPosition = -1;
        StringBuilder winners = new StringBuilder();
        for (int i = 0; i < countOfCars; i++) {
            Car car = racingCars.get(i);
            winners = car.printWinners(winners, winnerPosition);
            winnerPosition = car.comparePositionWith(winnerPosition);
        }
        return winners.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars = (Cars) o;
        return Objects.equals(racingCars, cars.racingCars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(racingCars);
    }
}
