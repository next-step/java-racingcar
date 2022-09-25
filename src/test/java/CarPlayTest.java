
import java.util.List;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import step3.domain.Car;
import step3.service.CarPlay;

class CarPlayTest {

    private CarPlay carPlay;
    private Car car;

    @BeforeEach
    void setTest() {
        car = new Car();
        carPlay = new CarPlay(car);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7})
    @DisplayName("4이상일 경우에만 true 값을 반환하는지 확인")
    void checkReturnBiggerThanFour(int input) {

        if (input >= 4) {
            assertThat(car.isMovingForward(input)).isTrue();
        } else {
            assertThat(car.isMovingForward(input)).isFalse();
        }
    }

    @Test
    @DisplayName("0과 1만 포함된 랜덤 자동차 리스트를 출력하는지 확인")
    void randomCarListContainsOnlyOneAndZero() {

        int maxNumber = 2;

        List<Integer> randomList = carPlay.carMovement();

        for (Integer randomElement : randomList) {
            assertThat(randomElement).isLessThan(maxNumber);
        }
    }

}