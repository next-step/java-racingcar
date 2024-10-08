package study;

import carracing.domain.carracing.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CopyTest {

    @DisplayName("[study]객체의 깊은 복사의 소요 시간을 확인한다.")
    @Test
    void check_elapsed_time_of_deep_copy_of_Object() {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            cars.add(new Car("moon"));
        }

        long start = System.currentTimeMillis();
        List<Car> result = this.deepCopy(cars);
        long end = System.currentTimeMillis();

        long elapsedTime = end - start;
        System.out.printf("소요 시간 : %d", elapsedTime);
        assertThat(result).hasSize(100000);
    }

    private List<Car> deepCopy(List<Car> cars) {
        List<Car> result = new ArrayList<>();
        for (Car car : cars) {
            result.add(new Car(car.getNameString()));
        }
        return result;
    }
}
