package winner.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-11-01 22:53
 */
public class RacingCarsTest {

    private RacingCars racingCars;

    @BeforeEach
    void setUp() {
        racingCars = new RacingCars(Arrays.asList(new Car("pobi", 3), new Car("kim", 5)));

    }

    @Test
    void 레이싱카_객체_생성() {
        assertThat(racingCars).isEqualTo(new RacingCars(Arrays.asList(new Car("pobi", 3), new Car("kim", 5))));
    }

    @Test
    void 우승자_찾기() {
        String result = racingCars.findWinners();
        assertThat(result.split(",")[0]).isEqualTo("kim");
    }
}
