package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.Car;
import racing.domain.Racing;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {
    @DisplayName("3단계 - 자동차 경주 - 레이싱 객체가 생성되는지 확인")
    @Test
    void create_racing() {
        //given
        int leftMatchCounts = 0;
        List<Car> cars = Collections.singletonList(new Car());

        //when
        Racing racing = new Racing(leftMatchCounts, cars);

        //then
        assertThat(racing).isNotNull();
    }

    @DisplayName("3단계 - 자동차 경주 - 매치가 끝날때 남은 매치 카운트가 감소하는지 확인")
    @Test
    void finish_race() {
        //given
        int leftMatchCounts = 2;
        List<Car> cars = Collections.singletonList(new Car());
        Racing racing = new Racing(leftMatchCounts, cars);

        //when
        racing.race();

        //then
        assertThat(racing.getLeftMatchCounts()).isEqualTo(leftMatchCounts - 1);
    }
}
