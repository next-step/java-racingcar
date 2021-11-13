package step3;

import org.junit.jupiter.api.Test;
import step3.domain.entity.Car;
import step3.domain.entity.Contest;
import step3.domain.movingstrategy.InputMovingStrategy;
import step3.view.LocationView;

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
        Contest contest = new Contest(round, participants, new InputMovingStrategy(4), new LocationView());
        contest.play();
        
    }
}
