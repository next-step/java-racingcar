package step33;

import org.junit.jupiter.api.*;


class CarTest {

    private Car car;

    @BeforeEach
    void init(){
        car = new Car();
    }

    @DisplayName("isOver이 true일 경우 String 결과 테스트")
    @Test
    void isOverTrueTest() {
        int s = car.moveCars(true);
        Assertions.assertEquals(1, s);
    }

    @DisplayName("isOver이 false일 경우 String 결과 테스트")
    @Test
    void isOverFalseTest() {
        int s = car.moveCars(false);
        Assertions.assertEquals(0, s);
    }

}