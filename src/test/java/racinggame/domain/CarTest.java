package racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @Test
    @DisplayName("자동차를 생성한다.")
    void createCarTest() {
        Car car = initCar();
        assertThat(car).isNotNull();
        assertThat(car.getPosition()).isZero();
        assertThat(car.getName()).isEqualTo("테스트카");
    }

    @Test
    @DisplayName("4 미만의 수가 전달되었을 때 자동차가 이동하지 않는다.")
    void carDoesNotMoveWhenRandomValueIsLessThanFour() {
        Car car = initCar();
        int incorrectMoveNumber = 3;
        car.move(incorrectMoveNumber);
        assertThat(car.getPosition()).isZero();
    }

    @Test
    @DisplayName("4 이상의 수가 전달되었을 때 자동차가 한칸 이동한다.")
    void carMovesForwardWhenRandomValueIsFourOrHigher() {
        Car car = initCar();
        int correctMoveNumber = 4;
        car.move(correctMoveNumber);
        assertThat(car.getPosition()).isOne();
    }

    @Test
    @DisplayName("자동차의 이름이 5자리를 초과할 경우 예외를 throw 한다.")
    void throwExceptionWhenCarNameExceedsFiveCharacters() {
        assertThatThrownBy(() -> Car.create("BMW530"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차의 이름은 5자리를 초과할 수 없습니다.");
    }

    @Test
    @DisplayName("자동차의 위치와 입력된 위치가 같을 때 true를 반환한다.")
    void isEqualPositionTest() {
        Car car = initCar();
        int correctMoveNumber = 5;
        int orderPosition = 1;
        car.move(correctMoveNumber);
        assertThat(car.isEqualPosition(orderPosition)).isTrue();
    }

    @Test
    @DisplayName("자동차의 위치와 입력된 위치 중 더 큰 위치를 반환한다.")
    void comparePositionTest() {
        Car car = initCar();
        int orderPosition = Integer.MAX_VALUE;
        assertThat(car.comparePosition(orderPosition)).isEqualTo(orderPosition);
    }

    private Car initCar() {
        return Car.create("테스트카");
    }

}