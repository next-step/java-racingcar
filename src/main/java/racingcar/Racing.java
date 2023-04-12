package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Racing {
    private final int numberOfCars;
    private final int numberOfRaces;

    public Racing(int numberOfCars, int numberOfRaces) {
        this.numberOfCars = numberOfCars;
        this.numberOfRaces = numberOfRaces;
    }

    public void excute() {
        List<Car> cars = new ArrayList<>();

        IntStream.range(0, numberOfCars)
                .forEach(i -> cars.add(new Car()));

        IntStream.range(0, numberOfRaces).forEach(i -> {
            IntStream.range(0, numberOfCars)
                    .forEach(j -> cars.get(j).move());
            System.out.println("");
        });
    }
}
