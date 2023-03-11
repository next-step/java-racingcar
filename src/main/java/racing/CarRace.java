package racing;

import java.util.*;
import java.util.stream.Collectors;

public class CarRace {

    private List<Car> cars = new ArrayList<>();

    List<Car> getCars() {
        return cars;
    }

    List<Car> getWinners() {
        int maxPosition;

//        Comparator<Car> comparatorByPosition = Comparator.comparingInt(Car::getPosition);
//        maxPosition = cars.stream().max(comparatorByPosition).orElseThrow().getPosition();

        // Comparator -> Collections 클래스를 사용한 sort 후 maxPosition 값을 구함
        Collections.sort(cars);
        maxPosition = cars.get(0).getPosition();

        return cars.stream()
                .filter(p -> p.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }


}