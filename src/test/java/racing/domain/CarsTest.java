package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarsTest {

    @ParameterizedTest(name = "{index} {displayName} input value={0}")
    @ValueSource(strings = {",,,,,", ","})
    @NullAndEmptySource
    @DisplayName("입력된 차 이름이 null, empty 또는 콤마만 찍힌 경우 IllegalArgumentException 발생")
    void case_when_create_cars_throws_illegalArgumentExcpetion(String carNames) {
        assertThrows(IllegalArgumentException.class, () -> Cars.of(carNames, () -> true));
    }

    @ParameterizedTest(name = "{index} {displayName} input value={0}")
    @ValueSource(strings = {"benz", "benz,audi,bmw", "bmw,,"})
    @DisplayName("구분자로 나뉜 차 이름이 5자 이하인 경우 테스트 정상")
    void case_when_carName_length_under_5(String carNames) {
        Cars cars = Cars.of(carNames, () -> true);
        assertThat(cars.size()).isEqualTo(carNames.split(Cars.DELIMITER).length);
    }

    @Test
    @DisplayName("구분자로 split한 개수만큼 자동차 생성")
    void number_of_cars() {
        Cars cars = Cars.of("benz,bmw,audi", () -> true);
        assertThat(cars.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("movable 전략 리턴 값이 true 일 때 모든 차들 1칸 이동")
    void move_cars() {
        Cars cars = Cars.of("benz,bmw,audi", () -> true);
        cars.moveCars();
        for (Car car : cars.getCars()) {
            assertThat(car.distance()).isEqualTo(1);
        }
    }

    @Test
    @DisplayName("movable 전략 리턴 값이 false 일 때 모든 차들 거리 변화 없음")
    void stop_cars() {
        Cars cars = Cars.of("benz,bmw,audi", () -> false);
        cars.moveCars();
        for (Car car : cars.getCars()) {
            assertThat(car.distance()).isEqualTo(0);
        }
    }
}
