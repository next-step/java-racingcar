package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class RoundTest {
    void mustMove(Car car, int count) {
        final int mustMoveValue = 9;

        for (int i = 0; i < count; i++) {
            car.tryMove(() -> mustMoveValue);
        }
    }

    @Test
    @DisplayName("우승자(distance가 가장 큰 Car 객체)를 구한다.")
    void getLeaders() {
        final Car pobi = new Car("pobi");
        final Car crong = new Car("crong");
        final Car honux = new Car("honux");

        mustMove(pobi, 5);
        mustMove(crong, 3);
        mustMove(honux, 1);

        final Round round = new Round(Arrays.asList(pobi, crong, honux));

        final List<String> expectedNames = Stream.of(pobi)
                .map(Car::getName)
                .collect(Collectors.toList());
        final List<String> winnerNames = round.getLeaderList()
                .stream()
                .map(Car::getName)
                .collect(Collectors.toList());

        // assert
        assertThat(winnerNames).containsAll(expectedNames);
    }

    @Test
    @DisplayName("우승자(distance가 가장 큰 Car 객체)를 구한다. 한 명 이상일 수 있다.")
    void getLeaders2() {
        final Car pobi = new Car("pobi");
        final Car crong = new Car("crong");
        final Car honux = new Car("honux");

        mustMove(pobi, 5);
        mustMove(crong, 5);
        mustMove(honux, 1);

        final Round round = new Round(Arrays.asList(pobi, crong, honux));

        final List<String> expectedNames = Stream.of(pobi, crong)
                .map(Car::getName)
                .collect(Collectors.toList());
        final List<String> winnerNames = round.getLeaderList()
                .stream()
                .map(Car::getName)
                .collect(Collectors.toList());

        // assert
        assertThat(winnerNames).containsAll(expectedNames);
    }
}
