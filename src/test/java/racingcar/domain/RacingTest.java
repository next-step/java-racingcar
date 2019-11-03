package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {

    @Test
    void 생성() {
        DriveWay driveWay = new RandomValueDriveWay();
        Racing racing = new Racing("a,b,c", 5, driveWay);
        assertThat(racing).isEqualTo(new Racing("a,b,c", 5, driveWay));
    }

    @Test
    void findWinners() {
        Racing racing = new Racing("a,b,c", 5, () -> true);
        racing.race();
        List<Car> winners = racing.findWinners();
        assertThat(winners.size()).isEqualTo(3);
    }
}
