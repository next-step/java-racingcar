package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.status.MoveAbility;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CarsTest {

    @DisplayName("입력받은 숫자만큼 자동차 생성 여부 테스트")
    @Test
    void readyCarsTest() {
        int expectedSize = 3;
        Cars cars = new Cars(expectedSize);
        assertThat(cars.getSize())
                .isEqualTo(expectedSize);
    }

    @DisplayName("최소 차량 수 유효성 체크 테스트")
    @ParameterizedTest
    @ValueSource(ints = {Cars.MIN_CAR_SIZE - 1, Cars.MIN_CAR_SIZE - 2})
    void validateTest(int count) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Cars(count));
    }

    @DisplayName("이동 가능한 차량들의 이동 테스트")
    @Test
    void moveCarsTest() {
        Cars cars = new Cars(findMoveAbleCars());
        cars.moveAll();

        assertThat(cars.getCarList().stream()
                .map(Car::getPosition)
                .collect(Collectors.toList()))
                .containsExactly(1, 1, 1, 1, 1);
    }

    private List<Car> findMoveAbleCars() {
        MoveAbility positiveMoveAbility = number -> true;
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            cars.add(new Car(positiveMoveAbility));
        }
        return cars;
    }
}
