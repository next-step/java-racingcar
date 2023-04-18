import CarRacing.domain.Competition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestCarRacingCompetition {

    Competition competition = new Competition();
    @Test
    @DisplayName("4보다 적은 수 입력 시 차량 이동 없음")
    public void drive_less_4() {
        int actual = competition.drive(3);
        assertThat(actual).isEqualTo(0);
    }

    @Test
    @DisplayName("4보다 큰 수 입력 시 차량 이동")
    public void drive_more_4() {
        int actual = competition.drive(5);
        assertThat(actual).isEqualTo(1);
    }

    @Test
    @DisplayName("4 입력 시 차량 이동")
    public void drive_equal_4() {
        int actual = competition.drive(4);
        assertThat(actual).isEqualTo(1);
    }
}
