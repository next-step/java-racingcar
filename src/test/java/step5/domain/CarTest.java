package step5.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import step5.exception.ValidateLengthOfCarName;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {


    private static final String CAR_NAME = "Wani";
    private static final int MOVE_CONDITION = 4;
    private Car car;


    @BeforeEach
    void setUp() {
        car = new Car(CAR_NAME);
    }

    @Test
    @DisplayName("이름이 맞게 들어가는지 확인을 한다.")
    void validationCarName() {
        //given
        assertThat(car.toString()).isEqualTo(CAR_NAME);
    }
    @ParameterizedTest
    @DisplayName("랜덤 전진 조건을 경계 테스트를 한다. ")
    @CsvSource(value = {"3:0", "4:1"}, delimiter = ':')
    void 경계테스트(int randomNumber , int expected ){
        //when
        car.move(randomNumber);
        //then
        assertThat(car.getPosition()).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4})
    @DisplayName("움직임 횟수에 따라 차의 포지션을 맞춥니다.")
    void moveCarGetPosition(int moveCount) {
        //given
        //when
        for (int i = 0; i < moveCount; i++) {
            car.move(MOVE_CONDITION);
        }
        //then
        assertThat(car.getPosition()).isEqualTo(moveCount);
    }


    @Test
    @DisplayName("자동차 이름이 5글자 초과 일경우 익셉션 발생")
    void validCarCount() {
        //then
        assertThatThrownBy(() -> new Car("abcdef")).isInstanceOf(ValidateLengthOfCarName.class);
    }

}