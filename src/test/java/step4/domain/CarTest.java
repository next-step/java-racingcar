package step4.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step4.exception.OutBoundCarListSizeException;
import step4.exception.ValidateLengthOfCarName;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {


    private static final String CAR_NAME = "Wani";
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car(CAR_NAME);
    }

    @Test
    @DisplayName("이름이 맞게 들어가는지 확인을 한다.")
    void validationCarName() {
        //given
        assertThat(car.getName()).isEqualTo(CAR_NAME);
    }

    @Test
    @DisplayName("전략에 따라 차가 무조건 움직이는지 확인한다.")
    void mustMoveCar() {
        //given
        MoveStrategy moveStrategy = new MustMoveStrategy();
        //when
        car.move(moveStrategy);
        //then
        assertThat(car.getCarPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("전략에 따라 차가 안움직이는지 확인한다.")
    void notMoveCar() {
        //given
        MoveStrategy moveStrategy = new NotMoveStrategy();
        //when
        car.move(moveStrategy);
        //then
        assertThat(car.getCarPosition()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4})
    @DisplayName("움직임 횟수에 따라 차의 포지션을 맞춥니다.")
    void moveCarGetPosition(int moveCount) {
        //given
        MoveStrategy moveStrategy = new MustMoveStrategy();
        //when
        for (int i = 0; i < moveCount; i++) {
            car.move(moveStrategy);
        }
        //then
        assertThat(car.getCarPosition()).isEqualTo(moveCount);
    }


    @Test
    @DisplayName("자동차 이름이 5글자 초과 일경우 익셉션 발생")
    void validCarCount() {
        //then
        assertThatThrownBy(() -> new Car("abcdef")).isInstanceOf(ValidateLengthOfCarName.class);
    }

}