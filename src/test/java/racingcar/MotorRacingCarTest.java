package racingcar;

import org.junit.jupiter.api.RepeatedTest;

import racingcar.domain.MotorRacing;

import static java.util.stream.Collectors.joining;
import static org.assertj.core.api.Assertions.assertThat;

public class MotorRacingCarTest {
    @RepeatedTest(5)
    void test(){
        MotorRacing motorRacing = new MotorRacing(3);
        motorRacing.racing(5);
        assertThat(motorRacing.participationCount()).isEqualTo(3);
        System.out.println(motorRacing);
    }
}
