package racingcar.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.car.Car;
import racingcar.helper.Fixture;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("CarDto 테스트")
class CarDtoTest {

    @DisplayName("CarDto 는 Car 객체를 가지고 초기화 한다.")
    @Test
    void initCarDto() {
        Car car = Fixture.testCar();

        assertThat(CarDto.from(car)).isNotNull();
    }

    @DisplayName("CarDto 는 Car 객체가 null 일 경우 예외를 발생한다.")
    @Test
    void initFailWhenCarIsNull() {
        assertThatThrownBy(() -> CarDto.from(null)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("CarDto 는 Car 객체의 position 값을 그대로 리턴한다.")
    @Test
    void carDtoHasPosition() {
        Car car = Fixture.testCar();

        CarDto carDto = CarDto.from(car);
        assertThat(carDto.getPosition()).isEqualTo(0);

        car.move(Fixture.ALWAYS_MOVE_STRATEGY);

        carDto = CarDto.from(car);
        assertThat(carDto.getPosition()).isEqualTo(1);
    }

    @DisplayName("전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.(뷰와 연관 되어있으므로 DTO가 이름을 가지고 있는지만 테스트)")
    @Test
    void carDtoHasName() {
        Car car = Fixture.testCar();
        CarDto carDto = CarDto.from(car);

        assertThat(carDto.getName()).isEqualTo(car.name());
    }
}
