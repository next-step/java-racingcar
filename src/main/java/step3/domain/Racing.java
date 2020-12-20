package step3.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Racing {
    private List<Car> car = new ArrayList<>();

    public void setCar(List<Car> car) {
        this.car = car;
    }

    public List<Car> getCar() {
        return car;
    }

    public List<Car> carRegistration(int createCar) {
        return Stream.generate(Car::new)
        .limit(createCar)
        .collect(toList());
    }

    public void carsMove() {
        car.forEach(s -> s.move(new CarMovingStrategy()));
    }

    public void numberOfCarMove(int moveCount) {
        IntStream.range(0,moveCount).forEach(i -> carsMove());
    }
}
