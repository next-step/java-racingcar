package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("Cars 클래스 테스트")
public class CarsTest {
    private final String carName1 = "테스터";
    private final String carName2 = "테스터2";
    private final String carNames = carName1.concat(",").concat(carName2);

    @DisplayName("자동차의 이름을 입력받아서 일급 컬렉션 Cars 객체를 생성할 수 있다.")
    @Test
    void createCars() {
        // when
        Cars actual = Cars.createCars(carNames);

        // then
        assertThat(actual.getSize()).isEqualTo(carNames.split(",").length);
    }

    @DisplayName("전략에 따라 자동차를 움직일 수 있다.")
    @Test
    void carRacing() {
        // given
        Cars cars = Cars.createCars(carNames);

        // when
        cars.carRacing(new FixedNumberStrategy());

        // then
        Car car = cars.getCars().get(0);

        assertAll(
                () -> assertThat(car.getName()).isEqualTo(carName1),
                () -> assertThat(car.getPosition()).isEqualTo(1)
        );
    }

    @DisplayName("우승자를 알 수 있다.")
    @Test
    void getWinners() {
        // given
        int numberOfIterations = 3;
        Cars cars = Cars.createCars(carNames);
        IntStream.range(0, numberOfIterations)
                .forEach(num -> cars.carRacing(new FixedNumberStrategy()));

        // when
        Cars winners = cars.getWinners();

        // then
        assertAll(
                () -> assertThat(winners.getCars().get(0).getName()).isEqualTo(carName1),
                () -> assertThat(winners.getSize()).isEqualTo(carNames.split(",").length)
        );
    }
}
