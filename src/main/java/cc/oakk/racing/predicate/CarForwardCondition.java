package cc.oakk.racing.predicate;

import cc.oakk.racing.Car;
import cc.oakk.racing.converter.Converter;

import java.util.function.Predicate;

public class CarForwardCondition<T> {
    private Predicate<T> predicate;
    private Converter<Car, T> carConverter;

    public CarForwardCondition(Predicate<T> predicate, Converter<Car, T> carConverter) {
        if (predicate == null) {
            throw new IllegalArgumentException("condition is null!");
        }

        if (carConverter == null) {
            throw new IllegalArgumentException("carConverter is null!");
        }

        this.predicate = predicate;
        this.carConverter = carConverter;
    }

    public boolean isCarFowardable(Car car) {
        T convertedCar = carConverter.convert(car);
        return predicate.test(convertedCar);
    }
}
