package study.racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.racingcar.domain.car.Car;
import study.racingcar.domain.history.History;

class HistoryTest {


    @DisplayName("우승자를 리스트로 반환")
    @Test
    void winners() {
        Car carA = new Car("a");
        Car carB = new Car("b");

        Map<Car, String> map = Map.of(carA, "----", carB, "-");

        History history = new History(new LinkedList<>(List.of(map)));
        List<String> winners = history.winners();
        assertThat(winners.size()).isEqualTo(1);
        assertThat(winners.get(0)).isEqualTo(carA.name());
        assertThat(winners).doesNotContain(carB.name());
        assertThat(winners).containsExactly("a");
    }
}