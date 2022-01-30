package racinggame.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinnerTest {

    @DisplayName("우승자 잘 뽑히는지 확인")
    @Test
    void 우승자_확인() {
        List<Car> cars = Arrays.asList(
            new Car("test1", 1),
            new Car("test2", 5),
            new Car("test3", 3)
        );
        Winner winner = new Winner(cars);
        List<String> winners = winner.getWinnersName();
        Assertions.assertThat(winners).containsExactly("test2");
    }

    @DisplayName("공동 우승자 잘 뽑히는지 확인")
    @Test
    void 공동_우승자_확인() {
        List<Car> cars = Arrays.asList(
            new Car("test1", 5),
            new Car("test2", 3),
            new Car("test3", 5)
        );
        Winner winner = new Winner(cars);
        List<String> winners = winner.getWinnersName();
        Assertions.assertThat(winners).containsExactly("test1", "test3");
    }
}