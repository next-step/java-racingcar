package racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @Test
    @DisplayName("자동차를 생성한다.")
    void createCarTest() {
        var car = initCar();
        assertThat(car).isNotNull();
        assertThat(car.getPosition()).isZero();
        assertThat(car.getName()).isEqualTo("테스트카");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("4 미만의 수가 전달되었을 때 자동차가 한칸 이동한다.")
    void carDoesNotMoveWhenRandomValueIsLessThanFour(int incorrectMoveNumber) {
        var car = initCar();
        car.move(incorrectMoveNumber);
        assertThat(car.getPosition()).isZero();
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6})
    @DisplayName("4 이상의 수가 전달되었을 때 자동차가 한칸 이동한다.")
    void carMovesForwardWhenRandomValueIsFourOrHigher(int correctMoveNumber) {
        var car = initCar();
        car.move(correctMoveNumber);
        assertThat(car.getPosition()).isOne();
    }

    @Test
    @DisplayName("자동차의 이름이 5자리를 초과할 경우 RuntimeException 예외를 throw 한다.")
    void throwExceptionWhenCarNameExceedsFiveCharacters() {
        assertThatThrownBy(() -> Car.create("BMW530"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("자동차의 이름은 5자리를 초과할 수 없습니다.");
    }

    private Car initCar() {
        return Car.create("테스트카");
    }

}