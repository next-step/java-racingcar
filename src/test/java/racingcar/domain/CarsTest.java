package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @Test
    void 생성() {
        DriveWay driveWay = new RandomValueDriveWay();
        Cars cars = new Cars("a,b,c", driveWay);
        assertThat(cars).isEqualTo(new Cars("a,b,c", driveWay));
    }

    @Test
    void race() {
        Cars cars = new Cars("a,b,c", () -> true);
        cars.race();
        assertThat(cars.findWinners().size()).isEqualTo(3);
    }

}
