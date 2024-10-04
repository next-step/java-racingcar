package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.CarManager;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @Test
    void getCurrentPosition() {
        Car car = getCar("car");
        assertThat(car.getCurrentPosition()).isEqualTo(0);
    }


    @Test
    void run_전진() {
        Car car = getCar("car");

        car.run(true);

        assertThat(car.getCurrentPosition()).isEqualTo(1);
    }

    @Test
    void run_멈춤() {

        Car car = getCar("car");

        car.run(false);

        assertThat(car.getCurrentPosition()).isEqualTo(0);
    }


    @Test
    void getName_자동차이름부여확인() {

        Car car = getCar("pobi");

        assertThat(car.getName()).isEqualTo("pobi");
    }
    @Test
    void getName_자동차이름검증() {
        assertThatThrownBy(() -> getCar("자동차명테스트")).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 명은 최소1글자, 최대5글자로 제한합니다.");
    }

    private static Car getCar(String carName) {
        CarManager carManager = new CarManager();
        return carManager.createCarsByCnt(Arrays.asList(carName)).get(0);
    }


}