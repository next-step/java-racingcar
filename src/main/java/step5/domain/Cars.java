package step5.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars = new ArrayList<>();
    private Map<String, Integer> carsMap = new HashMap<>();

    public Cars(final String names) {
        for (String carName : names.split(",")) {
            cars.add(new Car(carName));
        }
    }

    public Cars(List<Car> carList) {
        this.cars = carList;
    }

    public List<Car> getCars() {
        return cars;
    }

    public Map<String, Integer> eachRoundMove() {
        for (Car car : cars) {
            carsMap.put(car.getName(),  car.getPosition());
        }
        return carsMap;
    }

    public String finalWinner() {
        List<String> winner = new ArrayList<>();
        int max = getMaxPosition();

        carsMap.forEach(
                (name, position) -> {
                    if(position >= max) {
                        winner.add(name);
                    }
                }
        );
        String winners = winner.stream().collect(Collectors.joining(","));
        return winners;
    }

    private int getMaxPosition() {
        int max = carsMap.values()
                .stream()
                .mapToInt(Integer::intValue)
                .max().getAsInt();
        return max;
    }

}
