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

    @DisplayName("5단계 - 자동차 경주(리팩토링) - 레이스 후 자동차가 전진했는지 확인")
    @Test
    void is_go_after_race() {
        RacingCars racingCars = racing.race(() -> true);
        assertThat(racingCars.getFarthestPosition()).isEqualTo(new Position(1));
    }

    @DisplayName("5단계 - 자동차 경주(리팩토링) - 레이스 후 자동차가 정지했는지 확인")
    @Test
    void is_stop_after_race() {
        RacingCars racingCars = racing.race(() -> false);
        assertThat(racingCars.getFarthestPosition()).isEqualTo(new Position(0));
    }

    @DisplayName("5단계 - 자동차 경주(리팩토링) - 레이스 후 매치 카운트가 감소했는지 확인")
    @Test
    void decrease_match_count_after_race() {
        racing.race(() -> true);
        assertThat(racing.getLeftMatchCount()).isEqualTo(new MatchCount(1));
    }

    @DisplayName("3단계 - 자동차 경주 - 매치가 끝날때 남은 매치 카운트가 감소하는지 확인")
    @Test
    void finish_match() {
        racing.finishMatch();
        assertThat(racing.getLeftMatchCount()).isEqualTo(new MatchCount(1));
    }

    @DisplayName("4단계 - 자동차 경주(우승자) - 남은 매치 카운트가 0 초과인 경우 레이싱이 아직 안끝났는지 확인")
    @Test
    void is_not_finished() {
        assertThat(racing.isNotFinished()).isEqualTo(true);
    }
}
