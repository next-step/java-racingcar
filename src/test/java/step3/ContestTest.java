package step3;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class ContestTest {
    @Test
    void play() {
        int round = 3;
        Car car = new Car();
        List<Car> participants = Stream.of(car).collect(Collectors.toList());
        Contest contest = new Contest(round, participants);
        contest.play();
        assertThat(car.location).isEqualTo(3);
    }
}
