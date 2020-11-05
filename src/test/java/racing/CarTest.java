package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {


    @ParameterizedTest
    @ValueSource(ints = {1, 3, 4, 5, 6, 8})
    @DisplayName("Car.move()로 스키드마크 생성 테스트")
    public void car_random_makeSkidMark(int tryCount) {
        Car car = new Car();

        for (int i = 0; i < tryCount; i++) {
            car.move();
        }

        assertThat(car.skidMark()).contains("-");
    }

}
