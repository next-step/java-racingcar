package step3;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingGame {
    public void run(int car, int move) {
        validate(car, move);

        Set<Car> cars = IntStream.range(0, car)
                .mapToObj(i -> new Car())
                .collect(Collectors.toSet());


        System.out.println("실행결과");
        IntStream.range(0, move)
                .mapToObj(i -> cars)
                .forEach(this::move);
    }

    public void move(Set<Car> cars) {
        cars.forEach(car -> car.move(car.random()));
        ResultView.resultPrint(cars);
    }

    private void validate(int car, int move) {
        if (car == 0) {
            throw new IllegalArgumentException("자동차 수가 0입니다.");
        }

        if (move == 0) {
            throw new IllegalArgumentException("이동횟수가 0입니다.");
        }
    }

}
