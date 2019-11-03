package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @Test
    void 생성() {
        DriveWay driveWay = new RandomValueDriveWay();
        Cars cars = Cars.newInstance("a,b,c", driveWay);
        assertThat(cars).isEqualTo(Cars.newInstance("a,b,c", driveWay));
    }

    @Test
    void race() {
        Cars cars = Cars.newInstance("a,b,c", () -> true);
        cars.race();
        assertThat(cars.findWinners().size()).isEqualTo(3);
    }

}
