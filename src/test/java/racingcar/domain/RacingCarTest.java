package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RacingCarTest {
    @Test
    void 객체_생성_테스트() {
        assertThat(new RacingCar("car")).isEqualTo(new RacingCar("car"));
    }

    @ParameterizedTest
    @CsvSource(value = {"5:1", "1:0"}, delimiter = ':')
    void 이동_테스트(int random, int position) {
        RacingCar racingCar = new RacingCar("자동차", 0);
        racingCar.move(random);

        assertThat(racingCar).isEqualTo(new RacingCar("자동차", position));
    }

    @ParameterizedTest
    @CsvSource(value = {"5:1", "1:0"}, delimiter = ':')
    void 최대_포지션_테스트(int random, int position) {
        RacingCar racingCar = new RacingCar("자동차", 0);
        racingCar.move(random);

        assertThat(racingCar.maxPosition(position)).isEqualTo(position);
    }

    @ParameterizedTest
    @CsvSource(value = {"5:1:true", "1:1:false"}, delimiter = ':')
    void 최대_포지션_여부_테스트(int random, int position, boolean result) {
        RacingCar racingCar = new RacingCar("자동차", 0);
        racingCar.move(random);

        assertThat(racingCar.isMaxPosition(position)).isEqualTo(result);
    }
}
