package carracing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CarServiceTest {

    @Test
    @DisplayName("등록한 차량번호와 인스턴스의 차량번호는 같아야 함")
    public void registerCar() {
        // given
        CarService carService = new CarService();

        // when
        Car car = carService.registerCar(1);

        // then
        assertThat(car.getCarNumber()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -1000})
    @DisplayName("차량번호는 0이나 음수가 올 수 없음")
    public void registerCar_carNumberIsZeroOrNegative(int param) {
        // given
        CarService carService = new CarService();

        // when then
        assertThatIllegalArgumentException()
                .isThrownBy( () -> carService.registerCar(param) )
                .withMessageMatching("차량번호는 1 이상의 숫자여야 합니다.");
    }

    @RepeatedTest(100)
    @DisplayName("차량이 움직이면 움직인 거리는 기존보다 줄어들지 않음")
    public void car_move() {
        // given
        CarService carService = new CarService();

        // when
        Car car = carService.registerCar(1);
        int beforeMileage = car.getMileage();
        car.drive();

        // then
        assertThat(beforeMileage).isLessThanOrEqualTo(car.getMileage());
    }
}