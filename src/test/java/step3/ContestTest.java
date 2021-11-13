package step3;

import org.junit.jupiter.api.Test;
import step3.domain.Car;
import step3.domain.Contest;
import step3.movingstrategy.InputMovingStrategy;
import step3.view.LocationReporter;

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
        Contest contest = new Contest(round, participants, new InputMovingStrategy(4), new LocationReporter());
        contest.play();

        assertThat(firstCar.getLocation()).isEqualTo(3);
        assertThat(secondCar.getLocation()).isEqualTo(3);
    }
}
