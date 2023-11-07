package racing;

import jdk.jfr.Name;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.Racing.ParticipatingCars;
import racing.car.Car;
import racing.ui.ResultView;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RacingTest {

    @DisplayName("입력받은 자동차 이릅 배열로 자동차 이름을 생성한다.")
    @Test
    void ready() {
        // given
        String inputNames = "test1,test2,test3";

        // when
        Racing racing = new Racing(inputNames, 0);

        // then
        int participatingCarCount = racing.participatingCars().size();
        assertThat(participatingCarCount).isEqualTo(3);
        for (int i = 0; i < participatingCarCount; ++i) {
            assertThat(racing.participatingCars().get(i).name()).isEqualTo("test" + (i + 1));
        }
    }

    @DisplayName("우승자 확인 테스트")
    @Test
    void winner() {
        // given
        Car car1 = new Car("test1", 0);
        Car car2 = new Car("test2", 1);
        Car car3 = new Car("test3", 2);
        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        Racing racing = new Racing("test1,test2,test3", 0);

        // when, then
        System.out.println(racing.winners().get(0).name());
        System.out.println(car3.name());
        assertThat(racing.winners().get(0)).isEqualTo(car3);
    }
}
