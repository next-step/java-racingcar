package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarTest {

    Car car;

    @BeforeEach
    void setUp(){
        car = new Car("test");;
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5})
    @DisplayName("차 forward 에 따라 position 더해지는 것 확인")
    void forwardTest(int add) {
        car.forward(add);
        assertThat(car.getPosition()).isEqualTo(add);
    }

    @ParameterizedTest
    @CsvSource(value = {"false,1","false,3","false,4"})
    @DisplayName("move 메서드 실행할 때 isMovable이 false면 position 변하지 않는 것 테스트")
    void movableFalse_carNotMoveTest(boolean isMovable, int moveCount) {
        car.move(isMovable,moveCount);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource(value = {"true,1","true,3","true,4"})
    @DisplayName("move 메서드 실행할 때 isMovable이 true면 moveCount만큼 position 변하는 것 테스트")
    void movableTrue_carMoveTest(boolean isMovable, int moveCount) {
        car.move(isMovable,moveCount);
        assertThat(car.getPosition()).isEqualTo(moveCount);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,-", "2,--", "3,---"})
    @DisplayName("Car의 position에 맞춰 - 호출하는 것 테스트")
    void printPositionTest(int add, String expected) {
        car.forward(add);
        assertThat(car.printPosition()).isEqualTo(expected);
    }
}