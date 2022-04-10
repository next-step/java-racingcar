package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Cars {
    private final List<Car> cars;

    public Cars(List<Car> input) {
        List<Car> cars = new ArrayList<>(input);
        validate(cars);
        this.cars = cars;
    }

    private void validate(List<Car> input) {
        Objects.requireNonNull(input, "전달된 리스트가 올바르지 않습니다 : Cars is null");

        if (input.isEmpty()) {
            throw new IllegalArgumentException("전달된 리스트가 올바르지 않습니다 : Cars is empty");
        }
    }

    public void play() {
        for(Car car : cars) {
            car.move();
        }
    }

    public void print() {
        for(Car car : cars) {
            int state = car.state();
            for(int i=0; i<state; i++){
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }
}
