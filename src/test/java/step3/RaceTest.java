package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import step3.object.Car;
import step3.util.MovableNumberGenerator;
import step3.util.NonMovableNumberGenerator;
import step3.util.NumberGenerator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceTest {


    //    초간단 자동차 경주 게임을 구현한다.
//    주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
//    사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
//    전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.
//    자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.

    @ParameterizedTest
    @DisplayName("자동차 움직임 테스트 (4 이상만 전진)")
    @CsvSource(value = {"0,1", "7,2", "9,2"}, delimiter = ',')
    void moveTest(int chance, int expected){
        Car car = new Car();
        car.move(chance);
        int actual = car.getPosition();
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("자동차 생성 테스트")
    @ValueSource(ints = {1, 4, 10})
    void generateCarArrayTest(int carCount){
        step3.Race race = new step3.Race();
        List<Car> actual = race.generateCarList(carCount);
        assertThat(actual).hasSize(carCount);
    }

    @DisplayName("숫자가 4보다 작으면 위치를 그대로 유지")
    @Test
    void stayIfNumberIstSmallerThanFour() {
        // Given
        final Car car = new Car();
        final NumberGenerator numberGenerator = new NonMovableNumberGenerator();
        int expected = car.getPosition();
        // When
        car.move(numberGenerator.generate());
        int actual = car.getPosition();
        // Then
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("숫자가 4보다 크면 전진")
    @Test
    void moveIfNumberIstGreaterThanAndEqualToFour() {
        // Given
        final Car car = new Car();
        final NumberGenerator numberGenerator = new MovableNumberGenerator();
        int expected = car.getPosition() + 1;
        // When
        car.move(numberGenerator.generate());
        int actual = car.getPosition();
        // Then
        assertThat(actual).isEqualTo(expected);
    }

}
