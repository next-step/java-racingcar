package racingcar.race;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.race.Car;
import racingcar.race.Race;
import racingcar.rule.MinimumRule;
import racingcar.util.BasicNumberGenerator;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RaceTest {
    @ParameterizedTest(name = "입력값({0})이 경기 규칙 최소값({1}) 이상이면 자동차의 이동거리({2})가 증가한다")
    @CsvSource(value = {"3:4:0", "4:4:1", "5:4:1"}, delimiter = ':')
    public void race_start_car_distacne_increase(int input, int minimum, int distance){
        List<Car> cars = new ArrayList<>();
        cars.add(new Car());
        cars.add(new Car());
        cars.add(new Car());
        cars.add(new Car());
        cars.add(new Car());

        BasicNumberGenerator generator = new BasicNumberGenerator(input);
        MinimumRule rule = new MinimumRule(minimum, generator);

        Race race = new Race(cars, rule);
        race.start();

        for (Car car : cars) {
            assertThat(car.distance()).isEqualTo(distance);
        }
    }
}