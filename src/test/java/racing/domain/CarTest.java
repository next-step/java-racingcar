package racing.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CarTest {

    MoveConditionStrategy moveConditionStrategy;

    @BeforeEach
    public void beforeEach() {
        moveConditionStrategy = new OverFourStrategy();
    }

    @Test
    @DisplayName("자동차가 움직였으면 거리가 증가")
    public void moveTest() {
        //given
        Car car = new Car("aaa", moveConditionStrategy);
        int moveCount = car.getMoveCount();

        //when
        boolean isMove = car.isMove();

        //then
        if (isMove) {
            assertThat(car.getMoveCount()).isEqualTo(moveCount + 1);
        }
    }

    @Test
    @DisplayName("자동차가 움직였으면 거리가 증가")
    public void notMoveTest() {
        //given
        Car car = new Car("aaa", moveConditionStrategy);
        int moveCount = car.getMoveCount();

        //when
        boolean isMove = car.isMove();

        //then
        if (!isMove) {
            assertThat(car.getMoveCount()).isEqualTo(moveCount);
        }
    }

    @ParameterizedTest
    @CsvSource(value = {"aaa", "bbb", "ccc"})
    @DisplayName("자동차 이름이 전부 5자 이내인 자동차 생성")
    public void makeCarTest(String name) {
        assertThat(new Car(name, moveConditionStrategy).getName()).isEqualTo(name);
    }

    @DisplayName("자동차 이름이 5자 초과면 에러")
    @ParameterizedTest
    @CsvSource(value = {"123456", "1234567", "12345678"})
    public void invalidMakeCarTest(String name) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new Car(name, moveConditionStrategy);
                });
    }
}
