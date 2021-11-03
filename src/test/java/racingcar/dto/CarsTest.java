package racingcar.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.service.domain.Car;
import racingcar.service.dto.Cars;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

class CarsTest {

    @Test
    @DisplayName("Cars 정상 생성 시, getPositions 데이터 검증")
    void getPositions() {
        Cars cars = Cars.from(getTestCarList());
        assertThat(cars.getPositions()).isNotEmpty();
        assertThat(cars.getPositions().size()).isEqualTo(getTestCarList().size());
    }

    @Test
    @DisplayName("Cars 생성 시, null 값이 들어오면 예외를 발생 검증")
    void createException() {
        assertThatNullPointerException().isThrownBy(() -> Cars.from(null));
    }

    private List<Car> getTestCarList() {
        return Arrays.asList(new Car(1),
                             new Car(2),
                             new Car(3));
    }
}
