package camp.nextstep.edu.racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.racingcar.domain.Cars;
import camp.nextstep.edu.racingcar.domain.result.RoundResult;
import camp.nextstep.edu.racingcar.domain.strategy.DriveStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {

    @Test
    @DisplayName("전략 객체를 실행한 값이 true라면 자동차들이 전진한다")
    void mustDrive() {
        // given
        DriveStrategy driveStrategy = () -> true;
        Cars cars = new Cars(driveStrategy, 2);

        // when
        RoundResult roundResult1 = cars.drive();
        RoundResult roundResult2 = cars.drive();

        // then
        assertThat(roundResult1.toString()).isEqualTo("-\n-\n");
        assertThat(roundResult2.toString()).isEqualTo("--\n--\n");
    }

    @Test
    @DisplayName("전략 객체를 실행한 값이 false라면 자동차들이 전진하지 않는다")
    void mustNotDrive() {
        // given
        DriveStrategy driveStrategy = () -> false;
        Cars cars = new Cars(driveStrategy, 2);

        // when
        RoundResult roundResult1 = cars.drive();
        RoundResult roundResult2 = cars.drive();

        // then
        assertThat(roundResult1.toString()).isEqualTo('\n');
        assertThat(roundResult2.toString()).isEqualTo('\n');
    }
}
