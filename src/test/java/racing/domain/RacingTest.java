package racing.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {
    private Racing racing;

    @BeforeEach
    public void beforeEach() {
        racing = new Racing(2, Collections.singletonList(new Car("car1")));
    }

    @DisplayName("3단계 - 자동차 경주 - 레이싱 객체가 생성되는지 확인")
    @Test
    void create_racing() {
        //given
        int leftMatchCounts = 0;
        List<Car> cars = Collections.singletonList(new Car("car1"));

        //when
        Racing racing = new Racing(leftMatchCounts, cars);

        //then
        assertThat(racing).isNotNull();
    }

    @DisplayName("3단계 - 자동차 경주 - 매치가 끝날때 남은 매치 카운트가 감소하는지 확인")
    @Test
    void finish_race() {
        //given
        int leftMatchCounts = racing.getLeftMatchCounts();

        //when
        racing.race();

        //then
        assertThat(racing.getLeftMatchCounts()).isEqualTo(leftMatchCounts - 1);
    }

    @DisplayName("4단계 - 자동차 경주(우승자) - 남은 매치 카운트가 0 초과인 경우 레이싱이 아직 안끝났는지 확인")
    @Test
    void is_not_finished() {
        assertThat(racing.isNotFinished()).isEqualTo(true);
    }
}
