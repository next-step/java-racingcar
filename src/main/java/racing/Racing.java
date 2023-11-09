package racing;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Racing {

    public Racing() {
    }

    public List<Car> generateNamedCar(RaceInfo raceInfo) {
        String[] names = raceInfo.nameData();
        return Arrays.stream(names).map(Car::new).collect(Collectors.toList());
    }

    public void goRacing(List<Car> cars, RaceInfo raceInfo) {
        RandomMoveCondition moveCondition = new RandomMoveCondition();
        race(cars, raceInfo, moveCondition);
    }

    private void race(List<Car> cars, RaceInfo raceInfo, RandomMoveCondition moveCondition) {
        for (int i = 0; i < raceInfo.trialData(); i++) {
            drive(cars, moveCondition);
        }
    }

    public void drive(List<Car> cars, MoveCondition moveCondition) {
        cars.forEach(car -> {
            car.move(moveCondition);
        });
    }

    public List<String> winner(List<Car> cars) {
        int maxDistance = cars.stream()
                .mapToInt(Car::carDistance)
                .max().orElseThrow(NoSuchElementException::new);

        return cars.stream()
                .filter(car -> car.equalDistance(maxDistance))
                .map(Car::carName)
                .collect(Collectors.toList());
    }
}
