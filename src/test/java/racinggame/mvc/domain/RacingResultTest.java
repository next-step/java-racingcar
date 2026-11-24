package racinggame.mvc.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingResultTest {

    @Test
    @DisplayName("경주에 참가한 모든 자동차를 반환한다.")
    void 경주_중인_자동차_목록() {
        Car first = new Car();
        Car second = new Car();
        RacingResult sut = new RacingResult(List.of(first, second), List.of(second));

        assertThat(sut.getRacers()).containsExactly(first, second);
    }

    @Test
    @DisplayName("공동 우승자가 있으면 우승한 자동차를 모두 반환한다.")
    void 우승자_목록() {
        Car first = new Car();
        Car second = new Car();
        Car third = new Car();
        RacingResult sut = new RacingResult(List.of(first, second, third), List.of(first, third));

        assertThat(sut.getWinners()).containsExactly(first, third);
    }
}
