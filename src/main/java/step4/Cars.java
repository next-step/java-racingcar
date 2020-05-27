package step4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cars {

    private static final String RANKED_STRING_DELIMITER = ",";

    private List<Car> cars = new ArrayList<>();

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void setupCars(String[] carsNames, CarMoveStrategy carMoveStrategy) {
        Arrays.stream(carsNames).forEachOrdered(name ->
                cars.add(new Car(name, 0, carMoveStrategy)));
    }

    public String getWinners() {

        Optional<Car> max = cars.stream().max((o1, o2) -> (o1.getLocation() >= o2.getLocation()) ? 1 : -1);
        Stream<Car> ranked = cars.stream().filter(o -> o.getLocation() == max.get().getLocation());
        String winners = ranked.map(Car::getCarName).collect(Collectors.joining(RANKED_STRING_DELIMITER));

        return winners;
    }

    public void move() {
        cars.stream().forEach(car -> {
            car.move();
        });
    }

    public void printCurrentLocation() {
        cars.stream().forEachOrdered(car -> {
            System.out.println(car.getCarName() + "\t\t : "
                    + new String(new char[car.getLocation()]).replace("\0", "-"));
        });
    }

}
