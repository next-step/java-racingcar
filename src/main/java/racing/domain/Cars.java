package racing.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars){
        this.cars = cars;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public void advanceCars(GameCondition gameCondition) {
        cars.forEach(car -> car.advance(gameCondition));
    }

    public int getWinnerDistance(){
        return cars.stream()
                .mapToInt(Car::getNumberOfAdvance)
                .max()
                .orElse(0);
    }

    public List<String> getWinnerNames(){
        int winnerDistance = getWinnerDistance();
        return cars.stream()
                .filter(car -> car.getNumberOfAdvance() == winnerDistance)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
