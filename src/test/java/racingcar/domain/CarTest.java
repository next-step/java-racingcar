package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @DisplayName("Car 클래스의 move 메서드의 전진하는 조건은 0 에서 9 사이의 random 값에서 random 값이 기준으로 삼은 값 이상일 경우이다.")
    @ParameterizedTest
    @CsvSource(value = {"1:0", "2:0", "4:1", "5:1"}, delimiter = ':')
    void move(int input, int expected) {
        MoveCondition moveCondition = new RandomMoveCondition();
        Car car = new Car(moveCondition);

        car.move(input);
        assertThat(car.getPosition()).isEqualTo(expected);
    }
}