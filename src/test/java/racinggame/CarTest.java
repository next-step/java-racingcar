package racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    @DisplayName("자동차를 생성한다.")
    void createCarTest() {
        var car = initCar();
        assertThat(car).isNotNull();
        assertThat(car.getPosition()).isZero();
    }

    @Test
    @DisplayName("자동차가 현재 위치를 반환한다.")
    void getCurrentPositionTest() {
        var moveCount = 3;
        var correctNumber = 5;
        var car = initCar();
        for (int i = 0; i < moveCount; i++) {
            car.move(correctNumber);
        }
        assertThat(car.getPosition()).isEqualTo(moveCount);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6})
    @DisplayName("4 이상의 수가 전달되었을 때 자동차가 한칸 이동한다.")
    void carMovesForwardWhenRandomValueIsFourOrHigher(int number) {
        var car = initCar();
        car.move(number);
        assertThat(car.getPosition()).isOne();
    }

    private Car initCar() {
        return Car.create();
    }

}