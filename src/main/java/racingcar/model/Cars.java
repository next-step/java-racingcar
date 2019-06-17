package racingcar.model;

import racingcar.util.NumberGenerator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cars {

    private List<Car> cars;

    Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(String names) {
        CarsValidator.validate(names);

        String[] namesArr = parseArrays(names);
        List<Car> cars = Arrays.stream(namesArr)
                .map(name -> Car.create(name))
                .collect(Collectors.toList());
        return new Cars(cars);
    }

    private static String[] parseArrays(String names) {
        String noBlackNames = names.replace(" ", "");
        String[] namesArr = noBlackNames.split("\\,");
        CarsValidator.validateCount(namesArr.length);
        return namesArr;
    }

    public static Cars newInstance(int count) {
        CarsValidator.validateCount(count);
        List<Car> cars = IntStream.range(0, count).mapToObj(value -> Car.create()).collect(Collectors.toList());
        return new Cars(cars);
    }

    Cars moveAll(NumberGenerator numberGenerator) {
        for (Car car : cars) {
            car.move(numberGenerator.getNumber());
        }
        return this;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    @Override
    public String toString() {
        return "Cars{" + "cars=" + cars + '}';
    }
}
