package racingcar.race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.rule.MinimumRule;
import racingcar.util.BasicNumberGenerator;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RaceRecordTest {
    @Test
    @DisplayName("경기가 끝나면 경기 기록을 생성한다. 경기 기록에는 자동차와 거리가 저장 된다")
    public void race_record(){
        List<Car> cars = new ArrayList<>();
        cars.add(new Car());
        cars.add(new Car());
        cars.add(new Car());
        cars.add(new Car());
        cars.add(new Car());

        BasicNumberGenerator generator = new BasicNumberGenerator(5);
        MinimumRule rule = new MinimumRule(5, generator);

        Race race = new Race(cars, rule);
        race.start();


        race.raceRecords()
                .forEach(raceRecord -> {
                    assertThat(cars).contains(raceRecord.car());
                    assertThat(raceRecord.distance()).isEqualTo(1);
                });
    }
}