package step3.model;

import step3.util.ErrorMessage;
import step3.view.ResultView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cars {

    private static final int INVALID_NUMBER_OF_CARS = 0;

    private List<Car> cars;

    public Cars(int numberOfCars) {
        // TODO : stream에서 에러내기
        invalidInput(numberOfCars);
        this.cars = Stream.generate(Car::new)
                .limit(numberOfCars)
                .collect(Collectors.toList());
    }

    void race() {
        cars.stream()
                .peek(car -> car.move(new Fuel()))
                .forEach(car -> car.accept(new ResultView()));
    }

    private static void invalidInput(int numberOfCars) {
        if(numberOfCars <= INVALID_NUMBER_OF_CARS) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT);
        }
    }




}
