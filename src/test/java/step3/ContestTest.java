package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.entity.Car;
import step3.domain.entity.Contest;
import step3.domain.entity.Participants;
import step3.view.LocationView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ContestTest {
    @Test
    void play() {
        int round = 3;

        Car firstCar = new Car();
        Car secondCar = new Car();

        List<Car> participants = Stream.of(firstCar, secondCar).collect(Collectors.toList());
        Contest contest = new Contest(round, new Participants(participants), () -> true, new LocationView());
        contest.play();
    }
}
