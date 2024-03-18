package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingGameTest {
    @DisplayName("자동차리스트 생성")
    @Test
    void makeCarListTest() {
        List<Car> carList = Cars.makeCarList("pobi,crong,honux");
        assertThat(carList.size()).isEqualTo(3);
    }

    @DisplayName("공백 자동차리스트 생성")
    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void carNameTest(String names) {
        assertThatThrownBy(() -> Cars.makeCarList(names))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("거리 최대값 확인")
    @Test
    void getMaxPositionTest() {
        List<Car> carList = Arrays.asList(
                new Car("pobi", 2),
                new Car("crong", 3),
                new Car("honux", 1));
        assertThat(Record.findMaxPosition(carList)).isEqualTo(3);
    }

    @DisplayName("단일 우승자")
    @Test
    void winnerTest() {
        List<Car> carList = Arrays.asList(
                new Car("pobi", 2),
                new Car("crong", 3),
                new Car("honux", 1));
        assertThat(Record.getRecord(carList)).containsExactly("crong");
    }

    @DisplayName("다중 우승자")
    @Test
    void winnersTest() {
        List<Car> carList = Arrays.asList(
                new Car("pobi", 3),
                new Car("crong", 3),
                new Car("honux", 1));
        assertThat(Record.getRecord(carList)).hasSize(2);
    }
}