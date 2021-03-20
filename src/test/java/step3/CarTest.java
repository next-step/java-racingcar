package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {

    @DisplayName("랜덤 값 4이상이면 자동차가 전진하는지 테스트")
    @ValueSource(ints = {4, 5, 6, 7, 8})
    @ParameterizedTest
    void carMove(int randomNumber) {
        Car car = new Car();
        car.carCanGoJudge(randomNumber);
        assertEquals(1, car.getGoDistance());
    }

    @DisplayName("랜덤 값 4미만이면 자동차가 가만히 있어야 하는 테스트")
    @ValueSource(ints = {1, 2, 3})
    @ParameterizedTest
    void carStay(int randomNumber) {
        Car car = new Car();
        car.carCanGoJudge(randomNumber);
        assertEquals(0, car.getGoDistance());
    }

    @DisplayName("자동차 수 입력받은 값 만큼 자동차가 만들어지는지 확인하는 테스트")
    @Test
    void createCarTest() {
        // 이런식으로 테스트 작성해도 될까요??,,
        Racing racing = new Racing(new InputDto(3, 5));
        assertEquals(3, racing.getCarList().size());
    }
}
