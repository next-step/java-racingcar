package racing.domain.racing;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.car.Car;
import racing.domain.car.Car.Name;
import racing.domain.racing.Racing.ParticipatingCars;

import static org.assertj.core.api.Assertions.*;

public class RacingTest {

    @DisplayName("입력받은 자동차 이릅 배열로 자동차 이름을 생성한다.")
    @Test
    void ready() {
        // given
        String inputNames = "test1,test2,test3";

        // when
        Racing racing = new Racing(inputNames, 0, new RandomNumber(10));

        // then
        int participatingCarCount = racing.participatingCars().numberOfCars();
        assertThat(participatingCarCount).isEqualTo(3);
        for (int i = 0; i < participatingCarCount; ++i) {
            assertThat(racing.participatingCars().cars().get(i).name()).isEqualTo(
                new Name("test" + (i + 1)));
        }
    }

    @DisplayName("우승자 확인 테스트")
    @Test
    void winners() {
        // given
        Car car1 = new Car("test1");
        Car car2 = new Car("test2");
        Car car3 = new Car("test3");
        car1.move(5);
        car2.move(1);
        car3.move(3);

        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        ParticipatingCars participatingCars = new ParticipatingCars(cars);

        // when, then
        assertThat(participatingCars.winners()).contains(car1);
    }
}
