package racing.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Cars {
    private static final String NAME_SEPARATOR = ",";
    private static final int MAX_BOUND = 10;

    private List<Car> cars = new ArrayList<>();

    public Cars() {
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Cars run() {
        for(Car car: cars) {
            car.move(getRandomNum());
        }
        return this;
    }

    private RandomNumber getRandomNum() {
        Random random = new Random();
        return new RandomNumber(random.nextInt(MAX_BOUND));
    }

    public List<Car> getCars() {
        return cars;
    }

    public Cars generateCarsWithName(String names) {
        String[] carNames = names.split(NAME_SEPARATOR);
        for(String name: carNames) {
            cars.add(new Car(name));
        }
        return this;
    }


    private int getMaxPosition() {
        int maxPosition = 0;
        for(Car car: cars) {
            maxPosition = car.max(maxPosition);
        }
        return maxPosition;
    }

    public Cars findWinner() {
        List<Car> winners = new ArrayList<>();
        int maxPosition = getMaxPosition();
        for(Car car: cars) {
            if(car.isWinner(maxPosition)){
                winners.add(car);
            }
        }
        return new Cars(winners );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cars cars1 = (Cars) o;

        return Objects.equals(cars, cars1.cars);
    }

    @Override
    public int hashCode() {
        return cars != null ? cars.hashCode() : 0;
    }

    public String getNames() {
        return cars.stream()
                .map(it -> it.getName().toString()).collect(Collectors.joining(NAME_SEPARATOR));
    }

    @Override
    public String toString() {
        return "Cars{" +
                "cars=" + cars +
                '}';
    }
}
