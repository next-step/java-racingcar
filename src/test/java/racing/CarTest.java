package racing;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Car 클래스 테스트")
class CarTest {

    private Car testCar;
    private final int beforePosition = 0;

    @BeforeEach
    void setUp() {
        testCar = new Car("super");
    }

    @Test
    @DisplayName("숫자(주사위 값)가 4 이상이면 자동차의 위치를 1만큼 이동시키는 테스트")
    void movePositionTest() {
        testCar.move(4);
        assertThat(beforePosition).isLessThan(testCar.getPosition());
    }

    @Test
    @DisplayName("숫자(주사위 값)가 4 미만이면 자동차의 위치를 이동시키지 않는 테스트")
    void stopPositionTest() {
        testCar.move(3);
        assertThat(beforePosition).isEqualTo(testCar.getPosition());
    }

    @Test
    @DisplayName("자동차의 이름과 위치를 확인하는 테스트")
    void nameAndPositionTest() {
        testCar.move(4);
        assertThat("super").isEqualTo(testCar.getName());
        assertThat(1).isEqualTo(testCar.getPosition());
    }

    @Test
    @DisplayName("position 비교로 자동차의 깊은복사가 잘 이루어지는지 테스트")
    void deepCopyTest() {
        testCar.move(4);
        Car deepCopyCar = testCar.deepCopyCar();
        deepCopyCar.move(4);

        assertThat(testCar.getPosition()).isNotEqualTo(deepCopyCar.getPosition());
    }
}