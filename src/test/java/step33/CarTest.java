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
        String s = car.moveCars(true);
        Assertions.assertEquals("-", s);
    }

    @DisplayName("isOver이 false일 경우 String 결과 테스트")
    @Test
    void isOverFalseTest() {
        String s = car.moveCars(false);
        Assertions.assertEquals("", s);
    }

}