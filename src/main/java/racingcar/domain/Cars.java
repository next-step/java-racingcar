package racingcar.domain;

import racingcar.service.MoveStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cars {
    private final List<Car> cars;

    public Cars(Cars cars) {
        this.cars = deepCopy(cars);
    }

    public Cars() {
        this.cars = new ArrayList<>();
    }

    public Cars(String names) {
        this.cars = generateCars(parseCarNames(names));
    }

    public Cars(int[] locations, Name[] names) {
        this.cars = generateCars(locations, names);
    }

    public void move(MoveStrategy moveStrategy) {
        for (int i = 0; i < getSize(); i++) {
            this.cars.get(i).move(moveStrategy.getIsMove());
        }
    }

    private Name[] parseCarNames(String tmpCarNames) {
        String[] carNames = tmpCarNames.split(",");
        List<Name> names = new ArrayList<>();
        for (String name : carNames) {
            names.add(new Name(name));
        }
        return names.toArray(new Name[names.size()]);
    }

    public List<Car> getCars() {
        return cars;
    }

    public Cars winners() {
        int winnerLocation = winnerLocation();
        Cars winners = findWinners(winnerLocation);
        return winners;
    }

    private int winnerLocation() {
        int winnerLocation = 0;
        for (Car car : this.cars) {
            winnerLocation = car.bigLocation(winnerLocation);
        }
        return winnerLocation;
    }

    private Cars findWinners(int winnerLocation) {
        Cars winnerCars = new Cars();
        cars.stream().forEach(car -> {
            winnerCars.addWinners(car, winnerLocation);
        });
        return winnerCars;
    }

    private void addWinners(Car car, int winnerLocation) {
        if (car.isSame(winnerLocation)) {
            cars.add(car);
        }
    }

    private int getSize() {
        return cars.size();
    }

    private List<Car> deepCopy(Cars cars) {
        List<Car> copiedCars = new ArrayList<>();
        for (Car car : cars.getCars()) {
            copiedCars.add(new Car(car));
        }
        return copiedCars;
    }

    private List<Car> generateCars(Name[] names) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            cars.add(new Car(names[i]));
        }
        return cars;
    }

    private List<Car> generateCars(int[] locations, Name[] names) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            cars.add(new Car(locations[i], names[i]));
        }
        return cars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Cars cars1 = (Cars) o;
        return Objects.equals(cars, cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}


