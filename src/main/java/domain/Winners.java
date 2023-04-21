package domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.Integer.*;

public class Winners {

    private final List<String> winners;


    public Winners(Cars cars) {
        List<Car> winners = checkCarWithFarthestDistance(cars);

        this.winners =
                List.of(winners.stream()
                .map(Car::getCarName)
                .toArray(String[]::new));
    }

    private List<Car> checkCarWithFarthestDistance(Cars cars) {
        int farthestDistance = getFarthestDistance(cars);
        return getCarsWithFarthestDistance(cars, farthestDistance);
    }

    private int getFarthestDistance(Cars cars) {
        int farthestDistance = 0;
        for (int i = 0; i < cars.countCars(); i++) {
            farthestDistance = max(farthestDistance, cars.getEachCar(i).getCarCurrentDistance());
        }
        return farthestDistance;
    }

    private List<Car> getCarsWithFarthestDistance(Cars cars , int farthestDistance) {
        return IntStream
                .range(0, cars.countCars())
                .filter(carIndex -> cars.getEachCar(carIndex).getCarCurrentDistance() == farthestDistance)
                .mapToObj(cars::getEachCar)
                .collect(Collectors.toList());
    }

    public String[] winnersName(){
        return winners.toArray(new String[winners.size()]);
    }
}
