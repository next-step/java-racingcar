package racingGame.domain;

import racingGame.exception.NotWinnerException;
import racingGame.factory.CarFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> namingCars = new ArrayList<>();

    public List<Car> getCars() {
        return Collections.unmodifiableList(namingCars);
    }

    public List<String> findCoWinner() {
        return namingCars.stream()
                .filter(car -> car.getTraceSize() == getMaxPosition())
                .map(Car::getCarName)
                .collect(Collectors.toList());
    }


    private long getMaxPosition() {
        return getMaxCar().getTraceSize();
    }

    public void addNewCar(InputValue inputValue, CarFactory carFactory) {
        for (int i = 0; i < inputValue.getCarsSize(); i++) {
            Car car = carFactory.createCar(inputValue.getCarName().get(i));
            namingCars.add(car);
        }
    }

    private Car getMaxCar() throws NotWinnerException {
        return namingCars.stream().max(Comparator.comparing(Car::getTraceSize)).orElseThrow(() ->new NotWinnerException("우승자가 없습니다."));
    }

}
