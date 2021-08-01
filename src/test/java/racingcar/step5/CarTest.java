package racingcar.step5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.step5.domain.Car;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    String carList[] = {"pobi", "coco", "crong"};

    @Test
    @DisplayName("자동차 객체 생성 테스트")
    void 자동차객체생성() {
        String[] cars = {"pobi", "cony", "hee"};
        List<Car> carList = Car.createCars(cars);
        assertThat(cars.length).isEqualTo(carList.size());
    }

    @Test
    @DisplayName("자동차 전진 테스트")
    void 전진(){
        List<Car> cars = Car.createCars(carList);
        cars.get(0).move(() -> true);
        assertThat(cars.get(0).getDistance()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차 멈춤 테스트")
    void 멈춤(){
        List<Car> cars = Car.createCars(carList);
        cars.get(0).move(() -> false);
        assertThat(cars.get(0).getDistance()).isEqualTo(0);
    }
}
