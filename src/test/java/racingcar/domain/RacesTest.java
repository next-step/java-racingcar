package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.rule.MinimumRule;
import racingcar.util.BasicNumberGenerator;

import java.util.Arrays;
import java.util.List;

class RacesTest {

    @Test
    @DisplayName("경기의 승자를 가져온다. 가장 멀리 이동한 자동차가 승자이다. 승자는 한명 이상이다.")
    public void winners() {

        Cars cars = Cars.ofCars(Arrays.asList(
                new Car("carA", 1),
                new Car("carB", 2),
                new Car("carC", 2)));

        BasicNumberGenerator generator = new BasicNumberGenerator(4);
        MinimumRule rule = new MinimumRule(4, generator);

        Races races = Races.newInstance(cars, rule, 3);

        races.getRaces().forEach(Race::start);

        List<CarName> winners = races.winners();

        Assertions.assertThat(winners).containsExactly(new CarName("carB"), new CarName("carC"));
    }
}