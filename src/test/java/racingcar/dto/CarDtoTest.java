package racingcar.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.car.Car;
import racingcar.helper.Fixture;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("CarDto 테스트")
class CarDtoTest {

    @DisplayName("CarDto 는 Car 객체를 가지고 초기화 한다.")
    @Test
    void initCarDto() {
        Car car = Car.from(Fixture.alwaysMoveStrategy());

        assertThat(CarDto.from(car)).isNotNull();
    }

    @DisplayName("CarDto 는 Car 객체의 position 값을 그대로 리턴한다.")
    @Test
    void carDtoHasPosition() {
        Car car = Car.from(Fixture.alwaysMoveStrategy());

        CarDto carDto = CarDto.from(car);
        assertThat(carDto.getPosition()).isEqualTo(0);

        car.move();

        carDto = CarDto.from(car);
        assertThat(carDto.getPosition()).isEqualTo(1);
    }

}