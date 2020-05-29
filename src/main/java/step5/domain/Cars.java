package step5.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private static final String RANKED_STRING_DELIMITER = ",";

    private List<Car> carsList = new ArrayList<>();

    public static Cars of(String[] carNames, int location, CarMoveStrategy carMoveStrategy) {

        Cars cars = new Cars();
        Arrays.stream(carNames).forEachOrdered(name -> {
            cars.carsList.add(new Car(name, location, carMoveStrategy));
        });

        return cars;
    }


    public String getWinners() {
        int maxLocation = carsList.stream().map(Car::getLocation).max(Integer::compareTo).orElse(0); // 기본값 최소위치
        return carsList.stream().filter(car -> car.getLocation() == maxLocation)
                .map(car -> car.getCarName()).collect(Collectors.joining(RANKED_STRING_DELIMITER));
    }

    public void move() {
        carsList.forEach(Car::move);
    }


    public void printCurrentLocation() {
        carsList.stream().forEachOrdered(car -> {
            System.out.println(car.getCarName() + "\t\t : "
                    + new String(new char[car.getLocation()]).replace("\0", "-"));


        });
    }

    public List<Car> getCarsList() {
        return carsList;
    }

}
