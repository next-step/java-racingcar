package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static view.ResultView.WINNERS_DELIMITER;

public class Cars {
    private final List<Car> cars;

    public Cars(CarNames carNames) {
        this.cars = from(carNames);
    }

    private static List<Car> from(CarNames carNames) {
        List<Car> cars = new ArrayList<>();
        for (String username : carNames.names()) {
            cars.add(new Car(new CarName(username)));
        }
        return cars;
    }

    public void race(NumberGenerator numberGenerator) {
        for (Car car : this.cars) {
            car.move(numberGenerator.generate());
        }
    }

    public Map<String, Integer> positionByName() {
        return this.cars.stream()
                .collect(Collectors.toMap(Car::name, Car::position));
    }

    public List<String> winners() {
        int maxPosition = calculateMaxPosition();
        return this.cars.stream()
                .filter(it -> it.position() == maxPosition)
                .map(Car::name)
                .collect(Collectors.toUnmodifiableList());
    }

    private int calculateMaxPosition() {
        return this.cars.stream()
                .map(Car::position)
                .max(Integer::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("우승자 위치를 찾을 수 없습니다."));
    }

    public static void printResult(Cars cars) {
        Map<String, Integer> positionByName = cars.positionByName();
        int maxPosition = positionByName.values().stream()
                .max(Integer::compareTo)
                .orElseThrow(IllegalArgumentException::new);
        String winners = positionByName.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == maxPosition)
                .map(Map.Entry::getKey)
                .collect(Collectors.joining(WINNERS_DELIMITER));
        System.out.println(winners + "가 최종 우승했습니다.");
    }
}
