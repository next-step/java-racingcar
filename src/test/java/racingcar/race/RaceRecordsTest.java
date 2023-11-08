package racingcar.race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.rule.MinimumRule;
import racingcar.rule.Rule;
import racingcar.util.BasicNumberGenerator;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class RaceRecordsTest {

    @Test
    @DisplayName("경기 기록을 저장한다. 자동차와 거리가 저장된다")
    public void race_record(){
        Rule rule = new MinimumRule(4, new BasicNumberGenerator(4));

        List<Car> list = new ArrayList<>();
        Car carA = new Car();
        Car carB = new Car();
        list.add(carA);
        list.add(carB);

        Cars cars = new Cars(list);
        cars.move(rule);

        RaceRecords raceRecords = new RaceRecords();
        raceRecords.record(cars.list());

        assertThat(raceRecords.list().get(0).car()).isEqualTo(carA);
        assertThat(raceRecords.list().get(1).car()).isEqualTo(carB);
    }
}