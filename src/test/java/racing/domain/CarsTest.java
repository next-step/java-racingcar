package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @Test
    @DisplayName("자동차를 10대 생성하여 생성된 자동차 수 확인")
    void 자동차_대수_확인() {
        Cars cars = new Cars(10);
        assertThat(cars.getCars().size()).isEqualTo(10);
    }

    @Test
    @DisplayName("자동차를 생성하고 5번 이동하여 최소값을 체크해 모두 5번 이동되었는지 테스트")
    void 자동차들_이동거리_확인() {
        Cars cars = new Cars(10);

        IntStream.range(0,5).forEach(e -> cars.moves());

        int minDistance = Collections
                .min(cars.getCars(),Comparator.comparingInt(Car::getDistance))
                .getDistance();

        assertThat(minDistance).isEqualTo(5);
    }
}
