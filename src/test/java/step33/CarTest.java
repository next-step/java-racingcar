package step33;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


class CarTest {

    private Car car;

    @BeforeEach
    void init(){
        car = new Car();
    }

    @DisplayName("isOver이 true일 경우 String 결과 테스트")
    @ParameterizedTest
    @ValueSource(ints = {4,5,6,7,8,9})
    void isOverTrueTest(int number) {
        car.moveCars(number);
        Assertions.assertEquals(1, car.getMoveCount());
    }

    @DisplayName("isOver이 false일 경우 String 결과 테스트")
    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3})
    void isOverFalseTest(int number) {
        car.moveCars(number);
        Assertions.assertEquals(0, car.getMoveCount());
    }

}