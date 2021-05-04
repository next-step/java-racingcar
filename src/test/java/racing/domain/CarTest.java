package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private Car car;

    @Test
    @DisplayName("movable 전략 리턴 값이 true 일 때 1칸 이동")
    void move() {
        car = Car.of("benz", () -> true);
        car.move();
        assertThat(car.distance()).isEqualTo(1);
    }

    @Test
    @DisplayName("movable 전략 리턴 값이 false 일 때 거리 변화 없음.")
    void stop() {
        car = Car.of("benz", () -> false);
        car.move();
        assertThat(car.distance()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차 distance 따라 역순 정렬 테스트")
    void comparable_reverse_order() {
        Car benz = Car.of("benz", () -> true);
        benz.move();
        benz.move();

        Car audi = Car.of("audi", () -> true);
        audi.move();
        audi.move();
        audi.move();

        Car bmw = Car.of("bmw", () -> true);
        bmw.move();

        List<Car> carList = new ArrayList<>();
        carList.add(benz);
        carList.add(audi);
        carList.add(bmw);

        carList.sort(Comparator.reverseOrder());
        assertThat(carList.get(0)).isEqualTo(audi);

    }
}
