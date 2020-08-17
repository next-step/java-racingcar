package racing.car.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinnersTest {
    private Winners winners;

    @BeforeEach
    void setUp() {
        Car car1 = new Car("tom", 5);
        Car car2 = new Car("rose", 5);
        Car car3 = new Car("min", 5);

        winners = new Winners(Arrays.asList(car1, car2, car3));
    }

    @Test
    @DisplayName("우승자 이름 리스트 반환하")
    void getWinnerNames() {
        // given
        List<String> expectedWinnerNames = Arrays.asList("tom", "rose", "min");

        // when
        List<String> winnerNames = winners.getWinnerNames();

        // then
        assertThat(winnerNames).isEqualTo(expectedWinnerNames);
    }
}