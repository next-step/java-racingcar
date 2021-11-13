package step3;

import org.junit.jupiter.api.Test;
import step3.movingstrategy.InputMovingStrategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class ContestTest {
    @Test
    void play() {
        int round = 3;

        Car firstCar = new Car();
        Car secondCar = new Car();

        List<Car> participants = Stream.of(firstCar, secondCar).collect(Collectors.toList());
        Contest contest = new Contest(round, participants, new InputMovingStrategy(4));
        contest.play();

        assertThat(firstCar.location).isEqualTo(3);
        assertThat(secondCar.location).isEqualTo(3);
    }
}
