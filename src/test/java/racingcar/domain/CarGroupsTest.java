package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.status.PositiveMoveAbility;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CarGroupsTest {

    @DisplayName("입력받은 숫자만큼 자동차 생성 여부 테스트")
    @Test
    void readyCarsTest() {
        int expectedSize = 3;
        CarGroups carGroups = new CarGroups(expectedSize);
        assertThat(carGroups.getCarsSize())
                .isEqualTo(expectedSize);
    }

    @DisplayName("최소 차량 수 유효성 체크 테스트")
    @ParameterizedTest
    @ValueSource(ints = {CarGroups.MIN_CAR_SIZE - 1, CarGroups.MIN_CAR_SIZE - 2})
    void validateTest(int count) {
        assertThatIllegalArgumentException().isThrownBy(() -> new CarGroups(count));
    }

    @DisplayName("이동 가능한 차량들의 이동 테스트")
    @Test
    void moveCarsTest() {
        CarGroups carGroups = new CarGroups(findMoveAbleCars());
        carGroups.moveCars();

        assertThat(carGroups.getCars().stream()
                .map(Car::getPosition)
                .collect(Collectors.toList()))
                .containsExactly(1, 1, 1, 1, 1);
    }

    private List<Car> findMoveAbleCars() {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            cars.add(new Car(new PositiveMoveAbility()));
        }
        return cars;
    }
}
