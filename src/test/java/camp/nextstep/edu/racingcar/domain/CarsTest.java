package camp.nextstep.edu.racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.racingcar.domain.Cars;
import camp.nextstep.edu.racingcar.domain.result.DriveResult;
import camp.nextstep.edu.racingcar.domain.result.RoundResult;
import camp.nextstep.edu.racingcar.domain.strategy.DriveStrategy;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {

    @Test
    @DisplayName("전략 객체를 실행한 값이 true라면 자동차들이 전진한다")
    void mustDrive() {
        // given
        DriveStrategy driveStrategy = () -> true;
        Cars cars = new Cars(driveStrategy, new String[] { "tmp", "tmp2" });

        // when
        RoundResult roundResult1 = cars.drive();
        RoundResult roundResult2 = cars.drive();

        // then
        List<DriveResult> driveResults1 = roundResult1.driveResults();
        assertThat(driveResults1.size()).isEqualTo(2);
        assertThat(driveResults1.get(0).drivenDistance()).isEqualTo(1);
        assertThat(driveResults1.get(1).drivenDistance()).isEqualTo(1);

        List<DriveResult> driveResults2 = roundResult2.driveResults();
        assertThat(driveResults2.size()).isEqualTo(2);
        assertThat(driveResults2.get(0).drivenDistance()).isEqualTo(2);
        assertThat(driveResults2.get(1).drivenDistance()).isEqualTo(2);
    }

    @Test
    @DisplayName("전략 객체를 실행한 값이 false라면 자동차들이 전진하지 않는다")
    void mustNotDrive() {
        // given
        DriveStrategy driveStrategy = () -> false;
        Cars cars = new Cars(driveStrategy, new String[] { "tmp", "tmp2" });

        // when
        RoundResult roundResult1 = cars.drive();
        RoundResult roundResult2 = cars.drive();

        // then
        List<DriveResult> driveResults1 = roundResult1.driveResults();
        assertThat(driveResults1.size()).isEqualTo(2);
        assertThat(driveResults1.get(0).drivenDistance()).isEqualTo(0);
        assertThat(driveResults1.get(1).drivenDistance()).isEqualTo(0);

        List<DriveResult> driveResults2 = roundResult2.driveResults();
        assertThat(driveResults2.size()).isEqualTo(2);
        assertThat(driveResults2.get(0).drivenDistance()).isEqualTo(0);
        assertThat(driveResults2.get(1).drivenDistance()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차 이름들을 ,로 구분하여 받아 자동차들을 생성한다")
    void carNames() {
        // given
        DriveStrategy driveStrategy = () -> false;
        Cars cars = new Cars(driveStrategy, new String[] { "a", "b" });

        // when
        RoundResult roundResult = cars.drive();
        List<DriveResult> driveResults = roundResult.driveResults();

        // then
        assertThat(driveResults.size()).isEqualTo(2);
        assertThat(driveResults.get(0).name()).isEqualTo("a");
        assertThat(driveResults.get(1).name()).isEqualTo("b");
    }
}
