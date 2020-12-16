package step3.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Racing {

    public List<Car> car = new ArrayList<>();
    public static int INPUT_NUMBER_OF_MOVE = 0;
    public static int INPUT_NUMBER_OF_CAR_CREATE = 0;

    private int randomNumber() {
        Random random = new Random();
        return random.nextInt(10);
    }

    public List<Car> carRegistration(int INPUT_NUMBER_OF_CAR_CREATE) {
        IntStream.range(0,INPUT_NUMBER_OF_CAR_CREATE).forEach(i -> car.add(new Car()));

        return car;
    }

    public void carsMove() {
        car.forEach(s -> s.move(randomNumber()));
    }

    public void numberOfCarMove() {
        for(int i = 0; i< INPUT_NUMBER_OF_MOVE; i++)
            carsMove();
    }
}
