package step5.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
 * Cars
 * ver. 1.0
 * 2020.05.28
 * Copyright ...
 */
public class Cars {

    private static final String RANKED_STRING_DELIMITER = ",";

    private List<Car> carsList = new ArrayList<>();

    private Cars() {
    }

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

     public List<Car> getCarsList() {
        return carsList;
    }

}
