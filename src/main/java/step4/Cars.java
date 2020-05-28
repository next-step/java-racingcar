package step4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cars {

    private static final String RANKED_STRING_DELIMITER = ",";

    private List<Car> carsList = new ArrayList<>();

    public static Cars of(String[] carNames, CarMoveStrategy carMoveStrategy) {

        Cars cars = new Cars();
        Arrays.stream(carNames).forEachOrdered(name -> {
            cars.carsList.add(new Car(name, 0, carMoveStrategy));
        });

        return cars;
    }


    public String getWinners() {

        Optional<Car> max = carsList.stream().max((o1, o2) -> (o1.getLocation() >= o2.getLocation()) ? 1 : -1);
        Stream<Car> ranked = carsList.stream().filter(o -> o.getLocation() == max.get().getLocation());
        String winners = ranked.map(Car::getCarName).collect(Collectors.joining(RANKED_STRING_DELIMITER));

        return winners;
    }

    public void move() {
        carsList.stream().forEach(Car::move);
    }

    public void printCurrentLocation() {
        carsList.stream().forEachOrdered(car -> {
            System.out.println(car.getCarName() + "\t\t : "
                    + new String(new char[car.getLocation()]).replace("\0", "-"));
        });
    }

}
