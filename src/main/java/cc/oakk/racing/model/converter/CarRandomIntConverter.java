package cc.oakk.racing.model.converter;

import cc.oakk.racing.model.Car;

import java.util.Random;

public class CarRandomIntConverter implements Converter<Car, Integer> {
    public static final int RANDOM_BOUNDS = 10;

    Random random;

    public CarRandomIntConverter() {
        this.random = new Random();
    }

    @Override
    public Integer convert(Car car) {
        return random.nextInt(RANDOM_BOUNDS);
    }
}
