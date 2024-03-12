package carracing.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @Nested
    @DisplayName("move() 테스트")
    class MoveTest {
        MovingStrategy alwaysReturnTrueStub = () -> true;
        MovingStrategy alwaysReturnFalseStub = () -> false;
        Car testCart = Car.newCar(NameOfCar.newName("차"));

        @ParameterizedTest
        @CsvSource(value = {"0:0", "1:1", "5:5", "3:3"}, delimiter = ':')
        @DisplayName("isMovable()이 true를 반환하는 경우 Car의 position이 1 증가한다.")
        void testMoveIsMovableTrueCase(int moveCount, int expected) {
            for (int i = 0; i < moveCount; i++) {
                testCart.move(alwaysReturnTrueStub);
            }

            assertThat(testCart.position()).isEqualTo(expected);
        }

        @ParameterizedTest
        @ValueSource(ints = {0, 1, 10, 20})
        @DisplayName("isMovable()이 false를 반환하는 경우 Car의 position을 증가하지 않는다.")
        void testMoveIsMovableFalseCase(int moveCount) {
            for (int i = 0; i < moveCount; i++) {
                testCart.move(alwaysReturnFalseStub);
            }

            assertThat(testCart.position()).isEqualTo(0);
        }
    }
}