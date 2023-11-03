package racing;

import jdk.jfr.Name;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RacingTest {
    @Name("경주 준비 자동차 생성 테스트")
    @ValueSource(ints = {1, 2, 3, 4, 5})
    @ParameterizedTest(name = "경주 준비 자동차 생성 테스트: input = {0}, 참여한 자동차 수 = {0}")
    void ready(int numberOfCar) {
        // given
        Racing racing = new Racing();

        // when
        List<Car> participatingCars = racing.ready(numberOfCar);

        // then
        assertThat(participatingCars.size()).isEqualTo(numberOfCar);
    }
}
