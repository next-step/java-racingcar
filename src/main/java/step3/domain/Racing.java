package step3.domain;

import step3.util.Validator;

import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Created By mand2 on 2020-11-04.
 * 경주 operation
 */
public class Racing {

    private final int rounds;
    private final List<Car> cars;

    private Racing(int participants, int rounds) {
        this.rounds = rounds;
        this.cars = initCars(participants);
    }

    public static Racing of(int participants, int rounds) {
        Validator.checkArgumentInRange(participants, 1);
        Validator.checkArgumentInRange(rounds, 1);

        return new Racing(participants, rounds);
    }

    private List<Car> initCars(int participants) {
        return Stream.generate(() -> new Car())
                .limit(participants)
                .collect(toList());
    }

    // random 돌려서 값 나옴 => 전진할지 말지 판단
    //TODO 중간중간 result 전달해주는 일급컬렉션으로 변경? List Score?
    public List<Integer> race() {
        return this.cars.stream().map(car -> {
            if (randomize() >= 4) {
                car.forward();
            }
            return car.getStep();
        }).collect(toList());
    }

    private int randomize() {
        return new Random().nextInt(10);
    }

}
