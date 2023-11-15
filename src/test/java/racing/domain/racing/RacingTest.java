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
        Racing racing = new Racing(inputNames);

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
        int randNums[] = {1, 5};
        Racing racing = new Racing("test1,test2");

        // when
        racing.race(randNums);

        // then
        assertThat(racing.winners().get(0).name()).isEqualTo(new Name("test2"));
    }
}
