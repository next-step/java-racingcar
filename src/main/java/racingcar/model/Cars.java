package racingcar.model;

import com.google.common.base.Strings;
import racingcar.util.NumberGenerator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    public static final String DELIMITER = "\\,";
    private List<Car> cars;

    Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(String names) {
        validateEmpty(names);
        CarsValidator.validate(names);

        List<Car> cars = createCarList(names);
        return new Cars(cars);
    }

    private static void validateEmpty(String name) {
        if (name == null || Strings.isNullOrEmpty(name.trim())) {
            throw new NameException("빈 문자열 입니다");
        }
    }

    private static List<Car> createCarList(String names) {
        String[] nameArr = names.split(DELIMITER);
        return Arrays.stream(nameArr)
                .map(name -> Car.create(name))
                .collect(Collectors.toList());
    }

    public Cars move(NumberGenerator numberGenerator) {
        for (Car car : cars) {
            car.move(numberGenerator.getNumber());
        }
        return this;
    }

    public List<Car> winningCars() {
        return cars.stream()
                .filter(car -> isMaxPosition(car))
                .collect(Collectors.toList());
    }

    public boolean isMaxPosition(Car car) {
        return Position.max() == car.getPosition();
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    @Override
    public String toString() {
        return "Cars{" + "cars=" + cars + '}';
    }
}
