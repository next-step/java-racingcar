package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    @DisplayName("자동차 전진 테스트")
    void move() {
        //given
        Car firstCar = new Car();
        Car secondCar = new Car();
        Car thirdCar = new Car();
        Car fourthCar = new Car();

        //when
        firstCar.move(5);
        firstCar.move(9);
        secondCar.move(3);
        secondCar.move(2);
        int movementRangeOfFirstCar = firstCar.getMovementRange();
        int movementRangeOfSecondCar = secondCar.getMovementRange();

        //then
        assertEquals(2, movementRangeOfFirstCar, "4이상의 값이 2번 들어갔기 때문에 2번 이동해야 한다.");
        assertEquals(0, movementRangeOfSecondCar, "4미만의 값이 2번 들어갔기 때문에 이동하지 않아야 한다.");
        assertThatIllegalArgumentException().isThrownBy(() -> thirdCar.move(-10)).withMessageContaining("이동 범위의 조건은 0 ~ 9");
        assertThatIllegalArgumentException().isThrownBy(() -> fourthCar.move(10)).withMessageContaining("이동 범위의 조건은 0 ~ 9");
    }
}