package racing;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Car 클래스 테스트")
class CarTest {

    private Car testCar;
    private int beforePosition;

    @BeforeEach
    void setUp() {
        testCar = new Car();
        beforePosition = testCar.showMyPosition();
    }

    @Test
    @DisplayName("숫자(주사위 값)가 4 이상이면 자동차의 위치를 1만큼 이동시키는 테스트")
    void movePositionTest() {
        testCar.move(4);
        int currentPosition = testCar.showMyPosition();
        assertThat(beforePosition).isLessThan(currentPosition);
    }

    @Test
    @DisplayName("숫자(주사위 값)가 4 미만이면 자동차의 위치를 이동시키지 않는 테스트")
    void stopPositionTest() {
        testCar.move(3);
        int currentPosition = testCar.showMyPosition();
        assertThat(beforePosition).isEqualTo(currentPosition);
    }
}