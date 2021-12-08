package racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.domain.entity.Car;
import racinggame.domain.entity.Contest;
import racinggame.domain.entity.Participants;
import racinggame.view.LocationView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ContestTest {
    @Test
    @DisplayName("Contest를 통해 레이싱 게임의 정상 동작을 테스트 한다.")
    void play() {
        int round = 3;

        Car firstCar = new Car("car1");
        Car secondCar = new Car("car2");

        List<Car> participants = Stream.of(firstCar, secondCar).collect(Collectors.toList());
        Contest contest = new Contest(round, new Participants(participants), () -> true, new LocationView(), winnerReporter);
        contest.play();
    }
}
