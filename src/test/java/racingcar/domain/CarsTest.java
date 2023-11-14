package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.rule.MinimumRule;
import racingcar.rule.Rule;
import racingcar.util.BasicNumberGenerator;

import java.util.Arrays;

class CarsTest {

    @Test
    @DisplayName("자동차들을 이동시킨다. 이동된 자동차는 이동거리가 증가한다")
    public void cars_move() {
        Rule rule = new MinimumRule(4, new BasicNumberGenerator(4));

        Cars cars = Cars.ofString(Arrays.asList("carA", "carB"));
        RaceRecords raceRecords = cars.move(rule);

        for (RaceRecord raceRecord : raceRecords.getRaceRecords()) {
            Assertions.assertThat(raceRecord.position().equals(new Position(1))).isTrue();
        }
    }
}