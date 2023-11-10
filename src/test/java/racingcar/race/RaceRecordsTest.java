package racingcar.race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.CarName;
import racingcar.domain.Position;
import racingcar.rule.MinimumRule;
import racingcar.rule.Rule;
import racingcar.util.BasicNumberGenerator;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class RaceRecordsTest {

    @Test
    @DisplayName("경기 기록을 저장한다. 자동차와 거리가 저장된다")
    public void race_record(){
        Rule rule = new MinimumRule(4, new BasicNumberGenerator(4));

        Car carA = new Car("carA", new Position(1));
        Car carB = new Car("carB", new Position(1));

        List<Car> list = Arrays.asList(carA, carB);

        Cars cars = new Cars(list);
        cars.move(rule);

        RaceRecords raceRecords = new RaceRecords();
        raceRecords.record(cars.list());

        assertThat(raceRecords.list().get(0).carName().equals("carA")).isTrue();
        assertThat(raceRecords.list().get(1).carName().equals("carB")).isTrue();
    }

    @Test
    @DisplayName("경기 우승자를 가져온다. 우승자는 한명 이상일 수 있다.")
    public void race_record_winner(){
        Car carA = new Car("carA", new Position(3));
        Car carB = new Car("carB", new Position(3));
        Car carC = new Car("carC", new Position(1));

        List<Car> list = Arrays.asList(carA, carB, carC);

        RaceRecords raceRecords = new RaceRecords();
        raceRecords.record(list);

        List<CarName> winners = raceRecords.winners();

        assertThat(winners).containsExactly(new CarName("carA"), new CarName("carB"));
    }
}