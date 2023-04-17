package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class CarTest {

    @DisplayName("자동차 이름 5자 초과시 예외 처리")
    @Test
    void carNameLengthException() {
        assertThatThrownBy(() -> {
            new Car("hoyeon", 1);
        }).isInstanceOf(RuntimeException.class)
                .hasMessageContaining("자동차 이름은 5자를 초과할 수 없습니다.");
    }

    @DisplayName("숫자가 4이상이면 전진")
    @ParameterizedTest
    @CsvSource(value = {"0:1", "1:1", "2:1", "3:1",
            "4:2", "5:2", "6:2", "7:2", "8:2", "9:2"}, delimiter = ':')
    void makeMoveCount(int number, int moveCount) {
        //given
        Car car = new Car("oyeon", 1);

        //when
        car.makeMoveCount(number);

        //then
        assertThat(car.moveCount()).isEqualTo(moveCount);
    }

    @DisplayName("moveCount와 maxMoveCount비교")
    @Test
    void compareMoveCount() throws Exception {
        //given
        Car car = new Car("oyeon", 1);

        //when
        //then
        assertThat(car.moveCountIsGreaterThan(0)).isTrue();
        assertThat(car.moveCountIsGreaterThan(2)).isFalse();
        assertThat(car.moveCountIsEqualTo(1)).isTrue();
    }
}